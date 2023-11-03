import java.util.Scanner;

public class PointOfStudents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pointList[] = new int[10];
        for(int i = 0; i < 10; i++)
        {
            System.out.print(i + "th Point: ");
            pointList[i] = sc.nextInt();
        }
        int cnt = 0;
        for(int x : pointList)
            if(x >= 5) cnt++;
        System.out.println("Total of students pass is: " + cnt);
    }
}
