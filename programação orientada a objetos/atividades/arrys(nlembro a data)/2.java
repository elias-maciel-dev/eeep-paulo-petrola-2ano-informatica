// Ler 5 números, calcular a média, o maior e o menor
import java.util.*;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[5];

        for (int i = 0; i < 5; i++) {//passa por todos os numeros
            System.out.print("Digite um número: ");
            numeros[i] = sc.nextInt();
        }

        int soma = 0;
        int maior = numeros[0];
        int menor = numeros[0];//

        for (int n : numeros) {
            soma += n;
            if (n > maior) maior = n;
            if (n < menor) menor = n;
        }

        double media = soma / 5.0;//Divide por 5 (o .0 faz virar decimal)

        System.out.println("Média: " + media);
        System.out.println("Maior: " + maior);
        System.out.println("Menor: " + menor);

        sc.close();
    }
}