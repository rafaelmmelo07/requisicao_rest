package com.example.cadastros.Interface_ui.controller;

import com.example.cadastros.domain.repository.UsuarioRepository;
import com.example.cadastros.domain.entity.Usuario;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor


public class UsuarioController {

    final UsuarioRepository usuarioRepository;


    @GetMapping
    public List<Usuario> listarTodosUsuarios() {
        return usuarioRepository.findAll();

    }


    @GetMapping("/{id}")
    public Usuario buscarioporID(@PathVariable UUID id) {

        Optional<Usuario> usuario0pt = usuarioRepository.findById(id);

        if (usuario0pt.isPresent()) {
            return usuario0pt.get();
        } else {
            throw new RuntimeException("Usuario nao encontrado ");
        }
    }


    @PostMapping
    public Usuario cadastroUsuario( @Valid @RequestBody Usuario usuario) {
        return  usuarioRepository.save(usuario);
    }


    @PutMapping("/{id}")
    //PutMapping = é o caminho que ele vai puxar o id

    public Usuario atualizarUsuario(@PathVariable UUID id, @Valid @RequestBody Usuario usuario) {
        Usuario usuarioExistente = buscarioporID(id);
        usuarioExistente.setNome(usuario.getNome());
        usuarioExistente.setCpf(usuario.getCpf());
        usuarioExistente.setEmail(usuario.getEmail());


        return usuarioRepository.save(usuarioExistente);
    }

    @DeleteMapping("/{id}")
    public void excluirUsuario(@PathVariable UUID id) {
        usuarioRepository.deleteById(id);

    }
}

