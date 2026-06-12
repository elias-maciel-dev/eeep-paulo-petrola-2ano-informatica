package model;

/**
 * Representa uma definição de termo relacionado a gênero/sexualidade.
 * Herda de Conteudo e sobrescreve exibir() — polimorfismo.
 */
public class Definicao extends Conteudo {

    private String termo;
    private String descricao;

    public Definicao(String termo, String categoria, String descricao) {
        super(termo, categoria);
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("Descrição não pode ser vazia.");
        }
        this.termo = termo;
        this.descricao = descricao;
    }

    public String getTermo() {
        return termo;
    }

    public void setTermo(String termo) {
        if (termo == null || termo.isBlank()) {
            throw new IllegalArgumentException("Termo não pode ser vazio.");
        }
        this.termo = termo;
        setTitulo(termo);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("Descrição não pode ser vazia.");
        }
        this.descricao = descricao;
    }

    @Override
    public String exibir() {
        return "📖 " + termo + "\n\n" + descricao;
    }
}
