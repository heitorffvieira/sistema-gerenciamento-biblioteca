package sistema_biblioteca;

import java.util.List;
import java.util.Scanner;

public class Livro {

    private String titulo;
    private String autor;
    private int ISBN;
    private int anoPublicacao;
    private int qtdEstoque;
    private String categoria;
    private String status;

    public Livro(String titulo, String autor, int ISBN, int anoPublicacao,
                 int qtdEstoque, String categoria, String status) {

        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.anoPublicacao = anoPublicacao;
        this.qtdEstoque = qtdEstoque;
        this.categoria = categoria;
        this.status = status;

    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public static void exibirLivros(List<Livro> livros) {
        for (int i = 0; i < livros.size(); i++) {
            System.out.println("ID: " + (i+1) + livros.get(i));
        }
    }

    @Override
    public String toString() {
        return " | Título: " + this.titulo + " | Autor: " + this.autor + " | ISBN: " + this.ISBN+
                " | Ano de Publicação: " + this.anoPublicacao + " | Quantidade no estoque: " + this.qtdEstoque+
                " | Categoria: " + this.categoria + " | Status: " + this.status;
    }

    public static void cadastrarLivro(List<Livro> livrosCadastrados) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Título do livro: ");
        String tituloLivro = scanner.nextLine();

        System.out.printf("Nome do autor: ");
        String autorLivro = scanner.nextLine();

        System.out.printf("ISBN: ");
        int isbnLivro = scanner.nextInt();

        System.out.printf("Ano de publicação: ");
        int anoPublicacao = scanner.nextInt();

        System.out.printf("Quantidade no estoque: ");
        int qtdEstoque = scanner.nextInt();
        scanner.nextLine();

        System.out.printf("Categoria: ");
        String categoriaLivro = scanner.nextLine();

        System.out.printf("Status: ");
        String statusLivro = scanner.nextLine();

        Livro livroCadastrado = new Livro(tituloLivro, autorLivro, isbnLivro, anoPublicacao,
                qtdEstoque, categoriaLivro, statusLivro);

        livrosCadastrados.add(livroCadastrado);

        System.out.println("---LIVRO CADASTRADO---");
        System.out.println(livrosCadastrados);
    }

    public static void devolucaoLivro(List<Emprestimo> emprestimosAtivos, List<HistoricoEmprestimos> historicoEmprestimos,
                                      List<Livro> livrosCadastrados){

        Scanner scanner = new Scanner(System.in);

        System.out.println("--DEVOLUÇÃO DE LIVRO--");

        if (emprestimosAtivos.size() == 0) {
            System.out.println("Não nenhum livro emprestado!");
        } else {
            Emprestimo.exibirLivrosEmprestados(emprestimosAtivos);
            System.out.printf("Digite o ID do livro que deseja devolver: ");
            int idEmprestado = scanner.nextInt();
            scanner.nextLine();

            historicoEmprestimos.remove(idEmprestado - 1);
            Livro livroDevolucao = livrosCadastrados.get(idEmprestado - 1);
            int estoque = livroDevolucao.getQtdEstoque();
            livroDevolucao.setQtdEstoque(estoque + 1);

            System.out.println("--DEVOLUÇÃO CONCEDIDA!--");

        }
    }

}
