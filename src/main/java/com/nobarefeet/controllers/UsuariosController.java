package com.nobarefeet.controllers;

import com.nobarefeet.models.UsuarioModel;
import com.nobarefeet.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@AllArgsConstructor
public class UsuariosController {
    private final UsuarioRepository repository;

    @PostMapping(value = "/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioModel saveUsuario(@RequestBody UsuarioModel usuarioModel) {
        repository.save(usuarioModel);
        return usuarioModel;
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
    public UsuarioModel editarUsuario(@PathVariable("id") Integer id, @RequestBody UsuarioModel usuarioModel) {
        var optionalUsuario = repository.findById(id);
        if (optionalUsuario.isPresent()) {
            UsuarioModel usuarioModelASerAlterado = optionalUsuario.get();
            if (Objects.nonNull(usuarioModel.getNome())) {
                usuarioModelASerAlterado.setNome(usuarioModel.getNome());
            }
            if (Objects.nonNull(usuarioModel.getCep())) {
                usuarioModelASerAlterado.setCep(usuarioModel.getCep());
            }
            if (Objects.nonNull(usuarioModel.getEmail())) {
                usuarioModelASerAlterado.setEmail(usuarioModel.getEmail());
            }
            if (Objects.nonNull(usuarioModel.getDataNascimento())) {
                usuarioModelASerAlterado.setDataNascimento(usuarioModel.getDataNascimento());
            }
            if (Objects.nonNull(usuarioModel.getTelefone())) {
                usuarioModelASerAlterado.setTelefone(usuarioModel.getTelefone());
            }
            return repository.save(usuarioModelASerAlterado);
        }
        return null;
    }
}
