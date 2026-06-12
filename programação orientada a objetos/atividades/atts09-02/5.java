import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int n1 = entrada.nextInt();

        System.out.print("Digite o segundo número: ");
        int n2 = entrada.nextInt();

        int resto = n1 % n2;

        System.out.println("O resto da divisão é: " + resto);

        entrada.close();
    }
}