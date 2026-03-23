//Função que recebe um nome e mostra "Bom dia", "Boa tarde"
import java.time.LocalTime;

public class Saudacao {

    public static void saudacao(String nome) {
        int hora = LocalTime.now().getHour();

        if (hora < 12) {
            System.out.println("Bom dia, " + nome);
        } else if (hora < 18) {
            System.out.println("Boa tarde, " + nome);
        } else {
            System.out.println("Boa noite, " + nome);
        }
    }

    public static void main(String[] args) {
        saudacao("Elias");
    }
}