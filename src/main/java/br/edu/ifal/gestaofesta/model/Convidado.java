package br.edu.ifal.gestaofesta.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Convidado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nome;
    private Integer quantidadeAconpanhantes;

    public Convidado() {
        
    }

    public Convidado(String nome, Integer quantidadeAconpanhantes) {
        this.nome = nome;
        this.quantidadeAconpanhantes = quantidadeAconpanhantes;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadeAconpanhantes() {
        return quantidadeAconpanhantes;
    }

    public void setQuantidadeAconpanhantes(Integer quantidadeAconpanhantes) {
        this.quantidadeAconpanhantes = quantidadeAconpanhantes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
}