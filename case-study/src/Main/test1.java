package Main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class test1 implements Serializable {
    int data = 2;
    test1(int data){
        this.data = data;
    }
    String name = "phuong";
    void in(){
        System.out.println("test1");
    }
    public String toString(){
        return name + "  " + data;
    }
    public static void main(String[] args) {
        List<test1> b = new ArrayList<>();
        List<test1> c = new ArrayList<>();
        b.add(new test1(2));
        b.add(new test1(3));
        b.add(new test1(2));
        for(test1 x : b){
            if(x.data == 2) {
                b.remove(x);
                break;
            }

        }
        for(test1 x : b) System.out.println(x);
        System.out.println(b.get(0));
        System.out.println(b.get(1));

    }
}
