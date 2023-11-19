package Main;

import java.util.Scanner;

public class test1 {
    int data = 2;
    void in(){
        System.out.println("test1");
    }

    public static void main(String[] args) {
        test1 a = null;
        test1 [] test1s = {new test1(), new test1(), new test1()};
        for(test1 x : test1s){
            if(x.data == 2){
                a = x; break;
            }
        }
            a.data = 6;
        for(test1 x : test1s){
            System.out.println(x.data);
        }

    }
}
