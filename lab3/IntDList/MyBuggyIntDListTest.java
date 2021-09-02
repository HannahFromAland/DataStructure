import org.junit.Test;
import static org.junit.Assert.*;


public class MyBuggyIntDListTest {
    private BuggyIntDList l, m;

    @Test
    public void testMyBuggyMerge() {
        l = new BuggyIntDList();
        m = new BuggyIntDList();
        l.mergeIntDList(m);
        assertEquals("Size after merge should be 0", 0, l.size());

        l = new BuggyIntDList(1);
        m = new BuggyIntDList(3, 5, 7);
        l.mergeIntDList(m);
        assertEquals("Size after merge should be 4", 4, l.size());
        assertEquals(".getFront() should be 1", 1, l.getFront());
        assertEquals(".getBack() should be 7", 7, l.getBack());
        assertEquals("First item should be 1", 1, l.get(0));
        assertEquals("Last item should be 7", 7, l.get(-1));
    }
}

