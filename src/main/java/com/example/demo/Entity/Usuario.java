package com.example.demo.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "USUARIOS")
public class Usuario {
    
	@Id
    private String id;
	
	@Field
    private String userName;
	
	@Field
    private String contrasenia;
	
	@Field
	private String run;
	
	@Field
	private String nombre;
	
	@Field
	private String apePaterno;
	
	@Field
	private String apeMaterno;

    public Usuario() {
    }
    
    public Usuario(String name, String contrasenia, String run, String nombre, String apePaterno, String apeMaterno) {
    	this.userName = name;
    	this.contrasenia = contrasenia;
    	this.run = run;
    	this.nombre = nombre;
    	this.apePaterno = apePaterno;
    	this.apeMaterno = apeMaterno;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getRun() {
        return this.run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getApePaterno() {
        return this.apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }
    
    public String getApeMaterno() {
        return this.apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }
    
}
