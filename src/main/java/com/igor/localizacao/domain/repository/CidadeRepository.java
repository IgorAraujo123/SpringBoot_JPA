package com.igor.localizacao.domain.repository;

import com.igor.localizacao.domain.entity.Cidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade,Long>, JpaSpecificationExecutor<Cidade> {

    //Buscar por nome
    List<Cidade> findByNome(String name);

    //Busca pelo nome like
    @Query(" select c from Cidade c where upper(c.nome) like upper(?1)")
    List<Cidade> findByNomeLike(String nome);

    //Busca pelo nome like ordenado
    @Query(" select c from Cidade c where upper(c.nome) like upper(?1)")
    List<Cidade> findByNomeLike(String nome, Sort sort);

    //Busca pelo nome like paginado
    @Query(" select c from Cidade c where upper(c.nome) like upper(?1)")
    Page<Cidade> findByNomeLike(String nome, Pageable pageable);

    //Buscar pelo nome começando por aquele pedaço
    List<Cidade> findByNomeStartingWith(String nome);

    //Buscar pelo nome terminando por aquele pedaço
    List<Cidade> findByNomeEndingWith(String nome);

    //Buscar pelo nome contendo aquele pedaço
    List<Cidade> findByNomeContaining(String nome);

    List<Cidade> findByHabitantes(Long habitantes);

    List<Cidade> findByHabitantesLessThan(Long habitantes);

    List<Cidade> findByHabitantesGreaterThan(Long habitantes);

    List<Cidade> findByHabitantesLessThanEqual(Long habitantes);

    List<Cidade> findByHabitantesLessThanAndNomeLike(Long habitantes,String nome);
}
