package com.ipartek.pojo;

public class Busqueda {
	
	private int id;	
	private String codigo; // Es un string por lo que pueda introducir el usuario
	private int id_usuario;
	
	public Busqueda() {
		super();
		this.id = -1;
		this.codigo = "";
		this.id_usuario = -1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	@Override
	public String toString() {
		return "CodigoPostal [id=" + id + ", codigo=" + codigo + ", id_usuario=" + id_usuario + "]";
	}


	
	
	
	
}
