package com.alberto.Entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "futbolistas")
public class Futbolista implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idJug;
    @Column(name = "nombre")
    private String nom;
    @Column(name = "mediagoles")
    private double media;
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_Deporte", referencedColumnName = "id")
    private Deporte deporte;
    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "futbolistas")
    private List<Marca> marca;
    @OneToOne(mappedBy = "futbolista", cascade = CascadeType.PERSIST)
    private Delantero delantero;

    public Futbolista() {
    }

    public Futbolista(String nom, double media, Deporte deporte, List<Marca> marca, Delantero delantero) {
        this.nom = nom;
        this.media = media;
        this.deporte = deporte;
        this.marca = marca;
        this.deporte = deporte;
    }


    public int getIdJug() {
        return idJug;
    }

    public void setIdJug(int idJug) {
        this.idJug = idJug;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    public List<Marca> getMarca() {
        return marca;
    }

    public void setMarca(List<Marca> marca) {
        this.marca = marca;
    }

    public void setDelantero(Delantero delantero){this.delantero=delantero;}

    public Delantero getDelantero(){ return delantero;}

    @Override
    public String toString() {
        return "Futbolista{" +
                "idJug=" + idJug +
                ", nom='" + nom + '\'' +
                ", media=" + media +
                ", deporte=" + deporte +
                ", marca=" + marca +
                '}';
    }
}
