package model;

/**
 * Representa uma pergunta de múltipla escolha do quiz.
 * Herda de Conteudo e sobrescreve exibir() — polimorfismo.
 */
public class PerguntaQuiz extends Conteudo {

    private String enunciado;
    private String[] alternativas;
    private int indiceCorreto;

    public PerguntaQuiz(String enunciado, String categoria, String[] alternativas, int indiceCorreto) {
        super(enunciado, categoria);
        if (alternativas == null || alternativas.length < 2) {
            throw new IllegalArgumentException("A pergunta deve ter pelo menos 2 alternativas.");
        }
        if (indiceCorreto < 0 || indiceCorreto >= alternativas.length) {
            throw new IllegalArgumentException("Índice da resposta correta inválido.");
        }
        this.enunciado = enunciado;
        this.alternativas = alternativas;
        this.indiceCorreto = indiceCorreto;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        if (enunciado == null || enunciado.isBlank()) {
            throw new IllegalArgumentException("Enunciado não pode ser vazio.");
        }
        this.enunciado = enunciado;
        setTitulo(enunciado);
    }

    public String[] getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(String[] alternativas) {
        if (alternativas == null || alternativas.length < 2) {
            throw new IllegalArgumentException("A pergunta deve ter pelo menos 2 alternativas.");
        }
        this.alternativas = alternativas;
    }

    public int getIndiceCorreto() {
        return indiceCorreto;
    }

    public void setIndiceCorreto(int indiceCorreto) {
        if (indiceCorreto < 0 || indiceCorreto >= alternativas.length) {
            throw new IllegalArgumentException("Índice da resposta correta inválido.");
        }
        this.indiceCorreto = indiceCorreto;
    }

    public boolean verificarResposta(int indiceSelecionado) {
        return indiceSelecionado == indiceCorreto;
    }

    public String getRespostaCorreta() {
        return alternativas[indiceCorreto];
    }

    @Override
    public String exibir() {
        StringBuilder sb = new StringBuilder();
        sb.append("❓ ").append(enunciado).append("\n\n");
        for (int i = 0; i < alternativas.length; i++) {
            sb.append((char) ('A' + i)).append(") ").append(alternativas[i]).append("\n");
        }
        return sb.toString();
    }
}
