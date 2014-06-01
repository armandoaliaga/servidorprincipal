package com.ServerPrincipal.services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/s1/service")
public class S1_service {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle()
	{
		return "<p>Java web service</p>";
	}
}
