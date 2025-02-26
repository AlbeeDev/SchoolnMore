package it.corso.esercitazionebilanciofamiliare.repository;

import it.corso.esercitazionebilanciofamiliare.model.Operazione;
import org.springframework.data.repository.CrudRepository;

public interface OperazioneRepository extends CrudRepository<Operazione, Integer> {
}
