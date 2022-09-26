package com.miPortfolio.lgc.Controller;

import com.miPortfolio.lgc.Entity.Persona;
import com.miPortfolio.lgc.Interface.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {
    @Autowired
    IPersonaService iPersonaService;

    @GetMapping("/persona/traer")
    public List<Persona> getPersona(){
        return iPersonaService.getPersonas();
    }

    @PostMapping("/persona/crear")
    public String createPersona(@RequestBody Persona persona){
        iPersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }

    @DeleteMapping("/persona/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        iPersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }

    @PutMapping("/persona/editar/{id}")
    public Persona editPersona(@PathVariable Long id, @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("git") String nuevoGit,
                               @RequestParam("link") String nuevoLink,
                               @RequestParam("fotoPerfil") String nuevofotoPerfil,
                               @RequestParam("banner") String nuevobanner){
        Persona persona = iPersonaService.findPersona(id);

        persona.setNombre(nuevoNombre);
        persona.setGit(nuevoGit);
        persona.setLink(nuevoLink);
        persona.setFotoPerfil(nuevofotoPerfil);
        persona.setBanner(nuevobanner);

        iPersonaService.savePersona(persona);
        return persona;
    }
}
