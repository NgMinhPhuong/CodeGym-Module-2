import java.util.Scanner;

public class draw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        do{
            System.out.println("1. Print the rectagle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Chieu dai: ");
                    int a = sc.nextInt();
                    System.out.println("Chieu rong: ");
                    int b = sc.nextInt();
                    for(int i = 0; i < a; i++)
                    {
                        for(int j = 0; j < b; j++)
                        {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Nhap chieu cao: ");
                    int c = sc.nextInt();
                    for(int i = 0; i < c; i++)
                    {
                        for(int j = 0; j < i + 1; j++ ){
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println("Nhap chieu cao: ");
                    int d = sc.nextInt();
                    int in = d - 1, out = 0;
                    for(int i = 0; i < d; i++)
                    {
                        if(i == d - 1){
                          for(int j = 0; j < 2*d - 1; j++){
                              System.out.print("*");
                          }
                            System.out.println();
                        }
                        else {
                            for (int j = 0; j < in; j++) {
                                System.out.print(" ");
                            }
                            in--;
                            System.out.print("*");
                            for (int k = 0; k < out; k++) {
                                System.out.print(" ");
                            }
                            if (out == 0) out++;
                            else out += 2;
                            if (i == 0) System.out.println();
                            else System.out.println("*");
                        }
                    }

            }
        }while(choice != 4);
    }
}
