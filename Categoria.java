package sistema_biblioteca;

import java.util.List;

public class Categoria {

    private String nome;
    private String descricao;
    private int codigo;
    private int qtdLivros;
    private List<Livro> livrosAssociados;
    private int popularidade;
    private String dataCriacao;

    public Categoria(String nome, String descricao, int codigo, int qtdLivros,
                     List<Livro> livrosAssociados, int popularidade, String dataCriacao) {

        this.nome = nome;
        this.descricao = descricao;
        this.codigo = codigo;
        this.qtdLivros = qtdLivros;
        this.livrosAssociados = livrosAssociados;
        this.popularidade = popularidade;
        this.dataCriacao = dataCriacao;

    }
}
