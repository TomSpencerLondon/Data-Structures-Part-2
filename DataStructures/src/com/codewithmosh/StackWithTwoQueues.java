package com.codewithmosh;

import java.util.ArrayDeque;
import java.util.Queue;

// We always use queue1 for pushing new items.
// When popping an item, we move all the items
// except the last one from queue1 to queue2.
//
// Q1 [10, 20, 30, 40] => Q1 [40]
// Q2 []               => Q2 [10, 20, 30]
//
// Now the item to be popped is in Q1. We remove
// and return that as the item on top of the stack.
//
// Q1 []
// Q2 [10, 20, 30]
//
// We should swap the queues, so we can repeat this
// algorithm next time we need to pop the stack.
//
// Q1 [10, 20, 30]
// Q2 []  (ready for moving items)

public class StackWithTwoQueues {
    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();
    private int top;

    // O(1)
    public void push(int item) {
        queue1.add(item);
        top = item;
    }

    // O(n)
    public int pop() {
        if (isEmpty())
            throw new IllegalStateException();

        while (queue1.size() > 1) {
            top = queue1.remove();
            queue2.add(top);
        }

        swapQueues();

        return queue2.remove();
    }

    private void swapQueues() {
        var temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // O(1)
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    // O(1)
    public int size() {
        return queue1.size();
    }

    // O(1)
    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return top;
    }

    @Override
    public String toString() {
        return queue1.toString();
    }
}
