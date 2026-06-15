package view;

import controller.SistemaController;
import model.Mito;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

/**
 * Tela que exibe mitos e fatos sobre gênero/sexualidade.
 */
public class TelaMitos extends JFrame {

    private SistemaController controller;
    private List<Mito> mitos;
    private int indiceAtual = 0;

    private JLabel lblRotulo;
    private JTextArea areaAfirmacao;
    private JTextArea areaExplicacao;
    private JLabel lblContador;

    public TelaMitos(SistemaController controller) {
        this.controller = controller;
        this.mitos = controller.getMitos();
        configurarJanela();
        construirInterface();
        exibirMito();
    }

    private void configurarJanela() {
        setTitle("❓ Mitos e Fatos");
        setSize(650, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void construirInterface() {
        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(new EmptyBorder(20, 20, 20, 20));
        painel.setBackground(new Color(245, 245, 250));

        // Rótulo MITO/FATO
        lblRotulo = new JLabel("", SwingConstants.CENTER);
        lblRotulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblRotulo.setBorder(new EmptyBorder(10, 0, 10, 0));

        // Afirmação
        areaAfirmacao = new JTextArea();
        areaAfirmacao.setFont(new Font("Segoe UI", Font.ITALIC, 16));
        areaAfirmacao.setLineWrap(true);
        areaAfirmacao.setWrapStyleWord(true);
        areaAfirmacao.setEditable(false);
        areaAfirmacao.setBackground(new Color(245, 245, 250));
        areaAfirmacao.setBorder(new EmptyBorder(8, 8, 8, 8));

        // Explicação
        areaExplicacao = new JTextArea();
        areaExplicacao.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        areaExplicacao.setLineWrap(true);
        areaExplicacao.setWrapStyleWord(true);
        areaExplicacao.setEditable(false);
        areaExplicacao.setBackground(Color.WHITE);
        areaExplicacao.setBorder(new EmptyBorder(10, 10, 10, 10));
        JScrollPane scrollExp = new JScrollPane(areaExplicacao);
        scrollExp.setBorder(BorderFactory.createTitledBorder("Explicação"));

        // Painel central
        JPanel centro = new JPanel(new BorderLayout(0, 10));
        centro.setBackground(new Color(245, 245, 250));
        centro.add(areaAfirmacao, BorderLayout.NORTH);
        centro.add(scrollExp, BorderLayout.CENTER);

        // Navegação
        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        navPanel.setBackground(new Color(245, 245, 250));
        JButton btnAnterior = new JButton("◀ Anterior");
        JButton btnProximo = new JButton("Próximo ▶");
        lblContador = new JLabel("", SwingConstants.CENTER);
        lblContador.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        estilizarBotaoNav(btnAnterior);
        estilizarBotaoNav(btnProximo);

        btnAnterior.addActionListener(e -> navegar(-1));
        btnProximo.addActionListener(e -> navegar(1));

        navPanel.add(btnAnterior);
        navPanel.add(lblContador);
        navPanel.add(btnProximo);

        painel.add(lblRotulo, BorderLayout.NORTH);
        painel.add(centro, BorderLayout.CENTER);
        painel.add(navPanel, BorderLayout.SOUTH);

        add(painel);
    }

    private void estilizarBotaoNav(JButton btn) {
        btn.setBackground(new Color(21, 101, 192));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void exibirMito() {
        if (mitos.isEmpty()) {
            areaAfirmacao.setText("Nenhum conteúdo disponível.");
            return;
        }
        try {
            Mito m = mitos.get(indiceAtual);
            boolean ehMito = m.isEhMito();
            lblRotulo.setText(ehMito ? "❌ MITO" : "✅ FATO");
            lblRotulo.setForeground(ehMito ? new Color(183, 28, 28) : new Color(27, 94, 32));
            areaAfirmacao.setText("\"" + m.getAfirmacao() + "\"");
            areaExplicacao.setText(m.getExplicacao());
            lblContador.setText((indiceAtual + 1) + " / " + mitos.size());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao exibir conteúdo: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void navegar(int direcao) {
        int novo = indiceAtual + direcao;
        if (novo < 0 || novo >= mitos.size()) {
            JOptionPane.showMessageDialog(this,
                    "Não há mais itens nessa direção.",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        indiceAtual = novo;
        exibirMito();
    }
}
