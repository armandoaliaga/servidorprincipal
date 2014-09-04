package com.ServerPrincipal.services;

import sun.net.www.http.Hurryable;

public class Himno {
	
	private int id;
	private int number;
	private String name;
	private String lyrics;
	//versiculo de apoyo
	//autor cmd
	
	
	public Himno(int n,String name,String lyrics)
	{
		number=n;
		this.name=name;
		this.lyrics=lyrics;
	}
	
	public Himno(int id, int number, String name, String lyrics) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.lyrics = lyrics;
	}

	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLyrics() {
		return lyrics;
	}
	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
