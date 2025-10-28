package com.example.Proyect2.models;

import java.util.Deque;

public class Supervisor {
    private String nombre;
    private Categoria categoria;
    private Empresa empresa;
    private Deque<Tecnicos> tecnicos;

    public Supervisor() {}

    public Supervisor(String nombre, Categoria categoria, Empresa empresa, Deque<Tecnicos> tecnicos) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.empresa = empresa;
        this.tecnicos = tecnicos;
    }

    public Deque<Tecnicos> getTecnicos() {
        return tecnicos;
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
}
