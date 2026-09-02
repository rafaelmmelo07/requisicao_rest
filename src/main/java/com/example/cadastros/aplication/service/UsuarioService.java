package com.example.cadastros.aplication.service;

import com.example.cadastros.domain.entity.Usuario;
import com.example.cadastros.domain.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service

public class UsuarioService {
    final UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
    public Usuario findById(@PathVariable UUID id) {
        Optional<Usuario> usuario0pt = usuarioRepository.findById(id);
        if (usuario0pt.isPresent()) {
            return usuario0pt.get();
        } else {
            throw new RuntimeException("Usuario nao encontrado ");
        }



    }
    public Usuario save( Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario update(UUID id, Usuario usuario){
        Usuario usuarioExistente = findById(id);
        usuarioExistente.setNome(usuario.getNome());
        usuarioExistente.setCpf(usuario.getCpf());
        usuarioExistente.setEmail(usuario.getEmail());


        return usuarioRepository.save(usuarioExistente);
       }

    public void delete( UUID id) {
        usuarioRepository.deleteById(id);

    }
    }

