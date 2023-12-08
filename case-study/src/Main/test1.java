package Main;

import java.util.ArrayList;

public class test1 {
    ArrayList<String> ar;

    public ArrayList<String> getAr() {
        return ar;
    }

    public static void main(String[] args) {
        test1 a = new test1();
        a.getAr().add("43");
        System.out.println(
                a.getAr()
        );
    }
}
