package com.teste.classes;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Classe funcionário, herda de pessoa. 
 */
public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String cargo;

    /**
     * Método construtor de funcionário.
     * 
     * @param String nome
     * @param LocalDate dataDeAniversario
     * @param BigDecimal salario
     * @param String cargo
     */
    public Funcionario(String nome, LocalDate dataDeAniversario, BigDecimal salario, String cargo) {
        super(nome, dataDeAniversario);
        this.salario = salario;
        this.cargo = cargo;
    }

    /**
     * Retorna o salário do funcionário.
     * 
     * @return BigDecimal
     */
    public BigDecimal getSalario() {
        return salario;
    }

    /**
     * Returna o cargo do funcionário.
     * 
     * @return String
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Retorna salário do funcionário.
     * 
     * @param BigDecimal salary
     */
    public void setSalario(BigDecimal salary) {
        this.salario = salary;
    }

    /**
     * Formatação sobreescrita da string da classe.
     */
    @Override
    public String toString() {
        return super.toString() + ", salário: " + String.format("%,.2f", salario) + ", função: " + cargo;
    }
}
