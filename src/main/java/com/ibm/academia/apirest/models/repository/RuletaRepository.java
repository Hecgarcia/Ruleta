package com.ibm.academia.apirest.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.models.entitie.Ruleta;

@Repository
public interface RuletaRepository extends PagingAndSortingRepository<Ruleta, Long> {

}
