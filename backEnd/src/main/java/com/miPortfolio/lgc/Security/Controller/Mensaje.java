package com.miPortfolio.lgc.Security.Controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mensaje {
    private String Mensaje;

    public Mensaje() {
    }

    public Mensaje(String mensaje) {
        Mensaje = mensaje;
    }
}
