package Main;

import java.util.ArrayList;
import java.util.List;

public class test2 extends test1{
    static List<test1> l = new ArrayList<>();
    static test1 intest2(){
        l.add(new test2());
        return l.get(0);
    }
    public static void main(String[] args) {
        test2 b = (test2) intest2();
        b.data = 5;
        b.l.add(new test1());
        for(test1 x : l) System.out.print(x.data + " ");
    }
}
