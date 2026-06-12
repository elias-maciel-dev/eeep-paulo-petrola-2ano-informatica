// Source reconstructed from decompiled classes
public class Main {
    public static void main(String[] args) {
        Pessoa p = new Pessoa("Carlos");
        Aluno a = new Aluno("Elias");
        Professor prof = new Professor("Marcos");

        p.apresentacao();
        a.apresentacao();
        prof.apresentacao();

        p.saudacao();
        a.saudacao();
        prof.saudacao();
    }
}
