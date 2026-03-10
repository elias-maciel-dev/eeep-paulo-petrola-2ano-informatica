import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int n = entrada.nextInt();

        for (int i = n; i <= n + 100; i += 6) {
            System.out.println(i);
        }

        entrada.close();
    }
}