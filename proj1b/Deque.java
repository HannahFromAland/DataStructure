public interface Deque<Item> {
    public void addFirst(Item x);
    public void addLast(Item y);
    public int size();
    public void printDeque();
    public Item removeFirst();
    public Item removeLast();
    public Item get(int index);
    default boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

}
