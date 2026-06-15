import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int a = entrada.nextInt();

        System.out.print("Digite o segundo número: ");
        int b = entrada.nextInt();

        System.out.print("Digite o terceiro número: ");
        int c = entrada.nextInt();

        int temp;

        if (a > b) { temp = a; a = b; b = temp; }
        if (a > c) { temp = a; a = c; c = temp; }
        if (b > c) { temp = b; b = c; c = temp; }

        System.out.println("Ordem crescente: " + a + ", " + b + ", " + c);

        entrada.close();
    }
}