package com.ServerPrincipal.services;

import java.util.Date;

public class Sermon {

	private int id;
	private String name;
	private int durationseg;
	private String name_of_predicador;
	private String descripcion;
	private String serie;
	private Date fecha;
	
	//descripcionmensaje serie fecha foto
	
	
	
	public Sermon(String name, int duration , String predicador)
	{
		this.name=name;
		this.durationseg=duration;
		this.name_of_predicador=predicador;
	}
	public Sermon(int id,String name, int duration , String predicador)
	{
		this.id=id;
		this.name=name;
		this.durationseg=duration;
		this.name_of_predicador=predicador;
	}
	
	public Sermon(int id,String name, int duration , String predicador,String descripcion, String serie,Date fecha)
	{
		this.id=id;
		this.name=name;
		this.durationseg=duration;
		this.name_of_predicador=predicador;
		this.descripcion=descripcion;
		this.serie=serie;
		this.fecha=fecha;
	}
	
	public String getName() {
		return name;
	}
	
	public String getName_of_predicador() {
		return name_of_predicador;
	}
	
	public int getDurationseg() {
		return durationseg;
	}
	
	public int getId() {
		return id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public String getSerie() {
		return serie;
	}
	
	public Date getFecha() {
		return fecha;
	}
	

	/*
	@Override
    public String toString() {
        return "Sermon [name=" + name + ", durationseg=" + durationseg + ", predicador=" +predicador+"]";
    }
    */
	
}
