package Controller;

import Model.Product;
import Model.User;
import service.VoteProductService;
import service.ShopService;
import service.UserService;
import untils.DataVote;

public class VoteProductController {
    private static VoteProductController instance;
    private VoteProductController(){

    }

    public static VoteProductController getInstance() {
        if(instance == null){
            instance = new VoteProductController();
        }
        return instance;
    }

    public void voteProduct(String accountName, int id, int star, String comment, User userComment){
        User user = UserService.getInstance().checkUserExists(accountName);
        if(user == null){
            System.out.println("This store is not available");
            return;
        }

        Product product = ShopService.getInstance().checkIdExists(id);
        if (product == null){
            System.out.println("This store has no this ID");
            return;
        }
        String path = "C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\vote_product\\"
                + accountName + "_" + id + ".csv";
        DataVote.getInstance().writeVote(path, star, comment, userComment);
        System.out.println("Comment Successfully");
    }


    public void showVoteProduct(String accountName, int id){
        User user = UserService.getInstance().checkShopExists(accountName);
        if(user == null){
            System.out.println("This store is not available");
            return;
        }

        Product product = ShopService.getInstance().checkIdExists(id);
        if (product == null){
            System.out.println("This store has no this ID");
            return;
        }
        String path = "C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\vote_product\\"
                + accountName + "_" + id + ".csv";

        VoteProductService.getInstance().showVoteProduct(path);

    }
}
