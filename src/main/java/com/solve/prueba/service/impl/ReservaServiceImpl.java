package com.solve.prueba.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solve.prueba.exception.ReservasException;
import com.solve.prueba.model.dto.ReservaDto;
import com.solve.prueba.model.dto.RespuestaDto;
import com.solve.prueba.model.entities.Reserva;
import com.solve.prueba.model.entities.Usuario;
import com.solve.prueba.model.response.ReservarVueloResponse;
import com.solve.prueba.repository.ReservaRepository;
import com.solve.prueba.repository.UsuarioRepository;
import com.solve.prueba.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService {

	@Autowired UsuarioRepository usuarioRepository;
	@Autowired ReservaRepository reservaRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public ReservarVueloResponse reservarVuelo(ReservaDto reservaDto) throws ReservasException {
		ReservarVueloResponse reservarVueloResponse = new ReservarVueloResponse();
		
		if(Objects.nonNull(reservaDto)){
		
			Reserva reserva = modelMapper.map(reservaDto, Reserva.class);
			
			if(Objects.nonNull(reserva.getUsuario())){
			
				Usuario usuario = usuarioRepository.findByCedula(reserva.getUsuario().getCedula());
				
				if(Objects.nonNull(usuario)){
					reserva.setUsuario(usuario);
					reservaRepository.save(reserva);
				}else{
					usuarioRepository.save(reserva.getUsuario());
					reservaRepository.save(reserva);
				}
				
				dtoAssemblerRespuesta(reservarVueloResponse);
			}
		}
		
		return reservarVueloResponse;
	}
	
	private void dtoAssemblerRespuesta(ReservarVueloResponse reservarVueloResponse) {
		RespuestaDto respuesta = new RespuestaDto();
		respuesta.setCodigo(0);
		respuesta.setDescripcion("OK");
		reservarVueloResponse.setRespuestaDto(respuesta);
	}
	
	@Override
	public List<ReservaDto> consultarByCedula(String cedula) throws ReservasException {
		
		List<Reserva> reserva = reservaRepository.consultarByCedula(cedula);
		
		if(Objects.nonNull(reserva) && !reserva.isEmpty()){
			return reserva.stream().map(r -> modelMapper.map(r, ReservaDto.class)).collect(Collectors.toList());
		}
		
		return new ArrayList<>();
	}
	
	@Override
	public List<ReservaDto> consultarByCedulaFecha(String cedula, Date fecha) throws ReservasException {
		
		List<Reserva> reserva = reservaRepository.consultarByCedulaFecha(cedula, fecha);
		
		if(Objects.nonNull(reserva) && !reserva.isEmpty()){
			return reserva.stream().map(r -> modelMapper.map(r, ReservaDto.class)).collect(Collectors.toList());
		}
		
		return new ArrayList<>();
	}

}
