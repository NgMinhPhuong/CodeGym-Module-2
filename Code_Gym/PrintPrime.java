import java.util.Scanner;

public class PrintPrime {
    static boolean checkPrime(int x){
        for(int i = 2; i <= Math.sqrt(x); i++)
        {
            if(x % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number Of Prime to Print:");
        int num = sc.nextInt();
        int i = 2;
        int cnt = 0;
        while(cnt < num)
        {
            if(PrintPrime.checkPrime(i))
            {
                System.out.println(i); cnt++;
            }
            i++;
        }
    }
}
