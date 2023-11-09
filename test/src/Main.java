
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class Main {
    public static void someMethod() {
        try{
            if(2 < 3){
                throw new FileNotFoundException();
            }
        } catch (Exception e){
            System.out.println("cc");
        }
    }

    public static void main(String[] args) throws IOException {
        someMethod();

    }
}