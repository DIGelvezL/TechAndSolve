package com.solve.prueba.model.request;

import java.io.Serializable;
import java.util.Date;

public class ConsultaReservaRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String cedula;
	private Date fechaReserva;
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public Date getFechaReserva() {
		return fechaReserva;
	}
	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}
	
}
