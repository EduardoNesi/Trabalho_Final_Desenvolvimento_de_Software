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
            System.out.println("\n             #####                            #####                         " +
                    "\n            #     #    ##    #    #  ######  #     #  #####   ####   #####  " +
                    "\n            #         #  #   ##  ##  #       #          #    #    #  #    # " +
                    "\n            #  ####  #    #  # ## #  #####    #####     #    #    #  #    # " +
                    "\n            #     #  ######  #    #  #             #    #    #    #  #####  " +
                    "\n            #     #  #    #  #    #  #       #     #    #    #    #  #      " +
                    "\n             #####   #    #  #    #  ######   #####     #     ####   #      " +
                    "\n                                                                            ");

            System.out.println("1. Adicionar novo jogo");
            System.out.println("2. Listar todos os jogos");
            System.out.println("3. Listar jogos para menores de 18 anos");
            System.out.println("4. Atualizar dados de um jogo");
            System.out.println("5. Remover um jogo");
            System.out.println("6. Vender jogo");
            System.out.println("7. Procure o jogo pelo nome dele");
            System.out.println("8. Salvar dados em arquivo");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt(); // Lê a opção escolhida pelo usuário

            switch (opcao) {
                case 1:
                    scanner.nextLine(); // Consumir a quebra de linha
                    System.out.print("Digite o nome do jogo: ");
                    String nome = scanner.nextLine(); // Lê o nome do jogo digitado pelo usuário
                    if (loja.verificarItemExistente(nome)) { // verifica se o item procurado pelo nome dele existe na
                                                             // loja
                        System.out.println("Jogo já existe na loja. Por favor, tente novamente.");
                        break;// para e retorna para o começo do case
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

                    System.out.print("Digite a unidade do jogo: ");
                    int unidade = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha pendente
                    System.out.print("Digite a região do jogo: ");
                    String regiao = scanner.nextLine();

                    Jogo novoJogo = new Jogo(nome, categoria, classificacaoIndicativa, unidade, regiao); // Cria um
                    // novo jogo
                    // com os
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
                    if (!loja.verificarItemExistente(nomeAtualizar)) { // verifica se o jogo existe na loja
                        System.out.println("Jogo não encontrado na loja. Por favor, tente novamente.");
                        break; // para e retorna para o começo
                    }
                    System.out.print("Digite o novo nome do jogo: ");
                    String novoNome = scanner.nextLine(); // Lê o novo nome do jogo
                    if (!novoNome.equals(nomeAtualizar) && loja.verificarItemExistente(novoNome)) { // verifica se esse
                                                                                                    // novo nome é igual
                                                                                                    // a um jogo
                                                                                                    // existente
                        System.out
                                .println("O novo nome do jogo já existe na loja. Por favor, insira um nome diferente.");
                        break; // para e retorna para o começo
                    }
                    System.out.print("Digite o novo nome do jogo: ");
                    if (novoNome.equals(nomeAtualizar)) { // verifica se o novo nome do jogo é igual ao jogo que você
                                                          // está tentando atualizar
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

                    System.out.print("Digite a nova unidade do jogo: ");
                    int novaUnidades = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha pendente
                    System.out.print("Digite a nova região do jogo: ");
                    String novaRegiao = scanner.nextLine();

                    loja.atualizarItem(nomeAtualizar, novoNome, novaCategoria, novaClassificacaoIndicativa,
                            novaUnidades, novaRegiao); // Atualiza
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
                    scanner.nextLine(); // Consumir a quebra de linha
                    System.out.print("Digite o nome do jogo que deseja vender: ");
                    String nomeJogo = scanner.nextLine(); // Lê o nome do jogo a ser atualizado

                    System.out.print("Digite a quantidade de vendas do jogo: ");
                    int quantidade_vendida = scanner.nextInt(); // Lê a quantidade de jogos a ser vendido

                    if (!loja.verificarItemExistente(nomeJogo)) { // verifica se o jogo existe na loja
                        System.out.println("Jogo não encontrado na loja. Por favor, tente novamente.");
                    }
                    loja.venderJogo(nomeJogo, quantidade_vendida); // chama o método para vender o jogo
                    break;
                case 7:
                    scanner.nextLine(); // Consumir a quebra de linha
                    System.out.print("Digite o nome do jogo que procurar: ");
                    String nomedoJogo = scanner.nextLine();
                    loja.procurarJogo(nomedoJogo);

                    break;

                case 8:
                    loja.salvarDados("dados.txt"); // Salva os dados da loja no arquivo "dados.txt"
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (opcao != 9);

        scanner.close(); // Fecha o Scanner
    }
}
