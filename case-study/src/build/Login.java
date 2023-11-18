package build;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Login {
    ObjectInputStream ois;
    Login(){

    }
    Client login(String accountName, String password){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\AccountList.csv"));)
        {
            Client client = null;
            while((client = (Client) ois.readObject()) != null) {
                if(client.accountName.equals(accountName) && client.password.equals(password)){
                    return client;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Wrong Account or Password. Please Enter Again");
        return null;
    }

    public static void main(String[] args) {
        System.out.println("dsa");
    }
}
