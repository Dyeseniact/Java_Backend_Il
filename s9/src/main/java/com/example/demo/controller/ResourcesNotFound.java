package com.example.demo.controller;

public class ResourcesNotFound extends RuntimeException{
    public ResourcesNotFound(String err) {
        super(err);
    }
}
