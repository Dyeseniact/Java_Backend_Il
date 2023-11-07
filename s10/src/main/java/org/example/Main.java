package org.example;

import org.example.hilos.Hilos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Hilo de usuario vive en el proyecto y espera a que todos los hilos finalizen

//Hilo demonio vove en el sistema, en la maquina virtual y no espera a que los hilos finalicen para terminar la ejecución se continuan ejecutando en la VM

public class Main {
    public static void main(String[] args) {
//        HILOS
        for (int i = 0; i < 10; i++) {
//            new Hilos("Hilo " + i, 10000).start();

            Thread hilo = new Hilos("Hilo " + i, 10000);
            hilo.setDaemon(true);
            hilo.start();
        }

        System.out.println(sizeOf.apply("Bedu"));
        System.out.println(sizeOfLambda.apply("Bedu"));
        System.out.println(new SizeOfFunction().apply("Bedu"));

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Beto"));
        personas.add(new Persona("Carlos"));
        personas.add(new Persona("Andrés"));

        personas.sort(Comparator.comparing(p -> p.nombre));

        Stream<Persona> stream = personas.stream();
        List<String> nombres = stream
                .filter(p -> p.nombre != null)
                .map(p -> p.nombre)
                .collect(Collectors.toList());

        System.out.println(nombres);
    }

//    LAMBDA - > Son funcionen sin nombre, mas rapidas.
    static Function<String, Integer> sizeOf = (String placeholder) -> {
        return placeholder.length();
    };

    static Function<String, Integer> sizeOfLambda = placeholder -> placeholder.length();

    public static class SizeOfFunction implements Function<String, Integer> {
        public Integer apply(String placeholder){
            return placeholder.length();
        }
    }

    static class Persona{
        String nombre;
        Persona(String nombre){
            this.nombre = nombre;
        }
    }
}