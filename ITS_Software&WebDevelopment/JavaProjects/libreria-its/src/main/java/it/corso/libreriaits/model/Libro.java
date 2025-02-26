package it.corso.libreriaits.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libri")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String titolo;
    @Column
    private double prezzo;
    @Column
    private String copertina;
    @Column
    private int copieDisponibili;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_autore", referencedColumnName = "id")
    private Autore autore;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    private Categoria categoria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getCopertina() {
        return copertina;
    }

    public void setCopertina(String copertina) {
        this.copertina = copertina;
    }

    public int getCopieDisponibili() {
        return copieDisponibili;
    }

    public void setCopieDisponibili(int copieDisponibili) {
        this.copieDisponibili = copieDisponibili;
    }

    public Autore getAutore() {
        return autore;
    }

    public void setAutore(Autore autore) {
        this.autore = autore;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
