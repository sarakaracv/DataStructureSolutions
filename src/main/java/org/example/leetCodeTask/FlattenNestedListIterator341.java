package org.example.leetCodeTask;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.*;

public class FlattenNestedListIterator341 {
}
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

    public class NestedIterator implements Iterator<Integer> {
        private Stack<NestedInteger> stack;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            pushListToStack(nestedList);
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty() && !stack.peek().isInteger()) {
                pushListToStack(stack.pop().getList());
            }
            return !stack.isEmpty();
        }

        private void pushListToStack(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
        }

        //second


        public class NestedIterator implements Iterator<Integer> {
            private Deque<NestedInteger> stack;

            public NestedIterator(List<NestedInteger> nestedList) {
                stack = new ArrayDeque<>(nestedList);
            }

            @Override
            public Integer next() {
                return stack.removeFirst().getInteger();
            }

            @Override
            public boolean hasNext() {
                while (!stack.isEmpty() && !stack.peekFirst().isInteger()) {
                    List<NestedInteger> nestedList = stack.removeFirst().getList();
                    for (int i = nestedList.size() - 1; i >= 0; i--) {
                        stack.addFirst(nestedList.get(i));
                    }
                }
                return !stack.isEmpty() && stack.peekFirst().isInteger();
            }
        }

    }

