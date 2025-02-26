package it.corso.libreriaits.repository;

import it.corso.libreriaits.model.Carrello;
import org.springframework.data.repository.CrudRepository;

public interface CarrelloRepository extends CrudRepository<Carrello, Integer> {
}
