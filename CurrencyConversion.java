import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your monney: ");
        int USD = sc.nextInt();
        System.out.println(USD + " USD = " + USD * 23000 + " VND");
    }
}
