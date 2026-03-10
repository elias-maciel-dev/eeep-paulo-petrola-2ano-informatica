public class Ex5 {

    public static void main(String[] args) {

        int soma = 0;

        for (int i = 2; i <= 50; i++) {

            boolean primo = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    primo = false;
                    break;
                }
            }

            if (primo) {
                System.out.println(i);
                soma += i;
            }

        }

        System.out.println("Soma dos primos: " + soma);
    }
}