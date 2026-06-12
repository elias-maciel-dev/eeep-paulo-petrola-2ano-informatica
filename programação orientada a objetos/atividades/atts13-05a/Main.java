class Pessoa {
    String nome;
    String fone;
    String cpf;

    Pessoa(String nome, String fone, String cpf) {
        this.nome = nome;
        this.fone = fone;
        this.cpf = cpf;
    }

    void apresentar() {
        System.out.println("Nome: " + nome);
        System.out.println("Fone: " + fone);
        System.out.println("CPF: " + cpf);
    }
}


class Aluno extends Pessoa {
    String matricula;

    Aluno(String nome, String fone, String cpf, String matricula) {
        super(nome, fone, cpf);//super chama coisas da classe que herdou
        this.matricula = matricula;
    }

    void aprender() {
        System.out.println(nome + " está aprendendo.");
    }
}

class Professor extends Pessoa {
    String titulo;

    Professor(String nome, String fone, String cpf, String titulo) {
        super(nome, fone, cpf);
        this.titulo = titulo;
    }

    void ensinar() {
        System.out.println(nome + " está ensinando.");
    }
}

class Funcionario extends Pessoa {
    int cod;
    String funcao;

    Funcionario(String nome, String fone, String cpf, int cod, String funcao) {
        super(nome, fone, cpf);
        this.cod = cod;
        this.funcao = funcao;
    }

    void desempenharFuncao() {
        System.out.println(nome + " trabalha como " + funcao);
    }
}

class Responsavel {
    String nome;
    Aluno aluno;

    Responsavel(String nome, Aluno aluno) {
        this.nome = nome;
        this.aluno = aluno;
    }

    void mostrarAluno() {
        System.out.println(nome + " é responsável por " + aluno.nome);
    }
}

public class Main {
    public static void main(String[] args) {

        Aluno aluno = new Aluno(
            "Elias",
            "889999999",
            "123456789",
            "2025001"
        );

        Professor professor = new Professor(
            "Carlos",
            "887777777",
            "987654321",
            "Mestre"
        );

        Funcionario funcionario = new Funcionario(
            "João",
            "886666666",
            "111222333",
            1,
            "Secretário"
        );

        Responsavel responsavel = new Responsavel(
            "Maria",
            aluno
        );

        aluno.apresentar();
        aluno.aprender();

        System.out.println();

        professor.apresentar();
        professor.ensinar();

        System.out.println();

        funcionario.apresentar();
        funcionario.desempenharFuncao();

        System.out.println();

        responsavel.mostrarAluno();
    }
}