// Ler dois vetores A (10 elementos) e B (20 elementos), juntar os dois vetores em um vetor C (30 elementos) e ordenar o vetor C
import java.util.*;

public class Ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] A = new int[10];
        int[] B = new int[20];
        int[] C = new int[30];//Vetor final com espaço pra tudo

        System.out.println("Vetor A:");
        for (int i = 0; i < 10; i++) {
            A[i] = sc.nextInt();
        }

        System.out.println("Vetor B:");
        for (int i = 0; i < 20; i++) {
            B[i] = sc.nextInt();
        }

        // juntar
        for (int i = 0; i < 10; i++) {
            C[i] = A[i];
        }

        for (int i = 0; i < 20; i++) {
            C[i + 10] = B[i];
        }

        Arrays.sort(C);//Organiza do menor para o maior

        System.out.println("Vetor C ordenado:");
        for (int num : C) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}