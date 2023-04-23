package com.igor.localizacao.service;

import ch.qos.logback.core.util.StringCollectionUtil;
import com.igor.localizacao.domain.entity.Cidade;
import com.igor.localizacao.domain.repository.CidadeRepository;
import static com.igor.localizacao.domain.repository.specs.CidadeSpecs.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.swing.text.StringContent;
import java.util.List;

@Service
public class CidadeService {

    private CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository){
        this.cidadeRepository = cidadeRepository;
    }

    public void listarCidadePorQuantidadeDeHabitantes(){
        cidadeRepository.findByHabitantesLessThanAndNomeLike(6785309L,"%o%")
                .forEach(System.out::println);
    }

    public void listarCidadePorNome(){
        Sort sort = Sort.by("nome");
        Pageable pageable = PageRequest.of(2,5);
        cidadeRepository.findByNomeLike("%%%",sort).forEach(System.out::println);
    }

    public void listarCidadePorHabitantes(){
        cidadeRepository.findByHabitantes(695477L).forEach(System.out::println);
    }

    public void salvarCidade(){
        var cidade = new Cidade(1L,"São Paulo", 1221221L);
        cidadeRepository.save(cidade);
    }

    public void listarCidade(){
        cidadeRepository.findAll().forEach(System.out::println);
    }

    public List<Cidade> filtroDinamico(Cidade cidade){
        ExampleMatcher exampleMatcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);
        Example<Cidade> example = Example.of(cidade, exampleMatcher);
        return cidadeRepository.findAll(example);
    }

    public void listarCidadeByNomeSpec(){
        cidadeRepository
                .findAll(habitantesBetWeen(6785309L,12321331L))
                .forEach(System.out::println);
    }

    public void listarCidadeSpecFiltroDinamico(Cidade filtro){
        Specification<Cidade> spec = Specification.where((root, query, cb) -> cb.conjunction());

        if(filtro.getId() != null){
            spec = spec.and(idEqual(filtro.getId()));
        }

        if(StringUtils.hasText(filtro.getNome())){
            spec = spec.and(nomeEqual(filtro.getNome()));
        }

        if(filtro.getHabitantes() != null){
           spec = spec.and(habitantesGreaterThan(filtro.getHabitantes()));
        }

        cidadeRepository
                .findAll(spec)
                .forEach(System.out::println);
    }
}
