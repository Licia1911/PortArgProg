package com.miPortfolio.lgc.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
@Getter
@Setter
@Entity
public class AcercaDe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreAE;
    @NotNull
    private String descripcionAE;

    public AcercaDe() {
    }

    public AcercaDe(String nombreAE, String descripcionAE) {
        this.nombreAE = nombreAE;
        this.descripcionAE = descripcionAE;
    }
}
