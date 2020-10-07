package com.github.leventarican;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class DeveloperResourceTest {

    @Test
    public void testEndpoint() {
        given()
          .when().get("/developer/code")
          .then()
             .statusCode(200)
             .body(is("code"));
    }

}