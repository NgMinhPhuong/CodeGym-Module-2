package Nganxep;
public class QueueMax {
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
        if(value >= top.value){
            tmp.next = top;
            top = tmp;
            return;
        }
        if(value <= tail.value){
            tail.next = tmp;
            tail = tmp;
            return;
        }
        Node co = top;
        Node p = co;
        while(co != null)
        {
            if(co.value <= value){
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
        QueueMax a = new QueueMax();
        a.push(5);
        a.push(7);
        a.push(15);
        a.push(1);
        a.push(6);
        a.show();  
        System.out.println(a.top());    
        System.out.println(a.pop()); 
        System.out.println(a.top()); 
        a.pop();
        System.out.println(a.top());
        
        
   }
}
