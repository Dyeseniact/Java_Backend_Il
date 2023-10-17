package org.example;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CadenaRestaurantes {
    private Random random = new Random();

    public double obtenerGananciasFranquicia(int id) {
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return random.nextInt(40000) + 10000;
    }
}
