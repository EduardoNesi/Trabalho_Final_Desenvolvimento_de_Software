import java.io.*;
import java.util.*;

// Classe principal que representa a loja de jogos
class LojaJogos {
    private List<ItemJogo> itens; // Lista para armazenar os itens da loja

    public LojaJogos() {
        this.itens = new ArrayList<>(); // Construtor da classe que inicializa a lista de itens
    }

    public boolean verificarItemExistente(String nome) {
        for (ItemJogo item : itens) {
            if (item.getNome().equals(nome)) {
                return true; // Item encontrado
            }
        }
        return false; // Item não encontrado
    }

    // Método para adicionar um item à loja
    public void adicionarItem(ItemJogo item) {
        itens.add(item); // Adiciona o item à lista
    }

    // Método para listar todos os itens da loja
    public void listarItens() {
        for (ItemJogo item : itens) { // Percorre a lista de itens
            System.out.println(item); // Imprime o item
        }
    }

    // Método para listar apenas os jogos para menores de 18 anos
    public void listarItensMenores18Anos() {
        for (ItemJogo item : itens) { // Percorre a lista de itens
            if (item instanceof Jogo) { // Verifica se o item é do tipo Jogo
                Jogo jogo = (Jogo) item; // Faz um cast do item para a classe Jogo
                if (jogo.getClassificacaoIndicativa() < 18) { // Verifica a classificação indicativa do jogo
                    System.out.println(item); // Imprime o item
                }
            }
        }
    }

    // Método para atualizar os dados de um item da loja
    public void atualizarItem(String nome, String novoNome, Categoria novaCategoria, int novaClassificacaoIndicativa,
            int novaUnidades, String novaRegiao) {
        for (ItemJogo item : itens) { // Percorre a lista de itens
            if (item.getNome().equals(nome) && item instanceof Jogo) { // Verifica se o nome do item corresponde e se é
                                                                       // do tipo Jogo
                Jogo jogo = (Jogo) item; // Faz um cast do item para a classe Jogo
                jogo.setNome(novoNome); // Atualiza os dados do jogo
                jogo.setCategoria(novaCategoria);
                jogo.setClassificacaoIndicativa(novaClassificacaoIndicativa);
                jogo.setUnidades(novaUnidades);
                jogo.setRegiao(novaRegiao);
                jogo.setUnidades(novaUnidades);
                jogo.setRegiao(novaRegiao);
                break;
            }
        }

    }

    public boolean removerItem(String nome) {
        boolean encontrado = false; // Variável para verificar se o item foi encontrado
        Iterator<ItemJogo> iterator = itens.iterator(); // Obtém um iterador para percorrer a lista
        while (iterator.hasNext()) { // Enquanto houver itens na lista
            ItemJogo item = iterator.next(); // Obtém o próximo item
            if (item.getNome().equals(nome)) { // Verifica se o nome do item corresponde
                iterator.remove(); // Remove o item da lista
                encontrado = true; // O item foi encontrado
                break;
            }
        }
        if (encontrado) {
            return true; // Retorna true se o item foi encontrado e removido
        } else {
            System.out.println("O jogo informado não existe na loja GameStop.");
            // Abre o scanner novamente para que o usuário possa fazer uma nova operação
            return false; // Retorna false se o item não foi encontrado
        }
    }

    // Método para salvar os dados da loja em um arquivo de texto
    public void salvarDados(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) { // Cria um PrintWriter para escrever
                                                                                  // no arquivo
            for (ItemJogo item : itens) { // Percorre a lista de itens
                writer.println(item.getNome() + "," + item.getCategoria() + ","
                        + (item instanceof Jogo ? ((Jogo) item).getClassificacaoIndicativa() : "") + ","
                        + (item instanceof Jogo ? ((Jogo) item).getUnidades() : "") + ","
                        + (item instanceof Jogo ? ((Jogo) item).getRegiao() : "")); // Escreve os dados
                                                                                    // do item no
                                                                                    // arquivo
            }
            System.out.println("Jogos salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os jogos: " + e.getMessage());
        }
    }

    // Método para carregar os dados da loja a partir de um arquivo de texto
    public void carregarDados(String nomeArquivo) {
        try (Scanner scanner = new Scanner(new File(nomeArquivo))) { // Cria um Scanner para ler o arquivo
            while (scanner.hasNextLine()) { // Enquanto houver linhas no arquivo
                String linha = scanner.nextLine(); // Lê a próxima linha
                String[] partes = linha.split(","); // Divide a linha nos valores separados por vírgula
                if (partes.length >= 2) { // Verifica se existem pelo menos 2 partes (nome e categoria)
                    String nome = partes[0]; // Obtém o nome do jogo
                    Categoria categoria = Categoria.valueOf(partes[1]); // Obtém a categoria do jogo

                    // Obtém a classificação indicativa, se existir, senão assume o valor 0
                    int classificacaoIndicativa = partes.length >= 3 ? Integer.parseInt(partes[2]) : 0;

                    // Obtém a quantidade de unidades, se existir, senão assume o valor 0
                    int unidade = partes.length >= 4 ? Integer.parseInt(partes[3]) : 0;

                    // Obtém a região, se existir, senão assume uma string vazia
                    String regiao = partes.length >= 5 ? partes[4] : "";

                    Jogo jogo = new Jogo(nome, categoria, classificacaoIndicativa, unidade, regiao);
                    // Cria um novo objeto Jogo com os dados lidos

                    adicionarItem(jogo); // Adiciona o jogo à lista de itens da loja
                }
            }
            System.out.println("Jogos carregados com sucesso.");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        }
    }

    public boolean verificarJogoExistente(String nomeRemover) {
        return false;
    }

    public void venderJogo(String nomeJogo, int quantidade_vendida) {
        for (ItemJogo item : itens) { // Percorre a lista de itens
            if (item.getNome().equals(nomeJogo) && item instanceof Jogo) { // Verifica se o nome do item corresponde e
                                                                           // se é
                // do tipo Jogo
                Jogo jogo = (Jogo) item; // Faz um cast do item para a classe Jogo
                jogo.setUnidades(jogo.getUnidades() - quantidade_vendida);
                break;
            }
        }
    }
}