package com.ServerPrincipal.services;

public class Sermon {

	private int id;
	private String name;
	private int durationseg;
	private String name_of_predicador;
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

	/*
	@Override
    public String toString() {
        return "Sermon [name=" + name + ", durationseg=" + durationseg + ", predicador=" +predicador+"]";
    }
    */
	
}
