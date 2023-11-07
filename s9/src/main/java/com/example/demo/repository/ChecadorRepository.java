package com.example.demo.repository;

import com.example.demo.entity.Checador;
import com.example.demo.entity.Empleado;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ChecadorRepository extends ReactiveMongoRepository<Checador, String> {

    @Query(value = "{ 'empleado._id' : ?0, 'esEntrada' : ?1 }", fields = "{ 'empleado' : 0 }")
    Flux<Checador> findByEmpleado(String empleadoId, boolean esEntrada);



}

