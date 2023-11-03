public class MinArrayWithMethod {
    static int Min_Element(int [] Array){
        int index = 0;
        for(int i = 0; i < Array.length; i++)
        {
            if(Array[i] < Array[index])
                index = i;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {4, 12, 7, 8, 1, 6, 9};
        int index = Min_Element(arr);
        System.out.println("The smallest element in the array at index: " + index);
    }
}
