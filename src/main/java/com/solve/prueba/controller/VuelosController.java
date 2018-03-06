package com.solve.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.solve.prueba.exception.ReservasException;
import com.solve.prueba.model.dto.VuelosDto;
import com.solve.prueba.service.VuelosService;
import com.solve.prueba.util.ConstantesUtil;

@RestController
@RequestMapping(ConstantesUtil.URL_API)
public class VuelosController {
	
	@Autowired private VuelosService vuelosService;
	
	@CrossOrigin
	@RequestMapping(value = ConstantesUtil.CONSULTAR_VUELOS, method = RequestMethod.GET)
	public List<VuelosDto> consultarVuelos() {
		List<VuelosDto> lst = null;
		try {
			lst = vuelosService.getVuelos();
		} catch (ReservasException e) {
			e.printStackTrace();
		}
		return lst;
	}

}
