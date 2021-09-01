public interface Deque<Item> {
    void addFirst(Item x);
    void addLast(Item y);
    int size();
    void printDeque();
    Item removeFirst();
    Item removeLast();
    Item get(int index);
    default boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

}
