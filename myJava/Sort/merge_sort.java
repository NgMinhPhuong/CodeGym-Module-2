package Sort;


import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class merge_sort {
    int [] sott(int [] a, int l, int r){
        if(l == r) {
            int [] ret = {a[l]};
            return ret;
        }
        int k = (l + r) / 2;
        int [] a1 = sott(a ,l, k);
        int [] a2 = sott(a, k+1, r);
        int n = a1.length + a2.length;
        int [] result = new int[n];
        int ia1 = 0, ia2 = 0, i = 0;
        while(ia1 < a1.length)
        {
            if(a1[ia1] < a2[ia2])
            {
                result[i] = a1[ia1];
                i++;
                ia1++;
                if(ia1 == a1.length)
                {
                    while(ia2 < a2.length)
                    {
                        result[i] = a2[ia2];
                        i++;
                        ia2++;
                    }
                }
            }
            else{
                result[i] = a2[ia2];
                i++;
                ia2++;
                if(ia2 == a2.length)
                {
                    while(ia1 < a1.length)
                    {
                        result[i] = a1[ia1];
                        i++;
                        ia1++;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        merge_sort a = new merge_sort();
        int [] b = {10,7,4,9,4,0,3};
        b = a.sott(b, 0, b.length - 1);

        System.out.println(Arrays.toString(b));
    }

}