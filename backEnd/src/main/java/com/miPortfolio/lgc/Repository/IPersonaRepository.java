package com.miPortfolio.lgc.Repository;

import com.miPortfolio.lgc.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona,  Long> {

}
