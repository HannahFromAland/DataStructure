public class ArrayDeque<Item> {
    private Item[] item;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        item = (Item[]) new Object[100];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    private void resize(int capacity){
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(item, 0, a ,0 ,size);
        item = a;
    }

    public void addFirst(Item a) {
        if(size ==item.length){
            resize(size *2);
        }
        item[nextFirst] = a;
        size++;
        nextFirst = (nextFirst-1+item.length)%item.length;
    }

    public void addLast(Item a){
        if(size == item.length){
            resize(size *2);
        }
        item[nextLast] = a;
        size++;
        nextLast = (nextLast+1)%item.length;
    }

    public boolean isEmpty(){
        if(size == 0) return true;
        else return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for(int i = (nextFirst+1)% item.length ;i<nextLast;i = (i+1)% item.length){
            System.out.print(item[i]);
        }
        System.out.println();
    }

    public Item removeFirst(){
        if(size == 0){
            return null;
        }else{
            nextFirst = (nextFirst+1)% item.length;
            Item curr = item[nextFirst];
            item[nextFirst] = null;
            size--;
            if((float)item.length/(float)size <=0.25){
                resize(size);
            }
            return curr;

        }
    }

    public Item removeLast(){
        if(size == 0){
            return null;
        }else{
            nextLast = (nextLast-1+item.length)% item.length;
            Item curr = item[nextLast];
            item[nextLast] = null;
            size--;
            if((float)item.length/(float)size <=0.25){
                resize(size);
            }
            return curr;
        }
    }

    public Item get(int index){
        return item[(nextFirst+1+index)%item.length];
    }

}
