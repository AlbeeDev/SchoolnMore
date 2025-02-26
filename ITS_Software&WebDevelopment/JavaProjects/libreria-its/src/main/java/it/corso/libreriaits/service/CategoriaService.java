package it.corso.libreriaits.service;

import it.corso.libreriaits.model.Categoria;

import java.util.List;

public interface CategoriaService {
    List<Categoria> elencoCategorie();
    Categoria datiCategoria(int id);
}
