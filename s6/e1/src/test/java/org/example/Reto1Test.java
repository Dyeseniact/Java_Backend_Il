package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Reto1Test {

    @Test
    @DisplayName("Convierte enteros  sTRING")
    void string() {
        Integer numero = 1996;
        String string = "1996";

        Reto1<Integer> reto1 = new Reto1<>();

        assertEquals(string, reto1.conversorString(numero));
    }


}