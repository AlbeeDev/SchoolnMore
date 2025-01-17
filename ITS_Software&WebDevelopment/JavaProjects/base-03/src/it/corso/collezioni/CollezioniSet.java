package it.corso.collezioni;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollezioniSet {
    public static void main(String[] args) {
        complessi();
    }

    static void standard(){
        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        System.out.println(set);

    }

    static void complessi(){
        Set<Persona> persone = new HashSet<>();

        persone.add(new Persona("mario",42));
        persone.add(new Persona("mario",42));

        System.out.println(persone);
    }
}

