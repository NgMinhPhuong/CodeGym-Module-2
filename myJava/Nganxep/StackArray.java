package Nganxep;

public class StackArray {
    int size;
    int a[];
    public StackArray(int x){
        a=new int[x];
        size=x;
    }
    int i=-1;
    public boolean isFull(){
        return i == size;
    }
    public boolean push(int value){
        if(i==size-1) { System.out.print("day roi ko them dc nua"); System.out.println(); return false;}
        i++;
        a[i] = value;
        return true;
    }
    public int top(){
        if(isEmpty()) return -1;
        return a[i];
    }
    public boolean isEmpty(){
        return i==-1;
    }
    public boolean pop(){
        if(isEmpty()) 
        {
            System.out.println("Rong roi xoa sao duoc nua");
            return false;
        }
       
        i--;
        return true;
    }

    public void show(){
        for(int x : a){
            System.out.print(this.a.length + " "+ x + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        StackArray a=new StackArray(4);
        System.out.println(a.isEmpty());
        System.out.println(a.isFull());
        a.push(12);
        a.push(13);
        a.push(14);
        a.push(15);
        a.push(16);
        a.show();
    }
}
