import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    static int binarySearch(int [] array, int l, int r, int value){
        if(l > r) return - 1;
        int middle = (l + r) / 2;
        if(array[middle] == value) return middle;
        if(array[middle] > value) return binarySearch(array, l, middle - 1, value);
        else return binarySearch(array, middle + 1, r, value);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your the size of array:");
        int size = sc.nextInt();
        int [] myArr = new int[size];
        for(int i = 0; i < size; i++){
            System.out.print("Element " + i + ": ");
            myArr[i] = sc.nextInt();
        }
        Arrays.sort(myArr);
        System.out.println(Arrays.toString(myArr));
        System.out.println(BinarySearch.binarySearch(myArr, 0 , myArr.length, 4));
    }
}
