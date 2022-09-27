package com.miPortfolio.lgc.Dto;



import javax.validation.constraints.NotBlank;


public class dtoAcercaDe {
    @NotBlank
    private String nombreAD;
    @NotBlank
    private String descripcionAD;

    public dtoAcercaDe() {
    }

    public dtoAcercaDe(String nombreAE, String descripcionAE) {
        this.nombreAD = nombreAD;
        this.descripcionAD = descripcionAD;
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
