package com.solve.prueba.service;

import java.util.List;

import com.solve.prueba.exception.ReservasException;
import com.solve.prueba.model.dto.VuelosDto;

public interface ReservasService {

	List<VuelosDto> getVuelosDisponibles() throws ReservasException;

}
