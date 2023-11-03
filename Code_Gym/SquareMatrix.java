import java.util.Scanner;

public class SquareMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("the row and columm is: ");
        int size = sc.nextInt();
        int [][] a= new int[size][size];
        for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j < a[0].length; j++)
            {
                a[i][j] = sc.nextInt();
            }
        }
        int sum = 0;
        for (int i = 0; i < size; i++)
        {
            sum += a[i][i];
        }
        System.out.println("Tong dg cheo la: " + sum);

    }
}
