
public class LinkedListDeque<T> {
    private Node sentinel;
    private int size;

    private class Node<T> {
        private Node prev;
        private Node next;
        private T item;

        public Node(Node prev, Node next, T item) {
            this.prev = prev;
            this.next = next;
            this.item = item;
        }

        public Node() {
            prev = null;
            next = null;
            item = null;
        }
    }

    /**
     * Initialize the LinkedListDeque
     */
    public LinkedListDeque() {
        size = 0;
        sentinel = new Node();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(T item) {
        Node curr = new Node(sentinel, sentinel.next, item);
        sentinel.next.prev = curr;
        sentinel.next = curr;
        size++;
    }

    public void addLast(T item) {
        Node curr = new Node(sentinel.prev, sentinel, item);
        sentinel.prev.next = curr;
        sentinel.prev = curr;
        size++;
    }

    public boolean isEmpty() {
        if (size == 0) return true;
        else return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = sentinel.next;
        while (p.next != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (sentinel.next == sentinel){
            return null;
        }else{
            Node p = sentinel.next;
            sentinel.next = p.next;
            p.next.prev = sentinel;
            size--;
            return (T) p.item;
        }
    }

    public T removeLast(){
        if(sentinel.prev ==sentinel){
            return null;
        }else{
            Node p = sentinel.prev;
            sentinel.prev = p.prev;
            p.prev.next = sentinel;
            size--;
            return (T) p.item;
        }
    }

    public T get(int index){
        if(size == 0){
            return null;
        }
        Node p = sentinel.next;
        while(index >0){
            p = p.next;
            index--;
        }
        return (T) p.item;
    }

    public T getRecursive(int index){
        return (T) getRecursiveHelper(sentinel.next,index);
    }

    private T getRecursiveHelper(Node p, int index){
        if(index == 0){
            return (T) p.item;
        }else{
            return (T) getRecursiveHelper(p.next,index-1);
        }
    }
}
