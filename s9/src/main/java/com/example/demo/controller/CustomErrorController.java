package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class CustomErrorController {
    @ExceptionHandler(ResourcesNotFound.class)
    public Mono<ServerResponse> adviceNotFound() {
        return ServerResponse.status(HttpStatus.NOT_FOUND).body(BodyInserters.fromValue("Historial no encontrado"));
    }

}


