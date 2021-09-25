import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
public class TestIntList {

    @Test
    public void testIntListSkip() {
        IntList p = new IntList(1,null);
        IntList q = new IntList(2,p);
        IntList r = new IntList(3,q);
        IntList s = new IntList(4,r);

        s.skippfy();
        assertEquals(4, s.get(0));
        assertEquals(2, s.get(1));
    }
}
