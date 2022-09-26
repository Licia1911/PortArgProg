package com.miPortfolio.lgc.Repository;

import com.miPortfolio.lgc.Entity.AcercaDe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RAcercaDe extends JpaRepository<AcercaDe, Integer> {
    public Optional<AcercaDe> findByNombreAD(String nombreAD);
    public boolean existByNombreAD(String nombreAD);
}
