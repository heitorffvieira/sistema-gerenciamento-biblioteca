package sistema_biblioteca;

import java.util.List;

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
}
