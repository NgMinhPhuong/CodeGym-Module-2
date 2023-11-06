public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> a = new MyLinkedList<>();
        a.addFirst(3);
        a.addFirst(3);
        a.addLast(1);
        a.addLast(2);
        a.addLast(4);
        a.addLast(3);
        a.addLast(7);
        a.addLast(3);
        a.show();
        a.remove((Object) 3);
        a.show();
        System.out.println(a.contains(2));
        System.out.println(a.indexOf(4));
        System.out.println(a.get(3));
        System.out.println(a.getFirst());
        System.out.println(a.getLast());
        Object c = 2;
        if(c instanceof Integer) System.out.println("yes");


    }
}
