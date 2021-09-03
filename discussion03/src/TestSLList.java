import org.junit.Test;
import static org.junit.Assert.*;

public class TestSLList {
    @Test
    public void testSLListInsert() {
        SLList a = new SLList(1, null);
        a.addFirst(2);
        a.addFirst(3);
        a.addFirst(4);
        a.insert(5, 0);
        a.insert(0, 4);
        a.insert(6, 2);
        assertEquals(5, a.get(0));
        assertEquals(6, a.get(2));
        assertEquals(0, a.get(5));
    }

    @Test
    public void testSLListRemove() {
        SLList a = new SLList(1, null);
        a.addFirst(2);
        a.addFirst(2);
        a.addFirst(4);
        a.removeItem(2);
        assertEquals(4, a.get(0));
        assertEquals(1, a.get(1));
    }

    @Test
    public void testSLListReverse() {
        SLList a = new SLList(1, null);
        a.addFirst(2);
        a.addFirst(3);
        a.addFirst(4);
        a.reverse();
        assertEquals(1, a.get(0));
        assertEquals(2, a.get(1));
        assertEquals(3, a.get(2));
        assertEquals(4, a.get(3));

        a = new SLList(1, null);
        a.reverse();
        assertEquals(0, a.get(0));


    }


}

