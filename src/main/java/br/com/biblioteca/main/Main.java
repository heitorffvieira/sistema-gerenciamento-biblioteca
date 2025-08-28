package sistema_biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Livro> livrosCadastrados = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        List<Funcionario> funcionarios = new ArrayList<>();
        List<Emprestimo> emprestimosAtivos = new ArrayList<>();
        List<HistoricoEmprestimos> historicoEmprestimos = new ArrayList<>();
        List<Reserva> reservas = new ArrayList<>();
        List<Multa> multasAplicadas = new ArrayList<>();

        int escolhaUser;

        do {
            System.out.println("==== Sistema de Biblioteca ====");
            System.out.println("1- Cadastrar Livro");
            System.out.println("2- Cadastrar Cliente");
            System.out.println("3- Cadastrar Funcionário");
            System.out.println("4- Realizar Empréstimo");
            System.out.println("5- Devolução de Livro");
            System.out.println("6- Gerenciar Reservas");
            System.out.println("7- Aplicar Multa");
            System.out.println("8- Realizar Pagamento");
            System.out.println("9- Relatórios");
            System.out.println("10- Sair");

            System.out.print("Escolha uma opção: ");
            escolhaUser = scanner.nextInt();
            scanner.nextLine();

            switch (escolhaUser) {

                case 1:
                    Livro.cadastrarLivro(livrosCadastrados);
                    break;

                case 2:
                    Cliente.cadastrarCliente(clientes);
                    break;

                case 3:
                    Funcionario.cadastrarFuncionario(funcionarios);
                    break;

                case 4:
                    Emprestimo.realizarEmprestimo(livrosCadastrados, emprestimosAtivos, historicoEmprestimos,
                            funcionarios, clientes);
                    break;

                case 5:
                    Livro.devolucaoLivro(emprestimosAtivos, historicoEmprestimos,livrosCadastrados);
                    break;

                case 6:
                    Reserva.gerenciarReservas(reservas, clientes, livrosCadastrados, funcionarios);
                    break;

                case 7:
                    Multa.aplcarMulta(clientes, livrosCadastrados, funcionarios, historicoEmprestimos, multasAplicadas);
                    break;

                case 8:
                    Pagamento.realizarPagamento(multasAplicadas);
                    break;

                case 9:
                    Relatorio.exibirRelatorios(multasAplicadas, historicoEmprestimos, emprestimosAtivos, funcionarios,
                            clientes, reservas, livrosCadastrados);
                    break;

                default:
                    System.out.println("--SELECIONE UMA OPÇÃO VÁLIDA!--");
            }

        } while (escolhaUser != 10);

        System.out.println("--FIM DO PROGRAMA--");
        scanner.close();

    }

}