// Ler 5 números e armazenar em um vetor, depois exibir os números digitados
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] vetor = new int[5];//essa poha cria um vetor de 5 posições(tipo uma lista)

        for (int i = 0; i < vetor.length; i++) {//luping de 4 pq são 5 expaços (basicamente preenche o vetor)
            System.out.print("Digite um número: ");
            vetor[i] = sc.nextInt();
        }

        System.out.println("Números digitados:");//guarda os numeros digitados
        for (int num : vetor) {
            System.out.println(num);
        }

        sc.close();
    }
}