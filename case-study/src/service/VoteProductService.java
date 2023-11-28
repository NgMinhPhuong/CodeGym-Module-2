package service;

import untils.DataFile;

import java.util.List;

public class VoteProductService {
    private static VoteProductService instance;
    private VoteProductService(){

    }

    public static VoteProductService getInstance() {
        if(instance == null){
            instance = new VoteProductService();
        }
        return instance;
    }

    public void showVoteProduct(String path) {
        List<String> listComment;
        listComment = DataFile.getInstance().readVote(path);
        if (listComment == null) {
            System.out.println("There are no comments for this product yet");
            return;
        }
        String[] ss;
        for (int i = listComment.size() - 1; i >= 0; i--) {
            ss = listComment.get(i).split(",");
            System.out.println(ss[0] + ": " + ss[1] + " SAO -> " + ss[2]);
        }
    }

}
