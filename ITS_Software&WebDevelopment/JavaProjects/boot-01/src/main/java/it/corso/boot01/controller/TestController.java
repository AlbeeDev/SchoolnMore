package it.corso.boot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping
    @ResponseBody
    public String metodoUno(){
        return "test";
    }

    @GetMapping("/due")
    @ResponseBody
    public String metodoDue(){
        return "<h1>benvenuto in test controller</h1>";
    }

    @GetMapping("/tre")
    @ResponseBody
    public String metodoTre(@RequestParam String nome,@RequestParam String cognome){
        return "<h1>benvenuto "+ nome +" "+cognome+"</h1>";
    }

    @GetMapping("/quattro")
    @ResponseBody
    public String metodoQuattro(@RequestParam(required = false, defaultValue = "Pippo") String nome,@RequestParam(required = false) String cognome){
        cognome = cognome != null ? cognome : "Pippo";
        return "<h1>benvenuto "+ nome +" "+cognome+"</h1>";
    }

    @GetMapping("/cinque")
    @ResponseBody
    public String metodoCinque(@RequestParam(required = false, defaultValue = "2") int numero){
        numero++;
        return "<h1>benvenuto "+ numero +"</h1>";
    }

    @GetMapping("/sei")
    @ResponseBody
    public String metodoSei(@RequestParam(required = false) String numero){
        try {
            int num = Integer.parseInt(numero);
            return "<h1>benvenuto "+ ++num +"</h1>";
        } catch (Exception e) {
            return "<h1>Numero invalido</h1>";
        }
    }
}
