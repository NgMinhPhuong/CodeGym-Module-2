import java.util.Scanner;
import java.util.Stack;

public class Check {
    public String checkDauNgoac(String s){
        boolean check = true;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                st.push('(');
            }
            else if(s.charAt(i) == ')'){
                if(st.isEmpty()){
                    check = false;
                    break;
                }else{
                    st.pop();
                }
            }
        }
        if(!check || !st.isEmpty()) return ("Khong hop le");
        else return ("Hop le");
    }

}
