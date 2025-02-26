package it.corso.esercitazionebilanciofamiliare.service;

import it.corso.esercitazionebilanciofamiliare.model.Operazione;
import it.corso.esercitazionebilanciofamiliare.repository.OperazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperazioneServiceImpl implements OperazioneService{

    @Autowired
    private OperazioneRepository operazioneRepository;

    @Override
    public List<Operazione> getAllOperazioni() {
        return (List<Operazione>) operazioneRepository.findAll();
    }

    @Override
    public Double getBilancioTotale() {
        List<Operazione> operazioni = getAllOperazioni();
        Double bilancioTotale = 0.0;
        for (Operazione operazione : operazioni) {
            bilancioTotale += operazione.getImporto();
        }
        return bilancioTotale;
    }

    @Override
    public void aggiungiOperazione(Operazione operazione) {
        operazioneRepository.save(operazione);
    }

    @Override
    public void eliminaOperazione(Integer id) {
        Operazione op = operazioneRepository.findById(id).get();
        operazioneRepository.delete(op);
    }
}
