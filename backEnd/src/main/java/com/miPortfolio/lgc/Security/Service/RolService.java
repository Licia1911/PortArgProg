package com.miPortfolio.lgc.Security.Service;

import com.miPortfolio.lgc.Security.Entity.Rol;
import com.miPortfolio.lgc.Security.Enums.RolNombre;
import com.miPortfolio.lgc.Security.Repository.iRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository iRolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return iRolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        iRolRepository.save(rol);
    }

}
