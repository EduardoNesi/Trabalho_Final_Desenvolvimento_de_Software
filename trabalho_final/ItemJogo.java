// Interface para representar um item de jogo
interface ItemJogo {
    String getNome(); // Método para obter o nome do item de jogo

    Categoria getCategoria(); // Método para obter a categoria do item de jogo

    int getClassificacaoIndicativa(); // Método para obter a classificação indicativa do jogo

    int getUnidades(); // Método para obter as unidades do jogo

    String getRegiao(); // Método para obter a região a jogo

}