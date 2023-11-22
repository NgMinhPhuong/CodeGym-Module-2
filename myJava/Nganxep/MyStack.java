package Nganxep;

import java.util.List;

public class MyStack {
    private class Node{
        private int value;
        Node next;
        Node(int value){
            this.value=value;
        }
    }
    Node topNode;
    boolean isEmpty(){
        return topNode==null;
    }

    int push(int value){
        if(isEmpty()) {topNode=new Node(value);return topNode.value;}
        else{
            Node tmp=new Node(value);
            tmp.next=topNode;
            topNode=tmp;
            return tmp.value;
        }
    }

    int pop(){
        if(isEmpty()) {System.out.println("delete is failed");return -1;}
        else{
            int valu=topNode.value;
            topNode=topNode.next;
            return valu;
        }
    }

    int top(){
        return topNode.value;
    }

    void show(){
        if(isEmpty()) {System.out.println("Stack is empty"); return;}
        else{
            Node a=topNode;
            while(a!=null)
            {
                System.out.print(a.value+" ");
                a=a.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

        List<Integer> l = null;
        l.add(6);
        l.add(6);
        l.add(6);
        for(int x : l) System.out.println(x);

    }

}
