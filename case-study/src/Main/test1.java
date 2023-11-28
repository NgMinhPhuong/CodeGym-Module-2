package Main;


import java.io.Serializable;
import java.util.Scanner;


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
        int a = new Scanner(System.in).nextInt();

    }
}
