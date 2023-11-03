import java.util.Arrays;
import java.util.Scanner;

public class AddElementIntoArray {
    public static void main(String[] args) {
        int [] a = {1,2,3,4,5,6,0,0,0};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number need to add:");
        int num = sc.nextInt();
        System.out.println("Add at index: ");
        int index = sc.nextInt();
        for(int i = a.length - 1; i > index; i--)
        {
            a[i] = a[i - 1];
        }
        a[index] = num;
        System.out.println(Arrays.toString(a));
    }
}
