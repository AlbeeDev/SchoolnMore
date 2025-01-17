package it.corso.funzionale;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Flusso {
    public static void main(String[] args) {
        List<Persona> persone = Arrays.asList(new Persona("Mario",10),
                new Persona("luigi",30),
                new Persona("gianni",45),
                new Persona("laura",22));

        persone = persone.stream()
                .filter(persona -> persona.getEta() >= 18)
                .toList();

        int somma = persone.stream()
                .mapToInt(persona -> persona.getEta())
                .reduce(0, (eta1, eta2) -> eta1 + eta2);

        OptionalDouble mediaeta = persone.stream()
                .mapToDouble(persona -> persona.getEta())
                .average();

        persone = persone.stream()
                .sorted((Persona p1, Persona p2) -> p1.getEta() - p2.getEta())
                .toList();

        List<String> nomi = persone.stream()
                        .map(persona -> persona.getNome().toLowerCase())
                        .toList();


        System.out.println(persone);
    }

}

class Persona{
    private String nome;
    private int eta;

    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", eta=" + eta +
                '}';
    }
}
