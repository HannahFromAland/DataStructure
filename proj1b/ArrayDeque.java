public class ArrayDeque<Item> implements Deque<Item> {
    private Item[] item;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        item = (Item[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }
    @Override
    public void addFirst(Item a) {
        if (size == item.length) {
            resize(size * 2);
        }
        item[nextFirst] = a;
        size++;
        nextFirst = (nextFirst - 1 + item.length) % item.length;
    }
    @Override
    public void addLast(Item a) {
        if (size == item.length) {
            resize(size * 2);
        }
        item[nextLast] = a;
        size++;
        nextLast = (nextLast + 1) % item.length;
    }

    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        int j = 0;
        for (int i = (nextFirst + 1) % item.length; j != size; i = (i + 1) % item.length) {
            System.out.print(item[i]);
            j++;
            if (j > size) {
                break;
            }
        }
        System.out.println();
    }

    private void resize(int newSize) {
        Item[] a = (Item[]) new Object[newSize];
        int newIndex = 0;
        for (int i = (nextFirst + 1) % item.length; newIndex != size; i = (i + 1) % item.length) {
            a[newIndex] = item[i];
            newIndex++;
        }
        item = a;
        nextFirst = newSize - 1;
        nextLast = size;
    }
    @Override
    public Item removeFirst() {
        if (size == 0) {
            return null;
        } else {
            nextFirst = (nextFirst + 1) % item.length;
            Item curr = item[nextFirst];
            item[nextFirst] = null;
            size--;
            if (item.length >= 16 && (float) size / (float) item.length <= 0.25) {
                resize(size);
            }
            return curr;

        }
    }
    @Override
    public Item removeLast() {
        if (size == 0) {
            return null;
        } else {
            nextLast = (nextLast - 1 + item.length) % item.length;
            Item curr = item[nextLast];
            item[nextLast] = null;
            size--;
            if (item.length >= 16 &&  (float) size / (float) item.length <= 0.25) {
                resize(size);
            }
            return curr;
        }
    }
    @Override
    public Item get(int index) {
        return item[(nextFirst + 1 + index) % item.length];
    }
}
