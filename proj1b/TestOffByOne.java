import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testOffByOne() {
        assertTrue(offByOne.equalChars('&', '%'));
    }

    @Test
    public void testOffByOne2() {
        assertTrue(offByOne.equalChars('a', 'b'));
    }

    @Test
    public void testOffByOne3() {
        assertTrue(offByOne.equalChars('r', 'q'));
    }

    @Test
    public void testOffByOne4() {
        assertFalse(offByOne.equalChars('A', 'b'));
    }
}
