package com.solve.prueba.service;

import com.solve.prueba.exception.ReservasException;
import com.solve.prueba.model.dto.ReservaDto;
import com.solve.prueba.model.response.ReservarVueloResponse;

public interface ReservaService {
	
	ReservarVueloResponse reservarVuelo(ReservaDto reservaDto) throws ReservasException;
}
