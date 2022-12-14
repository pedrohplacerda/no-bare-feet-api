package com.nobarefeet.controllers;

import com.nobarefeet.models.Anuncio;
import com.nobarefeet.repositories.AnuncioRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@RestController
@AllArgsConstructor
public class AnunciosController {
    private final AnuncioRepository repository;

    @PostMapping(value = "/anuncios")
    @ResponseStatus(HttpStatus.CREATED)
    public Anuncio criarAnuncio(Anuncio anuncio) {
        Anuncio anuncioSalvo = repository.save(anuncio);
        log.info("Anuncio criado com sucesso.");
        return anuncioSalvo;
    }

    @GetMapping(value = "/anuncios")
    public List<Anuncio> buscarAnunciosAtivos() {
        List<Anuncio> anuncioList = repository.findAll();
        return anuncioList.stream().filter(Anuncio::getAtivo).collect(Collectors.toList());
    }

    @DeleteMapping(value = "/anuncios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAnuncio(@PathVariable("id") Integer idAnuncio) {
        repository.deleteById(idAnuncio);
        log.info("Anúncio deletado com sucesso.");
    }

    @PutMapping(value = "/anuncios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Anuncio editarUsuario(@PathVariable("id") Integer id, @RequestBody Anuncio anuncio) {
        var optionalAnuncio = repository.findById(id);
        if(optionalAnuncio.isPresent()) {
            Anuncio anuncioASerAlterado = optionalAnuncio.get();
            if (Objects.nonNull(anuncio.getTitulo())) {
                anuncioASerAlterado.setTitulo(anuncio.getTitulo());
            }
            if (Objects.nonNull(anuncio.getAtivo())) {
                anuncioASerAlterado.setAtivo(anuncio.getAtivo());
            }
            if (Objects.nonNull(anuncio.getDescricao())) {
                anuncioASerAlterado.setDescricao(anuncio.getDescricao());
            }
            return repository.save(anuncioASerAlterado);
        }
        return null;
    }

}
