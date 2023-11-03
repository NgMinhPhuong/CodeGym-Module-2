import java.util.Scanner;

public class ElementMaxInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size: ");
        int size = sc.nextInt();
        int [] a = new int[size];
        for(int i = 0; i < a.length; i++)
        {
            a[i] = sc.nextInt();
        }
        int max = a[0];
        for(int x : a)
        {
            if(x > max) max = x;
        }
        System.out.println("MaxElement in the Array is: " + max);
    }
}
