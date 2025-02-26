package it.corso.libreriaits.service;

import it.corso.libreriaits.model.*;
import it.corso.libreriaits.repository.CarrelloRepository;
import it.corso.libreriaits.repository.ClienteRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CarrelloRepository carrelloRepository;

    @Autowired
    private LibroService libroService;

    @Override
    public String controlloLogin(String username, String password, HttpSession session) {
        Cliente cliente = clienteRepository.findByProfiloUsername(username);
        if(cliente == null || !cliente.getProfilo().getPassword().equals(password)) {
            return "Credenziali Errate";
        }
        session.setAttribute("cliente", cliente);
        return "Login Autorizzato";
    }

    @Override
    public String aggiuntaCarrello(Integer idLibro, HttpSession session) {
        Libro libro = libroService.datiLibro(idLibro);
        Cliente clienteSession = (Cliente) session.getAttribute("cliente");
        Cliente cliente = clienteRepository.findById(clienteSession.getId()).get();

        if(cliente.getCarrello() == null) {
            Carrello carrello = new Carrello();
            carrello.setCliente(cliente);
            cliente.setCarrello(carrello);
        }

        for (LibroCarrello libroCarrello : cliente.getCarrello().getLibriCarrello()){
            if (libroCarrello.getLibro().getId() == idLibro){
                return "libro presente nel carrello";
            }
        }
        LibroCarrello libroCarrello = new LibroCarrello();
        libroCarrello.setNumeroCopie(1);
        libroCarrello.setLibro(libro);
        libroCarrello.setCarrello(cliente.getCarrello());
        cliente.getCarrello().getLibriCarrello().add(libroCarrello);
        cliente.getCarrello().setUltimaModifica(LocalDateTime.now());
        clienteRepository.save(cliente);
        return "Libro aggiunto al carrello";
    }

    @Override
    public Cliente datiCliente(Integer id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public void rimozioneLibroCarrello(Integer idLibroCarrello, HttpSession session) {
        Cliente clienteSession = (Cliente) session.getAttribute("cliente");
        Cliente cliente = clienteRepository.findById(clienteSession.getId()).get();
        for (LibroCarrello libroCarrello : cliente.getCarrello().getLibriCarrello()) {
            if (libroCarrello.getId() == idLibroCarrello){
                cliente.getCarrello().getLibriCarrello().remove(libroCarrello);
                break;
            }
        }
        if(cliente.getCarrello().getLibriCarrello().isEmpty()){
            Carrello carrello = cliente.getCarrello();
            cliente.setCarrello(null);
            clienteRepository.save(cliente);
            carrelloRepository.delete(carrello);
        } else {
            cliente.getCarrello().setCliente(cliente);
            cliente.setCarrello(cliente.getCarrello());
            clienteRepository.save(cliente);
        }
    }

    @Override
    public void modificaCopieLibroCarrello(Integer idLibroCarrello, String op, HttpSession session) {
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        cliente = clienteRepository.findById(cliente.getId()).get();

        for (LibroCarrello libroCarrello : cliente.getCarrello().getLibriCarrello()) {
            if (libroCarrello.getId() == idLibroCarrello){
                if(op.equals("minus") && libroCarrello.getNumeroCopie() > 1){
                    libroCarrello.setNumeroCopie(libroCarrello.getNumeroCopie() - 1);
//                    cliente.getCarrello().setCliente(cliente);
//                    cliente.setCarrello(cliente.getCarrello());
                    clienteRepository.save(cliente);
                } else if (op.equals("plus") && libroCarrello.getNumeroCopie() < libroCarrello.getLibro().getCopieDisponibili()){
                    libroCarrello.setNumeroCopie(libroCarrello.getNumeroCopie() + 1);
//                    cliente.getCarrello().setCliente(cliente);
//                    cliente.setCarrello(cliente.getCarrello());
                    clienteRepository.save(cliente);
                }
                break;
            }
        }

    }

    @Override
    public void registrazioneCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public String controlloUsername(String username) {
        if(clienteRepository.findByProfiloUsername(username) != null){
            return "profilo esistente";
        }
        return null;
    }

    @Override
    public String eliminazioneProfilo(HttpSession session) {
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        cliente = clienteRepository.findById(cliente.getId()).get();

        for (Ordine ordine : cliente.getOrdini()){
            if(!ordine.getEvaso()){
                return "Alcuni ordini non sono evasi";
            }
        }

        clienteRepository.delete(cliente);
        session.removeAttribute("cliente");
        return null;
    }
}
