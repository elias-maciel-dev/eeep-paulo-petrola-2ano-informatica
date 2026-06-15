// Ler as notas de 10 alunos, calcular a média geral, a maior e a menor nota
import java.util.*;

public class Ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] notas = new double[10][4];

        double maior = Double.MIN_VALUE;
        double menor = Double.MAX_VALUE;
        double soma = 0;
        int totalNotas = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Aluno " + (i + 1));

            for (int j = 0; j < 4; j++) {
                System.out.print("Nota " + (j + 1) + ": ");
                notas[i][j] = sc.nextDouble();

                soma += notas[i][j];
                totalNotas++;

                if (notas[i][j] > maior) maior = notas[i][j];
                if (notas[i][j] < menor) menor = notas[i][j];
            }
        }

        double media = soma / totalNotas;

        System.out.println("Média geral: " + media);
        System.out.println("Maior nota: " + maior);
        System.out.println("Menor nota: " + menor);

        sc.close();
    }
}