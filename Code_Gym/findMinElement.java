import java.util.Scanner;

public class findMinElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int size = sc.nextInt();
        int a [] = new int[size];
        for(int i = 0; i < size; i++)
        {
            System.out.print(i + "th Element: ");
            a[i] = sc.nextInt();
        }
        int min = a[0];
        for(int x : a)
            if(x < min) min = x;
        System.out.println("the smallest Element is: " + min);
    }
}
