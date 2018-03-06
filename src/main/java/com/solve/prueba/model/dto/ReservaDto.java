package com.solve.prueba.model.dto;

import java.io.Serializable;
import java.util.Date;

public class ReservaDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date fechaReserva;
	private UsuarioDto usuario;
	private VuelosDto vuelo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getFechaReserva() {
		return fechaReserva;
	}
	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}
	public UsuarioDto getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDto usuario) {
		this.usuario = usuario;
	}
	public VuelosDto getVuelo() {
		return vuelo;
	}
	public void setVuelo(VuelosDto vuelo) {
		this.vuelo = vuelo;
	}
	
}
