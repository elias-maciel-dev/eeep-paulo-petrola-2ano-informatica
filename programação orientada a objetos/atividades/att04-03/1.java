import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int n = entrada.nextInt();

        for (int i = 1; i <= 10; i++) {

            System.out.println(n + " + " + i + " = " + (n + i));
            System.out.println(n + " - " + i + " = " + (n - i));
            System.out.println(n + " * " + i + " = " + (n * i));
            System.out.println(n + " / " + i + " = " + (n / (double)i));
            System.out.println("-------------------");
        }

        entrada.close();
    }
}