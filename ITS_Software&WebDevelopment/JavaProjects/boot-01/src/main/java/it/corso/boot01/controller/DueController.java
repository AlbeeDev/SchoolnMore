package it.corso.boot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/due")
public class DueController {
    @GetMapping
    public String due(@RequestParam(defaultValue = "ignoto") String nome, @RequestParam(defaultValue = "10") int eta, Model model) {
        model.addAttribute("nome", nome);
        model.addAttribute("eta", eta);
        return "due";
    }
}