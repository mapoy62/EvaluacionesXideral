package com.luv2code.web.jdbc;

public class Student {

	private int id;
	private String nomProd;
	private int cant;
	private int costo;
	private int precio;

	//Método para add-agregar producto
	public Student(String nomProd, int cant, int costo, int precio) {
		this.nomProd = nomProd;
		this.cant = cant;
		this.costo = costo;
		this.precio = precio;
	}

	//Sobrecarga - Método para get-obtener producto 
	public Student(int id, String nomProd, int cant, int costo, int precio) {
		this.id = id;
		this.nomProd = nomProd;
		this.cant = cant;
		this.costo = costo;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomProd() {
		return nomProd;
	}

	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
			this.precio = precio;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", nomProd=" + nomProd + ", cant=" + cant + ", costo=" + costo + ", precio="
				+ precio + "]";
	}
}
