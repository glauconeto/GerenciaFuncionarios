import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import com.teste.classes.Funcionario;

public class App {
    public static void main(String[] args) {
        // Cria um objeto ArrayList do tipo Funcionários para operar todas as ações.
        List<Funcionario> func = new ArrayList<>();

        // Insere todos os funcionários, na mesma ordem e as informações da tabela.
        func.add(new Funcionario("Maria", LocalDate.of(1990, 5, 15), new BigDecimal(2009.44), "Operador"));
        func.add(new Funcionario("João", LocalDate.of(1990, 05, 12), new BigDecimal(2284.38), "Operador"));
        func.add(new Funcionario("Caio", LocalDate.of(1961, 05, 02), new BigDecimal(9836.14), "Coordenador"));
        func.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal(19119.88), "Diretor"));
        func.add(new Funcionario("Alice", LocalDate.of(1995, 01, 05), new BigDecimal(2234.68), "Recepcionista"));
        func.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal(1582.72), "Operador"));
        func.add(new Funcionario("Arthur", LocalDate.of(1993, 03, 31), new BigDecimal (4071.84), "Contador"));
        func.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal (3017.45), "Gerente"));
        func.add(new Funcionario("Heloísa", LocalDate.of(1999, 11, 19),new BigDecimal (1606.85), "Eletricista"));
        func.add(new Funcionario("Helena", LocalDate.of(1999, 11, 19), new BigDecimal (2799.93), "Gerente"));

        // Remove o Funcionario "João".
        func.remove(1);

        System.out.println("Funcionários: ");
        func.forEach(System.out::println);

        // Realiza aumento de 10% para cada funcionário.
        func.forEach(emp -> emp.setSalary(emp.getSalary().multiply(new BigDecimal("1.1"))));
        // func.forEach(System.out::println);

        // Agrupa funcionários por função.
        Map<String, List<Funcionario>> funcionariosPorFuncao = func.stream()
                .collect(Collectors.groupingBy(Funcionario::getFunction));

        // Lista os funcionários agrupados por função.
        System.out.println("\nFuncionários agrupados por função:");
        funcionariosPorFuncao.forEach((function, empList) -> {
            System.out.println(function + ":");
            empList.forEach(emp -> System.out.println("  " + emp));
        });

        // Imprime funcionários que nasceram no mês 10 e 12.
        System.out.println("\nFuncionários que nasceram no mês de outubro e dezembro:");
        func.stream()
                .filter(emp -> emp.getDataDeAniversario().getMonth() == Month.OCTOBER || emp.getDataDeAniversario().getMonth() == Month.DECEMBER)
                .forEach(emp -> {
                    String dataFormatada = emp.getDataDeAniversario().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    System.out.println(emp.getName() + " - Aniversário: " + dataFormatada);
                });

        // 3.8 - Imprime o funcionário mais velho.
        System.out.println("\nFuncionario mais velho:");
        Funcionario funcionarioVelho = func.stream()
                .min((emp1, emp2) -> emp1.getDataDeAniversario().compareTo(emp2.getDataDeAniversario()))
                .orElse(null);
        
        if (funcionarioVelho != null) {
            int idade = LocalDate.now().getYear() - funcionarioVelho.getDataDeAniversario().getYear();
            System.out.println("Nome: " + funcionarioVelho.getName() + ", Idade: " + idade);
        }

        // Imprime uma lista de funcionários em ordem alfabética.
        System.out.println("\nFuncionarios em ordem alfabética:");
        func.stream()
                .sorted((emp1, emp2)->emp1.getName().compareTo(emp2.getName()))
                .forEach(System.out::println);

        // Imprime o total dos salários dos funcionários.
        BigDecimal totalSalaries = func.stream()
                .map(Funcionario::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("\nTotal de salários: " + String.format("%,.2f", totalSalaries));

        // Imprime quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
        System.out.println("\nQuantos salários mínimos ganha cada funcionário:\n");
        func.forEach(emp -> {
            BigDecimal numMinimumWages = emp.getSalary().divide(new BigDecimal("1212.00"), RoundingMode.HALF_DOWN);
            
            System.out.println(emp.getName() + ": " + String.format("%,.2f", numMinimumWages) + " salários mínimos");
        });
    }
}
