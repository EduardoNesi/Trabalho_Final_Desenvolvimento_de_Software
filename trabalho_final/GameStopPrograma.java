import java.util.*;

// Classe principal do programa
public class GameStopPrograma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner para ler a entrada do usuário
        LojaJogos loja = new LojaJogos(); // Cria um objeto da classe LojaJogos

        // Carregar dados do arquivo, se existir
        loja.carregarDados("dados.txt"); // Carrega os dados da loja a partir do arquivo "dados.txt"

        int opcao = 0;
        do {
            System.out.println("\n---- GameStop ----");
            System.out.println("1. Adicionar novo jogo");
            System.out.println("2. Listar todos os jogos");
            System.out.println("3. Listar jogos para menores de 18 anos");
            System.out.println("4. Atualizar dados de um jogo");
            System.out.println("5. Remover um jogo");
            System.out.println("6. Salvar dados em arquivo");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt(); // Lê a opção escolhida pelo usuário

            switch (opcao) {
                case 1:
                    scanner.nextLine(); // Consumir a quebra de linha
                    System.out.print("Digite o nome do jogo: ");
                    String nome = scanner.nextLine(); // Lê o nome do jogo digitado pelo usuário
                    if (loja.verificarItemExistente(nome)) {
                        System.out.println("Jogo já existe na loja. Por favor, tente novamente.");
                        break;
                    }
                    System.out.println("Categorias disponíveis: ");
                    for (Categoria categoria : Categoria.values()) { // Percorre as categorias disponíveis
                        System.out.println("- " + categoria.getDescricao()); // Imprime a descrição da categoria
                    }
                    System.out.print("Digite a categoria do jogo: ");
                    String categoriaString = scanner.nextLine(); // Lê a categoria do jogo digitada pelo usuário
                    Categoria categoria = Categoria.valueOf(categoriaString.toUpperCase()); // Converte a string para o
                                                                                            // valor da enumeração
                                                                                            // Categoria correspondente
                    System.out.print("Digite a classificação indicativa do jogo: ");
                    int classificacaoIndicativa = scanner.nextInt(); // Lê a classificação indicativa digitada pelo
                                                                     // usuário
                    Jogo novoJogo = new Jogo(nome, categoria, classificacaoIndicativa); // Cria um novo jogo com os
                                                                                        // dados lidos
                    loja.adicionarItem(novoJogo); // Adiciona o jogo à loja
                    System.out.println("Jogo adicionado com sucesso.");
                    break;

                case 2:
                    System.out.println("\n---- Lista de Jogos ----");
                    loja.listarItens(); // Lista todos os jogos da loja
                    break;

                case 3:
                    System.out.println("\n---- Lista de Jogos para Menores de 18 Anos ----");
                    loja.listarItensMenores18Anos(); // Lista apenas os jogos para menores de 18 anos
                    break;

                case 4:
                    scanner.nextLine(); // Consumir a quebra de linha
                    System.out.print("Digite o nome do jogo que deseja atualizar: ");
                    String nomeAtualizar = scanner.nextLine(); // Lê o nome do jogo a ser atualizado
                    if (!loja.verificarItemExistente(nomeAtualizar)) {
                        System.out.println("Jogo não encontrado na loja. Por favor, tente novamente.");
                        break;
                    }
                    System.out.print("Digite o novo nome do jogo: ");
                    String novoNome = scanner.nextLine(); // Lê o novo nome do jogo
                    if (!novoNome.equals(nomeAtualizar) && loja.verificarItemExistente(novoNome)) {
                        System.out
                                .println("O novo nome do jogo já existe na loja. Por favor, insira um nome diferente.");
                        break;
                    }
                    System.out.print("Digite o novo nome do jogo: ");
                    if (novoNome.equals(nomeAtualizar)) {
                        System.out.println(
                                "O novo nome do jogo é igual ao nome atual. Por favor, insira um nome diferente.");
                        break;
                    }

                    System.out.println("Categorias disponíveis: ");
                    for (Categoria categorias : Categoria.values()) { // Percorre as categorias disponíveis
                        System.out.println("- " + categorias.getDescricao()); // Imprime a descrição da categoria
                    }
                    System.out.print("Digite a nova categoria do jogo: ");
                    String novaCategoriaStr = scanner.nextLine(); // Lê a nova categoria do jogo
                    Categoria novaCategoria = Categoria.valueOf(novaCategoriaStr.toUpperCase()); // Converte a string
                    // para o valor da enumeração Categoria correspondente
                    System.out.print("Digite a nova classificação indicativa do jogo: ");
                    int novaClassificacaoIndicativa = scanner.nextInt(); // Lê a nova classificação indicativa do jogo
                    loja.atualizarItem(nomeAtualizar, novoNome, novaCategoria, novaClassificacaoIndicativa); // Atualiza
                    // os dados do jogo na loja
                    System.out.println("Jogo atualizado com sucesso.");
                    break;

                case 5:
                    scanner.nextLine(); // Consumir a quebra de linha
                    System.out.print("Digite o nome do jogo que deseja remover: ");
                    String nomeRemover = scanner.nextLine(); // Lê o nome do jogo a ser removido
                    boolean jogoRemovido = loja.removerItem(nomeRemover); // Remove o jogo da loja
                    if (jogoRemovido) {
                        System.out.println("Jogo removido com sucesso da loja GameStop.");
                    }
                    break;

                case 6:
                    loja.salvarDados("dados.txt"); // Salva os dados da loja no arquivo "dados.txt"
                    break;

                case 7:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (opcao != 7);

        scanner.close(); // Fecha o Scanner
    }
}
