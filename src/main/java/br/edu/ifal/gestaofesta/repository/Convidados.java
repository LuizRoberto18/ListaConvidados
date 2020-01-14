package br.edu.ifal.gestaofesta.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifal.gestaofesta.model.Convidado;

@Repository
public interface Convidados extends CrudRepository<Convidado, Long> {
    List<Convidado> findByNomeContaining(String nome);
}