package com.example;

//import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
//import javax.ws.rs.core.SecurityContext;

/**
 * when deploy to payara5 local
 * http://localhost:8080/javaee-eclipselink-h2-example/api/ping
 */
@RequestScoped
@Path("/v1")
public class PingResource {

    @Inject
    private BookService bookService;
    @Inject
    private UserService userService;
    
//    @Inject
//    private SecurityContext securityContext;
    
    @PersistenceContext
    private EntityManager em;

    @Path("secured")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response secured() {        
    	// assumption is that we already have authenticated through OIDC
//    	Principal userPrincipal = securityContext.getUserPrincipal();
//    	System.out.println("user principal: " + userPrincipal);
//    	String username = userPrincipal.getName();
        String username = "duke";
        User user = userService.findUser(username);

        // duke has role in table User
//        if (user != null && "READER".equals(user.getRole())) {
        if (user != null && "ADMIN".equals(user.getRole())) {
            //... Your existing logic
        	String msg = "user " + username + "has role: " + user.getRole();
        	System.out.println(msg);
            return Response.ok(msg).build();
        } else {
        	System.out.println("user " + username + "has NOT role: " + user.getRole());
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    @Path("ping")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        Book book = bookService.saveBook("Sample Book");
        return "Pong! Saved book with ID: " + book.getId();
    }
    
    @Path("pong")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String pong() {
        List<Book> books = bookService.listAllBooks();
        return books.stream().map(Book::getTitle).collect(Collectors.joining(", "));
    }
    
    @Path("add_user")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String addUser() {
        User user = userService.saveUser("duke");
        return "Saved user with name: " + user.getUser() + " and role: " + user.getRole();
    }

    @Path("list_users")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String listUsers() {
        List<User> users = userService.listAllUsers();
        return users.stream().map(User::getRole).collect(Collectors.joining(", "));
    }
}
