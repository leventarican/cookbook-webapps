package com.github.leventarican;

import java.io.StringWriter;
import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * using JSON-P streaming API
 *
 * @author levent@protonmail.com
 */
@Path("developers")
public class Developers {

    @GET
    public String devs() {
        StringWriter writer = new StringWriter();
        try (JsonGenerator generator = Json.createGenerator(writer)) {
            generator.writeStartArray().write("kotlin").write("java").writeEnd();
        }
        return writer.toString();
    }
}
