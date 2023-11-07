import com.sun.security.jgss.GSSUtil;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args) {
        Queue<Character> q = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String need to check: ");
        String s = sc.nextLine();
        boolean check = false;
        for(int i = s.length() - 1; i >= 0; i--){
            q.offer(s.charAt(i));
            System.out.println(s.charAt(i));
        }
        String ss = "";
        while(!q.isEmpty()){
            ss += q.poll();
        }
        System.out.println(ss);
        if(s.equals(ss)) check = true;
        if(check) System.out.println("String is Palindrome");
        else{
            System.out.println("String is not Palindrome");
        }

    }
}
