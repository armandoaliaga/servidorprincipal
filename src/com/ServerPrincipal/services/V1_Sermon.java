package com.ServerPrincipal.services;

import java.util.ArrayList;
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
            new Sermon(3,"El nacimiento de Jesus",2004,"Nelson Peñaranda"),
            new Sermon(4,"La creacion I",2004,"Marcos Cabrera"),
            new Sermon(5,"La creacion II",2004,"Juan Perez"),
            new Sermon(6,"Goliat",2004,"Marcelo Diaz"),
            new Sermon(7,"David",2004,"Ruben Quiroz"),
            new Sermon(8,"Sanson",2004,"Nelson Peñaranda"),
            //new Sermon(9,"Saul",2004,"Marcos Cabrera"),
            //new Sermon(10,"Samuel",2004,"Nelson Peñaranda"),
            //new Sermon(11,"Cain y abel",2004,"Ruben Quiroz"),
            //new Sermon(12,"Samuel II",2004,"Marcos Cabrera"),
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

    @GET
    @Path("/addSermon/{name}/{name_of_predicador}/{serie}/{descripcion}")
    public Collection<Sermon> addSermon(@PathParam("name") String name,@PathParam("name_of_predicador") String name_of_predicador,@PathParam("serie") String serie,@PathParam("descripcion") String descripcion) {    	
    	Sermon new_sermon = new Sermon(sermones.get(String.valueOf(sermones.size())).getId()+1, name, 1000, name_of_predicador);
    	Collection<Sermon> result = new ArrayList<Sermon>();
    	
    	if (new_sermon != null)
        {
    		sermones.put(String.valueOf(new_sermon.getId()), new_sermon);
        	log.info("getBook: " + new_sermon);
        	result.add(new_sermon);        	        	        	        
        }              
        return result;
    }   
}
