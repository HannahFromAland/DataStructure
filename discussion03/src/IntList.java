public class IntList {
    public int first;
    public IntList rest;
    public IntList(int first, IntList rest) {
        this.first = first;
        this.rest = rest;
    }

    public int get(int index) {

        IntList p = this;
        while (index > 0) {
            p = p.rest;
            index--;
        }
        return p.first;
    }

    public void skippfy() {
        IntList p = this;
        int n = 1;
        while (p != null) {
            IntList next = p.rest;
            for (int i = 0 ; i < n; i++) {
                if (next == null) {
                    break;
                }
                next = next.rest;
            }
            p.rest = next;
            n++;
            p = p.rest;
        }
    }
}
