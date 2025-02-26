package it.corso.libreriaits.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ordini")
public class Ordine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ricezione", nullable = false)
    private LocalDateTime ricezione;

    @Column(name = "totale", nullable = false)
    private Double totale;

    @Column(name = "evaso", nullable = false)
    private Boolean evaso = false;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente cliente;

    @OneToMany(mappedBy = "ordine", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<LibroOrdine> libriOrdine = new ArrayList<>();

    public List<LibroOrdine> getLibriOrdine() {
        return libriOrdine;
    }

    public void setLibriOrdine(List<LibroOrdine> libriOrdine) {
        this.libriOrdine = libriOrdine;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Boolean getEvaso() {
        return evaso;
    }

    public void setEvaso(Boolean evaso) {
        this.evaso = evaso;
    }

    public Double getTotale() {
        return totale;
    }

    public void setTotale(Double totale) {
        this.totale = totale;
    }

    public LocalDateTime getRicezione() {
        return ricezione;
    }

    public void setRicezione(LocalDateTime ricezione) {
        this.ricezione = ricezione;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
