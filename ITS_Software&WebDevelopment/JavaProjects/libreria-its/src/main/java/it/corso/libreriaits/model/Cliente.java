package it.corso.libreriaits.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "clienti")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 50)
    @Pattern(regexp = "[a-zA-Z\\sàèìòù']{1,50}", message = "caratteri non ammessi")
    private String nome;

    @Column(name = "cognome", nullable = false, length = 50)
    @Pattern(regexp = "[a-zA-Z\\sàèìòù']{1,50}", message = "caratteri non ammessi")
    private String cognome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_profilo", referencedColumnName = "id")
    @Valid
    private Profilo profilo;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Carrello carrello;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Ordine> ordini = new ArrayList<>();

    public List<Ordine> getOrdini() {
        return ordini;
    }

    public void setOrdini(List<Ordine> ordini) {
        this.ordini = ordini;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Profilo getProfilo() {
        return profilo;
    }

    public void setProfilo(Profilo profilo) {
        this.profilo = profilo;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
    }
}
