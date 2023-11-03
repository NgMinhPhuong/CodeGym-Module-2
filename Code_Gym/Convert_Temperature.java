import java.util.Scanner;

public class Convert_Temperature {
    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = (9.0 / 5) * celsius + 32;
        return fahrenheit;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (5.0 / 9) * (fahrenheit - 32);
        return celsius;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double fahrenheit, celsius;
        int choice = -1;
        do{
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    fahrenheit = sc.nextDouble();
                    System.out.println(fahrenheit + " fahrenheit = " + fahrenheitToCelsius(fahrenheit) + " Celsius");
                case 2:
                    celsius = sc.nextDouble();
                    System.out.println(celsius + " celsius = " + celsiusToFahrenheit(celsius) + " fahrenheit");
            }
        }while(choice != 0);
    }
}
