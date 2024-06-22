package com.teste.classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * classe Pessoa, que serve de classe base para a classe Funcionário.
 */
public class Pessoa {
    private String nome;
    private LocalDate dataDeAniversario;

    /**
     * Construtor.
     * 
     * @param String nome
     * @param LocalDate dataDeAniversario
     */
    public Pessoa(String nome, LocalDate dataDeAniversario) {
        this.nome = nome;
        this.dataDeAniversario = dataDeAniversario;
    }

    /**
     * Retorna nome do funcionário.
     * 
     * @return String
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a data de aniversário do funcionário.
     * 
     * @return LocalDate
     */
    public LocalDate getDataDeAniversario() {
        return dataDeAniversario;
    }

    /**
     * Formatação sobreescrita da string da classe.
     */
    @Override
    public String toString() {
        return "Nome: " + nome + ", data de nascimento: " + dataDeAniversario.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
