package view;

import controller.SistemaController;
import model.Definicao;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

/**
 * Tela de consulta de termos e definições.
 */
public class TelaTermos extends JFrame {

    private SistemaController controller;
    private JList<String> listaTermos;
    private JTextArea areaDescricao;
    private JTextField campoBusca;
    private List<Definicao> definicoes;

    public TelaTermos(SistemaController controller) {
        this.controller = controller;
        this.definicoes = controller.getDefinicoes();
        configurarJanela();
        construirInterface();
    }

    private void configurarJanela() {
        setTitle("📖 Termos e Definições");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void construirInterface() {
        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(new EmptyBorder(15, 15, 15, 15));
        painel.setBackground(new Color(245, 245, 250));

        // Busca
        JPanel painelBusca = new JPanel(new BorderLayout(8, 0));
        painelBusca.setBackground(new Color(245, 245, 250));
        JLabel lblBusca = new JLabel("🔍 Buscar:");
        lblBusca.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campoBusca = new JTextField();
        campoBusca.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(new Color(106, 27, 154));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFocusPainted(false);
        btnBuscar.addActionListener(e -> buscar());
        campoBusca.addActionListener(e -> buscar());

        painelBusca.add(lblBusca, BorderLayout.WEST);
        painelBusca.add(campoBusca, BorderLayout.CENTER);
        painelBusca.add(btnBuscar, BorderLayout.EAST);

        // Lista de termos
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (Definicao d : definicoes) {
            modelo.addElement(d.getTermo());
        }
        listaTermos = new JList<>(modelo);
        listaTermos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        listaTermos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaTermos.addListSelectionListener(e -> exibirDefinicao());
        JScrollPane scrollLista = new JScrollPane(listaTermos);
        scrollLista.setPreferredSize(new Dimension(220, 0));
        scrollLista.setBorder(BorderFactory.createTitledBorder("Termos"));

        // Área de descrição
        areaDescricao = new JTextArea();
        areaDescricao.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        areaDescricao.setLineWrap(true);
        areaDescricao.setWrapStyleWord(true);
        areaDescricao.setEditable(false);
        areaDescricao.setBackground(Color.WHITE);
        areaDescricao.setBorder(new EmptyBorder(10, 10, 10, 10));
        JScrollPane scrollDesc = new JScrollPane(areaDescricao);
        scrollDesc.setBorder(BorderFactory.createTitledBorder("Definição"));

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollLista, scrollDesc);
        split.setDividerLocation(220);

        painel.add(painelBusca, BorderLayout.NORTH);
        painel.add(split, BorderLayout.CENTER);

        add(painel);
    }

    private void exibirDefinicao() {
        int idx = listaTermos.getSelectedIndex();
        if (idx >= 0 && idx < definicoes.size()) {
            areaDescricao.setText(definicoes.get(idx).exibir());
            areaDescricao.setCaretPosition(0);
        }
    }

    private void buscar() {
        try {
            String termo = campoBusca.getText();
            definicoes = controller.buscarDefinicoes(termo);
            DefaultListModel<String> modelo = new DefaultListModel<>();
            for (Definicao d : definicoes) {
                modelo.addElement(d.getTermo());
            }
            listaTermos.setModel(modelo);
            areaDescricao.setText("");
            if (definicoes.isEmpty()) {
                areaDescricao.setText("Nenhum termo encontrado para \"" + termo + "\".");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro na busca: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
