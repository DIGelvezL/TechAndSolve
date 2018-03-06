package com.solve.prueba.model.response;

import java.io.Serializable;

import com.solve.prueba.model.dto.RespuestaDto;

public class ReservarVueloResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private RespuestaDto respuestaDto;

	public RespuestaDto getRespuestaDto() {
		return respuestaDto;
	}

	public void setRespuestaDto(RespuestaDto respuestaDto) {
		this.respuestaDto = respuestaDto;
	}
	
}
