import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class test implements Comparator<test> {
    int data;
    test(int data){
        this.data = data;
    }

    public static void main(String[] args) {
        List<test> t = new ArrayList<>();
        t.add(new test(7));
        t.add(new test(1));
        t.add(new test(2));
        t.add(new test(5));
        Collections.sort(t, new test(2));
        for(test x : t) System.out.println(x.data);
    }

    @Override
    public int compare(test o1, test o2) {
        return ((Comparable<Integer>)(o1.data)).compareTo(o2.data);
    }
}
