package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EchoClassTest {

    @Test
    @DisplayName("Echo de un string (generic explicito)")
    void echoClassTest() {
        String input = "Hola Mundo";
        String output = EchoClass.<String>echo(input);

        assertEquals(input, output);
    }
}