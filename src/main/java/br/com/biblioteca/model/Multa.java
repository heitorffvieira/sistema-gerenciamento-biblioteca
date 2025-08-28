package sistema_biblioteca;

import java.util.List;
import java.util.Scanner;

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

    public static void aplcarMulta(List<Cliente> clientes, List<Livro> livrosCadastrados, List<Funcionario> funcionarios,
                                   List<HistoricoEmprestimos> historicoEmprestimos, List<Multa> multasAplicadas) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("--APLICAR MULTA--");

        if (clientes.isEmpty()) {
            System.out.println("Ainda não há nenhum cliente cadastrado. Cadastre um para aplicar a multa!");
        } else if (livrosCadastrados.isEmpty()) {
            System.out.println("Ainda não há nenhum livro cadastrado. Cadastre um para aplicar a multa!");
        } else if (funcionarios.isEmpty()) {
            System.out.println("Ainda não há nenhum funcionário cadastrado. Cadastre um para aplicar a multa!");
        } else if (historicoEmprestimos.isEmpty()) {
            System.out.println("Ainda não há nenhum empréstimo cadastrado. Cadastre um para aplicar a multa!");
        }

        else {
            HistoricoEmprestimos.exibirHistoricoEmprestimos(historicoEmprestimos);
            System.out.printf("ID do Empréstimo: ");
            int idEmprestimo = scanner.nextInt();
            scanner.nextLine();
            HistoricoEmprestimos multaEmprestimo = historicoEmprestimos.get(idEmprestimo - 1);

            System.out.printf("Motivo da multa: ");
            String motivoMulta = scanner.nextLine();

            System.out.printf("Data de aplicação da multa (dd/mm/aa): ");
            String dataAplicacao = scanner.nextLine();

            Funcionario.exibirFuncionarios(funcionarios);
            System.out.printf("ID do Funcionário que está aplicando a multa: ");
            int idFuncionario = scanner.nextInt();
            Funcionario funcionarioAplicando = funcionarios.get(idFuncionario - 1);

            System.out.printf("Dias de atraso na devolução: ");
            int diasAtraso = scanner.nextInt();
            scanner.nextLine();

            System.out.printf("Forma de pagamento: ");
            String formaPagamento = scanner.nextLine();

            Multa multa = new Multa(multaEmprestimo, motivoMulta, dataAplicacao, funcionarioAplicando, diasAtraso, formaPagamento);
            multasAplicadas.add(multa);
            System.out.println("--MULTA APLICADA!--");
            System.out.println(multa);
        }

    }

}
