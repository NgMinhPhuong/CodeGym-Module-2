public class PrintPrimeto100 {
    static boolean checkPrime(int x){
        for(int i = 2; i <= Math.sqrt(x); i++)
        {
            if(x % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        for(int i = 2; i <= 100; i++)
        {
            if(PrintPrimeto100.checkPrime(i))
                System.out.print(i + " ");
        }
    }
}
