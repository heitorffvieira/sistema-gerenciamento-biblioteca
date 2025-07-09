package sistema_biblioteca;

import java.util.List;

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
}
