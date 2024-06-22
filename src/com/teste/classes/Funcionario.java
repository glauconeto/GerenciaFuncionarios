package com.teste.classes;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String cargo;

    public Funcionario(String nome, LocalDate dataDeAniversario, BigDecimal salario, String cargo) {
        super(nome, dataDeAniversario);
        this.salario = salario;
        this.cargo = cargo;
    }

    public BigDecimal getSalary() {
        return salario;
    }

    public String getFunction() {
        return cargo;
    }

    public void setSalary(BigDecimal salary) {
        this.salario = salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", salário: " + String.format("%,.2f", salario) + ", função: " + cargo;
    }
}
