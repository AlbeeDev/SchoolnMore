package it.corso.controller;

import it.corso.model.Persona;
import it.corso.repository.PersonaRepositoryBase;

public class PersonaController {

    private static PersonaRepositoryBase prb = new PersonaRepositoryBase();

    public static void main(String[] args) {
        //testRegistrazione();
        //System.out.println(prb.getPersona(1));
        System.out.println(prb.elencoPersone());
        //testaggiornamento();
        //prb.cancellaPersona(1);
    }

    static void testRegistrazione(){
        String nome = "Gianni";
        String cognome = "Verdi";
        int eta = 34;

        Persona persona = new Persona();
        persona.setNome(nome);
        persona.setCognome(cognome);
        persona.setEta(eta);

        prb.createPersona(persona);
    }

    static void testaggiornamento(){
        int idMod = 1;
        Persona persona = prb.getPersona(idMod);
        persona.setNome("Pippo");
        prb.aggiornamentoPersona(persona);
    }
}
