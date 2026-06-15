package view;

import controller.SistemaController;
import model.PerguntaQuiz;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

/**
 * Tela do Quiz educativo.
 */
public class TelaQuiz extends JFrame {

    private SistemaController controller;
    private List<PerguntaQuiz> perguntas;
    private int indiceAtual = 0;
    private int pontuacao = 0;

    private JLabel lblPergunta;
    private JLabel lblContador;
    private ButtonGroup grupoBotoes;
    private JRadioButton[] alternativas;
    private JButton btnResponder;
    private JPanel painelAlternativas;

    public TelaQuiz(SistemaController controller) {
        this.controller = controller;
        this.perguntas = controller.getPerguntas();
        configurarJanela();
        construirInterface();
        exibirPergunta();
    }

    private void configurarJanela() {
        setTitle("🎯 Quiz Educativo");
        setSize(680, 480);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void construirInterface() {
        JPanel painel = new JPanel(new BorderLayout(10, 15));
        painel.setBorder(new EmptyBorder(20, 25, 20, 25));
        painel.setBackground(new Color(245, 245, 250));

        // Header
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(27, 94, 32));
        header.setBorder(new EmptyBorder(12, 15, 12, 15));

        JLabel titulo = new JLabel("🎯 Quiz — InfoGênero");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titulo.setForeground(Color.WHITE);

        lblContador = new JLabel("", SwingConstants.RIGHT);
        lblContador.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblContador.setForeground(new Color(200, 255, 200));

        header.add(titulo, BorderLayout.WEST);
        header.add(lblContador, BorderLayout.EAST);

        // Pergunta
        lblPergunta = new JLabel("", SwingConstants.LEFT);
        lblPergunta.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblPergunta.setBorder(new EmptyBorder(10, 0, 10, 0));
        lblPergunta.setVerticalAlignment(SwingConstants.TOP);

        // Alternativas
        painelAlternativas = new JPanel(new GridLayout(4, 1, 5, 8));
        painelAlternativas.setBackground(new Color(245, 245, 250));
        grupoBotoes = new ButtonGroup();
        alternativas = new JRadioButton[4];

        for (int i = 0; i < 4; i++) {
            alternativas[i] = new JRadioButton();
            alternativas[i].setFont(new Font("Segoe UI", Font.PLAIN, 14));
            alternativas[i].setBackground(new Color(245, 245, 250));
            alternativas[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            grupoBotoes.add(alternativas[i]);
            painelAlternativas.add(alternativas[i]);
        }

        JPanel centro = new JPanel(new BorderLayout(0, 10));
        centro.setBackground(new Color(245, 245, 250));
        centro.add(lblPergunta, BorderLayout.NORTH);
        centro.add(painelAlternativas, BorderLayout.CENTER);

        // Botão responder
        btnResponder = new JButton("Responder");
        btnResponder.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnResponder.setBackground(new Color(27, 94, 32));
        btnResponder.setForeground(Color.WHITE);
        btnResponder.setFocusPainted(false);
        btnResponder.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnResponder.addActionListener(e -> responder());

        JPanel rodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
        rodape.setBackground(new Color(245, 245, 250));
        rodape.add(btnResponder);

        painel.add(header, BorderLayout.NORTH);
        painel.add(centro, BorderLayout.CENTER);
        painel.add(rodape, BorderLayout.SOUTH);

        add(painel);
    }

    private void exibirPergunta() {
        if (perguntas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhuma pergunta disponível.", "Aviso", JOptionPane.WARNING_MESSAGE);
            dispose();
            return;
        }

        PerguntaQuiz p = perguntas.get(indiceAtual);
        lblPergunta.setText("<html><body style='width:580px'>" + (indiceAtual + 1) + ". " + p.getEnunciado() + "</body></html>");
        lblContador.setText("Pergunta " + (indiceAtual + 1) + " de " + perguntas.size() + "  |  Pontos: " + pontuacao);

        String[] alts = p.getAlternativas();
        grupoBotoes.clearSelection();

        for (int i = 0; i < alternativas.length; i++) {
            if (i < alts.length) {
                alternativas[i].setText((char) ('A' + i) + ")  " + alts[i]);
                alternativas[i].setVisible(true);
                alternativas[i].setForeground(Color.BLACK);
            } else {
                alternativas[i].setVisible(false);
            }
        }

        btnResponder.setEnabled(true);
    }

    private void responder() {
        int selecionado = -1;
        for (int i = 0; i < alternativas.length; i++) {
            if (alternativas[i].isSelected()) {
                selecionado = i;
                break;
            }
        }

        if (selecionado == -1) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, selecione uma alternativa antes de responder.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            PerguntaQuiz p = perguntas.get(indiceAtual);
            boolean acertou = p.verificarResposta(selecionado);

            if (acertou) {
                pontuacao++;
                alternativas[selecionado].setForeground(new Color(27, 94, 32));
                JOptionPane.showMessageDialog(this,
                        "✅ Correto! Muito bem!",
                        "Resposta", JOptionPane.INFORMATION_MESSAGE);
            } else {
                alternativas[selecionado].setForeground(new Color(183, 28, 28));
                JOptionPane.showMessageDialog(this,
                        "❌ Errado!\nA resposta correta era:\n" + p.getRespostaCorreta(),
                        "Resposta", JOptionPane.ERROR_MESSAGE);
            }

            btnResponder.setEnabled(false);
            indiceAtual++;

            if (indiceAtual < perguntas.size()) {
                exibirPergunta();
            } else {
                exibirResultadoFinal();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao processar resposta: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void exibirResultadoFinal() {
        int total = perguntas.size();
        String mensagem;

        if (pontuacao == total) {
            mensagem = "🏆 Parabéns! Você acertou tudo!";
        } else if (pontuacao >= total / 2) {
            mensagem = "👍 Bom trabalho! Continue aprendendo!";
        } else {
            mensagem = "📚 Que tal revisar os termos e mitos antes de tentar novamente?";
        }

        JOptionPane.showMessageDialog(this,
                mensagem + "\n\nSua pontuação: " + pontuacao + " de " + total,
                "Resultado Final", JOptionPane.INFORMATION_MESSAGE);

        dispose();
    }
}
