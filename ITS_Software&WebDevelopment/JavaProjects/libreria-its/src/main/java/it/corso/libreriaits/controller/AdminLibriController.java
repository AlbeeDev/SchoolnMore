package it.corso.libreriaits.controller;

import it.corso.libreriaits.model.Autore;
import it.corso.libreriaits.model.Categoria;
import it.corso.libreriaits.model.Libro;
import it.corso.libreriaits.service.AutoreService;
import it.corso.libreriaits.service.CategoriaService;
import it.corso.libreriaits.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/adminlibri")
public class AdminLibriController {

    @Autowired
    private LibroService libroService;
    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private AutoreService autoreService;

    private Libro libro;

    @GetMapping
    public String adminlibri(Model model, @RequestParam(required = false) Integer id, @RequestParam(required = false) String esito) {
        List<Libro> libri = libroService.elencoLibri();
        List<Categoria> categorie = categoriaService.elencoCategorie();
        List<Autore> autori = autoreService.elencoAutori();
        if(id != null){
            libro = libroService.datiLibro(id);
        } else {
            libro = new Libro();
        }

        model.addAttribute("libri", libri);
        model.addAttribute("categorie", categorie);
        model.addAttribute("autori", autori);
        model.addAttribute("libro", libro);
        model.addAttribute("esito", esito);
        return "adminlibri";
    }

    @PostMapping
    public String gestioneForm(@RequestParam String titolo, @RequestParam String prezzo, @RequestParam String copieDisponibili, @RequestParam Integer idCategoria, @RequestParam Integer idAutore, @RequestParam(required = false) MultipartFile copertina) {
        libroService.registrazioneLibro(libro,titolo,prezzo,copieDisponibili,idCategoria,idAutore,copertina);
        return "redirect:/adminlibri";
    }

    @GetMapping("/elimina")
    public String elimina(@RequestParam Integer id) {
        String esito = libroService.eliminazioneLibro(id);
        if(esito != null){
            return "redirect:/adminlibri?esito=" + esito;
        }
        return "redirect:/adminlibri";
    }
}
