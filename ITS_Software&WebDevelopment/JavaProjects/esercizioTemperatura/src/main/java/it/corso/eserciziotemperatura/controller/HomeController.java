package it.corso.eserciziotemperatura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping
    public String home(@RequestParam(required = false) String temperatura, Model model) {
        try {
            double temp = Double.parseDouble(temperatura);
            model.addAttribute("gradi", temp);
            model.addAttribute("kelvin", (temp + 273.15));
            model.addAttribute("fahrenheit", ((temp * 9/5) + 32));
        } catch (Exception e) {
            if(temperatura == null || temperatura.isEmpty()){
                model.addAttribute("error", "errore valore mancante");
            } else {
                model.addAttribute("error", "errore di formato");
            }

        }
        return "home";
    }
}
