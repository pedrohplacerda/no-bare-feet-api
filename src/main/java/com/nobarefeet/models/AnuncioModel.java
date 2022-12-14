package com.nobarefeet.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "tb_anuncio")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnuncioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_anuncio")
    private Integer idAnuncio;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "marca")
    private String marcaProduto;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "tamanho")
    private String tamanho;

    @Column(name = "cor")
    private String cor;

    @Column(name = "condicao")
    private String condicao;

    @Column(name = "tipo_produto")
    private String tipoProduto;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "info_vendedor")
    private String infoVendedor;

    @Column(name = "ativo")
    private Boolean ativo;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "nome_anunciante")
    private String nomeAnunciante;

}
