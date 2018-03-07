package com.solve.prueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.solve.prueba.model.entities.Reserva;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Integer> {

	@Query(value = "SELECT r FROM Reserva r JOIN r.usuario u WHERE u.cedula = :cedula ")
	public List<Reserva> consultarByCedula(@Param("cedula") String cedula);
}
