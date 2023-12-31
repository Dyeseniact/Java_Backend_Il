package org.bedu.jse2.demo.ejemplos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Ejemplo2 {
    public List<Integer> transformar(Iterable<Integer> conjunto, Function<Integer, Integer> funcion){

        List<Integer> nuevaLista = new ArrayList<>();
        for(Integer value : conjunto){
            nuevaLista.add(funcion.apply(value));
        }

        return nuevaLista;
    }
}
