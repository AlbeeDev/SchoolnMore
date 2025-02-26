package it.corso.esercitazionecatalogo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "articoli")
public class Articolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "marchio")
    private String marchio;

    @Column(name = "modello")
    private String modello;

    @Column(name = "os")
    private String os;

    @Column(name = "memoria")
    private Integer memoria;

    @Column(name = "prezzo")
    private Double prezzo;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "image")
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public Integer getMemoria() {
        return memoria;
    }

    public void setMemoria(Integer memoria) {
        this.memoria = memoria;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getMarchio() {
        return marchio;
    }

    public void setMarchio(String marchio) {
        this.marchio = marchio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
