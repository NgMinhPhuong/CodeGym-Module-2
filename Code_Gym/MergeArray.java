public class MergeArray {
    public static void main(String[] args) {
        int [] a = {1,2,3,4,5};
        int [] b = {6,7,8,9,10};
        int [] c = new int[a.length + b.length];
        int i = 0;
        for(int x : a){
            c[i++] = x;
        }
        for (int x : b)
            c[i++] = x;
        for(int x : c) System.out.print(x + " ");
    }
}
