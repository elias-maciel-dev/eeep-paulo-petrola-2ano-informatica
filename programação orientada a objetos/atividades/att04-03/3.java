import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int n1 = entrada.nextInt();

        System.out.print("Digite o segundo número: ");
        int n2 = entrada.nextInt();

        for (int i = n1; i <= n2; i++) {

            if (i % 3 == 0) {
                System.out.println(i);
            }

        }

        entrada.close();
    }
}