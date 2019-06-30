package com.github.leventarican.boundary;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.leventarican.control.DeveloperHub;
import com.github.leventarican.entity.Developer;

@Stateless
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Path("dev")
public class DeveloperApi {
	
	@Inject
	DeveloperHub hub;
	
    @GET
	public Developer getDeveloper() {
		return hub.getDeveloper();
	}
}
