package build;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public abstract class User implements Serializable {
    String userName;
    String accountName;
    String password;


    public User(String userName, String accountName, String password) {
        this.userName = userName;
        this.accountName = accountName;
        this.password = password;
    }
    public void connectToAnUser(User user){
        String path = "C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\" + "MailBox_" + this.userName
                + "_And_" + user.userName + ".txt";
        File file = new File(path);
        try{
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Connect To " + user.userName + " Successfully");

    }
    public void sendMessageTo(User user, String message){
        String path = "C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\" + "MailBox_" + this.userName
                + "_And_" + user.userName + ".txt";
        File file = new File(path);
        if(file.exists()){
            try {
                FileWriter fr = new FileWriter(path, true);
                fr.write(this.userName + ": " + message + "\n");
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("Plese Connect To " + user.userName);
        }
    }
}
