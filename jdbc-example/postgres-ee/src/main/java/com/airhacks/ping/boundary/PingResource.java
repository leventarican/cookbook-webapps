package com.airhacks.ping.boundary;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
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
 * add datasource
 */
@Path("ping")
public class PingResource {
    
//    table programming_lanuages has two columnd: 1=id, 2=name
    final static int COLUMN_NAME = 2;

    @Inject
    @ConfigProperty(name = "query")
    String query;
    
    @Resource(lookup = "jdbc/postgrespool")
    DataSource ds;

    @GET
    public String ping() {
        String output = "";
        try {
            Connection connection = ds.getConnection();
            ResultSet result = connection.createStatement().executeQuery(query);
            while (result.next()) {
                output += result.getString(1) + "<p>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(PingResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }

}
