package it.corso.libreriaits.controller;

import it.corso.libreriaits.model.Libro;
import it.corso.libreriaits.service.ClienteService;
import it.corso.libreriaits.service.LibroService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dettaglio")
public class DettaglioController {

    @Autowired
    private LibroService libroService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String dettaglio(Model model, @RequestParam(defaultValue = "0") int id, @RequestParam(required = false) String esito, HttpSession session) {
        Libro libro = libroService.datiLibro(id);
        if(libro==null){
            return "redirect:/";
        }
        model.addAttribute("libro", libro);
        model.addAttribute("login",session.getAttribute("cliente") != null);
        model.addAttribute("esito", esito);
        return "dettaglio";
    }

    @GetMapping("/acquista")
    public String acquista(@RequestParam Integer id, HttpSession session) {
        String esito = clienteService.aggiuntaCarrello(id,session);
        return "redirect:/dettaglio?esito="+esito+"&id="+id;
    }
}
