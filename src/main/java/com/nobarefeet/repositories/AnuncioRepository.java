package com.nobarefeet.repositories;

import com.nobarefeet.models.AnuncioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnuncioRepository extends JpaRepository<AnuncioModel, Integer> {

    AnuncioModel findByIdAnuncio(Integer idAnuncio);

}
