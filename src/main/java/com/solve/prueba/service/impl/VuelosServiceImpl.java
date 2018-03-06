package com.solve.prueba.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solve.prueba.exception.ReservasException;
import com.solve.prueba.model.dto.VuelosDto;
import com.solve.prueba.model.entities.Vuelo;
import com.solve.prueba.repository.VueloRepository;
import com.solve.prueba.service.VuelosService;

@Service
public class VuelosServiceImpl implements VuelosService{
	
	@Autowired VueloRepository vueloRepository;
	
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<VuelosDto> getVuelos() throws ReservasException {
		List<Vuelo> lst = (List<Vuelo>) vueloRepository.findAll();
		
		return lst.stream().map(v -> modelMapper.map(v, VuelosDto.class)).collect(Collectors.toList());
	}
	
}
