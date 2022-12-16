package com.alberto.Entidades;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity

@DiscriminatorColumn(name = "delantero", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue(value = "D")
public class Delantero implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idDel;
    @Column
    private String pierna;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_Delantero", referencedColumnName = "idJug")
    private Futbolista futbolista;

    public Delantero() {
    }

    public Delantero(String pierna, Futbolista futbolista) {
        this.pierna = pierna;
        this.futbolista = futbolista;
    }

    public int getIdDel() {
        return idDel;
    }

    public void setIdDel(int idDel) {
        this.idDel = idDel;
    }

    public String getPierna() {
        return pierna;
    }

    public void setPierna(String pierna) {
        this.pierna = pierna;
    }

    public Futbolista getFutbolista() {
        return futbolista;
    }

    public void setFutbolista(Futbolista futbolista) {
        this.futbolista = futbolista;
    }

    @Override
    public String toString() {
        return "Delantero{" +
                "idDel=" + idDel +
                ", pierna='" + pierna + '\'' +
                ", futbolista=" + futbolista +
                '}';
    }
}
