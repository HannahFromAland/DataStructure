public class LinkedListDeque<Item> implements Deque<Item> {
    private Node sentinel;
    private int size;

    private class Node<Item> {
        private Node prev;
        private Node next;
        private Item item;

        Node(Node prev, Node next, Item item) {
            this.prev = prev;
            this.next = next;
            this.item = item;
        }
    }

    /**
     * Initialize the LinkedListDeque
     */
    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }
    @Override
    public void addFirst(Item item) {
        Node curr = new Node(sentinel, sentinel.next, item);
        sentinel.next.prev = curr;
        sentinel.next = curr;
        size++;
    }
    @Override
    public void addLast(Item item) {
        Node curr = new Node(sentinel.prev, sentinel, item);
        sentinel.prev.next = curr;
        sentinel.prev = curr;
        size++;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        Node p = sentinel.next;
        while (p.next != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }
    @Override
    public Item removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        } else {
            Node p = sentinel.next;
            sentinel.next = p.next;
            p.next.prev = sentinel;
            size--;
            return (Item) p.item;
        }
    }
    @Override
    public Item removeLast() {
        if (sentinel.prev == sentinel) {
            return null;
        } else {
            Node p = sentinel.prev;
            sentinel.prev = p.prev;
            p.prev.next = sentinel;
            size--;
            return (Item) p.item;
        }
    }
    @Override
    public Item get(int index) {
        if (size == 0) {
            return null;
        }
        Node p = sentinel.next;
        while (index > 0) {
            p = p.next;
            index--;
        }
        return (Item) p.item;
    }
}

