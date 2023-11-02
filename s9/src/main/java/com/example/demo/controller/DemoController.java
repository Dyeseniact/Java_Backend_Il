package com.example.demo.controller;

import com.example.demo.entity.Empleado;
import com.example.demo.entity.Historial;
import com.example.demo.repository.EmpleadoRepository;
import com.example.demo.repository.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.*;

@RestController
@RequestMapping("/empleados")
public class DemoController {
    
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private HistorialRepository historialRepository;

    @GetMapping("/{id}")
    private Mono<Empleado> getEmpleadoById(@PathVariable String id) {
        return empleadoRepository.findById(id);
    }

    @GetMapping("/historial/{id}")
    private Mono<Historial> getHistorialById(@PathVariable String id) {
        return historialRepository.findById(id).switchIfEmpty(Mono.error(new ResourcesNotFound("No se encontro el historial")));
    }

    @GetMapping
    private Flux<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @PostMapping
    private Mono<Empleado> crear(@RequestBody Empleado empleado) {
        return empleadoRepository.findById(empleado.getId())
                .flatMap(empleadoRegistrado -> Mono.error(
                        new Exception(String.format("Empleado con el id %s ya existe!!!", empleadoRegistrado.getId())))
                )
                .cast(Empleado.class)
                .switchIfEmpty(empleadoRepository.save(empleado));
        //return empleadoRepository.save(empleado);
    }

    @PostMapping("/historial")
    private Mono<Historial> crearHistorial(@RequestBody Historial historial) {
        return historialRepository.findById(historial.getId())
                .flatMap(historialRegistrado -> Mono.error(
                        new Exception(String.format("El empleado no se registro en el historial con el id %s", historialRegistrado.getId())))
                )
                                .cast(Historial.class)
                                .switchIfEmpty(historialRepository.save(historial));

    }


    @PutMapping("/{id}")
    public Mono<Empleado> actualizar(@PathVariable String id, @RequestBody Empleado empleado) {
        return empleadoRepository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("El empleado no existe")))
                .map(fetchedEmpleado -> {
                    fetchedEmpleado.setNombre(empleado.getNombre());
                    return fetchedEmpleado;
                })
                .flatMap(empleadoRepository::save);
    }

    @PutMapping("/historial/{id}")
    public Mono<Historial> actualizarHistorial(@PathVariable String id, @RequestBody Historial historial) {
        return historialRepository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("El historial no existe, el empleado no se registro.")))
                .map(fetchedHistorial -> {
                    fetchedHistorial.setEmpleadoId(historial.getEmpleadoId());
                    fetchedHistorial.setEsEntrada(historial.isEsEntrada());
                    fetchedHistorial.setFecha(historial.getFecha());
                    return fetchedHistorial;
                })
                .flatMap(historialRepository::save);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminar(@PathVariable String id){
        return empleadoRepository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("El empleado no existe")))
                .flatMap(empleadoRepository::delete);
    }

    @DeleteMapping("/historial/{id}")
    public  Mono<Void> eliminarHistorial(@PathVariable String id) {
        return historialRepository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("El historial no existe")))
                .flatMap(historialRepository::delete);
    }


}
