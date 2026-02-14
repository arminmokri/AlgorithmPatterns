package stack.implement_queue_using_stacks;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    interface MyQueue<E> {
        void push(E x);

        E pop();

        E peek();

        boolean empty();
    }

    static class MyQueueImp<E> implements MyQueue<E> {

        private final Deque<E> stack1;
        private final Deque<E> stack2;

        public MyQueueImp() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        @Override
        public void push(E e) {

            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }

            while (!stack2.isEmpty()) {
                stack1.add(stack2.pop());
            }
            stack1.add(e);
        }

        @Override
        public E pop() {
            if (!stack1.isEmpty()) {
                return stack1.pop();
            } else {
                return null;
            }
        }

        @Override
        public E peek() {
            if (!stack1.isEmpty()) {
                return stack1.peek();
            } else {
                return null;
            }
        }

        @Override
        public boolean empty() {
            return stack1.isEmpty();
        }
    }

}
