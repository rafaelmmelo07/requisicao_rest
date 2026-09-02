package com.example.cadastros.Interface_ui.controller;

import com.example.cadastros.aplication.service.UsuarioService;
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

   final UsuarioService usuarioService;


    @GetMapping
    public List<Usuario> listarTodosUsuarios() {
        return usuarioService.findAll();

    }


    @GetMapping("/{id}")
    public Usuario buscarioporID(@PathVariable UUID id) {
        return usuarioService.findById(id);
    }


    @PostMapping
    public Usuario cadastroUsuario( @RequestBody Usuario usuario) {
        return  usuarioService.save(usuario);
    }


    @PutMapping("/{id}")
    //PutMapping = é o caminho que ele vai puxar o id
    public Usuario atualizarUsuario(@PathVariable UUID id, @Valid @RequestBody Usuario usuario) {
     return usuarioService.update(id,usuario);
    }

    @DeleteMapping("/{id}")
    public void excluirUsuario(@PathVariable UUID id){
          usuarioService.delete(id);
    }
}

