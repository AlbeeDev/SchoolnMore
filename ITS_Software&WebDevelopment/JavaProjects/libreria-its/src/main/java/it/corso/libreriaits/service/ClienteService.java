package it.corso.libreriaits.service;

import it.corso.libreriaits.model.Cliente;
import jakarta.servlet.http.HttpSession;

public interface ClienteService {
    String controlloLogin(String username, String password, HttpSession session);
    String aggiuntaCarrello(Integer idLibro, HttpSession session);
    Cliente datiCliente(Integer id);
    void rimozioneLibroCarrello(Integer idLibroCarrello, HttpSession session);
    void modificaCopieLibroCarrello(Integer idLibroCarrello, String op, HttpSession session);
    void registrazioneCliente(Cliente cliente);
    String controlloUsername(String username);
    String eliminazioneProfilo(HttpSession session);
}
