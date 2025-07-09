package sistema_biblioteca;

import java.util.List;

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

}

