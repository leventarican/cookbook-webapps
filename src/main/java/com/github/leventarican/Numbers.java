package com.github.leventarican;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.Metric;

/**
 * @author levent@protonmail.com
 */
@ApplicationScoped
@Path("numbers")
public class Numbers {

    private UUID id = UUID.randomUUID();
    private List<String> numbers = new ArrayList<>();

    @Inject
    @Metric
    Counter numberCounter;

    @PostConstruct
    private void init() {
        numberCounter.inc(42);
    }

    /*
    curl -H "Accept: application/json" http://localhost:8080/webapp0/resources/numbers 
    */
    @GET
    public JsonArray numbers() {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        numbers.forEach((number) -> {
            builder.add(number);
        });
        return builder.build();
    }

    /*
    curl -H "Content-Type: application/json" -X POST -d '{"value":"42"}' localhost:8080/webapp0/resources/numbers/create
    */
    @POST 
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    @Metered
    public void createNumber(Number number) {
        if (numbers.add(number.value)) {
            numberCounter.inc();
        }
//        return Response.ok().build();
    }
    
    /*
    curl -H "Content-Type: application/json" -X PUT -d '{"value":"42"}' localhost:8080/webapp0/resources/numbers
    */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Metered
    public void putNumber(Number number) {
        if (numbers.add(number.value + "PUT")) {
            numberCounter.inc();
        }
    }
}

@XmlRootElement
class Number {
    @XmlElement public String value;
}