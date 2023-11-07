public class Queue {
    Node front;
    Node rear;
    public void enQueue(int data){
        Node tmp = new Node(data);
        if(front == null){
            front = tmp; rear = tmp;
        }
        else{
            rear.next = tmp; rear = rear.next;
            rear.next = front;
        }
    }
    public void deQueue(){
        if(front != null && rear != null) {
            if (front == rear) {
                front = null; rear = null;
                System.out.println("if");
            } else {
                front = front.next;
                rear.next = front;
                System.out.println("else");
            }
        }
    }
    public void displayQueue() {
        if (front != null) {
            Node run = front;
            do {
                System.out.print(run.data + " ");
                run = run.next;
            } while (run != front);
            System.out.println();
        }
    }
}
