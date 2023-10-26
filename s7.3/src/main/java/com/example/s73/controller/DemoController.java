package com.example.s73.controller;

import com.example.s73.entity.Empleado;
import com.example.s73.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/empleados")
public class DemoController {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping
    private Flux<Empleado> getAllEmpleados() {
        return empleadoRepository.findAllEmpleados();
    }

    @GetMapping("/{id}")
    private Mono<Empleado> getEmpleado(@PathVariable String id) {
        return empleadoRepository.findEmpleadoByIdd(id);
    }

    @PutMapping("/update")
    private Mono<Empleado> updateEmnpleado(@RequestBody Empleado empleado) {
        return empleadoRepository.updateEmpleado(empleado);
    }
}
