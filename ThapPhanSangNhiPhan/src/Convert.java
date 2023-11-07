import java.util.Scanner;
import java.util.Stack;

public class Convert {
    public static void main(String[] args) {
        Stack<Integer> st= new Stack<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("The number need to covert is: ");
        int num = sc.nextInt();
        while(num != 0){
           st.push(num % 2);
           num /= 2;
        }
        String res = "";
        while(!st.isEmpty()){
            res += st.pop();
        }
        System.out.println(res);
    }
}
