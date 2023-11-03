public class findMinElement {
    public static void main(String[] args) {
        int a [] = {1,2,3,4,5};
        int min = a[0];
        for(int x : a)
            if(x < min) min = x;
        System.out.println("the smallest Element is: " + min);
    }
}
