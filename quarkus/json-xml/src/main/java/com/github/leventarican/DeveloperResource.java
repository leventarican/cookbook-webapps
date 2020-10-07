package com.github.leventarican;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author levent
 */
@Path("/developer/code")
public class DeveloperResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String code() {
        return "code";
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("json-xml")
    public Developer codejson() {
        Developer dev = new Developer();
        dev.setId("0");
        dev.setProgrammingLanguage("java");
        return dev;
    }
}
