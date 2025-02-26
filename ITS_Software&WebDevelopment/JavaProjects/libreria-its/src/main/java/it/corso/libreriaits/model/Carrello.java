package it.corso.libreriaits.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "carrelli")
public class Carrello {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ultima_modifica", nullable = false)
    private LocalDateTime ultimaModifica;

    @OneToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "carrello",cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<LibroCarrello> libriCarrello = new ArrayList<LibroCarrello>();

    public List<LibroCarrello> getLibriCarrello() {
        return libriCarrello;
    }

    public void setLibriCarrello(List<LibroCarrello> libriCarrello) {
        this.libriCarrello = libriCarrello;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getUltimaModifica() {
        return ultimaModifica;
    }

    public void setUltimaModifica(LocalDateTime ultimaModifica) {
        this.ultimaModifica = ultimaModifica;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
