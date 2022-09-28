package com.miPortfolio.lgc.Controller;

import com.miPortfolio.lgc.Entity.Persona;
import com.miPortfolio.lgc.Interface.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired
    IPersonaService iPersonaService;

    @GetMapping("/persona/traer")
    public List<Persona> getPersona(){
        return iPersonaService.getPersonas();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/persona/crear")
    public String createPersona(@RequestBody Persona persona){
        iPersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/persona/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        iPersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    @PreAuthorize("hasRole('ADMIN')")
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

    @GetMapping("/persona/traer/perfil")
    public Persona findPersona(){
        return iPersonaService.findPersona((long) 1);
    }
}
