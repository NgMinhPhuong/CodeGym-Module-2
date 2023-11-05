import java.io.File;
import java.util.Date;

public class test {
    public static void xoaThuMuc(File fx){
        if(fx.isFile()){
            fx.delete();
        }
        else if(fx.isDirectory()){
            File [] arrFile = fx.listFiles();
            for(File f : arrFile)
            {
                xoaThuMuc(f);
                f.delete();
            }

        }
    }
    public static void main(String[] args) {
        File a = new File("C:\\Users\\DELL\\Desktop\\Dexoa\\f1cocon");
        xoaThuMuc(a);
        a.delete();
    }
}
