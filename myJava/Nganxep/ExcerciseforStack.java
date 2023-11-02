package Nganxep;

import java.util.Stack;

public class ExcerciseforStack {
    public static void main(String[] args) {
    
    String s="a2[ab3[ac]]a";//abcabab abcabab 
    Stack<Character> st=new Stack<>();
    for(int i=0;i<s.length();i++)
    {
        char c=s.charAt(i);
        if(c==']')
        {
            String lu="";
            while(st.peek()!='[')
            {
                lu=st.pop()+lu;
            }
            System.out.println("lu= "+lu);
            st.pop();
            String loop ="";
            System.out.println(st.toString());
            while( st.isEmpty()==false && Character.isDigit(st.peek()))
            {
                System.out.println(st.isEmpty());
                loop=st.pop()+loop;
                System.out.println(st.isEmpty());
                System.out.println(st.toString());
            }
            int nLoop;
            System.out.println("loop= "+loop);
            if(loop=="") nLoop=1;
            else nLoop=Integer.parseInt(loop);
            System.out.println("nloop= "+nLoop);
            System.out.println();
            lu=lu.repeat(nLoop);
            
            for(int j=0;j<lu.length();j++)
            {
                st.push(lu.charAt(j));
            }

        }
        else {st.push(c);}
    }
    String result="";
    while(st.isEmpty()==false)
    result=st.pop()+result;
    System.out.println(result);
    



    


}
}
