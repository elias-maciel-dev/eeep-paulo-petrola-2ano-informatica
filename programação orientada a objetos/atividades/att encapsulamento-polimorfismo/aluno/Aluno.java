// Source reconstructed from decompiled classes
public class Aluno extends Pessoa {
    public Aluno(String nome) {
        super(nome);
    }

    public void apresentacao() {
        System.out.println("Olá, eu sou o aluno " + this.getNome());
    }

    public void saudacao() {
        System.out.println("Oi professor!");
    }
}
