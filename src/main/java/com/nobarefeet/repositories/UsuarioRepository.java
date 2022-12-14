package com.nobarefeet.repositories;

import com.nobarefeet.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

    Boolean existsByNomeAndSenha(String nomeUsuario, String senha);

    UsuarioModel findAllByNome(String nome);

}
