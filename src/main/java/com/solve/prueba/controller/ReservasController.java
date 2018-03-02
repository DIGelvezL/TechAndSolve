package com.solve.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.solve.prueba.exception.ReservasException;
import com.solve.prueba.model.dto.VuelosDto;
import com.solve.prueba.service.ReservasService;

@RestController
@RequestMapping("api/")
public class ReservasController {
	
	@Autowired private ReservasService reservasService;

	@RequestMapping(method=RequestMethod.GET)
	public List<VuelosDto> consultarVuelosDisponibles() {
		List<VuelosDto> lst = null;
		try {
			lst = reservasService.getVuelosDisponibles();
		} catch (ReservasException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}

}
