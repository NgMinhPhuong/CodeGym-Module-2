import java.util.Scanner;

public class FindString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your String: ");
        String s = sc.nextLine();
        String res = "";
        String rem = "" + s.charAt(0);
        for(int i = 0; i < s.length(); i++){
            rem = "" + s.charAt(i);
            for(int j = i + 1; j < s.length(); j++)
            {
                String a = "" + s.charAt(j);
                String b = "" + rem.charAt(rem.length() - 1);
                if(a.compareTo(b) > 0){
                    rem += a;
                }
                if(rem.length() > res.length()) res = rem;
            }
        }
        System.out.println(res);
    }
}
