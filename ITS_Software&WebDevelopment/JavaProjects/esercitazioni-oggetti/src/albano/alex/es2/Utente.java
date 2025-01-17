package albano.alex.es2;

import java.util.Random;

public class Utente {
    String nome;
    String cognome;
    String password;

    public Utente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public void genPassword() {
        password = "";
        if (nome.length() >= 3 && cognome.length() >= 3) {
            password = nome.substring(nome.length()-3) + cognome.substring(0,3);
        } else {
            for(int i=0;i<6;i++){
                password += (char) ('a' + new Random().nextInt(26));
            }
        }
    }

    public String getPassword() {
        return password;
    }


}
