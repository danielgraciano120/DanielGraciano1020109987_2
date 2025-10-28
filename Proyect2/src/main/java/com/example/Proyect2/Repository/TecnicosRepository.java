package com.example.Proyect2.Repository;

import com.example.Proyect2.models.*;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class TecnicosRepository {

    private Stack<Tecnicos> tecnicos = new Stack<>();
    private Supervisor supervisor;

    public TecnicosRepository() {
        // Arrays de enums disponibles
        Empresa[] empresas = Empresa.values();
        Categoria[] categorias = Categoria.values();

        // Crear 10 técnicos con distintas combinaciones de empresa y categoría
        for (int i = 0; i < 10; i++) {
            Empresa empresa = empresas[i % empresas.length];      // Rotar empresas
            Categoria categoria = categorias[i % categorias.length]; // Rotar categorías

            Tecnicos tecnico = new Tecnicos("Técnico " + (i + 1), categoria, empresa);

            // Asignar proyectos (número aleatorio de completados)
            for (int j = 0; j < 5; j++) {
                tecnico.agregarProyecto((int) (Math.random() * 10 + 1));
            }

            tecnicos.push(tecnico);
        }

        // Crear el supervisor (asignarle todos los técnicos)
        Deque<Tecnicos> cuadrilla = new ArrayDeque<>(tecnicos);
        supervisor = new Supervisor("Carlos Ramírez", Categoria.SOFTWARE, Empresa.GOOGLE, cuadrilla);
    }

    public Stack<Tecnicos> getTecnicos() {
        return tecnicos;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }
}