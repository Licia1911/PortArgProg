package com.miPortfolio.lgc.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class AcercaDe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreAD;
    @NotNull
    private String descripcionAD;

    public AcercaDe() {
    }

    public AcercaDe(String nombreAE, String descripcionAE) {
        this.nombreAD = nombreAD;
        this.descripcionAD = descripcionAD;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreAD() {
        return nombreAD;
    }

    public void setNombreAD(String nombreAD) {
        this.nombreAD = nombreAD;
    }

    public String getDescripcionAD() {
        return descripcionAD;
    }

    public void setDescripcionAD(String descripcionAD) {
        this.descripcionAD = descripcionAD;
    }

}
