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
    public AnuncioModel criarAnuncio(@RequestBody AnuncioModel anuncioModel) {
        AnuncioModel anuncioModelSalvo = repository.save(anuncioModel);
        log.info("Anuncio criado com sucesso.");
        return anuncioModelSalvo;
    }

    @GetMapping(value = "/anuncios")
    public List<AnuncioModel> buscarAnunciosAtivos() {
        List<AnuncioModel> anuncioModelList = repository.findAll();
        return anuncioModelList.stream().filter(anuncioModel -> Objects.equals(anuncioModel.getAtivo(), 1)).collect(Collectors.toList());
    }

    @GetMapping(value = "/anuncios/{id}")
    public AnuncioModel buscarAnuncioPorId(@PathVariable Integer id) {
        return repository.findByIdAnuncio(id);
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
            if (Objects.nonNull(anuncioModel.getDescricao())) {
                anuncioModelASerAlterado.setDescricao(anuncioModel.getDescricao());
            }
            if (Objects.nonNull(anuncioModel.getCondicao())) {
                anuncioModelASerAlterado.setCondicao(anuncioModel.getCondicao());
            }
            if (Objects.nonNull(anuncioModel.getImg1())) {
                anuncioModelASerAlterado.setImg1(anuncioModel.getImg1());
            }
            if (Objects.nonNull(anuncioModel.getImg2())) {
                anuncioModelASerAlterado.setImg2(anuncioModel.getImg2());
            }
            if (Objects.nonNull(anuncioModel.getImg3())) {
                anuncioModelASerAlterado.setImg3(anuncioModel.getImg3());
            }
            if (Objects.nonNull(anuncioModel.getImg4())) {
                anuncioModelASerAlterado.setImg4(anuncioModel.getImg4());
            }
            if (Objects.nonNull(anuncioModel.getCor())) {
                anuncioModelASerAlterado.setCor(anuncioModel.getCor());
            }
            if (Objects.nonNull(anuncioModel.getModelo())) {
                anuncioModelASerAlterado.setModelo(anuncioModel.getModelo());
            }
            if (Objects.nonNull(anuncioModel.getTipoProduto())) {
                anuncioModelASerAlterado.setTipoProduto(anuncioModel.getTipoProduto());
            }
            if (Objects.nonNull(anuncioModel.getTamanho())) {
                anuncioModelASerAlterado.setTamanho(anuncioModel.getTamanho());
            }
            if (Objects.nonNull(anuncioModel.getAceitaTroca())) {
                anuncioModelASerAlterado.setAceitaTroca(anuncioModel.getAceitaTroca());
            }
            if (Objects.nonNull(anuncioModel.getAtivo())) {
                anuncioModelASerAlterado.setAtivo(anuncioModel.getAtivo());
            }
            if (Objects.nonNull(anuncioModel.getMarcaProduto())) {
                anuncioModelASerAlterado.setMarcaProduto(anuncioModel.getMarcaProduto());
            }
            if (Objects.nonNull(anuncioModel.getPreco())) {
                anuncioModelASerAlterado.setPreco(anuncioModel.getPreco());
            }
            return repository.save(anuncioModelASerAlterado);
        }
        return null;
    }

}
