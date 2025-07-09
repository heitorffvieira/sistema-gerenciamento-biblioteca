package sistema_biblioteca;

import java.util.List;

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

}
