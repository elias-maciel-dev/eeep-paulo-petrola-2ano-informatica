import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int n1 = entrada.nextInt();

        System.out.print("Digite o segundo número: ");
        int n2 = entrada.nextInt();

        System.out.print("Digite o terceiro número: ");
        int n3 = entrada.nextInt();

        int maior = n1;
        int menor = n1;

        if (n2 > maior) maior = n2;
        if (n3 > maior) maior = n3;

        if (n2 < menor) menor = n2;
        if (n3 < menor) menor = n3;

        System.out.println("Maior: " + maior);
        System.out.println("Menor: " + menor);

        entrada.close();
    }
}