public class MyLinkedList <E> {
    Node head;
    int numNodes = 0;

    class Node {
        Node next;
        Object data;

        Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }

    MyLinkedList() { //---------

    }

    public void addFirst(E e) { //----------
        Node tmp = new Node(e);
        if (numNodes == 0) {
            head = tmp;
            numNodes++;
        } else {
            tmp.next = head;
            head = tmp;
            numNodes++;
        }
    }

    public void addLast(E e) { //----------
        Node tmp = new Node(e);
        if (numNodes == 0) {
            head = tmp;
            numNodes++;
        } else {
            Node run = head;
            while (run.next != null) {
                run = run.next;
            }
            run.next = tmp;
            numNodes++;
        }
    }

    public void show() { //---------
        Node run = head;
        while (run != null) {
            System.out.print(run.data + " ");
            run = run.next;
        }
        System.out.println();
    }

    public void add(int index, E element) {//----------
        Node tmp = new Node(element);
        if (index >= 0 && index <= numNodes) {
            if (index == 0) addFirst(element);
            else if (index == numNodes) addLast(element);
            else {
                Node run = head;
                for (int i = 1; i < index; i++) {
                    run = run.next;
                }
                Node last = run.next.next;
                run.next = tmp;
                tmp.next = last;
                numNodes++;
            }
        }
    }

    public E remove(int index) { //------------
        E ret;
        if (index >= 0 && index < numNodes) {
            if (index == 0) {
                if (numNodes == 0) {
                    System.out.println("ko co j de xoa");
                } else {
                    ret = (E) head.data;
                    head = head.next; numNodes--;
                    return ret;
                }
            } else if (index == numNodes - 1) {
                Node run = head;
                while (run.next.next != null) {
                    run = run.next;
                }
                ret = (E) run.next.data;
                run.next = null; numNodes--;
                return ret;
            } else {
                Node run = head;
                for (int i = 1; i < index; i++) {
                    run = run.next;
                }
                ret = (E) run.next.data;
                run.next = run.next.next; numNodes--;
                return ret;
            }
        }
        return null;
    }
    public boolean remove(Object e){ //-----------
        if(numNodes == 0) return false;
        Node run = head;
        int size = numNodes;
        int indexDel = 0;
        for(int i = 0; i < size  ; i++){
            if((E) run.data == (E) e){
                    run = run.next;
                remove(indexDel);
            }
            else{

                run = run.next;
                indexDel++;
            }
        }
        return true;
    }

    public int size(){ //----------
        return this.numNodes;
    }

    public MyLinkedList<E> clone(){ //-----------
        MyLinkedList<E> a = new MyLinkedList<>();
        if(this.numNodes > 0) {

            a.numNodes = this.numNodes;

            Node copyy;
            Node run = head;
            copyy = new Node(run.data);
            Node luu = copyy;
            run = run.next;
            while (run != null) {
                copyy.next = new Node(run.data);
                copyy= copyy.next;
                run = run.next;
            }
            a.head = luu;
        }
        return a;
    }

    public boolean contains(E o){ //-------
        Node run = head;
        while(run != null){
            if((E)run.data == o){
                return true;
            }
            run = run.next;
        }
        return false;
    }
    public int indexOf(E o){ //-----
        int i = 0;
        Node run = head;
        while(run != null){
            if((E) run.data == o){
                return i;
            }
            run = run.next;
            i++;
        }
        return -1;
    }

    public E get(int index){
        if(numNodes > 0 && index >= 0 && index < numNodes) {
            Node run = head;
            for (int i = 0; i < index; i++) {
                run = run.next;
            }
            return (E) run.data;
        }
        return  null;
    }

    public E getFirst(){
        if(numNodes > 0){
            return (E) head.data;
        }
        return null;
    }

    public E getLast(){
        if(numNodes > 0){
            Node run = head;
            while(run.next != null){
                run = run.next;
            }
            return (E) run.data;
        }
        return null;
    }


}
