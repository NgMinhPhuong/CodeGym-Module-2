import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args){
        File file = new File("C:\\Users\\DELL\\Desktop\\Java_CODEGYM\\practice-ReadFile-.csv\\src\\DsCountry.csv");
        String line = "";
        String res = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null)
            {
                res += line + ",";
            }
            br.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        String [] s = res.split(",");
        int cnt = 0;
        for(String x : s)
        {
            System.out.print(x + "   ");
            cnt++;
            if(cnt == 3) {
                cnt = 0;
                System.out.println();
            }
        }

    }
}
