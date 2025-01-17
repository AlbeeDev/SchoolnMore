package it.corso.controller;

import it.corso.model.Libro;
import it.corso.model.Ordine;
import it.corso.repository.LibroRepository;
import it.corso.repository.LibroRepositoryImpl;
import it.corso.repository.OrdineRepository;
import it.corso.repository.OrdineRepositoryImpl;

import java.util.List;

public class Controller {

    private static OrdineRepository or = new OrdineRepositoryImpl();
    private static LibroRepository lr = new LibroRepositoryImpl();

    public static void main(String[] args) {
//        List<Ordine> ordini = or.elencoOrdini();
//        for (Ordine o : ordini) {
//            System.out.println(o);
//            for (Libro libro: o.getLibri()){
//                System.out.println(libro);
//            }
//        }
        Libro lib = new Libro();
        lib.setTitolo("Libro Cinque");
        lib.setPrezzo(13.67);

        lr.registrazioneLibro(lib,"Due","Romanzi");
    }
}
