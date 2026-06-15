package model;

/**
 * Representa um mito ou fato sobre gênero/sexualidade.
 * Herda de Conteudo e sobrescreve exibir() — polimorfismo.
 */
public class Mito extends Conteudo {

    private String afirmacao;
    private boolean ehMito;
    private String explicacao;

    public Mito(String afirmacao, String categoria, boolean ehMito, String explicacao) {
        super(afirmacao, categoria);
        if (explicacao == null || explicacao.isBlank()) {
            throw new IllegalArgumentException("Explicação não pode ser vazia.");
        }
        this.afirmacao = afirmacao;
        this.ehMito = ehMito;
        this.explicacao = explicacao;
    }

    public String getAfirmacao() {
        return afirmacao;
    }

    public void setAfirmacao(String afirmacao) {
        if (afirmacao == null || afirmacao.isBlank()) {
            throw new IllegalArgumentException("Afirmação não pode ser vazia.");
        }
        this.afirmacao = afirmacao;
        setTitulo(afirmacao);
    }

    public boolean isEhMito() {
        return ehMito;
    }

    public void setEhMito(boolean ehMito) {
        this.ehMito = ehMito;
    }

    public String getExplicacao() {
        return explicacao;
    }

    public void setExplicacao(String explicacao) {
        if (explicacao == null || explicacao.isBlank()) {
            throw new IllegalArgumentException("Explicação não pode ser vazia.");
        }
        this.explicacao = explicacao;
    }

    @Override
    public String exibir() {
        String rotulo = ehMito ? "❌ MITO" : "✅ FATO";
        return rotulo + "\n\n\"" + afirmacao + "\"\n\n" + explicacao;
    }
}
