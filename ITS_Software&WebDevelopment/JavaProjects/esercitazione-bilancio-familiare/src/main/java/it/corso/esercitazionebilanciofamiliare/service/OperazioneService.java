package it.corso.esercitazionebilanciofamiliare.service;

import it.corso.esercitazionebilanciofamiliare.model.Operazione;

import java.util.List;

public interface OperazioneService {
    List<Operazione> getAllOperazioni();
    Double getBilancioTotale();
    void aggiungiOperazione(Operazione operazione);
    void eliminaOperazione(Integer id);
}
