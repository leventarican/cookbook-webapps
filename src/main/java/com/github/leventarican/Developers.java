package com.github.leventarican;

import com.github.leventarican.database.InMemory;
import com.github.leventarican.entity.Developer;
import java.io.StringWriter;
import javax.annotation.PostConstruct;
import javax.ejb.Init;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * using JSON-P streaming API
 *
 * @author levent@protonmail.com
 */
@Path("developers")
public class Developers {

    @Inject
    InMemory database;
    
    @PostConstruct
    private void init() {
        database.generateData();
    }
    
    @GET
    public String devs() {
        StringWriter writer = new StringWriter();
        try (JsonGenerator generator = Json.createGenerator(writer)) {
            generator.writeStartArray().write("kotlin").write("java").writeEnd();
        }
        return writer.toString();
    }

    @GET
    @Path("{did}")
    public String getOrder(@PathParam("did") Integer id) {
        return database.getDeveloper(id).toJson();
    }
}
