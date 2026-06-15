import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int n1 = entrada.nextInt();

        System.out.print("Digite o segundo número: ");
        int n2 = entrada.nextInt();

        if (n2 > n1) {
            System.out.println("Soma: " + (n1 + n2));
        } else {
            System.out.println("Subtração: " + (n1 - n2));
        }

        entrada.close();
    }
}