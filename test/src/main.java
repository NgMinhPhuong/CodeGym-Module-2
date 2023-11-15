import java.util.PriorityQueue;

class main{
    public static void main(String[] args) {
        PriorityQueue<Integer> a = new PriorityQueue<>();
        a.offer(3);
        a.offer(20);
        a.offer(9);
        a.offer(8);
        a.offer(7);
        System.out.println(a.poll());
        System.out.println(a.poll());
        System.out.println(a.peek());

    }
}