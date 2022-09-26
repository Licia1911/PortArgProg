package com.miPortfolio.lgc.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class dtoExperiencia {
    @NotBlank
    private String nombreExp;
    @NotBlank
    private String descripcionExp;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreExp, String descripcionExp) {
        this.nombreExp = nombreExp;
        this.descripcionExp = descripcionExp;
    }
}
