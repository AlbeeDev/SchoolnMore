package it.corso.libreriaits.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "libri_carrelli")
public class LibroCarrello {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_libro", referencedColumnName = "id")
    private Libro libro;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_carrello", referencedColumnName = "id")
    private Carrello carrello;

    @Column(name = "numero_copie", nullable = false)
    private Integer numeroCopie;

    public Integer getNumeroCopie() {
        return numeroCopie;
    }

    public void setNumeroCopie(Integer numeroCopie) {
        this.numeroCopie = numeroCopie;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
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
