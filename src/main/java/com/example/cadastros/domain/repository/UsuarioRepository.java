package com.example.cadastros.domain.repository;

import com.example.cadastros.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface UsuarioRepository extends JpaRepository <Usuario, UUID> {
    Usuario findByEmail(String email);


}
