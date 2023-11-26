package Main;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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
        System.out.println("cc");
        LocalDateTime a = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime after = a.plusHours(6);
        System.out.println(a.format(formatter));
        System.out.println(after);

/////// Làm mở tài khoản khi hết thời gian khoá
    }
}
