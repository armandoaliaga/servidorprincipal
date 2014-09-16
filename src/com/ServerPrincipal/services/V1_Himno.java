package com.ServerPrincipal.services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/v1/himnos")
@Consumes({"application/json"})
@Produces({"application/json"})
public class V1_Himno {	
	private static final Logger log = Logger.getLogger(V1_Himno.class.getName());
	private static Map<String, Himno> himnos= new LinkedHashMap<String, Himno>();     
    static {
    	Himno[] himnosarr=new Himno[]{
    		new Himno(1,407,"Castillo fuerte","Castillo fuerte es nuestro Dios,Defensa y buen escudo.Con su poder nos librar�En todo trance agudo.Con furia y con af�nAc�sanos sat�n:Por armas deja verAstucia y gran poder;Cual �l no hay en la tierra. Nuestro valor es nada aqu�,Con �l todo es perdido;Mas con nosotros luchar�De Dios el escogido.Es nuestro Rey Jes�s,El que venci� en la cruz,Se�or y Salvador,Y siendo El solo Dios,El triunfa en la batalla. Y si demonios mil est�nProntos a devorarnos,No temeremos, porque DiosSabr� c�mo ampararnos.�Que muestre su vigorSat�n, y su furor!Da�arnos no podr�,Pues condenado es yaPor la Palabra Santa. Esa palabra del Se�or,Que el mundo no apetece,Por el Esp�ritu de DiosMuy firme permanece.Nos pueden despojarDe bienes, nombre, hogar,El cuerpo destruir,Mas siempre ha de existir De Dios el Reino eterno. Am�n."),
    		new Himno(2,809,"Cuan grande es Dios","Castillo fuerte es nuestro Dios,Defensa y buen escudo.Con su poder nos librar�En todo trance agudo.Con furia y con af�nAc�sanos sat�n:Por armas deja verAstucia y gran poder;Cual �l no hay en la tierra. Nuestro valor es nada aqu�,Con �l todo es perdido;Mas con nosotros luchar�De Dios el escogido.Es nuestro Rey Jes�s,El que venci� en la cruz,Se�or y Salvador,Y siendo El solo Dios,El triunfa en la batalla. Y si demonios mil est�nProntos a devorarnos,No temeremos, porque DiosSabr� c�mo ampararnos.�Que muestre su vigorSat�n, y su furor!Da�arnos no podr�,Pues condenado es yaPor la Palabra Santa. Esa palabra del Se�or,Que el mundo no apetece,Por el Esp�ritu de DiosMuy firme permanece.Nos pueden despojarDe bienes, nombre, hogar,El cuerpo destruir,Mas siempre ha de existir De Dios el Reino eterno. Am�n."),
    		new Himno(3,927,"Sublime Gracia","Suublime Gracia del Se�or que a un infeliz salvo Fui ciego mas miro yo perdido y El me hallo Su Gracia me ense�o a tener mis dudas ahuyento Oh cuan precioso fue a mi ser cuando el me transformo De mi maldad me liberto mi Salvador me rescato Y como el mar fluye su amor Sublime gracia y amor En los peligros y aflicci�n que yo he tenido aqu� su gracia siempre me libr� y me guiar� al hogar De mi maldad me liberto mi Salvador me rescato Y como el mar fluye su amor Sublime gracia y amor Y cuando en Si�n por siglos mil brillando este cual sol yo cantare por siempre ah� su amor que me salvo"),
    		new Himno(4,218,"Suenen dulces himnos","Suublime Gracia del Se�or que a un infeliz salvo Fui ciego mas miro yo perdido y El me hallo Su Gracia me ense�o a tener mis dudas ahuyento Oh cuan precioso fue a mi ser cuando el me transformo De mi maldad me liberto mi Salvador me rescato Y como el mar fluye su amor Sublime gracia y amor En los peligros y aflicci�n que yo he tenido aqu� su gracia siempre me libr� y me guiar� al hogar De mi maldad me liberto mi Salvador me rescato Y como el mar fluye su amor Sublime gracia y amor Y cuando en Si�n por siglos mil brillando este cual sol yo cantare por siempre ah� su amor que me salvo"),
    		new Himno(5,266,"Tu nombre levantare","Suublime Gracia del Se�or que a un infeliz salvo Fui ciego mas miro yo perdido y El me hallo Su Gracia me ense�o a tener mis dudas ahuyento Oh cuan precioso fue a mi ser cuando el me transformo De mi maldad me liberto mi Salvador me rescato Y como el mar fluye su amor Sublime gracia y amor En los peligros y aflicci�n que yo he tenido aqu� su gracia siempre me libr� y me guiar� al hogar De mi maldad me liberto mi Salvador me rescato Y como el mar fluye su amor Sublime gracia y amor Y cuando en Si�n por siglos mil brillando este cual sol yo cantare por siempre ah� su amor que me salvo"),
    		new Himno(6,285,"Estoy bien","Suublime Gracia del Se�or que a un infeliz salvo Fui ciego mas miro yo perdido y El me hallo Su Gracia me ense�o a tener mis dudas ahuyento Oh cuan precioso fue a mi ser cuando el me transformo De mi maldad me liberto mi Salvador me rescato Y como el mar fluye su amor Sublime gracia y amor En los peligros y aflicci�n que yo he tenido aqu� su gracia siempre me libr� y me guiar� al hogar De mi maldad me liberto mi Salvador me rescato Y como el mar fluye su amor Sublime gracia y amor Y cuando en Si�n por siglos mil brillando este cual sol yo cantare por siempre ah� su amor que me salvo"),
    		new Himno(7,284,"Canta al Se�or","Suublime Gracia del Se�or que a un infeliz salvo Fui ciego mas miro yo perdido y El me hallo Su Gracia me ense�o a tener mis dudas ahuyento Oh cuan precioso fue a mi ser cuando el me transformo De mi maldad me liberto mi Salvador me rescato Y como el mar fluye su amor Sublime gracia y amor En los peligros y aflicci�n que yo he tenido aqu� su gracia siempre me libr� y me guiar� al hogar De mi maldad me liberto mi Salvador me rescato Y como el mar fluye su amor Sublime gracia y amor Y cuando en Si�n por siglos mil brillando este cual sol yo cantare por siempre ah� su amor que me salvo"),
    	};
    	for (Himno himno : himnosarr) {
            himnos.put(String.valueOf(himno.getId()), himno);
        }
    }
    
