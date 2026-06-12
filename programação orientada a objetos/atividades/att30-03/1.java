class Aluno {
    String nome;
    String dt_nascimento;
    String telefone;
    String nome_responsavel;

    void apresentacao() {
        System.out.println("nome: " + nome);
        System.out.println("data de nascimento: " + dt_nascimento);
        System.out.println("telefone: " + telefone);
        System.out.println("responsável: " + nome_responsavel);
    }

    void saudacao() {
        int hora = java.time.LocalTime.now().getHour();

        if (hora < 12) {
            System.out.println("bom dia");
        } else if (hora < 18) {
            System.out.println("boa tarde");
        } else {
            System.out.println("boa noite");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Aluno a = new Aluno();

        a.nome = "Geymison";
        a.dt_nascimento = "22/04/1500";
        a.telefone = "99999-9999";
        a.nome_responsavel = "Mãe do Geymison";

        a.saudacao();
        a.apresentacao();
    }
}