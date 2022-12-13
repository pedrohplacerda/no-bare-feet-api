package com.nobarefeet.controllers;

import com.nobarefeet.models.Usuario;
import com.nobarefeet.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
public class UsuariosController {
    private final UsuarioRepository repository;

    @PostMapping(value = "/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario saveUsuario(@RequestBody Usuario usuario) {
        repository.save(usuario);
        return usuario;
    }

    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios() {
        return repository.findAll();
    }

    @DeleteMapping(value = "/usuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarUsuario(@PathVariable("id") Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    @PutMapping(value = "/usuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Usuario editarUsuario(@PathVariable("id") Integer id, @RequestBody Usuario usuario) {
        var optionalUsuario = repository.findById(id);
        if(optionalUsuario.isPresent()) {
            Usuario usuarioASerAlterado = optionalUsuario.get();
            if (Objects.nonNull(usuario.getNome())) {
                usuarioASerAlterado.setNome(usuario.getNome());
            }
            if (Objects.nonNull(usuario.getCep())) {
                usuarioASerAlterado.setCep(usuario.getCep());
            }
            if (Objects.nonNull(usuario.getEmail())) {
                usuarioASerAlterado.setEmail(usuario.getEmail());
            }
            if (Objects.nonNull(usuario.getDataNascimento())) {
                usuarioASerAlterado.setDataNascimento(usuario.getDataNascimento());
            }
            if (Objects.nonNull(usuario.getTelefone())) {
                usuarioASerAlterado.setTelefone(usuario.getTelefone());
            }
            return repository.save(usuarioASerAlterado);
        }
        return null;
    }
}
