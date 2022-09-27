package com.miPortfolio.lgc.Security.Entity;

import com.miPortfolio.lgc.Security.Enums.RolNombre;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;

    public Rol() {
    }

    public Rol(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }

}
