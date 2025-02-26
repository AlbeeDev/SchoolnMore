package it.corso.libreriaits.controller;

import it.corso.libreriaits.model.Cliente;
import it.corso.libreriaits.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registrazione")
public class RegistrazioneController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String registrazione(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "registrazione";
    }

    @PostMapping
    public String gestioneForm(@Valid @ModelAttribute Cliente cliente, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "registrazione";
        }

        String controllo = clienteService.controlloUsername(cliente.getProfilo().getUsername());
        if(controllo != null){
            model.addAttribute("controllo", controllo);
            return "registrazione";
        }
        clienteService.registrazioneCliente(cliente);
        return "redirect:/logincliente";
    }
}
