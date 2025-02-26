package it.corso.libreriaits.repository;

import it.corso.libreriaits.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
    Cliente findByProfiloUsername(String username);
}
