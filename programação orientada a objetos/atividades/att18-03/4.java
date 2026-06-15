// Inverter um número inteiro
public class InverterNumero {

    public static int inverter(int numero) {
        int invertido = 0;

        while (numero != 0) {
            int digito = numero % 10;
            invertido = invertido * 10 + digito;
            numero /= 10;
        }

        return invertido;
    }

    public static void main(String[] args) {
        System.out.println(inverter(123)); // 321
    }
}