import java.util.Scanner;

public class TotalOfColumm {
    public static void main(String[] args) {
        int [][] a = {{1,2,3}, {4,5,6}, {7,8,9}};
        Scanner sc = new Scanner(System.in);
        System.out.println("The columm need to count is: ");
        int thColuum = sc.nextInt();
        int sum = 0;
        for(int i = 0; i < a.length; i++)
        {
            sum += a[i][thColuum];
        }
        System.out.println("Total of " + thColuum + "th Columm is: " + sum);
    }
}
