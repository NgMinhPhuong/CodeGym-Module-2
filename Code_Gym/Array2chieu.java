import java.util.Arrays;

public class Array2chieu {
    public static void main(String[] args) {
        int [][] a = {{1,2,3}, {4,5,6}};
        int max = a[0][0];
        for(int [] x : a)
            for(int xx : x)
            {
                if(xx > max) max = xx;
            }
        System.out.println("Max Element in Array two dimensional is: " + max);
    }
}
