import java.util.Scanner;

public class DeleteElement_FromArray {
    public static void main(String[] args) {
        int [] a = {1,2,3,4,5,6,7,8};
        System.out.println("Enter the Element need to delete: ");
        Scanner sc = new Scanner(System.in);
        int dlE = sc.nextInt();
        for(int i = 0; i < a.length; i++)
        {
            if(a[i] == dlE)
            {
                a[i] = 0;
                for(int j = i; j < a.length - 1; j++)
                {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        for(int x : a)
            System.out.print(x + " ");


    }
}
