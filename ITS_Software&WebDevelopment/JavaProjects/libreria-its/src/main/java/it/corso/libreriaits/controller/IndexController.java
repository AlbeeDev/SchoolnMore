package it.corso.libreriaits.controller;

import it.corso.libreriaits.model.Libro;
import it.corso.libreriaits.service.LibroService;
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
    private LibroService libroService;

    @GetMapping
    public String index(Model model) {
        List<Libro> libri = libroService.elencoLibri();
        model.addAttribute("libri", libri);
        return "index";
    }
}
