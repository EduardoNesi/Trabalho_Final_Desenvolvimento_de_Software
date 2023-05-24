// Classe Jogo que implementa a interface ItemJogo
class Jogo implements ItemJogo {
    private String nome; // Atributo para armazenar o nome do jogo
    private Categoria categoria; // Atributo para armazenar a categoria do jogo
    private int classificacaoIndicativa; // Atributo para armazenar a classificação indicativa do jogo

    public Jogo(String nome, Categoria categoria, int classificacaoIndicativa) {
        this.nome = nome; // Construtor da classe que inicializa os atributos
        this.categoria = categoria;
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public String getNome() {
        return nome; // Método para obter o nome do jogo
    }

    public Categoria getCategoria() {
        return categoria; // Método para obter a categoria do jogo
    }

    public int getClassificacaoIndicativa() {
        return classificacaoIndicativa; // Método para obter a classificação indicativa do jogo
    }

    public void setNome(String nome) {
        this.nome = nome; // Método para alterar o nome do jogo
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria; // Método para alterar a categoria do jogo
    }

    public void setClassificacaoIndicativa(int classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa; // Método para alterar a classificação indicativa do
                                                                // jogo
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Categoria: " + categoria.getDescricao() + ", Classificação Indicativa: "
                + classificacaoIndicativa;
    }
}