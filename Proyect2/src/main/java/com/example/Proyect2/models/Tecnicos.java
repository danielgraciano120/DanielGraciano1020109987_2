package com.example.Proyect2.models;

import java.util.Stack;
import java.util.function.Function;

public class Tecnicos {
    private String nombre;
    private Categoria categoria;
    private Empresa empresa;
    private Stack<Integer> proyectos = new Stack<>();

    public Tecnicos() {}

    public Tecnicos(String nombre, Categoria categoria, Empresa empresa) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.empresa = empresa;
    }

    public void agregarProyecto(int cantidad) {
        proyectos.push(cantidad);
    }

    public Stack<Integer> getProyectos() {
        return proyectos;
    }

    public String getNombre() {
        return nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public int verTotalProyectos(Function<Tecnicos, Integer> funcion) {
        int total = funcion.apply(this);
        System.out.println("Total proyectos de " + nombre + ": " + total);
        return total;
    }

    @Override
    public String toString() {
        return nombre + " - " + categoria + " - " + empresa;
    }
}
