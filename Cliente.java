package sistema_biblioteca;

import java.util.List;

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
}
