package it.corso.libreriaits.service;

import it.corso.libreriaits.model.Ordine;
import jakarta.servlet.http.HttpSession;

public interface OrdineService {
    String invioOrdine(HttpSession sesion);
}
