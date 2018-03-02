package com.solve.prueba.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solve.prueba.exception.ReservasException;
import com.solve.prueba.model.dto.VuelosDto;
import com.solve.prueba.model.entities.Vuelo;
import com.solve.prueba.repository.VueloRepository;
import com.solve.prueba.service.ReservasService;

@Service
public class ReservasServiceImpl implements ReservasService{
	
	@Autowired VueloRepository vueloRepository;

	@Override
	public List<VuelosDto> getVuelosDisponibles() throws ReservasException {
		List<Vuelo> lst = (List<Vuelo>) vueloRepository.findAll();
		return lst.stream().map(v -> {
			VuelosDto dto = new VuelosDto();
			dto.setId(v.getId());
			dto.setAerolinea(v.getAerolinea());
			dto.setFecha(v.getFecha());
			dto.setValor(v.getValor());
			return dto;
		}).collect(Collectors.toList());
	}
	
	
}
