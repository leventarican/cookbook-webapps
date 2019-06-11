package com.github.leventarican;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author levent@protonmail.com
 */
@Path("machine")
public class Machine {

    @GET
    @Produces(MediaType.TEXT_XML)
    public ServerInfo serverinfo() {
        ServerInfo info = new ServerInfo();
        info.server = System.getProperty("os.name") + " " + System.getProperty("os.version");
        return info;
    }
}

@XmlRootElement
class ServerInfo {
    public String server;
}
