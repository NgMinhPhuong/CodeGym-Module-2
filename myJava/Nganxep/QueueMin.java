package Nganxep;
public class QueueMin {
   public class Node{
    int value;
    Node next;
    Node(int value)
    {
        this.value = value;
    }
    }
    Node top,tail;
    public boolean isEmpty(){
        return top == null;
    }
    
    public void push(int value){
        if(isEmpty()) {
            top = new Node(value); tail = top;
           return;
        }
        Node tmp = new Node(value);
        if(value <= top.value){
            tmp.next = top;
            top = tmp;
            return;
        }
        if(value >= tail.value){
            tail.next = tmp;
            tail = tmp;
            return;
        }
        Node co = top;
        Node p = co;
        while(co != null)
        {
            if(co.value >= value){
               p.next = tmp;
               tmp.next = co;
               return;
            }
            p = co;
            co = co.next;
        }
        return;
    }

    int top(){
        if(isEmpty()) return -1;
        return top.value;
    }
    
    void show(){
        Node sh = top;
        while(sh != null){
            System.out.print(sh.value + " ");
            sh = sh.next;
        }
        System.out.println();
    }

    int pop(){
        if(isEmpty()) return -1;
        int val = top.value;
        top = top.next;
        return val;
    }
    
   public static void main(String[] args) {
        QueueMin a = new QueueMin();
        a.push(30);
        a.push(23);
        a.push(10);
        a.push(22);
        a.push(1);
        a.show();
        System.out.println(a.top());
        a.pop();
        a.show();
        System.out.println(a.top());
        
        
   }
}
