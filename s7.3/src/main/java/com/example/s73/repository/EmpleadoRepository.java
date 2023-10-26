package com.example.s73.repository;

import com.example.s73.entity.Empleado;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EmpleadoRepository {
    static Map<String, Empleado> empleadoMap;

    static {
        empleadoMap = new HashMap<>();
        empleadoMap.put("1", new Empleado("1", "Empleado 1"));
        empleadoMap.put("2", new Empleado("2", "Empleado 2"));
        empleadoMap.put("3", new Empleado("3", "Empleado 3"));
        empleadoMap.put("4", new Empleado("4", "Empleado 4"));
        empleadoMap.put("5", new Empleado("5", "Empleado 5"));
        empleadoMap.put("6", new Empleado("6", "Empleado 6"));
        empleadoMap.put("7", new Empleado("7", "Empleado 7"));
        empleadoMap.put("8", new Empleado("8", "Empleado 8"));
        empleadoMap.put("9", new Empleado("9", "Empleado 9"));
        empleadoMap.put("10", new Empleado("10", "Empleado 10"));

    }

    //Busquedas sin bloquear el hilo principal
    public Mono<Empleado> findEmpleadoByIdd(String id) {
        return Mono.just(empleadoMap.get(id)); //Mono cuando ejecurte no bloquee la interfaz
    }

    public Flux<Empleado> findAllEmpleados(){
        return Flux.fromIterable(empleadoMap.values()); //no sabemos la cantidad por eso usamos flux no bloquea pero lo hace de manera asincrona hasta que termina
    }

    public Mono<Empleado> updateEmpleado(Empleado employee) {
        Empleado existeEmpleado = empleadoMap.get(employee.getId()); //lo buscamos
        if (existeEmpleado != null) {
            existeEmpleado.setNombre(employee.getNombre()); //si lo encuentra cambia el nombre
        }
        return Mono.just(existeEmpleado);
    }
}
