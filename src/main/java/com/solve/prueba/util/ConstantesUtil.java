package com.solve.prueba.util;

import java.io.Serializable;

public class ConstantesUtil implements Serializable {

	private static final long serialVersionUID = 5812654133034768859L;
	
	public static final String URL_API="/api";
	public static final String APPLICATION_JSON = "application/json";
	public static final String CONSULTAR_VUELOS = "/vuelos/consultarVuelos";
	public static final String RESERVAR_VUELO = "/reserva/reservarVuelo";
	public static final String CONSULTAR_RESERVA_BY_CEDULA = "/reserva/consultarByCedula";
	public static final String CONSULTAR_RESERVA_BY_CEDULA_FECHA = "/reserva/consultarByCedulaFecha";

}
