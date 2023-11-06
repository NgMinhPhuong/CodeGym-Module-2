package Nganxep;
public class MyQueue {
     class Node{
          int value;
         private Node next;
         private Node(int value){
         this.value=value;
         
        }
         
    }
     Node topNode;Node tailNode=topNode;
    
     MyQueue(){
        
    }
    
     boolean isEmpty(){
        
        return (topNode==null && tailNode==null);
        
    }

     boolean push(int value){
        Node tmp=new Node(value);
        if(isEmpty()) {topNode=tmp;tailNode=tmp;}
        else{
            tailNode.next=tmp;
            tailNode=tmp;
        }
        return true;
    }
     int pop(){
        if(isEmpty()) return -1;
        else{
        int valu=topNode.value;
        if(tailNode==topNode) {tailNode=null;topNode=null;return valu;} 
        topNode=topNode.next;
        return valu;
        }
    }
    
     int top(){
        if(isEmpty()) return -1;
        return topNode.value;
    }

    void show(){
        if(isEmpty()) {
            System.out.println("Queue is Empty"); return;
        }
        Node tmp=topNode;
        while(tmp!=null)
        {
            System.out.print(tmp.value+" ");
            tmp=tmp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyQueue a = new MyQueue();
        a.push(5);
        a.push(6);
        System.out.println(a.topNode.value);
    }

}
