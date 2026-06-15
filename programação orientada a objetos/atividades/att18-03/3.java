//CONTAR leitras de uma frase
public class Contador {

    public static int contarCaracteres(String frase) {
        return frase.length();
    }

    public static void main(String[] args) {
        String texto = "Olá mundo";
        System.out.println("Quantidade: " + contarCaracteres(texto));
    }
}