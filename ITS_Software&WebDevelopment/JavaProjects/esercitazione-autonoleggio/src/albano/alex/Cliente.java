package albano.alex;

public class Cliente {
    String nome;
    String cognome;
    String numeroPatente;

    public Cliente(String nome, String cognome, String numeroPatente) {
        this.nome = nome;
        this.cognome = cognome;
        this.numeroPatente = numeroPatente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNumeroPatente() {
        return numeroPatente;
    }

    public void setNumeroPatente(String numeroPatente) {
        this.numeroPatente = numeroPatente;
    }

    @Override
    public String toString() {
        return "\n- Cliente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", numeroPatente='" + numeroPatente + '\'' +
                '}';
    }
}

