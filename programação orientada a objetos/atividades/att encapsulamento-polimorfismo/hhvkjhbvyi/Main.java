import javax.swing.*;
import java.awt.*;

class Pessoa {
    private String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String apresentacao() {
        return "Olá, eu sou uma pessoa.";
    }

    public String saudacao() {
        return "Olá!";
    }
}

class Aluno extends Pessoa {
    public Aluno(String nome) {
        super(nome);
    }

    @Override
    public String apresentacao() {
        return "Olá, eu sou o aluno " + getNome();
    }

    @Override
    public String saudacao() {
        return "Oi professor!";
    }
}

class Professor extends Pessoa {
    public Professor(String nome) {
        super(nome);
    }

    @Override
    public String apresentacao() {
        return "Olá, eu sou o professor " + getNome();
    }

    @Override
    public String saudacao() {
        return "Bom dia, aluno!";
    }
}

public class Main extends JFrame {

    private JTextArea saida;

    public Main() {
        setTitle("POO - GUI com Swing NESSA POHA AGR VAI");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// fecha o programa ao fechar a janela
        setLocationRelativeTo(null);// centraliza na tela
        setLayout(new BorderLayout(10, 10));

        // Área de saída
        saida = new JTextArea();
        saida.setEditable(false);
        saida.setFont(new Font("Monospaced", Font.PLAIN, 14));
        saida.setMargin(new Insets(10, 10, 10, 10));
        JScrollPane scroll = new JScrollPane(saida);// adiciona barra de rolada

        // Painel de botões
        JPanel painelBotoes = new JPanel(new GridLayout(2, 3, 10, 10));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        Pessoa pessoa = new Pessoa("Carlos");
        Aluno aluno = new Aluno("Elias");
        Professor professor = new Professor("Marcos");

        JButton btnApresentacaoPessoa = new JButton("Apresentação Pessoa");
        JButton btnApresentacaoAluno = new JButton("Apresentação Aluno");
        JButton btnApresentacaoProf = new JButton("Apresentação Professor");

        JButton btnSaudacaoPessoa = new JButton("Saudação Pessoa");
        JButton btnSaudacaoAluno = new JButton("Saudação Aluno");
        JButton btnSaudacaoProf = new JButton("Saudação Professor");

        btnApresentacaoPessoa.addActionListener(e -> append(pessoa.apresentacao()));
        btnApresentacaoAluno.addActionListener(e -> append(aluno.apresentacao()));
        btnApresentacaoProf.addActionListener(e -> append(professor.apresentacao()));

        btnSaudacaoPessoa.addActionListener(e -> append(pessoa.saudacao()));
        btnSaudacaoAluno.addActionListener(e -> append(aluno.saudacao()));
        btnSaudacaoProf.addActionListener(e -> append(professor.saudacao()));

        painelBotoes.add(btnApresentacaoPessoa);
        painelBotoes.add(btnApresentacaoAluno);
        painelBotoes.add(btnApresentacaoProf);
        painelBotoes.add(btnSaudacaoPessoa);
        painelBotoes.add(btnSaudacaoAluno);
        painelBotoes.add(btnSaudacaoProf);

        // Botão limpar
        JButton btnLimpar = new JButton("Limpar");
        btnLimpar.addActionListener(e -> saida.setText(""));

        add(scroll, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.NORTH);
        add(btnLimpar, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void append(String texto) {
        saida.append(texto + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
// regra do Swing: toda GUI deve rodar na EDT