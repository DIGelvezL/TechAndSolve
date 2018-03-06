package com.solve.prueba.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.solve.prueba.model.entities.Reserva;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Integer> {

}
