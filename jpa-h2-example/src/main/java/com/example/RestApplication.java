package com.example;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class RestApplication extends Application {
    // Empty class is enough. It just signals to the JAX-RS runtime that this is a JAX-RS application.
}
