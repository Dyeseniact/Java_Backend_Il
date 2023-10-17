package org.example;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class R1 {
    public static void main(String[] args) {
        List<Integer> ids = IntStream.range(0, 1000)
                .boxed()
                .collect(Collectors.toList());
        obtenerSuma(ids.parallelStream());
    }

    private static void obtenerSuma(Stream<Integer> ids) {
        LocalTime inicio = LocalTime.now();
        double suma = ids.mapToDouble(id -> new CadenaRestaurantes()
                        .obtenerGananciasFranquicia(id))
                .sum();
        System.out.println("Ganancias totales: " + String.format("$%.2f", suma));
        Duration tiempo = Duration.between(inicio, LocalTime.now());
        System.out.println((Math.round(suma * 100.) / 100.) + " en " + tiempo.toMillis() + " ms");
    }
}
