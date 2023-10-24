package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Reto2Test {

    @Test
    @DisplayName("Prueba con Integers")
    void conversorString() {
        Integer entrada = 23423;
        String resultado = "23423";

        String output = Reto2.conversorString(entrada);

        assertEquals(resultado, output);
    }
}