package Main;

import java.util.ArrayList;
import java.util.List;

public class test1 {
    int data;

    public test1(int data) {
        this.data = data;
    }

    public static void main(String[] args) {
        List<test1> l = new ArrayList<>();
        l.add(new test1(3));
        l.add(new test1(50));
        test1 c = null;
        c.data = 2;
        for(test1 x : l) System.out.println(x.data);
    }
}
