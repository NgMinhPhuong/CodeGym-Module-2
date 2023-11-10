import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadByte {//Khi chạy sẽ ghi mảng byte vào file nguồn sau đó copy đến file đích và sau đó đọc file đích để Kiểm tra
    public static void main(String[] args) {
        int i = -1;
        byte [] bytes = new byte[1];
        byte [] sour = {'a','b','c','d','e'};
        try (DataOutputStream fos = new DataOutputStream(new FileOutputStream("C:\\Users\\DELL\\Desktop\\Java_CODEGYM\\copy-binaryFile\\src\\target.txt"));
             DataInputStream fin = new DataInputStream(new FileInputStream("C:\\Users\\DELL\\Desktop\\Java_CODEGYM\\copy-binaryFile\\src\\source.txt"));
             DataOutputStream fosSource = new DataOutputStream(new FileOutputStream("C:\\Users\\DELL\\Desktop\\Java_CODEGYM\\copy-binaryFile\\src\\source.txt"));){
            fosSource.write(sour);
            fosSource.close();
            while(true){
               i = fin.read(bytes);
                if(i == -1)
                    break;
                System.out.println(new String(bytes));
                fos.write(bytes);
            }

        } catch (IOException e) {
            System.out.println("hết");
        }

    }
}
