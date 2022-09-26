package com.miPortfolio.lgc.Service;

import com.miPortfolio.lgc.Entity.Persona;
import com.miPortfolio.lgc.Interface.IPersonaService;
import com.miPortfolio.lgc.Repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpPersonaService implements IPersonaService {
    @Autowired
    IPersonaRepository iPersonaRepository;

    @Override
    public List<Persona> getPersonas() {
        List<Persona> persona = iPersonaRepository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        iPersonaRepository.save(persona);

    }

    @Override
    public void deletePersona(Long id) {
        iPersonaRepository.deleteById(id);

    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = iPersonaRepository.findById(id).orElse(null);
        return persona;
    }
}
