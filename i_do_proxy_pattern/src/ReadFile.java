import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        try {
            FileInputStream fip = new FileInputStream(new File("C:\\Users\\DELL\\Desktop\\Java_CODEGYM\\i_do_proxy_pattern\\src\\fine.txt"));
            int i = -1; byte [] bytes = new byte[3];
            while((i = fip.read(bytes)) != -1){
                String s = new String(bytes, 0,i);
                System.out.println(s);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
