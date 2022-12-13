package com.nobarefeet.controllers;

import com.nobarefeet.models.Produto;
import com.nobarefeet.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProdutosController {

    private final ProdutoRepository repository;

    @PostMapping(value = "/produtos")
    @ResponseStatus(HttpStatus.CREATED)
    public Produto saveProduto(Produto produto) {
        return repository.save(produto);
    }

    @GetMapping(value = "/produtos")
    public List<Produto> getProdutos() {
        return repository.findAll();
    }

}
