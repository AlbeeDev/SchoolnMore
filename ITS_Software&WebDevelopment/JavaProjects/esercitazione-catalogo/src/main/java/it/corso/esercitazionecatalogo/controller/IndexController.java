package it.corso.esercitazionecatalogo.controller;

import it.corso.esercitazionecatalogo.model.Articolo;
import it.corso.esercitazionecatalogo.service.ArticoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private ArticoloService articoloService;

    @GetMapping
    public String index(Model model) {
        List<Articolo> articoli = articoloService.elencoArticolo();
        model.addAttribute("articoli", articoli);
        return "index";
    }
}