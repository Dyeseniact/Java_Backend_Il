package com.example.demo.repository;

import com.example.demo.entity.Empleado;
import com.example.demo.entity.Historial;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialRepository extends ReactiveMongoRepository<Historial, String> {
}
