import java.util.*;

public class test {
    test next;
    int val;

    test(int x) {
        this.val = x;
    }

    public static void main(String[] args) {
        test a = new test(5);
        test b = new test(6);
        a.next = b;
        b.val = 3;
        a.next.next = new test(7);

        if(a.next.val == b.val) System.out.println("yes");
    }
}


