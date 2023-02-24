package com.singleton;

public class Ventanilla {
	
	private String direccion;
	private static Ventanilla vent = new Ventanilla("OficinaY");
	private static int contador;
	
	//Constructor
	private Ventanilla(String direccion) {
		this.direccion = direccion;
		contador++;
	}
	
	public static int getContador() {
		return contador;
	}
	
//	public static String setDireccion() {
//		if(direccion == "col1") {
//			return "OficinaY";
//		}else {
//			return null;
//		}
//	}
	
	//
	public static Ventanilla getInstancia() {
		if(vent==null) {
			return new Ventanilla("OficinaX");
		}else{
			return vent;
		}
	}
}
