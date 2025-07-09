package sistema_biblioteca;

import java.util.List;

public class Multa {

    private HistoricoEmprestimos emprestimo;
    private String motivo;
    private String dataAplicacao;
    private Funcionario funcionarioAplicando;
    private int diasAtraso;
    private String formaPagamento;
    private double valor;

    public Multa(HistoricoEmprestimos emprestimo, String motivo, String dataAplicacao,
                 Funcionario funcionarioAplicando, int diasAtraso, String formaPagamento) {

        this.emprestimo = emprestimo;
        this.motivo = motivo;
        this.dataAplicacao = dataAplicacao;
        this.funcionarioAplicando = funcionarioAplicando;
        this.diasAtraso = diasAtraso;
        this.formaPagamento = formaPagamento;
        this.valor = calcularValorMulta();
    }

    public double calcularValorMulta() {
        return 10.0 + (diasAtraso * 2);
    }

    public double getValor() {
        return valor;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public static double calcularValorTotalMultas(List<Multa> multas) {
        double total = 0.0;
        for (Multa multa : multas) {
            total += multa.getValor();
        }
        return total;
    }

    public static void exibirMultas(List<Multa> multas) {
        for (int i = 0; i < multas.size(); i++) {
            System.out.println("ID: " + (i+1) + multas.get(i));
        }
    }

    @Override
    public String toString() {
        return " | Empréstimo: {" + this.emprestimo + "} | Motivo: {" + this.motivo + "} | Data da aplicação: " + this.dataAplicacao +
                " | Funcionário aplicando: " + this.funcionarioAplicando + " | Dias de atraso: " + this.diasAtraso +
                " | Forma de pagamento: " + this.formaPagamento + " | Valor da multa: R$ " + this.valor;
    }
}
