package com.miPortfolio.lgc.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class dtoAcercaDe {
    @NotBlank
    private String nombreAE;
    @NotBlank
    private String descripcionAE;

    public dtoAcercaDe() {
    }

    public dtoAcercaDe(String nombreAE, String descripcionAE) {
        this.nombreAE = nombreAE;
        this.descripcionAE = descripcionAE;
    }
}
