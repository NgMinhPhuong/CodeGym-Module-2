package Main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class test1 implements Serializable {
    int data = 2;
    String name = "phuong";
    void in(){
        System.out.println("test1");
    }
    public String toString(){
        return name + "  " + data;
    }
    public static void main(String[] args) {
        test1 a = new test1();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\ProductData.csv"));
            oos.writeObject(a);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\ProductData.csv"));
            test1 b;
            System.out.println(b = (test1) ois.readObject());
            if(b == a) System.out.println("YES");
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
