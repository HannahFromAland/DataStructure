public class SLList {
    private class IntNode {
        public int item;
        public IntNode next;

        IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;

    public SLList(int item, IntNode next) {
        this.first = new IntNode(item, next);
    }

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public int get(int index) {

        IntNode p = first;
        while (index > 0) {
            p = p.next;
            index--;
        }
        return p.item;
    }

    public void insert(int item, int position) {
        if (first == null || position == 0) {
            first = new IntNode(item, first);
            return;
        }
        IntNode p = first;
        while (position > 1) {
            if (p == null) {
                return;
            }
            p = p.next;
            position--;
        }
        IntNode q = p.next;
        p.next = new IntNode(item, q);

    }

    public void removeItem(int x) {
        first = removeItem(x, first);
    }

    /**
     * Using a helper method to remove recursively.
     */

    private IntNode removeItem(int x, IntNode current) {
        if (current == null) {
            return null;
        } else if (current.item == x) {
            return removeItem(x, current.next);
        } else {
            current.next = removeItem(x, current.next);
            return current;
        }

    }

    public void reverse() {
        if (first == null || first.next == null) {
            return;
        }
        IntNode pre = null;
        IntNode p = first;
        while (p != null) {
            IntNode q = p.next;
            p.next = pre;
            pre = p;
            p = q;
        }
        first = pre;
    }


}
