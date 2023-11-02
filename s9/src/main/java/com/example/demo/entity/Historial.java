package com.example.demo.entity;


public class Historial {

    private String id;

    private String empleadoId;

    private boolean esEntrada;

    private String fecha;

    public Historial(String id, String empleadoId, boolean esEntrada, String fecha) {
        this.id = id;
        this.empleadoId = empleadoId;
        this.esEntrada = esEntrada;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(String empleadoId) {
        this.empleadoId = empleadoId;
    }

    public boolean isEsEntrada() {
        return esEntrada;
    }

    public void setEsEntrada(boolean esEntrada) {
        this.esEntrada = esEntrada;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
