package com.miPortfolio.lgc.Service;

import com.miPortfolio.lgc.Entity.AcercaDe;
import com.miPortfolio.lgc.Repository.RAcercaDe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class SAcercaDe {
    @Autowired
    RAcercaDe rAcercaDe;

    public Optional<AcercaDe>getOne(int id){
        return rAcercaDe.findById(id);
    }

    public Optional<AcercaDe>getByNombreAD(String NombreAD){
        return rAcercaDe.findByNombreAD(NombreAD);
    }

    public void save(AcercaDe acercaDe){
        rAcercaDe.save(acercaDe);
    }

    public void delete(int id){
        rAcercaDe.deleteById(id);
    }


    public boolean  existsByNombreAD(String nomnreAD){
        return rAcercaDe.existsByNombreAD(nomnreAD);
    }

    public boolean existsById(int id) {
        return rAcercaDe.existsById(id);
    }
}
