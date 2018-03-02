package com.solve.prueba.model.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.ReturnInsert;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "VUELOS" database table.
 * 
 */
@Entity
@Table(name="\"VUELOS\"")
@NamedQuery(name="Vuelo.findAll", query="SELECT v FROM Vuelo v")
public class Vuelo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@ReturnInsert(returnOnly = true)
	private Integer id;

	private String aerolinea;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private double valor;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="vuelo")
	private List<Reserva> reservas;

	public Vuelo() {
		super();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAerolinea() {
		return this.aerolinea;
	}

	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setVuelo(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setVuelo(null);

		return reserva;
	}

}