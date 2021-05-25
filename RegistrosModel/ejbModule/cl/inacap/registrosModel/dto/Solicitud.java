package cl.inacap.registrosModel.dto;

import java.util.List;

public class Solicitud {
	
	private String rut;
	private String nombre;
	private String tipo;
	private int numeroSoli;
	List<Solicitud> solicitudes ;
	
	
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Solicitud> getSolicitudes() {
		return solicitudes;
	}
	public void setSolicitudes(List<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getNumeroSoli() {
		return numeroSoli;
	}
	public void setNumeroSoli(int numeroSoli) {
		this.numeroSoli = numeroSoli;
	}
	
	
	
	
	
	

}
