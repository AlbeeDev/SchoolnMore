package it.corso.libreriaits.controller;

import it.corso.libreriaits.model.Cliente;
import it.corso.libreriaits.service.ClienteService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/logincliente")
public class LoginClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String render(Model model, @RequestParam(required = false) String errore, HttpSession session) {
        if(session.getAttribute("cliente") != null) {
            return "redirect:/riservata";
        }
        model.addAttribute("errore", errore);
        return "logincliente";
    }

    @PostMapping
    public String gestioneForm(@RequestParam String username, @RequestParam String password, HttpSession session) {
        System.out.println(username);
        System.out.println(password);
        String esitoControllo = clienteService.controlloLogin(username, password, session);
        System.out.println(esitoControllo);
        if(esitoControllo.equals("Credenziali Errate")) {
            return "redirect:/logincliente?errore="+esitoControllo;
        }
        return "redirect:/riservata";
    }

}
