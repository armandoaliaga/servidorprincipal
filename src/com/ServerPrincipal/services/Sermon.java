package com.ServerPrincipal.services;

public class Sermon {

	private int id;
	private String name;
	private int durationseg;
	private String name_of_predicador;
	private String descripcion;
	private String serie;
	private String fecha;
	private String shareableURL="https://www.dropbox.com/s/3qhqrejv088pjd4/dbz.mp3?dl=1";
	//https://www.dropbox.com/s/3qhqrejv088pjd4/dbz.mp3?dl=1
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
	
	public Sermon(int id,String name, int duration , String predicador,String descripcion, String serie,String fecha)
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
	
	public String getFecha() {
		return fecha;
	}
	public String getShareableURL() {
		return shareableURL;
	}
	public void setShareableURL(String shareableURL) {
		this.shareableURL = shareableURL;
	}
	

	/*
	@Override
    public String toString() {
        return "Sermon [name=" + name + ", durationseg=" + durationseg + ", predicador=" +predicador+"]";
    }
    */
	
}
