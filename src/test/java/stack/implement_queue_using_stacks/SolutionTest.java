package stack.implement_queue_using_stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    void testMyQueueExample1_BasicOperations() {
        Solution.MyQueue<Integer> myQueue = new Solution.MyQueueImp<>();

        // ["MyQueue", "push", "push", "peek", "pop", "empty"]
        // [[], [1], [2], [], [], []]

        // push(1)
        myQueue.push(1);

        // push(2)
        myQueue.push(2);

        // peek() -> 1
        assertEquals(1, myQueue.peek());

        // pop() -> 1
        assertEquals(1, myQueue.pop());

        // empty() -> false
        assertFalse(myQueue.empty());
    }

    @Test
    void testMyQueue_EmptyQueueInitially() {
        Solution.MyQueue<Integer> myQueue = new Solution.MyQueueImp<>();
        assertTrue(myQueue.empty());
    }

    @Test
    void testMyQueue_SingleElementPushPop() {
        Solution.MyQueue<Integer> myQueue = new Solution.MyQueueImp<>();

        myQueue.push(10);
        assertFalse(myQueue.empty());
        assertEquals(10, myQueue.peek());
        assertEquals(10, myQueue.pop());
        assertTrue(myQueue.empty());
    }

    @Test
    void testMyQueue_MultiplePushPopOrderPreserved() {
        Solution.MyQueue<Integer> myQueue = new Solution.MyQueueImp<>();

        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);

        assertEquals(1, myQueue.pop());
        assertEquals(2, myQueue.pop());
        assertEquals(3, myQueue.pop());
        assertTrue(myQueue.empty());
    }

    @Test
    void testMyQueue_PeekDoesNotRemoveElement() {
        Solution.MyQueue<Integer> myQueue = new Solution.MyQueueImp<>();

        myQueue.push(5);
        myQueue.push(6);

        assertEquals(5, myQueue.peek());
        assertEquals(5, myQueue.peek()); // peek again
        assertEquals(5, myQueue.pop());
    }

    @Test
    void testMyQueue_InterleavedOperations() {
        Solution.MyQueue<Integer> myQueue = new Solution.MyQueueImp<>();

        myQueue.push(1);
        myQueue.push(2);
        assertEquals(1, myQueue.pop());

        myQueue.push(3);
        assertEquals(2, myQueue.peek());
        assertEquals(2, myQueue.pop());
        assertEquals(3, myQueue.pop());
        assertTrue(myQueue.empty());
    }

    @Test
    void testMyQueue_LargeNumberOfElements() {
        Solution.MyQueue<Integer> myQueue = new Solution.MyQueueImp<>();

        for (int i = 0; i < 1000; i++) {
            myQueue.push(i);
        }

        for (int i = 0; i < 1000; i++) {
            assertEquals(i, myQueue.pop());
        }

        assertTrue(myQueue.empty());
    }

    @Test
    void testMyQueue_GenericTypeString() {
        Solution.MyQueue<String> myQueue = new Solution.MyQueueImp<>();

        myQueue.push("A");
        myQueue.push("B");

        assertEquals("A", myQueue.peek());
        assertEquals("A", myQueue.pop());
        assertEquals("B", myQueue.pop());
        assertTrue(myQueue.empty());
    }
}
