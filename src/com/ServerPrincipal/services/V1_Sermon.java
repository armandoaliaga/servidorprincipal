package com.ServerPrincipal.services;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.ws.rs.*;



@Path("/v1")
@Consumes({"application/json"})
@Produces({"application/json"})
public class V1_Sermon {
	private static final Logger log = Logger.getLogger(V1_Sermon.class.getName());
    private static Map<String, Sermon> sermones= new LinkedHashMap<String, Sermon>();      
    static {
        Sermon[] sermonesarr = new Sermon[]{
            new Sermon(1,"Abraham y el llamado de Dios",1921,"Ruben Quiroz"), 
            new Sermon(2,"David y betsabe",2285,"Marcos Cabrera"), 
        };
        for (Sermon sermon : sermonesarr) {
            sermones.put(String.valueOf(sermon.getId()), sermon);
        }
    } 
    
    @GET
    @Path("/getSermones")
    public Collection<Sermon> getPuntos() {
        Collection<Sermon> result = sermones.values();
        log.info("getSermones: " + result);
        return result;
    }

}
