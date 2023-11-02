import java.util.Scanner;

public class ReadNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number need to read: ");
        int num = sc.nextInt();
        String res = "";
        switch (num) {
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            case 4:
                System.out.println("four");
                break;
            case 5:
                System.out.println("five");
                break;
            case 6:
                System.out.println("six");
                break;
            case 7:
                System.out.println("seven");
                break;
            case 8:
                System.out.println("eight");
                break;
            case 9:
                System.out.println("nine");
                break;
            case 10:
                System.out.println("ten");
                break;
            case 11:
                System.out.println("eleven");
                break;
            case 12:
                System.out.println("twelve");
                break;
            case 13:
                System.out.println("thirteen");
                break;
            case 14:
                System.out.println("fourteen");
                break;
            case 15:
                System.out.println("fifteen");
                break;
            default:
                String [] a = {"", "one", "two", "thir", "four", "five", "six", "seven", "eight", "nine"};
                if(num > 15 && num < 100)
                {
                    res = res + a[num / 10] + "ty" + " " + a[num % 10];
                }
                else
                {
                    res = res + a[num / 100] + " hundred " + a[(num % 100)/10] + "ty " + a[num % 10];
                }
                break;
        }
        System.out.println(res);
        
    }
}
