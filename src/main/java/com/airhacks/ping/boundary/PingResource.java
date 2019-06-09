package com.airhacks.ping.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author airhacks.com
 */
@Path("ping")
public class PingResource {

    @Inject
    @ConfigProperty(name = "message")
    String message;    

    @GET
    public String ping() {
//        int a = 100000000;
//        while(a > 0) {
//            a--;
//            Foobar f = new Foobar();
//            f.foo();
//        }
        return this.message + " Jakarta EE with MicroProfile";
    }
    
    class Foobar{
        int a = 2000000;
        int b = 1;
        Foobar() {
            while(a > 0) {
                a -= b;
            }
        }
        void foo() {
            ;
        }
    }
}