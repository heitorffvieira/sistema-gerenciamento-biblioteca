# 📚 Sistema de Gerenciamento de Biblioteca

Este é um sistema simples de gerenciamento de biblioteca desenvolvido em Java. O objetivo é simular o funcionamento de uma biblioteca, permitindo o controle de livros, clientes, funcionários, empréstimos, reservas, multas e geração de relatórios.

## 🚀 Funcionalidades

- 📘 **Cadastro de Livros**: Título, autor, categoria e disponibilidade.
- 👤 **Cadastro de Clientes e Funcionários**: Informações básicas para controle e registro.
- 🔄 **Empréstimos e Devoluções**: Controle completo de empréstimos com datas e status.
- ⏳ **Reservas de Livros**: Registro de reservas de títulos indisponíveis.
- 💸 **Multas e Pagamentos**: Cálculo de multas por atraso e registro de pagamentos.
- 📈 **Geração de Relatórios**: Histórico de empréstimos e outras informações administrativas.

## 🛠️ Tecnologias Utilizadas

- **Linguagem**: Java
- **IDE recomendada**: IntelliJ IDEA
- **Paradigma**: Programação Orientada a Objetos (POO)

## 📦 Estrutura do Projeto

- `Main.java`: Ponto de entrada da aplicação.
- `Livro.java`, `Cliente.java`, `Funcionario.java`: Classes principais do sistema.
- `Emprestimo.java`, `Reserva.java`, `Multa.java`, `Pagamento.java`: Operações e regras de negócio.
- `Relatorio.java`, `HistoricoEmprestimos.java`: Geração de relatórios e históricos.

## 🧪 Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/sistema-biblioteca.git
   cd sistema-biblioteca
2. Abra o projeto no IntelliJ IDEA (ou outra IDE Java).
3. Compile e execute a classe Main.java.

Este projeto não utiliza banco de dados — todos os dados são manipulados em memória.
