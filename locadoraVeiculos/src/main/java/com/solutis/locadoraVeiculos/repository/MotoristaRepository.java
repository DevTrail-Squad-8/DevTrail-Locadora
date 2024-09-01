package com.solutis.locadoraVeiculos.repository;

import com.solutis.locadoraVeiculos.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MotoristaRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT COUNT(m) FROM Motorista m WHERE m.email = :email")
    Long countByEmail(@Param("email") String email);
}