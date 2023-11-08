import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    static void sellectionSort(int [] arr){
        for(int i = 1; i < arr.length; i++){
            int pos = i; int val = arr[i];
            while(pos > 0 && val < arr[pos - 1]){
                arr[pos] = arr[pos - 1];
                pos--;
            }
            arr[pos] = val;
            System.out.println("The Array after " + i + " time Sort: " +
                    Arrays.toString(arr));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size: ");
        int size = sc.nextInt();
        int [] arr = new int[size];
        for(int i = 0; i < size; i++){
            System.out.print(i + "th Element: ");
            arr[i] = sc.nextInt();
        }
        sellectionSort(arr);


    }
}
