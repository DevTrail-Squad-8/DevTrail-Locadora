package com.solutis.locadoraVeiculos.repository;

import com.solutis.locadoraVeiculos.model.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

    @Query("SELECT COUNT(m) FROM Motorista m WHERE m.email = :email")
    Long countByEmail(@Param("email") String email);
}