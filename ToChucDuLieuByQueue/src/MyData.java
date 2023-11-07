import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MyData {
    String name;
    String gt;
    int birthDay;
    int birthMonth;
    int birthYear;

    MyData(String name, String gt, int birthDay, int birthMonth, int birthYear){
        this.name = name;
        this.gt = gt;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
    }

    public String getName(){
        return name;
    }



    public static void main(String[] args) {
        ArrayList<MyData> arr = new ArrayList<>();
        MyData a = new MyData("phuong", "nam", 30, 6, 2000);
        MyData b = new MyData("hung", "nam", 30, 6, 2000);
        MyData c = new MyData("an", "nam", 30, 6, 2000);
        MyData d = new MyData("hau", "nu", 30, 6, 2000);
        MyData e = new MyData("hoa", "nu", 30, 6, 2000);
        MyData f = new MyData("phu", "nam", 30, 6, 2000);
        arr.add(a);
        arr.add(b);
        arr.add(c);
        arr.add(d);
        arr.add(e);
        arr.add(f);
        Queue<MyData> nam = new LinkedList<>();
        Queue<MyData> nu = new LinkedList<>();
        for(MyData x : arr){
            if(x.gt.equals("nam")) {
                nam.offer(x);
            }else{
                nu.offer(x);
            }
        }
        System.out.println("listMen: ");
        while(!nam.isEmpty()){
            System.out.print(nam.poll().getName() + " ");
        }
        System.out.println();
        System.out.println("listWomen: ");
        while(!nu.isEmpty()){
            System.out.print(nu.poll().getName() + " ");
        }

    }




}
