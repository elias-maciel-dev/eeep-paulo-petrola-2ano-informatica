import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        double n1 = entrada.nextDouble();

        System.out.print("Digite o segundo número: ");
        double n2 = entrada.nextDouble();

        System.out.println("Escolha a operação:");
        System.out.println("1 - Soma");
        System.out.println("2 - Subtração");
        System.out.println("3 - Divisão");
        System.out.println("4 - Multiplicação");

        int op = entrada.nextInt();

        switch (op) {

            case 1:
                System.out.println("Resultado: " + (n1 + n2));
                break;

            case 2:
                System.out.println("Resultado: " + (n1 - n2));
                break;

            case 3:
                System.out.println("Resultado: " + (n1 / n2));
                break;

            case 4:
                System.out.println("Resultado: " + (n1 * n2));
                break;

            default:
                System.out.println("Operação inválida");
        }

        entrada.close();
    }
}