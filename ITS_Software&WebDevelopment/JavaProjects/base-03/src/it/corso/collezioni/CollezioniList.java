package it.corso.collezioni;

import java.util.*;

public class CollezioniList {
    public static void main(String[] args) {
        gestioneLista();
    }

    private static void preJava5(){
        List list = new ArrayList();
        list.add("1");
        list.add(2);
        list.add('s');

        for(int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }
    }

    private static void postJava7(){
        List<String> ls = new ArrayList<String>();
        ls.add("test");
        ls.add("ciao");
        ls.add("mondo");

        Collections.sort(ls);

        for (String s : ls) {
            System.out.println(s);
        }
    }

    private static void gestioneLista(){
        List<Persona> lp = new ArrayList<Persona>();
        lp.add(new Persona("mario",42));
        lp.add(new Persona("luigi",54));

        Collections.sort(lp);
        System.out.println(lp);

        Comparator<Persona> comparator = Comparator.comparing(Persona::getEta);
        lp.sort(comparator);
    }
}

class Persona implements Comparable<Persona>{
    private String nome;
    private int eta;

    Persona(String nome, int eta) {
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

    @Override
    public int compareTo(Persona o) {
        return this.nome.compareTo(o.nome);
    }

    @Override
    public int hashCode() {
        return nome.hashCode() + eta;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Persona){
            return this.nome.equals(((Persona) obj).nome) && this.eta == ((Persona) obj).eta;
        }
        return false;
    }
}
