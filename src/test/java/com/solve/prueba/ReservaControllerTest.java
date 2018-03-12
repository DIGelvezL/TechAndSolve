package com.solve.prueba;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.solve.prueba.controller.ReservaController;
import com.solve.prueba.model.dto.ReservaDto;
import com.solve.prueba.model.dto.UsuarioDto;
import com.solve.prueba.model.dto.VuelosDto;
import com.solve.prueba.model.entities.Usuario;
import com.solve.prueba.model.response.ReservarVueloResponse;
import com.solve.prueba.repository.ReservaRepository;
import com.solve.prueba.repository.UsuarioRepository;
import com.solve.prueba.service.ReservaService;
import com.solve.prueba.service.impl.ReservaServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservaControllerTest {
	
	ReservaController reservaController = new ReservaController();
	@InjectMocks ReservaService reservaService = new ReservaServiceImpl();
	@Mock UsuarioRepository usuarioRepository;
	@Mock ReservaRepository reservaRepository;
	
	@Before
	public void main(){
		ReflectionTestUtils.setField(reservaController, "reservaService", reservaService);
		ReflectionTestUtils.setField(reservaService, "usuarioRepository", usuarioRepository);
		ReflectionTestUtils.setField(reservaService, "reservaRepository", reservaRepository);
	}
	
	@Test
	public void reservarVueloDtoNull() {
		
		ReservarVueloResponse reservarVueloResponse = reservaController.reservarVuelo(null);
		assertEquals(null, reservarVueloResponse.getRespuestaDto());
	}
	
	@Test
	public void reservarVueloDtoNonNull() {
		Usuario arg1 = new Usuario();
		arg1.setId(1);
		arg1.setNombre("daniel");
		arg1.setApellido("gelvez");
		arg1.setCedula("123");
		
		Mockito.when(usuarioRepository.findByCedula(Mockito.anyString())).thenReturn(arg1);
		
//		Mockito.when(reservaRepository.save(Mockito.any()));
		
		ReservaDto reservaDto = new ReservaDto();
		reservaDto.setId(null);
		reservaDto.setFechaReserva(new Date());
		
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setId(1);
		usuarioDto.setNombre("daniel");
		usuarioDto.setApellido("gelvez");
		usuarioDto.setCedula("123");
		reservaDto.setUsuario(usuarioDto);
		
		VuelosDto vuelosDto = new VuelosDto();
		reservaDto.setVuelo(vuelosDto);
		
		ReservarVueloResponse reservarVueloResponse = reservaController.reservarVuelo(reservaDto);
		assertEquals("OK", reservarVueloResponse.getRespuestaDto().getDescripcion());
	}
	
	@Test
	public void reservarVueloDtoVacio() {
		Usuario arg1 = new Usuario();
		arg1.setId(1);
		arg1.setNombre("daniel");
		arg1.setApellido("gelvez");
		arg1.setCedula("123");
		
		Mockito.when(usuarioRepository.findByCedula(Mockito.anyString())).thenReturn(arg1);
		
		ReservaDto reservaDto = new ReservaDto();
		
		ReservarVueloResponse reservarVueloResponse = reservaController.reservarVuelo(reservaDto);
		assertEquals(null, reservarVueloResponse.getRespuestaDto());
	}
	
	@Test
	public void reservarVueloUsuarioEntityNull() {
		
		Mockito.when(usuarioRepository.findByCedula(Mockito.anyString())).thenReturn(null);
		
		ReservaDto reservaDto = new ReservaDto();
		reservaDto.setId(null);
		reservaDto.setFechaReserva(new Date());
		
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setId(1);
		usuarioDto.setNombre("daniel");
		usuarioDto.setApellido("gelvez");
		usuarioDto.setCedula("123");
		reservaDto.setUsuario(usuarioDto);
		
		VuelosDto vuelosDto = new VuelosDto();
		reservaDto.setVuelo(vuelosDto);
		
		ReservarVueloResponse reservarVueloResponse = reservaController.reservarVuelo(reservaDto);
		assertEquals("OK", reservarVueloResponse.getRespuestaDto().getDescripcion());
	}

}
