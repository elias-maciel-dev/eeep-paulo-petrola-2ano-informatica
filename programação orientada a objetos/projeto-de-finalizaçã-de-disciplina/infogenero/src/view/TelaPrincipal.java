package view;

import controller.SistemaController;

import javax.swing.*;
import java.awt.*;

/**
 * Tela principal do sistema InfoGênero.
 * Ponto de entrada da interface gráfica.
 */
public class TelaPrincipal extends JFrame {

    private SistemaController controller;

    public TelaPrincipal() {
        controller = new SistemaController();
        configurarJanela();
        construirInterface();
    }

    private void configurarJanela() {
        setTitle("InfoGênero — Sistema Educativo");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void construirInterface() {
        // Painel principal com fundo
        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.setBackground(new Color(245, 245, 250));

        // Header
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(106, 27, 154));
        header.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel titulo = new JLabel("🏳️‍⚧️ InfoGênero");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titulo.setForeground(Color.WHITE);

        JLabel subtitulo = new JLabel("Sistema Educativo sobre Gênero e Sexualidade");
        subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subtitulo.setForeground(new Color(220, 200, 255));

        header.add(titulo, BorderLayout.NORTH);
        header.add(subtitulo, BorderLayout.SOUTH);

        // Painel de botões
        JPanel painelBotoes = new JPanel(new GridLayout(3, 1, 15, 15));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
        painelBotoes.setBackground(new Color(245, 245, 250));

        JButton btnTermos = criarBotao("📖  Termos e Definições", new Color(106, 27, 154));
        JButton btnMitos = criarBotao("❓  Mitos e Fatos", new Color(21, 101, 192));
        JButton btnQuiz = criarBotao("🎯  Quiz Educativo", new Color(27, 94, 32));

        btnTermos.addActionListener(e -> abrirTermos());
        btnMitos.addActionListener(e -> abrirMitos());
        btnQuiz.addActionListener(e -> abrirQuiz());

        painelBotoes.add(btnTermos);
        painelBotoes.add(btnMitos);
        painelBotoes.add(btnQuiz);

        // Rodapé
        JLabel rodape = new JLabel("Projeto de Finalização POO — Elias Miguel Da Silva Maciel", SwingConstants.CENTER);
        rodape.setFont(new Font("Segoe UI", Font.ITALIC, 11));
        rodape.setForeground(Color.GRAY);
        rodape.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        painelPrincipal.add(header, BorderLayout.NORTH);
        painelPrincipal.add(painelBotoes, BorderLayout.CENTER);
        painelPrincipal.add(rodape, BorderLayout.SOUTH);

        add(painelPrincipal);
    }

    private JButton criarBotao(String texto, Color cor) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn.setBackground(cor);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        btn.setOpaque(true);
        btn.setContentAreaFilled(true);
        return btn;
    }

    private void abrirTermos() {
        try {
            new TelaTermos(controller).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao abrir a tela de termos: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void abrirMitos() {
        try {
            new TelaMitos(controller).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao abrir a tela de mitos: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void abrirQuiz() {
        try {
            new TelaQuiz(controller).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao abrir o quiz: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
