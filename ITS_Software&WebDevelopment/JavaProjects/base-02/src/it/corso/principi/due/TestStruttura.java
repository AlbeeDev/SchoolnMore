package it.corso.principi.due;

import it.corso.principi.uno.Persona;

public class TestStruttura {
    public static void main(String[] args) {
        Studente studente = new Studente("mario","rossi",18,8.5);

        Lavoratore lavoratore = new Lavoratore("gianni","verdi",45,1300);

        System.out.println(studente.getCognome());
        System.out.println(lavoratore.getReddito());

        studente.camminare();
        lavoratore.camminare();
        studente.function();
        lavoratore.function();

        Persona[] persone = {studente,lavoratore};
        for(Persona persona : persone){
            persona.function();
        }
    }
}
