import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArraySet<T> implements Iterable<T> {
    private T[] set;
    private int size;

    public ArraySet() {
        set = (T[]) new Object[100];
        size = 0;

    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for (int i = 0; i < size; i++) {
            if (set[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map.
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if (x == null) {
            throw new IllegalArgumentException("can't add null");
        }
        if (contains(x)) {
            return;
        } else {
            set[size] = x;
            size++;
        }
        return;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    /* returns an iterator (a.k.a. seer) into ME */
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T> {
        private int wizPos;

        public ArraySetIterator() {
            wizPos = 0;
        }
        public boolean hasNext() {
            return wizPos < size;
        }
        public T next() {
            T curr = set[wizPos];
            wizPos += 1;
            return curr;
        }
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("{");
//        for (int i = 0; i < size - 1; i++) {
//            sb.append(set[i]);
//            sb.append(",");
//        }
//        sb.append(set[size - 1]);
//        sb.append("}");
//        return sb.toString();
//    }

    @Override
    public String toString() {
        List<String> listOfItem = new ArrayList<>();
        for (T item: this) {
            listOfItem.add(item.toString());
        }
        return "{" + String.join(", ", listOfItem) + "}";
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        // check if the class of other is not the same as this
        if (this.getClass() != other.getClass()) {
            return false;
        }
        ArraySet<T> o = (ArraySet<T>) other;
        if (o.size() != this.size()) {
            return false;
        }
        for (T item: o) {
            if (!this.contains(item)) {
                return false;
            }
        }
        return true;
    }

    public static <G> ArraySet<G> of(G... stuff) {
        ArraySet<G> res = new ArraySet<>();
        for (G item : stuff) {
            res.add(item);
        }
        return res;
    }

    public static void main(String[] args) {
        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);
        ArraySet cset = aset;
        ArraySet<Integer> bset = new ArraySet<>();
        bset.add(5);
        bset.add(23);
        bset.add(433);
        //iteration
        for (int i : aset) {
            System.out.println(i);
        }
        System.out.println(aset.toString());
        ArraySet<Integer> ss = ArraySet.of(1,34,54);
        System.out.println(ss.toString());
    }

    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}
