// Enumeração para representar as categorias dos jogos
enum Categoria {
    ACAO("Ação"), // Valor da enumeração "ACAO" com descrição "Ação"
    AVENTURA("Aventura"), // Valor da enumeração "AVENTURA" com descrição "Aventura"
    ESTRATEGIA("Estratégia"), // Valor da enumeração "ESTRATEGIA" com descrição "Estratégia"
    RPG("RPG"), // Valor da enumeração "RPG" com descrição "RPG"
    SIMULACAO("Simulação"); // Valor da enumeração "SIMULACAO" com descrição "Simulação"

    private String descricao; // Atributo para armazenar a descrição da categoria

    Categoria(String descricao) {
        this.descricao = descricao; // Construtor da enumeração que atribui a descrição recebida ao atributo
    }

    public String getDescricao() {
        return descricao; // Método para obter a descrição da categoria
    }
}