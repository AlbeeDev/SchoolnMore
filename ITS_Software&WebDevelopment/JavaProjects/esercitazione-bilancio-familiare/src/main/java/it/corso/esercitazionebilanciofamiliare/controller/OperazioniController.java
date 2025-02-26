package it.corso.esercitazionebilanciofamiliare.controller;

import it.corso.esercitazionebilanciofamiliare.model.Operazione;
import it.corso.esercitazionebilanciofamiliare.repository.OperazioneRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/operazioni")
public class OperazioniController {

    @Autowired
    private OperazioneRepository operazioneRepository;

    @GetMapping
    public String operazioni(Model model) {
        model.addAttribute("operazione", new Operazione());
        return "operazioni";
    }

    @PostMapping
    public String gestioneForm(@Valid @ModelAttribute Operazione operazione, BindingResult result) {
        if (result.hasErrors()) {
            return "operazioni";
        }
        operazioneRepository.save(operazione);
        return "redirect:/";
    }
}
