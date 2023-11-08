import java.util.Scanner;

public class count {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your String: ");
        String s = sc.nextLine();
        String res = "";
        String rem = "";
        for(int i = 0; i < s.length(); i++){
            rem += s.charAt(i);
            for(int j = i + 1 ; j < s.length(); j++)
            {
                String rear = "" + s.charAt(j);
                String head = "" + s.charAt(j - 1);
                if (head.compareTo(rear) < 0) {
                    rem += rear;
                    if(j == s.length() - 1) {
                        if (rem.length() > res.length()) res = rem;
                        rem = "";
                        break;
                    }
                }
                else {
                    if (rem.length() > res.length()) res = rem;
                    rem = "";
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
//abcabcdgabmnsxy