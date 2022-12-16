package com.alberto.Entidades;

import com.alberto.Entidades.Futbolista;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "marcas")
public class Marca implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMarca;
    @Column(name = "Nombre Marca")
    private String noMarca;
    @Column
    private double valor;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "marca_futbolista", joinColumns = {@JoinColumn(name = "FK_marca", referencedColumnName = "idMarca")},
            inverseJoinColumns = {@JoinColumn(name = "FK_Futbolistas", referencedColumnName = "idJug")})
    private List<Futbolista> futbolistas;

    public Marca() {
    }

    public Marca(String noMarca, double valor, List<Futbolista> futbolistas) {
        this.noMarca = noMarca;
        this.valor = valor;
        this.futbolistas = futbolistas;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNoMarca() {
        return noMarca;
    }

    public void setNoMarca(String noMarca) {
        this.noMarca = noMarca;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<Futbolista> getFutbolistas() {
        return futbolistas;
    }

    public void setFutbolistas(List<Futbolista> futbolistas) {
        this.futbolistas = futbolistas;
    }

    @Override
    public String toString() {
        return "Marca{" +
                "idMarca=" + idMarca +
                ", noMarca='" + noMarca + '\'' +
                ", valor=" + valor +
                ", futbolistas=" + futbolistas +
                '}';
    }
}
