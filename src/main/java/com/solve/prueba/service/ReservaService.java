package com.solve.prueba.service;

import java.util.Date;
import java.util.List;

import com.solve.prueba.exception.ReservasException;
import com.solve.prueba.model.dto.ReservaDto;
import com.solve.prueba.model.response.ReservarVueloResponse;

public interface ReservaService {
	
	ReservarVueloResponse reservarVuelo(ReservaDto reservaDto) throws ReservasException;
	
	List<ReservaDto> consultarByCedula(String cedula) throws ReservasException;
	
	List<ReservaDto> consultarByCedulaFecha(String cedula, Date fecha) throws ReservasException;
}
