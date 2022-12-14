package com.nobarefeet.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = " tb_usuario")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_nascimento")
    private String dataNascimento;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf_cnpj")
    private String cpfCnpj;

    @Column(name = "cep")
    private String cep;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "senha")
    private String senha;

}
