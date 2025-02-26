package it.corso.libreriaits.service;

import it.corso.libreriaits.model.*;
import it.corso.libreriaits.repository.CarrelloRepository;
import it.corso.libreriaits.repository.ClienteRepository;
import it.corso.libreriaits.repository.LibroRepository;
import it.corso.libreriaits.repository.OrdineRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrdineServiceImpl implements OrdineService {

    @Autowired
    private OrdineRepository ordiniRepository;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private CarrelloRepository carrelloRepository;
    @Autowired
    private LibroRepository libroRepository;


    @Override
    public String invioOrdine(HttpSession session) {
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        cliente = clienteRepository.findById(cliente.getId()).get();

        Carrello carrello = cliente.getCarrello();
        List<LibroCarrello> libriCarrello = carrello.getLibriCarrello();

        double totaleCarrello = 0;
        for (LibroCarrello libroCarrello : libriCarrello) {
            Libro libro = libroCarrello.getLibro();
            if(libro.getCopieDisponibili() == 0){
                libriCarrello.remove(libroCarrello);
                if(libriCarrello.isEmpty()){
                    cliente.setCarrello(null);
                    clienteRepository.save(cliente);
                    carrelloRepository.delete(carrello);
                } else {
                    carrello.setCliente(cliente);
                    cliente.setCarrello(carrello);
                    carrelloRepository.save(carrello);
                }
                return "libro "+libro.getTitolo()+" non disponibile";
            } else if (libro.getCopieDisponibili() < libroCarrello.getNumeroCopie()) {
                libroCarrello.setNumeroCopie(libro.getCopieDisponibili());
                carrello.setCliente(cliente);
                cliente.setCarrello(carrello);
                carrelloRepository.save(carrello);
                return "libro "+libro.getTitolo()+" copie rimaste "+ libro.getCopieDisponibili();
            } else {
                totaleCarrello += libro.getPrezzo() * libroCarrello.getNumeroCopie();
            }
        }

        Ordine ordine = new Ordine();
        ordine.setCliente(cliente);
        ordine.setRicezione(LocalDateTime.now());
        ordine.setTotale(totaleCarrello);
        for (LibroCarrello libroCarrello : libriCarrello) {
            LibroOrdine libroOrdine = new LibroOrdine();
            libroOrdine.setNumeroCopie(libroCarrello.getNumeroCopie());
            libroOrdine.setPrezzoUnitario(libroCarrello.getLibro().getPrezzo());
            libroOrdine.setLibro(libroCarrello.getLibro());
            libroOrdine.setOrdine(ordine);
            ordine.getLibriOrdine().add(libroOrdine);

            libroOrdine.getLibro().setCopieDisponibili(libroOrdine.getLibro().getCopieDisponibili()-libroOrdine.getNumeroCopie());
            libroRepository.save(libroOrdine.getLibro());
        }

        ordiniRepository.save(ordine);

        cliente.setCarrello(null);
        clienteRepository.save(cliente);
        carrelloRepository.delete(carrello);

        return "ordine confermato";
    }
}
