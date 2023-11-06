import java.util.Arrays;

public class MyArrayList<E> {
    int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    Object elements[];
    MyArrayList(){

    }
    MyArrayList(int capacity){
        elements = new Object[capacity];
    }
    public void ensureCapacity(int newCapacity){
        elements = Arrays.copyOf(elements, newCapacity);
    }
    public boolean add( E element){
        if(size == elements.length)
            ensureCapacity(elements.length * 2);

        elements[size++] = element;
        return true;
    }
    public void add(int index, E element){
        if (size == elements.length)
            ensureCapacity(elements.length * 2);
        if(index <= size) {


            for(int i = elements.length - 1; i > index; i--)
            {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        }
    }
    public E remove(int index){
        E ret = (E) elements[index];
        for(int i = index; i < elements.length - 1; i++)
        {
            elements[i] = elements[i + 1];
        }
        size--;
        return ret;
    }

    public int size(){
        return size;
    }
    public MyArrayList clone(){
        MyArrayList<E> a = new MyArrayList<E>();
        a.size = this.size;
        a.elements = this.elements;
        return a;
    }
    public void show(){
        for(Object x : elements){
            if(x != null)
            System.out.println(x);
        }
    }
    public boolean contains(E e){
        for(Object x : elements){
            if(x == e){
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o){
        for(int i = 0; i < size; i++){
            if(elements[i] == o) return i;
        }
        return -1;
    }
    public E get(int i){
        return (E) elements[i];
    }
    public void clear(){
        elements = new Object[5];
        size = 0;
    }
    public static void main(String[] args) {
        MyArrayList a = new MyArrayList<>(4);
        a.add(0,2);
        a.add(1,"phuong");
        a.clear();



        a.show();
        System.out.println(a.size);
    }
}
