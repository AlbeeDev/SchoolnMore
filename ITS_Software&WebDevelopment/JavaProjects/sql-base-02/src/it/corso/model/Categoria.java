package it.corso.model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private int id;
    private String descrizione;

    private List<Libro> libri = new ArrayList<Libro>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public List<Libro> getLibri() {
        return libri;
    }

    public void setLibri(List<Libro> libri) {
        this.libri = libri;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}
