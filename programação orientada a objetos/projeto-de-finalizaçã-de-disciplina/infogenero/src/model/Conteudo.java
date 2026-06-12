package model;

/**
 * Classe abstrata base para todos os conteúdos do sistema.
 * Aplica encapsulamento e define contrato via método abstrato exibir().
 */
public abstract class Conteudo {

    private String titulo;
    private String categoria;

    public Conteudo(String titulo, String categoria) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Título não pode ser vazio.");
        }
        if (categoria == null || categoria.isBlank()) {
            throw new IllegalArgumentException("Categoria não pode ser vazia.");
        }
        this.titulo = titulo;
        this.categoria = categoria;
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Título não pode ser vazio.");
        }
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (categoria == null || categoria.isBlank()) {
            throw new IllegalArgumentException("Categoria não pode ser vazia.");
        }
        this.categoria = categoria;
    }

    /**
     * Método polimórfico — cada subclasse exibe seu conteúdo de forma diferente.
     */
    public abstract String exibir();

    @Override
    public String toString() {
        return "[" + categoria + "] " + titulo;
    }
}
