package com.teste.classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {
    private String nome;
    private LocalDate dataDeAniversario;

    public Pessoa(String nome, LocalDate dataDeAniversario) {
        this.nome = nome;
        this.dataDeAniversario = dataDeAniversario;
    }

    public String getName() {
        return nome;
    }

    public LocalDate getDataDeAniversario() {
        return dataDeAniversario;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", data de nascimento: " + dataDeAniversario.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
