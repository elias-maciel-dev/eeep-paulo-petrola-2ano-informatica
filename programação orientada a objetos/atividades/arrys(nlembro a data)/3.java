// Ler uma frase e contar quantas consoantes ela possui, além de exibir quais são as consoantes presentes na frase
import java.util.*;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite uma frase: ");
        String frase = sc.nextLine().toLowerCase();

        int contador = 0;

        for (char c : frase.toCharArray()) {//Converte a frase em letras e percorre uma por uma
            if (Character.isLetter(c) && "aeiou".indexOf(c) == -1) {
                System.out.print(c + " ");
                contador++;
            }
        }

        System.out.println("\nQuantidade de consoantes: " + contador);

        sc.close();
    }
}