// Source reconstructed from decompiled classes
public class Professor extends Pessoa {
    public Professor(String nome) {
        super(nome);
    }

    public void apresentacao() {
        System.out.println("Olá, eu sou o professor " + this.getNome());
    }

    public void saudacao() {
        System.out.println("Bom dia, aluno!");
    }
}
