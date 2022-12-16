package com.alberto.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "E")
public class Extremo extends Delantero{
    @Column
    private String banda;

    public Extremo() {
        super();
    }

    public Extremo(String pierna, Futbolista futbolista, String banda) {
        super(pierna, futbolista);
        this.banda = banda;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    @Override
    public String toString() {
        return "Extremo{" +
                "banda='" + banda + '\'' +
                '}';
    }
}
