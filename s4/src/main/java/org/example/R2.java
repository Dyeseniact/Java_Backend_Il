package org.example;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.OptionalDouble;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class R2 {
    public static void main(String[] args) {
        List<Integer> ids = IntStream.range(0, 1000)
                .boxed()
                .collect(Collectors.toList());
        obtenerSuma(ids);
    }

    private static void obtenerSuma(List<Integer> ids) {
        LocalTime inicio = LocalTime.now();
        List<CompletableFuture<Double>> futuros = ids.stream()
                .map(id -> CompletableFuture.supplyAsync(() -> new CadenaRestaurantes().obtenerGananciasFranquicia(id)))
                .collect(Collectors.toList());

        OptionalDouble suma = futuros.stream()
                .mapToDouble(CompletableFuture::join)
                .max();

        if (suma.isPresent()) {
            System.out.println("Las ganancias son: " + String.format("$%.2f", suma.getAsDouble()));
        } else {
            System.out.println("Error");
        }
    }
}
