package untils;

import Model.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class DataVote {
    private static DataVote instance;
    private DataVote(){

    }

    public static DataVote getInstance() {
        if(instance == null){
            instance = new DataVote();
        }
        return instance;
    }

    public void writeVote(String path, int star, String comment, User userComment){
        File file = new File(path);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        String  [] ss;
        List<String> list;
        list = readVote(path);
        for(String str : list){
            ss = str.split(",");
            if(ss[0].equals(userComment.getAccountName())){
                list.remove(str);
                break;
            }
        }
        list.add(userComment.getAccountName() + "," + star + "," + comment );
        try(BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path),"UTF-8"));){
            for(String str : list){
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //-----------------------------------------------------------------------
    public List<String> readVote(String path){
        File file = new File(path);
        if(!file.exists()){
            return null;
        }
        List<String> list = new ArrayList<>();
        String s;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path));){
            while((s = bufferedReader.readLine()) != null){
                list.add(s);
            }
            return list;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
