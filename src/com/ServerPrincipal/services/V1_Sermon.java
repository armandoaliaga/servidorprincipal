package com.ServerPrincipal.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;

import javax.media.Duration;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;


@Path("/v1")
@Consumes({"application/json"})
@Produces({"application/json"})
public class V1_Sermon {
	private static final Logger log = Logger.getLogger(V1_Sermon.class.getName());
    private static Map<String, Sermon> sermones= new LinkedHashMap<String, Sermon>();      
    static {
        Sermon[] sermonesarr = new Sermon[]{
            new Sermon(1,"Abraham y el llamado de Dios",1921,"Ruben Quiroz","descripcion jaja","Abraham","2014-08-01"), 
            new Sermon(2,"David y betsabe",2285,"Marcos Cabrera","descripcion jaja","Abraham","2014-08-02"), 
            new Sermon(3,"El nacimiento de Jesus",2004,"Nelson Peñaranda","descripcion jaja","asdfsa","2014-08-03"),
            new Sermon(4,"La creacion I",2004,"Marcos Cabrera","descripcion jaja","Abraham","2014-08-08"),
            new Sermon(5,"La creacion II",2004,"Juan Perez","descripcion jaja","Abraham","2014-08-07"),
            new Sermon(6,"Goliat",2004,"Marcelo Diaz","descripcion jaja","Abraham","2014-08-06"),
            new Sermon(7,"David",2004,"Ruben Quiroz","descripcion jaja","Abraham","2014-08-09"),
            new Sermon(8,"Sanson",2004,"Nelson Peñaranda","descripcion jaja","Abraham","2014-08-04"),
            new Sermon(9,"Saul",2004,"Marcos Cabrera","descripcion jaja","Abraham","2014-08-05"),
            new Sermon(10,"Samuel",2004,"Nelson Peñaranda","descripcion jaja","Abraham","2014-08-10"),
            new Sermon(11,"Cain y abel",2004,"Ruben Quiroz","descripcion jaja","Abraham","2014-08-12"),
            new Sermon(12,"Samuel II",2004,"Marcos Cabrera","descripcion jaja","Abraham","2014-08-11"),
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
    @Path("/addSermon/{name}/{name_of_predicador}/{serie}/{descripcion}/{fecha}")
    public Collection<Sermon> addSermon(@PathParam("name") String name,@PathParam("name_of_predicador") String name_of_predicador,@PathParam("serie") String serie,@PathParam("descripcion") String descripcion,@PathParam("fecha") String fecha) throws ParseException {    	
    	Sermon new_sermon = new Sermon(sermones.get(String.valueOf(sermones.size())).getId()+1, name, 1000, name_of_predicador,descripcion,serie,fecha);
    	Collection<Sermon> result = new ArrayList<Sermon>();
    	
    	if (new_sermon != null)
        {
    		sermones.put(String.valueOf(new_sermon.getId()), new_sermon);
        	log.info("getBook: " + new_sermon);
        	result.add(new_sermon);        	        	        	        
        }              
        return result;
    }   
    
    
    @GET
    @Path("/deleteSermon/{id}")
    public void deleteSermon(@PathParam("id") String id) throws ParseException {    	    	                     
        sermones.remove(id);		
    } 
    
    @GET
    @Path("/updateSermon/{id}/{name}/{name_of_predicador}/{serie}/{descripcion}/{fecha}")
    public Collection<Sermon> updateSermon(@PathParam("id") int id,@PathParam("name") String name,@PathParam("name_of_predicador") String name_of_predicador,@PathParam("serie") String serie,@PathParam("descripcion") String descripcion,@PathParam("fecha") String fecha) throws ParseException {    	
    	Sermon new_sermon = new Sermon(id,name,1000,name_of_predicador,descripcion,serie,fecha);
    	Collection<Sermon> result = new ArrayList<Sermon>();
    	
    	if (new_sermon != null)
        {        	
    		sermones.put(String.valueOf(id), new_sermon);
        	result.add(new_sermon);        	        	        	        
        }              
        return result;
    }   
    
    @GET
    @Path("/getSermon/{id}")
    public Sermon getPuntos(@PathParam("id") String id) {
    	Sermon result=sermones.get(id);
    	log.info("getSermon: " + result);
        return result;        
    }
    
    @GET
    @Path("/seturlSermon/{id}/{filename}")
    public Collection<Sermon> seturlSermon(@PathParam("id") int id,@PathParam("filename") String filename) throws ParseException {    	
    	
    	final String APP_KEY = "8izb50c4q7igf9h";
        final String APP_SECRET = "ksymf11y11ws3gn";

        DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);

        DbxRequestConfig config = new DbxRequestConfig("JavaTutorial/1.0", Locale.getDefault().toString());
    	
        String accessToken = "FWVemrNp-3EAAAAAAAAAGgNEHLFXNCVnqPh9_jmCwLbC0I5TM8WSxArUxdS87Otu";//authFinish.accessToken;
        
        DbxClient client = new DbxClient(config, accessToken);
    	
        try {
			System.out.println("Linked account: " + client.getAccountInfo().displayName);
		} catch (DbxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String ruta="";
        try {
			ruta=client.createShareableUrl("/"+filename);
			System.out.println(ruta);
		} catch (DbxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	ruta=ruta.substring(0,ruta.length()-1)+"1";
    	
    	Sermon new_sermon = sermones.get(String.valueOf(id));
    	Collection<Sermon> result = new ArrayList<Sermon>();
    	
    	if (new_sermon != null)
        {        	
    		new_sermon.setShareableURL(ruta);
    		sermones.put(String.valueOf(id), new_sermon);
        	result.add(new_sermon);        	        	        	        
        }              
        return result;
    }   
    
    @POST
    @Path("/nuevosermon")
    public Response createProductInJSON(Sermon product) {
    	 
		String result = "Product created : " + product;
		sermones.put(String.valueOf(product.getId()), product);
		return Response.status(201).entity(result).build();
 
	}
}
