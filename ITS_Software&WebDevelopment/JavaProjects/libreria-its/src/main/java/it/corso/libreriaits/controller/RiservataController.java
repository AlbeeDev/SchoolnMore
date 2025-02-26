package it.corso.libreriaits.controller;

import it.corso.libreriaits.model.Cliente;
import it.corso.libreriaits.model.LibroCarrello;
import it.corso.libreriaits.service.ClienteService;
import it.corso.libreriaits.service.OrdineService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/riservata")
public class RiservataController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private OrdineService ordineService;

    @GetMapping
    public String riservata(HttpSession session, Model model, @RequestParam(required = false) String esito, @RequestParam(required = false) String cancellazione) {
        if(session.getAttribute("cliente") == null) {
            return "redirect:/logincliente";
        }
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        cliente = clienteService.datiCliente(cliente.getId());
        if(cliente.getCarrello() != null) {
            double totaleCarello = 0;
            for (LibroCarrello libroCarrello : cliente.getCarrello().getLibriCarrello()){
                totaleCarello += (libroCarrello.getLibro().getPrezzo() * libroCarrello.getNumeroCopie());
            }
            model.addAttribute("totaleCarello", totaleCarello);
        }
        model.addAttribute("cliente", cliente);
        model.addAttribute("esito", esito);
        model.addAttribute("cancellazione", cancellazione);
        return "riservata";
    }

    @GetMapping("/rimuovi")
    public String rimuovi(HttpSession session, @RequestParam int id) {
        clienteService.rimozioneLibroCarrello(id,session);
        return "redirect:/riservata";
    }

    @GetMapping("/modifica")
    public String modifica(HttpSession session, @RequestParam int id, @RequestParam String op) {
        clienteService.modificaCopieLibroCarrello(id,op,session);
        return "redirect:/riservata";
    }

    @GetMapping("/conferma")
    public String conferma(HttpSession session) {
        String esito = ordineService.invioOrdine(session);
        return "redirect:/riservata?esito=" + esito;
    }

    @PostMapping
    public String gestioneForm(@Valid @ModelAttribute Cliente cliente, BindingResult result) {
        if(result.hasErrors()) {
            return "riservata";
        }
        clienteService.registrazioneCliente(cliente);
        return "redirect:/riservata";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        //session.invalidate();
        session.removeAttribute("cliente");
        return "redirect:/";
    }

    @GetMapping("/elimina")
    public String elimina(HttpSession session) {
        String cancellazione = clienteService.eliminazioneProfilo(session);
        if(cancellazione != null) {
            return "redirect:/riservata?cancellazione=" + cancellazione;
        }

        return "redirect:/";
    }
}
