public class FizzBuzzTranslate {
    public static String tranSlate(int x){
        String a [] = {"khong" ,"mot" ,"hai", "ba", "bon", "nam", "sau", "bay", "tam", "chin"};
        if(Integer.toString(x).length() == 2){
            return a[x/10] + " " + a[x%10];
        }
        else{
            return a[x%10] + "";
        }
    }
}
