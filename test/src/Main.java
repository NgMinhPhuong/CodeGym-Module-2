
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

class Main {
    public static void someMethod() {
        try{
            if(2 < 3){
                throw new FileNotFoundException();
            }
        } catch (Exception e){
            System.err.println("cc");
        }
    }

    public static void main(String[] args) {
        //ghi dữ liệu vào file temp.dat với DataOutputStream
        File file = new File("C:\\Users\\DELL\\Desktop\\Java_CODEGYM\\test\\src\\testFile.txt");
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream(file))) {
            output.writeUTF("John");
            output.writeDouble(85.5);
            output.writeUTF("Susan");
            output.writeDouble(185.5);
            output.writeUTF("Kim");
            output.writeDouble(105.25);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //đọc dữ liệu từ file temp.dat với DataInputStream

        try (DataInputStream input = new DataInputStream(new FileInputStream(file))) {
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte [] b = new byte[4];
        int i = -1;
//        try {
//            InputStream is = new FileInputStream(file);
//            while (true) {
//                System.out.println((i = is.read(b)));
//                if(i == -1) break;
//                String s = new String(b, 0, i);
//                System.out.println(s);
//            }
//        } catch(FileNotFoundException e){
//            e.printStackTrace();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}