// Source reconstructed from decompiled classes
public class Pessoa {
    private String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void apresentacao() {
        System.out.println("Olá, eu sou uma pessoa.");
    }

    public void saudacao() {
        System.out.println("Olá!");
    }
}
