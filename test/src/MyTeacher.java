import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyTeacher {




        public static void main(String[] args) {

            //Save file
            try {
                String fileName = "C:\\Users\\DELL\\Desktop\\Java_CODEGYM\\test\\src\\testFile.txt";
                FileOutputStream fos = new FileOutputStream(fileName);
                byte[] data = "Hello FIS an FOS example".getBytes();
                fos.write(data);
                System.out.println("Save file successfully!");
                fos.close();
            } catch (IOException e) {
                System.out.println("Save file failed!");
                e.printStackTrace();
            }

            //Read file
            try {
                String fileName = "C:\\Users\\DELL\\Desktop\\Java_CODEGYM\\test\\src\\testFile.txt";
                FileInputStream fis = new FileInputStream(fileName);
                int n = fis.available();
                byte[] data = new byte[n];
                fis.read(data);
                System.out.println("File content is: " + new String(data));
                fis.close();
            } catch (IOException e) {
                System.out.println("Read file failed!");
                e.printStackTrace();
            }
        }


}
