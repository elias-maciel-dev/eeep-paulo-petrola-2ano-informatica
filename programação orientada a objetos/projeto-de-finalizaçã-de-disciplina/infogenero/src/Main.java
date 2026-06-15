import view.TelaPrincipal;

import javax.swing.*;

/**
 * Ponto de entrada do sistema InfoGênero.
 */
public class Main {
    public static void main(String[] args) {
        // Garante que a GUI seja criada na Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            try {
                // Aplica o look and feel do sistema operacional
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                // Se falhar, continua com o padrão do Swing
                System.err.println("Aviso: não foi possível aplicar o look and feel do sistema. " + e.getMessage());
            }

            TelaPrincipal tela = new TelaPrincipal();
            tela.setVisible(true);
        });
    }
}
