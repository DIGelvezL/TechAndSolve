package com.solve.prueba.service;

import java.util.List;

import com.solve.prueba.exception.ReservasException;
import com.solve.prueba.model.dto.VuelosDto;

public interface VuelosService {

	List<VuelosDto> getVuelos() throws ReservasException;

}
