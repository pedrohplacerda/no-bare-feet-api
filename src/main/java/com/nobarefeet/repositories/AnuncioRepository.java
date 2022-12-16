package com.nobarefeet.repositories;

import com.nobarefeet.models.AnuncioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnuncioRepository extends JpaRepository<AnuncioModel, Integer> {

    AnuncioModel findByIdAnuncio(Integer idAnuncio);

    @Query("SELECT a FROM AnuncioModel a WHERE " + "a.titulo LIKE CONCAT('%', :query, '%') OR "
            + "a.descricao LIKE CONCAT('%', :query, '%') OR " + "a.marcaProduto LIKE CONCAT('%', :query, '%') OR " +
            "a.cor LIKE CONCAT('%', :query, '%') OR " + "a.modelo LIKE CONCAT('%', :query, '%')")
    List<AnuncioModel> searchAnuncios(String query);


}
