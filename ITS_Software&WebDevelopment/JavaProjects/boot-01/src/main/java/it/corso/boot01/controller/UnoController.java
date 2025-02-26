package it.corso.boot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/uno")
public class UnoController {

    @GetMapping
    public String uno(@RequestParam(defaultValue = "ignoto") String nome, Model model) {
        model.addAttribute("nome", nome);
        return "uno";
    }
}
