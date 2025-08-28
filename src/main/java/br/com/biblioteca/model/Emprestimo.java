package sistema_biblioteca;

import java.util.List;
import java.util.Scanner;

public class Emprestimo {

    private Cliente cliente;
    private Livro livro;
    private String dataEmprestimo;
    private String dataDevolucao;
    private String status;
    private double multaAplicada;
    private Funcionario funcionarioResponsavel;

    public Emprestimo(Cliente cliente, Livro livro, String dataEmprestimo,
                      String dataDevolucao, String status, double multaAplicada,
                      Funcionario funcionarioResponsavel) {

        this.cliente = cliente;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
        this.multaAplicada = multaAplicada;
        this.funcionarioResponsavel = funcionarioResponsavel;

    }

    public static void exibirLivrosEmprestados(List<Emprestimo> emprestimosAtivos) {
        for (int i = 0; i < emprestimosAtivos.size(); i++) {
            System.out.println("ID: " + (i+1) + emprestimosAtivos.get(i));
        }
    }

    @Override
    public String toString() {
        return " | Cliente: {" + this.cliente + "} | Livro: {" + this.livro + "} | Data do empréstimo: " + this.dataEmprestimo+
                " | Data da devolução: " + this.dataDevolucao + " | Status: " + this.status+
                " | Multa: " + this.multaAplicada + " | Funcionário: {" + this.funcionarioResponsavel + "}";
    }

    public static void realizarEmprestimo(List<Livro> livrosCadastrados, List<Emprestimo> emprestimosAtivos,
                                          List<HistoricoEmprestimos> historicoEmprestimos, List<Funcionario> funcionarios,
                                          List<Cliente> clientes) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("--REALIZAR EMPRÉSTIMO--");

        if (clientes.isEmpty()) {
            System.out.println("Ainda não há nenhum cliente cadastrado. Cadastre um para realizar o empréstimo!");
        } else if (livrosCadastrados.isEmpty()) {
            System.out.println("Ainda não há nenhum livro cadastrado. Cadastre um para realizar o empréstimo!");
        } else if (funcionarios.isEmpty()) {
            System.out.println("Ainda não há nenhum funcionário cadastrado. Cadastre um para realizar o empréstimo!");
        }

        else {
            Livro.exibirLivros(livrosCadastrados);
            System.out.print("Digite o ID do livro: ");
            int idLivro = scanner.nextInt();
            scanner.nextLine();
            Livro livroEmprestimo = livrosCadastrados.get(idLivro - 1);
            int disponibilidadeLivro = livroEmprestimo.getQtdEstoque();

            if (disponibilidadeLivro == 0) {
                System.out.println("Livro indisponível. Tente novamente!");
            } else {
                livroEmprestimo.setQtdEstoque(livroEmprestimo.getQtdEstoque()-1);

                Cliente.exibirClientes(clientes);
                System.out.printf("Qual cliente deseja conceder o empréstimo? ID: ");
                int idCliente = scanner.nextInt();
                scanner.nextLine();
                Cliente clienteEmprestimo = clientes.get(idCliente - 1);

                Funcionario.exibirFuncionarios(funcionarios);
                System.out.print("Digite o ID do funcionário responsável: ");
                int idFuncionario = scanner.nextInt();
                scanner.nextLine();
                Funcionario funcionarioEmprestimo = funcionarios.get(idFuncionario - 1);

                System.out.printf("Data do empréstimo (dd/mm/aa): ");
                String dataEmprestimo = scanner.nextLine();

                System.out.printf("Data da devolução (dd/mm/aa): ");
                String dataDevolucao = scanner.nextLine();

                System.out.printf("Ativar o empréstimo (s/n)? ");
                String statusEmprestimo = scanner.nextLine();

                double multa = 0.0;

                if (statusEmprestimo.equalsIgnoreCase("s")) {
                    Emprestimo novoEmprestimo = new Emprestimo(clienteEmprestimo, livroEmprestimo, dataEmprestimo,
                            dataDevolucao, statusEmprestimo, multa, funcionarioEmprestimo);
                    emprestimosAtivos.add(novoEmprestimo);
                }

                HistoricoEmprestimos emprestimo = new HistoricoEmprestimos(clienteEmprestimo, livroEmprestimo, dataEmprestimo,
                        dataDevolucao, statusEmprestimo, multa, funcionarioEmprestimo);

                historicoEmprestimos.add(emprestimo);

                System.out.println("--EMPRÉSTIMO CADASTRADO--");
                System.out.println(emprestimo);
            }
        }



    }
}
