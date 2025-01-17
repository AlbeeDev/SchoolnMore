package it.corso.collezioni;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CollezioniMap {
    public static void main(String[] args) {
        Map<Integer, String> mappa = new HashMap<>();

        mappa.put(1, "ciao");
        mappa.put(2, "mondo");

        System.out.println(mappa);

        mappa.put(2, "bello");
        System.out.println(mappa);

        for(int key : mappa.keySet()) {
            System.out.println(mappa.get(key));
        }
    }
}
