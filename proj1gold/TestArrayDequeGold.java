import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestArrayDequeGold {
    @Test
    public void testRandom() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        String action = "\n";
        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                sad.addLast(i);
                ads.addLast(i);
                action+="addLast(" + i +") \n";
            } else {
                sad.addFirst(i);
                ads.addFirst(i);
                action+="addFirst(" + i +") \n";
            }
        }

        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (sad.size() == 0 || ads.size() == 0) {
                break;
            }
            Integer actual;
            Integer expected;
            if (numberBetweenZeroAndOne < 0.5) {
                actual = sad.removeFirst();
                expected = ads.removeFirst();
                action+="removeFirst() \n";
            } else {
                actual = sad.removeLast();
                expected = ads.removeLast();
                action+="removeLast() \n";
            }

            assertEquals(action, expected, actual);
        }

    }
}
