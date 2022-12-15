package com.nobarefeet.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

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

    @Column(name = "preco")
    private String preco;

    @Column(name = "ativo")
    @Nullable
    private Integer ativo;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "nome_anunciante")
    private String nomeAnunciante;

    @Column(name = "img1")
    private String img1;

    @Column(name = "img2")
    private String img2;

    @Column(name = "img3")
    private String img3;

    @Column(name = "img4")
    private String img4;

    @Column(name = "aceita_troca")
    private Integer aceitaTroca;
}
