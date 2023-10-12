package org.bedu.jse2.demo.ejemplos;

import java.util.function.Function;

public class Ejemplo1 {
//    Con función anonima
//    private final StringToInteger parser = new StringToInteger() {
//        @Override
//        public Integer convertir(String str) {
//            return Integer.parseInt(str);
//        }
//    };

//    Con lambda
//    private final StringToInteger parser = str -> Integer.parseInt(str);

    //    Lambda con metodo de referencia
    private final StringToInteger parser = Integer::parseInt;
    /*Integer sumar(String a, String b){
        return parser.convertir(a) + parser.convertir(b);
    }*/

    // Reto 01 ---
    private final Function<String, Integer> parser2 = Integer::parseInt;
    public Integer sumar(String a, String b) {
        return parser2.apply(a) * parser2.apply(b);
    }
}