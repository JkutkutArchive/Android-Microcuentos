package com.jkutkut.android_microcuentos.model;

import java.io.Serializable;

public class Cuento implements Serializable {
    private final String titulo;
    private final String avance;
    private final String texto;

    public Cuento(String titulo, String avance, String texto) {
        this.titulo = titulo;
        this.avance = avance;
        this.texto = texto;
    }

    // GETTERS
    public String getTitulo() {
        return titulo;
    }

    public String getAvance() {
        return avance;
    }

    public String getTexto() {
        return texto;
    }
}
