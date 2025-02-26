package it.corso.esercitazionebilanciofamiliare.controller;

import it.corso.esercitazionebilanciofamiliare.model.Operazione;
import it.corso.esercitazionebilanciofamiliare.service.OperazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private OperazioneService operazioneService;

    @GetMapping
    public String home(Model model) {
        List<Operazione> operazioni = operazioneService.getAllOperazioni();
        double bilancio = operazioneService.getBilancioTotale();
        model.addAttribute("operazioni", operazioni);
        model.addAttribute("bilancio", bilancio);
        return "home";
    }

    @GetMapping("/elimina")
    public String elimina(@RequestParam Integer id) {
        operazioneService.eliminaOperazione(id);
        return "redirect:/";
    }

}
