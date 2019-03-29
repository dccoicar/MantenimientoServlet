package com.phantom.entity;

public class Persona {
	
	
	private int id;
	private String nombres;
	private String apellidos;
	private String direccion;
	private String paises;
	
	
	public Persona() {
		
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getPaises() {
		return paises;
	}


	public void setPaises(String paises) {
		this.paises = paises;
	}
	
	
}
