package sistema_biblioteca;

import java.util.List;
import java.util.Scanner;

public class Pagamento {

    private Multa multaSelecionada;
    private double valor;
    private String formaPagamento;
    private String statusPagamento;
    private String dataPagamento;
    private String motivoMulta;
    private double valorTotal;

    public Pagamento(Multa multaSelecionada, String statusPagamento, String dataPagamento) {
        this.multaSelecionada = multaSelecionada;
        this.valor = multaSelecionada.getValor(); 
        this.formaPagamento = multaSelecionada.getFormaPagamento();
        this.statusPagamento = statusPagamento;
        this.dataPagamento = dataPagamento;
        this.motivoMulta = multaSelecionada.getMotivo();
        this.valorTotal = multaSelecionada.getValor();
    }

    @Override
    public String toString() {
        return " | Multa: {" + multaSelecionada + "} | Valor: R$" + valor +
                " | Forma de pagamento: " + formaPagamento +
                " | Status de pagamento: " + statusPagamento +
                " | Data de pagamento: " + dataPagamento +
                " | Motivo da multa: " + motivoMulta +
                " | Valor total: R$" + valorTotal;
    }

    public static void realizarPagamento(List<Multa> multasAplicadas) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--REALIZAR PAGAMENTO--");

        if (multasAplicadas.isEmpty()) {
            System.out.println("Não há nenhuma multa cadastrada.");
        } else {
            Multa.exibirMultas(multasAplicadas);
            System.out.printf("ID da multa para pagamento: ");
            int idMulta = scanner.nextInt();
            scanner.nextLine();
            Multa multaPagamento = multasAplicadas.get(idMulta - 1);

            System.out.println("Valor: R$" + multaPagamento.getValor());
            double valorMulta = multaPagamento.getValor();

            System.out.printf("Forma de pagamento: " + multaPagamento.getFormaPagamento());
            String formaPagamento = multaPagamento.getFormaPagamento();

            System.out.printf("Status do pagamento: ");
            String statusPagamento = scanner.nextLine();

            System.out.printf("Data do pagamento (dd/mm/aa): ");
            String dataPagamento = scanner.nextLine();

            System.out.println("Motivo da multa: " + multaPagamento.getMotivo());
            System.out.println("Valor total: R$" + multaPagamento.getValor());
            String motivoMulta = multaPagamento.getMotivo();

            Pagamento pagamento = new Pagamento(multaPagamento, statusPagamento, dataPagamento);

            System.out.println("--PAGAMENTO FEITO!--");
            System.out.println(pagamento);
        }

    }

}
