package com.miPortfolio.lgc.Security.Service;

import com.miPortfolio.lgc.Security.Entity.Usuario;
import com.miPortfolio.lgc.Security.Repository.iUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    iUsuarioRepository iusuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public boolean existByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.existByNombreUsuario(nombreUsuario);
    }

    public boolean existByEmail(String email){
        return iusuarioRepository.existByEmail(email);
    }

    public void save(Usuario usuario){
        iusuarioRepository.save(usuario);
    }
}
