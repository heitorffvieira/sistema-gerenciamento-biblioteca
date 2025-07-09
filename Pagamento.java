package sistema_biblioteca;

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
        this.valor = multaSelecionada.getValor(); // agora pode acessar!
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
}
