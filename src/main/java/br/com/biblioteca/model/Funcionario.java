package sistema_biblioteca;

import java.util.List;
import java.util.Scanner;

public class Funcionario {

    private String nome;
    private String CPF;
    private String cargo;
    private String email;
    private String telefone;
    private String dataContratacao;
    private String turnoTrabalho;

    public Funcionario(String nome, String CPF, String cargo, String email,
                       String telefone, String dataContratacao, String turnoTrabalho) {

        this.nome = nome;
        this.CPF = CPF;
        this.cargo = cargo;
        this.email = email;
        this.telefone = telefone;
        this.dataContratacao = dataContratacao;
        this.turnoTrabalho = turnoTrabalho;

    }

    public static void exibirFuncionarios(List<Funcionario> funcionarios) {
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.println("ID: " + (i+1) + funcionarios.get(i));
        }
    }

    @Override
    public String toString() {
        return " | Nome: " + this.nome + " | CPF: " + this.CPF + " | Cargo: " + this.cargo+
                " | Telefone: " + this.telefone + " | Email: " + this.email+
                " | Data de contratação: " + this.dataContratacao + " | Turno de trabalho: " + this.turnoTrabalho;
    }

    public static void cadastrarFuncionario(List<Funcionario> funcionarios) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Nome do funcionário: ");
        String nomeFuncionario = scanner.nextLine();

        System.out.printf("CPF: ");
        String cpfFuncionario = scanner.nextLine();

        System.out.printf("Cargo: ");
        String cargo = scanner.nextLine();

        System.out.printf("Email: ");
        String emailFuncionario = scanner.nextLine();

        System.out.printf("Telefone: ");
        String telefoneFuncionario = scanner.nextLine();

        System.out.printf("Data de contratação (dd/mm/aa): ");
        String dataContratacao = scanner.nextLine();

        System.out.printf("Turno de trabalho: ");
        String turnoTrabalho = scanner.nextLine();

        Funcionario novoFuncionario = new Funcionario(nomeFuncionario, cpfFuncionario, cargo, emailFuncionario,
                telefoneFuncionario, dataContratacao, turnoTrabalho);

        funcionarios.add(novoFuncionario);

        System.out.println("---FUNCIONÁRIO CADASTRADO---");
        System.out.println(funcionarios);
    }
}
