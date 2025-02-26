package it.corso.libreriaits.service;

import it.corso.libreriaits.model.Categoria;
import it.corso.libreriaits.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> elencoCategorie() {
        return (List<Categoria>) categoriaRepository.findAll();
    }

    @Override
    public Categoria datiCategoria(int id) {
        return categoriaRepository.findById(id).get();
    }
}
