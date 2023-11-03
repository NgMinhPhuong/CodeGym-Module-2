import java.util.Scanner;

public class countWordofString {
    public static void main(String[] args) {
        String a = "phuong";
        System.out.println("Enter word need to find: ");
        Scanner sc = new Scanner(System.in);
        char word = sc.next().charAt(0);
        int cnt = 0;
        for (int i = 0; i < a.length() ;  i++)
        {
            if(a.charAt(i) == word)
                cnt++;
        }
        System.out.println("there is " + cnt + " \"" + word + "\" in String a");
    }
}
