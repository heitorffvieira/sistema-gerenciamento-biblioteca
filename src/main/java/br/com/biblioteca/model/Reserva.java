package sistema_biblioteca;

import java.util.List;
import java.util.Scanner;

public class Reserva {

    private Cliente cliente;
    private Livro livro;
    private String dataReserva;
    private String status;
    private String dataExpiracao;
    private int numeroDiasParaRetirada;
    private String dataSolicitacao;

    public Reserva(Cliente cliente, Livro livro, String dataReserva, String status,
                   String dataExpiracao, int numeroDiasParaRetirada, String dataSolicitacao) {

        this.cliente = cliente;
        this.livro = livro;
        this.dataReserva = dataReserva;
        this.status = status;
        this.dataExpiracao = dataExpiracao;
        this.numeroDiasParaRetirada = numeroDiasParaRetirada;
        this.dataSolicitacao = dataSolicitacao;

    }

    public static void exibirReservas(List<Reserva> reservas) {
        for (int i = 0; i < reservas.size(); i++) {
            System.out.println("ID: " + (i+1) + reservas.get(i));
        }
    }

    @Override
    public String toString() {
        return " | Cliente: {" + this.cliente + "} | Livro: {" + this.livro + "} | Data da reserva: " + this.dataReserva+
                " | Status da reserva: " + this.status + " | Data de expiração: " + this.dataExpiracao+
                " | Dias para retirada: " + this.numeroDiasParaRetirada + " | Data da solicitação: " + this.dataSolicitacao;
    }

    public static void gerenciarReservas(List<Reserva> reservas, List<Cliente> clientes, List<Livro> livrosCadastrados,
                                         List<Funcionario> funcionarios) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("--GERENCIAR RESERVAS--");

        if (clientes.isEmpty()) {
            System.out.println("Ainda não há nenhum cliente cadastrado. Cadastre um para gerenciar reservas!");
        } else if (livrosCadastrados.isEmpty()) {
            System.out.println("Ainda não há nenhum livro cadastrado. Cadastre um para gerenciar reservas");
        } else if (funcionarios.isEmpty()) {
            System.out.println("Ainda não há nenhum funcionário cadastrado. Cadastre um para gerenciar reservas");
        }

        else {
            System.out.println("---------------------------");
            System.out.println("O que deseja fazer?");
            System.out.println("1- Criar reserva");
            System.out.println("2- Cancelar reserva");
            System.out.println("3- Ver reservas ativas");
            System.out.printf("Sua escolha: ");
            int escolha = scanner.nextInt();

            if (escolha == 1) {
                Cliente.exibirClientes(clientes);
                System.out.printf("Digite o ID do Cliente: ");
                int idCliente = scanner.nextInt();
                Cliente clienteReserva = clientes.get(idCliente - 1);

                Livro.exibirLivros(livrosCadastrados);
                System.out.printf("Digite o ID do Livro: ");
                int idLivro = scanner.nextInt();
                Livro livroReserva = livrosCadastrados.get(idLivro - 1);
                scanner.nextLine();

                System.out.printf("Data da reserva (dd/mm/aa): ");
                String dataReserva = scanner.nextLine();

                System.out.printf("Status da reserva: ");
                String statusReserva = scanner.nextLine();

                System.out.printf("Data de expiração (dd/mm/aa): ");
                String dataExpiracao = scanner.nextLine();

                System.out.printf("Número de dias para a retirada: ");
                int numeroDiasRetirada = scanner.nextInt();
                scanner.nextLine();

                System.out.printf("Data da solicitação (dd/mm/aa): ");
                String dataSolicitacao = scanner.nextLine();

                Reserva novaReserva = new Reserva(clienteReserva, livroReserva, dataReserva, statusReserva,
                        dataExpiracao, numeroDiasRetirada, dataSolicitacao);

                reservas.add(novaReserva);
                System.out.println("--RESERVA CRIADA!--");
                System.out.println(novaReserva);

            } else if (escolha == 2) {
                if (reservas.isEmpty()) {
                    System.out.println("Não há nenhuma reserva cadastrada. Tente novamente!");
                } else {
                    Reserva.exibirReservas(reservas);
                    System.out.printf("Selecione o ID da reserva que deseja cancelar: ");
                    int idReserva = scanner.nextInt();
                    scanner.nextLine();
                    reservas.remove(idReserva - 1);
                    System.out.println("--RESERVA CANCELADA!--");
                }

            } else if (escolha == 3) {
                if (reservas.isEmpty()) {
                    System.out.println("Não há nenhuma reserva cadastrada. Tente novamente!");
                } else {
                    System.out.println("--RESERVAS ATIVAS--");
                    Reserva.exibirReservas(reservas);
                }
            }

        }
    }

}

