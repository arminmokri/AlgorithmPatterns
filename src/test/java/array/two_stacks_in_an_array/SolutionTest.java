package array.two_stacks_in_an_array;

import common.PrintHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    public void testDefaultCase() {
        Solution stack = new Solution(4);

        assertTrue(stack.pushA(1));
        assertTrue(stack.pushB(7));
        assertTrue(stack.pushA(11));
        assertTrue(stack.pushB(77));

        if (PrintHelper.debug) {
            stack.printSpace();
        }

        assertFalse(stack.pushA(111));

        assertEquals(11, stack.popA());
        assertEquals(1, stack.popA());

        assertEquals(77, stack.popB());
        assertEquals(7, stack.popB());

        assertNull(stack.popA());
        assertNull(stack.popB());

        if (PrintHelper.debug) {
            stack.printSpace();
        }
    }

    @Test
    public void testPushAndPopStackA() {
        Solution stack = new Solution(5);

        assertTrue(stack.pushA(10));
        assertTrue(stack.pushA(20));
        assertEquals(20, stack.popA());
        assertEquals(10, stack.popA());
        assertNull(stack.popA());

        if (PrintHelper.debug) {
            stack.printSpace();
        }
    }

    @Test
    public void testPushAndPopStackB() {
        Solution stack = new Solution(5);

        assertTrue(stack.pushB(30));
        assertTrue(stack.pushB(40));
        assertEquals(40, stack.popB());
        assertEquals(30, stack.popB());
        assertNull(stack.popB());

        if (PrintHelper.debug) {
            stack.printSpace();
        }
    }

    @Test
    public void testOverflow() {
        Solution stack = new Solution(2);

        assertTrue(stack.pushA(1));
        assertTrue(stack.pushB(2));
        assertFalse(stack.pushA(3));
        assertFalse(stack.pushB(4));

        if (PrintHelper.debug) {
            stack.printSpace();
        }
    }

    @Test
    public void testUnderflow() {
        Solution stack = new Solution(3);

        assertNull(stack.popA());
        assertNull(stack.popB());

        if (PrintHelper.debug) {
            stack.printSpace();
        }
    }

    @Test
    public void testFullInterleavedUsage() {
        Solution stack = new Solution(4);

        assertTrue(stack.pushA(1));
        assertTrue(stack.pushB(9));
        assertTrue(stack.pushA(2));
        assertTrue(stack.pushB(8));
        assertFalse(stack.pushA(3)); // Should fail — full

        assertEquals(2, stack.popA());
        assertEquals(1, stack.popA());
        assertNull(stack.popA()); // Already empty

        assertEquals(8, stack.popB());
        assertEquals(9, stack.popB());
        assertNull(stack.popB()); // Already empty

        if (PrintHelper.debug) {
            stack.printSpace();
        }
    }

    @Test
    public void testInternalArrayIntegrity() {
        Solution stack = new Solution(5);

        stack.pushA(10);
        stack.pushA(20);
        stack.pushB(30);
        stack.pushB(40);

        assertEquals(10, stack.getMyList()[0]);
        assertEquals(20, stack.getMyList()[1]);
        assertEquals(30, stack.getMyList()[4]);
        assertEquals(40, stack.getMyList()[3]);

        if (PrintHelper.debug) {
            stack.printSpace();
        }
    }
}
