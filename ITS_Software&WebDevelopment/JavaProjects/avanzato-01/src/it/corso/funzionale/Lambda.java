package it.corso.funzionale;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lambda {
    public static void main(String[] args) {
        List<String> lista = Arrays.asList("buongiorno","buonasera","buonanotte");
        //testterm(lista);
        testgen(lista, s -> s.length() > 9);
        testgen(lista, s -> s.endsWith("a"));
    }

    static void testlung(List<String> lista){
        for (String s : lista) {
            if(s.length()>9){
                System.out.println(s);
            }
        }
    }

    static void testterm(List<String> lista){
        for (String s : lista) {
            if(s.endsWith("a")){
                System.out.println(s);
            }
        }
    }

    static void testgen(List<String> lista,Predicate<String> pred){
        for (String s : lista) {
            if(pred.test(s)){
                System.out.println(s);
            }
        }
    }
}
