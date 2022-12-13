package com.nobarefeet.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = " tb_produto")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Integer idProduto;

    @Column(name = "nome_produto")
    private String nomeProduto;

    @Column(name = "preco")
    private Integer preco;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "tamanho")
    private Integer tamanho;

    @Column(name = "cor")
    private String cor;

    @Column(name = "marca")
    private String marca;

    @Column(name = "qtd")
    private Integer qtd;
}
