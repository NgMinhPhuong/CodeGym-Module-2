package Main;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

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
        LocalTime localTime = LocalTime.now().truncatedTo(java.time.temporal.ChronoUnit.SECONDS);
        System.out.println(localTime);
        LocalDate localDate = LocalDate.now();
        String e = localDate + "534";
        System.out.println(e);


    }
}
