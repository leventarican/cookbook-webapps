package com.airhacks.ping.boundary;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;
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
    
    @Resource(lookup = "jdbc/postgrespool")
    DataSource ds;

    @GET
    public String ping() {
         String schema = "#";
        try {
            schema = ds.getConnection().getSchema();
        } catch (SQLException ex) {
            Logger.getLogger(PingResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return this.message + " Jakarta EE with MicroProfile 2+!; postgres: " + schema;
    }

}
