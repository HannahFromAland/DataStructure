package discussion03;

public class SLList {
    private class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }

        private IntNode first; //head node


        public void addFirst(int x) {
            first = new IntNode(x, first);
        }

        public void insert (int item, int position){
            if(first == null  || position == 0){
                addFirst(item);
                return;
            }else{
                IntNode p = first;
                while(position > 1 && p.next != null){
                    p = p.next;
                    position--;
                }
                IntNode curr = new IntNode(item,p.next);
                p.next =curr;
            }
        }

        public void removeItem (int x) {
            removeItemHelper(x,first);
        }

        public IntNode removeItemHelper (int x, IntNode current) {
            if(current == null) {
                return null;
            }else if(current.item ==x){
              return removeItemHelper(x,current.next); //return current node, but delete current one
            }else{
                current.next = removeItemHelper(x,current.next);
                return current;
            }
        }

        public void reverse(){
            if(first ==null || first.next==null){
                return;
            }
            IntNode p = first;
            IntNode prev = null;
            while(p!=null){
                IntNode tmp = p.next;
                p.next = prev;
                prev = p;
                p = tmp;
            }
        }

    }

}