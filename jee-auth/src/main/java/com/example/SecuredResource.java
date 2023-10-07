package com.example;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/secured")
public class SecuredResource {

    @GET
    @RolesAllowed("admin")
    public String getSecuredData() {
        return "This is secured data!";
    }
}