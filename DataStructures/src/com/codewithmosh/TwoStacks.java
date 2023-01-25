package com.codewithmosh;

import java.util.Arrays;

// We could solve this problem by dividing the
// array in half and using the left and right space
// for each stack. This approach doesn't make use
// of the available space efficiently. What if we
// need more items in one stack?

// A better implementation: we need two variables
// that determine the top of each stack (top1, top2).

// For the first stack, we start filling the array
// from the left. So, top1 is initially -1 because
// the stack is empty. As we push items in the first
// stack, we increase top1.

// For the second stack, we start filling the array
// from the right. Initially, top2 is equal to
// the length of the array. As we push items to
// the second stack, we decrease top2.
//
// When pushing into either stack, we check to
// see if top1 and top2 are next to each other.
// That means both stacks are full.

public class TwoStacks {
  private int top1;
  private int top2;
  private int[] items;

  public TwoStacks(int capacity) {
    if (capacity <= 0)
      throw new IllegalArgumentException("capacity must be 1 or greater.");

    items = new int[capacity];
    top1 = -1;
    top2 = capacity;
  }

  public void push1(int item) {
    if (isFull1())
      throw new IllegalStateException();

    items[++top1] = item;
  }

  public int pop1() {
    if (isEmpty1())
      throw new IllegalStateException();

    return items[top1--];
  }

  public boolean isEmpty1() {
    return top1 == -1;
  }

  public boolean isFull1() {
    return top1 + 1 == top2;
  }

  public void push2(int item) {
    if (isFull2())
      throw new IllegalStateException();

    items[--top2] = item;
  }

  public int pop2() {
    if (isEmpty2())
      throw new IllegalStateException();

    return items[top2++];
  }

  public boolean isEmpty2() {
    return top2 == items.length;
  }
  public boolean isFull2() {
    return top2 - 1 == top1;
  }

  @Override
  public String toString() {
    return Arrays.toString(items);
  }
}
