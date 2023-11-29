package untils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataBlackList {
    private static DataBlackList instance;
    private DataBlackList(){

    }

    public static DataBlackList getInstance() {
        if(instance == null){
            instance = new DataBlackList();
        }
        return instance;
    }

    public List<String[]> readBlockAccount(){
        String path = "C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\BlackList.csv";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path));){
            List<String[]> list = new ArrayList<>();
            String s;
            String [] ss;
            while((s = bufferedReader.readLine()) != null){
                ss = s.split(",");
                list.add(ss);
            }

            return list;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeBlockAccount(List<String[]> list){
        String path = "C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\BlackList.csv";
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));){
            for(String [] x : list){
                bufferedWriter.write(x[0] + "," + x[1] + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
