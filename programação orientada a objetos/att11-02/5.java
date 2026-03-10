import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = entrada.nextLine();

        System.out.print("Digite seu ano de nascimento: ");
        int ano = entrada.nextInt();

        int idade = 2026 - ano;

        if (idade >= 18) {
            System.out.println(nome + ", entrada liberada.");
        } else {
            System.out.println(nome + ", entrada não liberada.");
        }

        entrada.close();
    }
}