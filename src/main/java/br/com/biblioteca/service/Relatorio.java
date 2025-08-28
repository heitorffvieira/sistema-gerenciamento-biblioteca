package sistema_biblioteca;

import java.util.List;
import java.util.Scanner;

public class Relatorio {

    private List<HistoricoEmprestimos> emprestimosCadastrados;
    private List<Emprestimo> emprestimosAtivos;
    private List<Livro> livrosCadastrados;
    private List<Multa> multasCadastradas;
    private double valorTotalMultas;
    private List<Cliente> clientesCadastrados;
    private List<Funcionario> funcionariosCadastrados;
    private List<Reserva> reservasAtivas;

    public Relatorio(List<HistoricoEmprestimos> emprestimosCadastrados, List<Emprestimo> emprestimosAtivos, List<Livro> livrosCadastrados, List<Multa> multasCadastradas,
                     double valorTotalMultas, List<Cliente> clientesCadastrados, List<Funcionario> funcionariosCadastrados, List<Reserva> reservasAtivas) {

        this.emprestimosCadastrados = emprestimosCadastrados;
        this.emprestimosAtivos = emprestimosAtivos;
        this.livrosCadastrados = livrosCadastrados;
        this.multasCadastradas = multasCadastradas;
        this.valorTotalMultas = valorTotalMultas;
        this.clientesCadastrados = clientesCadastrados;
        this.funcionariosCadastrados = funcionariosCadastrados;
        this.reservasAtivas = reservasAtivas;

    }

    public List<HistoricoEmprestimos> getEmprestimosCadastrados() {
        return emprestimosCadastrados;
    }

    public List<Emprestimo> getEmprestimosAtivos() {
        return emprestimosAtivos;
    }

    public List<Livro> getLivrosCadastrados() {
        return livrosCadastrados;
    }

    public List<Multa> getMultasCadastradas() {
        return multasCadastradas;
    }

    public double getValorTotalMultas() {
        return valorTotalMultas;
    }

    public List<Cliente> getClientesCadastrados() {
        return clientesCadastrados;
    }

    public List<Funcionario> getFuncionariosCadastrados() {
        return funcionariosCadastrados;
    }

    public List<Reserva> getReservasAtivas() {
        return reservasAtivas;
    }

    @Override
    public String toString() {
        return "Empréstimos cadastrados: " + getLivrosCadastrados() + "\n" +
                "Empréstimos Ativos: " + getEmprestimosAtivos() + "\n" +
                "Livros cadastrados: " + getLivrosCadastrados() + "\n" +
                "Multas aplicadas: " + getMultasCadastradas() + "\n" +
                "Valor total em multas: R$" + getValorTotalMultas() + "\n" +
                "Clientes cadastrados: " + getClientesCadastrados() + "\n" +
                "Reservas ativas: " + getReservasAtivas();
    }

    public static void exibirRelatorios(List<Multa> multasAplicadas, List<HistoricoEmprestimos> historicoEmprestimos, List<Emprestimo> emprestimosAtivos,
                                        List<Funcionario> funcionarios, List<Cliente> clientes, List<Reserva> reservas, List<Livro> livrosCadastrados) {

        Scanner scanner = new Scanner(System.in);

        double valorTotalMultas = Multa.calcularValorTotalMultas(multasAplicadas);

        Relatorio relatorio = new Relatorio(historicoEmprestimos, emprestimosAtivos, livrosCadastrados, multasAplicadas,
                valorTotalMultas, clientes, funcionarios, reservas);

        System.out.println("--RELATÓRIOS--");
        System.out.println("1- Ver histórico de empréstimos");
        System.out.println("2- Ver empréstimos ativos");
        System.out.println("3- Ver livros cadastrados");
        System.out.println("4- Ver multas aplicadas");
        System.out.println("5- Ver valor total de multas");
        System.out.println("6- Ver clientes cadastrados");
        System.out.println("7- Ver funcionários cadastrados");
        System.out.println("8- Ver reservas cadastradas");
        System.out.println("9- Ver relatório completo");

        System.out.printf("Sua escolha: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1:
                if (relatorio.getEmprestimosCadastrados().isEmpty()) {
                    System.out.println("Não há nenhum empréstimo cadastrado");
                } else {
                    System.out.println("--EMPRÉSTIMO(s) CADASTRADO(s)--");
                    HistoricoEmprestimos.exibirHistoricoEmprestimos(historicoEmprestimos);
                }
                break;
            case 2:
                if (relatorio.getEmprestimosAtivos().isEmpty()) {
                    System.out.println("Não há nenhum empréstimo ativo!");
                } else {
                    System.out.println("--EMPRÉSTIMO(s) ATIVO(s)--");
                    Emprestimo.exibirLivrosEmprestados(emprestimosAtivos);
                }
                break;
            case 3:
                if (relatorio.getEmprestimosCadastrados().isEmpty()) {
                    System.out.println("Não há histórico de empréstimo!");
                } else {
                    System.out.println("--EMPRÉSTIMO(s) CADASTRADO(s)--");
                    HistoricoEmprestimos.exibirHistoricoEmprestimos(historicoEmprestimos);
                }
                break;
            case 4:
                if (relatorio.getMultasCadastradas().isEmpty()) {
                    System.out.println("Não há nenhuma multa cadastrada!");
                } else {
                    System.out.println("--MULTA(s) CADASTRADA(s)--");
                    Multa.exibirMultas(multasAplicadas);
                }
                break;
            case 5:
                if (relatorio.getMultasCadastradas().isEmpty()) {
                    System.out.println("Não há nenhuma multa cadastrada!");
                } else {
                    System.out.println("Valor total em multas: R$" + relatorio.getValorTotalMultas());
                }
                break;
            case 6:
                if (relatorio.getClientesCadastrados().isEmpty()) {
                    System.out.println("Não nenhum cliente cadastrado!");
                } else {
                    System.out.println("--CLIENTE(s) CADASTRADO(s)--");
                    Cliente.exibirClientes(clientes);
                }
                break;
            case 7:
                if (relatorio.getFuncionariosCadastrados().isEmpty()) {
                    System.out.println("Não há nenhum funcionário cadastrado!");
                } else {
                    System.out.println("--FUNCIONÁRIO(s) CADASTRADO(s)--");
                    Funcionario.exibirFuncionarios(funcionarios);
                }
                break;
            case 8:
                if (relatorio.getReservasAtivas().isEmpty()) {
                    System.out.println("Não há nenhuma reserva cadastrada!");
                } else {
                    System.out.println("--RESERVA(s) CADASTRADA(s)--");
                    Reserva.exibirReservas(reservas);
                }
            case 9:
                System.out.println(relatorio);
                break;
            default:
                System.out.println("Opção inválida!");
        }

    }

}
