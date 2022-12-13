package com.nobarefeet.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = " tb_usuario")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf_cnpj")
    private String cpfCnpj;

    @Column(name = "cep")
    private Integer cep;

    @Column(name = "num_de_vendas")
    private Integer numDeVendas;

    @Column(name = "porcentagem_satisfacao")
    private Integer porcentagemSatisfacao;

    @Column(name = "telefone")
    private String telefone;

}
