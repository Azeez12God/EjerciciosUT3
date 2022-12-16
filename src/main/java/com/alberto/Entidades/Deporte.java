package com.alberto.Entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "deportes")
public class Deporte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @OneToMany(mappedBy = "deporte", cascade = CascadeType.PERSIST)
    private List<Futbolista> futbolistas;

    public Deporte() {
    }

    public Deporte(String nombre, List<Futbolista> futbolistas) {
        this.nombre = nombre;
        this.futbolistas = futbolistas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Futbolista> getFutbolistas() {
        return futbolistas;
    }

    public void setFutbolistas(List<Futbolista> futbolistas) {
        this.futbolistas = futbolistas;
    }

    @Override
    public String toString() {
        return "Deporte{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                //", futbolistas=" + futbolistas +
                '}';
    }
}