    @GET
    @Path("/getHimnos")
    public Collection<Himno> getHimnos() {
        Collection<Himno> result = himnos.values();
        log.info("getSermones: " + result);
        return result;
    }
    
    @GET
    @Path("/deleteHimno/{id}")
    public void deleteSermon(@PathParam("id") String id) throws ParseException {    	    	                     
        himnos.remove(id);		
    }   
    
    @GET
    @Path("/getHimno/{id}")
    public Himno getHimno(@PathParam("id") String id) {
    	Himno result=himnos.get(id);
    	log.info("getSermon: " + result);
        return result;        
    }
    
    @GET
    @Path("/addHimno/{numero}/{name}/{lyrics}")
    public Collection<Himno> addHimno(@PathParam("numero") String numero,@PathParam("name") String name,@PathParam("lyrics") String lyrics) throws ParseException {    	    	
    	Himno new_himno = new Himno(himnos.get(String.valueOf(himnos.size())).getId()+1,Integer.parseInt(numero),name, lyrics);
    	Collection<Himno> result = new ArrayList<Himno>();
    	
    	if (new_himno != null)
        {
    		
    		himnos.put(String.valueOf(new_himno.getId()), new_himno);
        	log.info("getBook: " + new_himno);
        	result.add(new_himno);        	        	        	        
        }              
        return result;
    }   
    
}
