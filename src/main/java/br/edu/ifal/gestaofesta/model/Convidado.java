package br.edu.ifal.gestaofesta.model;

public class Convidado{

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

    
}