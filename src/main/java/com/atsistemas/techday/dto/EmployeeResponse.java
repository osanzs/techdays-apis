package com.atsistemas.techday.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeResponse {

	@JsonProperty("uuid")
	private String uuid = null;
	
	@JsonProperty("nombre")
	private String nombre = null;

	@JsonProperty("apellido1")
	private String apellido1 = null;

	@JsonProperty("apellido2")
	private String apellido2 = null;

	@JsonProperty("sede")
	private String sede = null;

	@JsonProperty("modalidad")
	private String modalidad = null;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	@Override
	public String toString() {
		return "EmployeeResponse [uuid=" + uuid + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2="
				+ apellido2 + ", sede=" + sede + ", modalidad=" + modalidad + "]";
	}

	public EmployeeResponse(String uuid, String nombre, String apellido1, String apellido2, String sede,
			String modalidad) {
		super();
		this.uuid = uuid;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.sede = sede;
		this.modalidad = modalidad;
	}

	public EmployeeResponse() {
		super();
		
	}
	
	
}
