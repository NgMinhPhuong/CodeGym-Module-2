package untils;

import Model.RegisterAccount;
import Model.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DataFile {
    private DataFile(){

    }
    private static DataFile instance;
    private File file;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public static DataFile getInstance() {
        if(instance == null){
            instance = new DataFile();
        }
        return instance;
    }

    //-----------------------------------------------------
    public void writeClient() {
        try {
            oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\Client.csv"));
            oos.writeObject(RegisterAccount.getAccountClientList());
            oos.close();
        } catch (Exception e) {
            System.out.println("Error Write File Client.csv");
        }
    }

    //---------------------------------------------------------------

    public void writeShop() {
        try {
            oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\Shop.csv"));
            oos.writeObject(RegisterAccount.getAccountShopList());
            oos.close();
        } catch (Exception e) {
            System.out.println("Error Write File Shop.csv");
        }

    }

    //---------------------------------------------------------------
    public void readClient() {
        file = new File("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\Client.csv");
        if (file.length() != 0) {
            try {
                ois = new ObjectInputStream(new FileInputStream("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\Client.csv"));
                RegisterAccount.setAccountClientList((List<User>) ois.readObject());
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error Read Client.csv");
            }
        }
    }

    //------------------------------------------------------------

    public void readShop() {
        file = new File("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\Shop.csv");
        if (file.length() != 0) {
            try {
                ois = new ObjectInputStream(new FileInputStream("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\Shop.csv"));
                RegisterAccount.setAccountShopList((List<User>) ois.readObject());
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error Read Shop.csv");
            }
        }
    }

    //-----------------------------------------------------------------


    public void writeVote(String path, String accountName, int star, String comment){
        file = new File(path);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        List<String> list = new ArrayList<>();
        String s;
        String [] ss;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            while((s = bufferedReader.readLine()) != null){
                list.add(s);
            }
        }  catch (IOException e){
            throw new RuntimeException(e);
        }
        for(String str : list){
            if(str.contains(accountName)){
                list.remove(str);
                break;
            }
        }
        list.add(accountName + "," + star + "," + comment );
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));){
            for(String str : list){
                bufferedWriter.write(str + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //-----------------------------------------------------------------------
    public void readVoteAndShow(String path){
        file = new File(path);
        if(!file.exists()){
            System.out.println("There are no comments for this product yet");
            return;
        }
        List<String> list = new ArrayList<>();
        String s;
        String [] ss;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path));){
            while((s = bufferedReader.readLine()) != null){
                list.add(s);
            }
            for(int i = list.size() - 1; i >= 0; i--){
                ss = list.get(i).split(",");
                System.out.println(ss[0] + ": " + ss[1] + " SAO -> " + ss[2]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
