package com.miPortfolio.lgc.Security.Repository;

import com.miPortfolio.lgc.Security.Entity.Rol;
import com.miPortfolio.lgc.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
