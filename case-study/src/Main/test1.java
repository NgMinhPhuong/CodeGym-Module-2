package Main;


import java.io.Serializable;


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
        int x = 50;   // Tọa độ x
        int y = 5;    // Tọa độ y

        // Sử dụng escape sequence để di chuyển con trỏ đến tọa độ x, y
        System.out.print("\033[" + y + ";" + x + "H");

        // Tiếp tục với các dòng lệnh khác
        System.out.println("Hello, world!");
    }
}
