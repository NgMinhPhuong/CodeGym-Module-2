import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        int [] a = {1,2,3,4,5,6,7};
        for(int x : a){
            st.push(x);
        }
        int i = 0;
        while(!st.isEmpty()){
            a[i] = st.pop();
            i++;
        }
        for(int x : a)
            System.out.print(x + " ");
    }
}