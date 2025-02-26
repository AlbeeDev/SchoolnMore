package it.corso.libreriaits.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "libri_ordini")
public class LibroOrdine {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_libro", referencedColumnName = "id")
    private Libro libro;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_ordine", referencedColumnName = "id")
    private Ordine ordine;

    @Column(name = "numero_copie", nullable = false)
    private Integer numeroCopie;

    @Column(name = "prezzo_unitario", nullable = false)
    private Double prezzoUnitario;

    public Double getPrezzoUnitario() {
        return prezzoUnitario;
    }

    public void setPrezzoUnitario(Double prezzoUnitario) {
        this.prezzoUnitario = prezzoUnitario;
    }

    public Integer getNumeroCopie() {
        return numeroCopie;
    }

    public void setNumeroCopie(Integer numeroCopie) {
        this.numeroCopie = numeroCopie;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
