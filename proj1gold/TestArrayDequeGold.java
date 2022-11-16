import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

public class TestArrayDequeGold {
    @Test
    public void testRandom() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        String message = "";

        for (Integer i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                sad.addLast(i);
                ads.addLast(i);
                message += "addLast(" + i + ") \n";
            } else {
                sad.addFirst(i);
                ads.addFirst(i);
                message += "addFirst(" + i + ") \n";
            }
        }
        for (int i = 0; i < 10; i++) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            Integer actual;
            Integer expected;
            if (numberBetweenZeroAndOne < 0.5) {
                actual = sad.removeLast();
                expected = ads.removeLast();
                message += "removeLast() \n";
            } else {
                actual = sad.removeFirst();
                expected = ads.removeFirst();
                message += "removeFirst() \n";
            }
            assertEquals(message, expected, actual);
        }

    }
}
