package sistema_biblioteca;

import java.util.List;
import java.util.Scanner;

public class Cliente {

    private String nome;
    private String CPF;
    private String cidade;
    private String telefone;
    private String email;
    private String dataNascimento;
    private boolean clienteNovo;

    public Cliente(String nome, String CPF, String cidade, String telefone,
                   String email, String dataNascimento, boolean clienteNovo) {

        this.nome = nome;
        this.CPF = CPF;
        this.cidade = cidade;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.clienteNovo = clienteNovo;

    }

    public static void exibirClientes(List<Cliente> clientes) {
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("ID: " + (i+1) + clientes.get(i));
        }
    }

    @Override
    public String toString() {
        return " | Nome: " + this.nome + " | CPF: " + this.CPF + " | Cidade: " + this.cidade+
                " | Telefone: " + this.telefone + " | Email: " + this.email+
                " | Data de nascimento: " + this.dataNascimento + " | Cliente novo? " + this.clienteNovo;
    }

    public static void cadastrarCliente(List<Cliente> clientes) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        System.out.printf("CPF: ");
        String cpfCliente = scanner.nextLine();

        System.out.printf("Cidade: ");
        String cidadeCliente = scanner.nextLine();

        System.out.printf("Telefone: ");
        String telefoneCliente = scanner.nextLine();

        System.out.printf("Email: ");
        String emailCliente = scanner.nextLine();

        System.out.printf("Data de nascimento (dd/mm/aa): ");
        String nascimentoCliente = scanner.nextLine();

        System.out.printf("É cliente novo? (s/n) ");
        String isNew = scanner.nextLine();
        boolean clienteNovo;

        if (isNew.equalsIgnoreCase("s")){
            clienteNovo = true;
        } else {
            clienteNovo = false;
        }

        Cliente dadosCliente = new Cliente(nomeCliente, cpfCliente, cidadeCliente,
                telefoneCliente, emailCliente, nascimentoCliente, clienteNovo);

        clientes.add(dadosCliente);

        System.out.println("---CLIENTE CADASTRADO---");
        System.out.println(clientes);
    }
}
