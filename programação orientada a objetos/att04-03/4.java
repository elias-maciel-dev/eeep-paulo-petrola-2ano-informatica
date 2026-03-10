import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int senha = 1234;
        int tentativa;

        do {

            System.out.print("Digite a senha: ");
            tentativa = entrada.nextInt();

        } while (tentativa != senha);

        System.out.println("Senha correta!");

        entrada.close();
    }
}