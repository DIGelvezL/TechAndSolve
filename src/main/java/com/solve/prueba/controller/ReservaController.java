package com.solve.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.solve.prueba.exception.ReservasException;
import com.solve.prueba.model.dto.ReservaDto;
import com.solve.prueba.model.response.ReservarVueloResponse;
import com.solve.prueba.service.ReservaService;
import com.solve.prueba.util.ConstantesUtil;

@RestController
@RequestMapping(ConstantesUtil.URL_API)
public class ReservaController {

	@Autowired private ReservaService reservaService;
	
	@CrossOrigin
	@RequestMapping(value = ConstantesUtil.RESERVAR_VUELO, method = RequestMethod.POST, 
			consumes=ConstantesUtil.APPLICATION_JSON,produces = ConstantesUtil.APPLICATION_JSON)
	@ResponseBody
	public ReservarVueloResponse reservarVuelo(@RequestBody ReservaDto reservaDto) {
		ReservarVueloResponse reservarVueloResponse = null;
		try {
			reservarVueloResponse = reservaService.reservarVuelo(reservaDto);
		} catch (ReservasException e) {
			e.printStackTrace();
		}
		return reservarVueloResponse;
	}
}
