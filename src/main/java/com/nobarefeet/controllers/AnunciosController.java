package com.nobarefeet.controllers;

import com.nobarefeet.models.AnuncioModel;
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
    public AnuncioModel criarAnuncio(AnuncioModel anuncioModel) {
        AnuncioModel anuncioModelSalvo = repository.save(anuncioModel);
        log.info("Anuncio criado com sucesso.");
        return anuncioModelSalvo;
    }

    @GetMapping(value = "/anuncios")
    public List<AnuncioModel> buscarAnunciosAtivos() {
        List<AnuncioModel> anuncioModelList = repository.findAll();
        return anuncioModelList.stream().filter(AnuncioModel::getAtivo).collect(Collectors.toList());
    }

    @DeleteMapping(value = "/anuncios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAnuncio(@PathVariable("id") Integer idAnuncio) {
        repository.deleteById(idAnuncio);
        log.info("Anúncio deletado com sucesso.");
    }

    @PutMapping(value = "/anuncios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public AnuncioModel editarUsuario(@PathVariable("id") Integer id, @RequestBody AnuncioModel anuncioModel) {
        var optionalAnuncio = repository.findById(id);
        if (optionalAnuncio.isPresent()) {
            AnuncioModel anuncioModelASerAlterado = optionalAnuncio.get();
            if (Objects.nonNull(anuncioModel.getTitulo())) {
                anuncioModelASerAlterado.setTitulo(anuncioModel.getTitulo());
            }
            if (Objects.nonNull(anuncioModel.getAtivo())) {
                anuncioModelASerAlterado.setAtivo(anuncioModel.getAtivo());
            }
            if (Objects.nonNull(anuncioModel.getDescricao())) {
                anuncioModelASerAlterado.setDescricao(anuncioModel.getDescricao());
            }
            return repository.save(anuncioModelASerAlterado);
        }
        return null;
    }

}
