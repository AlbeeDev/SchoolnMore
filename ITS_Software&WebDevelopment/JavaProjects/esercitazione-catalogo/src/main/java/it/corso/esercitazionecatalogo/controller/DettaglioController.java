package it.corso.esercitazionecatalogo.controller;

import it.corso.esercitazionecatalogo.model.Articolo;
import it.corso.esercitazionecatalogo.service.ArticoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dettaglio")
public class DettaglioController {

    @Autowired
    private ArticoloService articoloService;

    @GetMapping
    public String dettaglio(Model model, @RequestParam(defaultValue = "0") int id) {
        Articolo articolo = articoloService.datiArticolo(id);
        if(articolo==null){
            return "redirect:/";
        }
        model.addAttribute("articolo", articolo);
        return "dettaglio";
    }
}

