public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> a = new MyLinkedList<>();
        a.addFirst(3);
        a.addFirst(4);
        a.addLast(2);

        MyLinkedList<Integer> b = a.clone();
        b.addLast(1);
        a.show();
        b.show();
    }
}
