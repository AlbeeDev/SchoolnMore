package it.corso.libreriaits.repository;

import it.corso.libreriaits.model.Libro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends CrudRepository<Libro, Integer> {
    Libro findLibroById(Integer id);
}
