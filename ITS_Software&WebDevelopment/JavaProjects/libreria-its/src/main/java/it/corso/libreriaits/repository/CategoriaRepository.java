package it.corso.libreriaits.repository;

import it.corso.libreriaits.model.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {
}
