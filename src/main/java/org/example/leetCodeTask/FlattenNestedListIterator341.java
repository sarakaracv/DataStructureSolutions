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


// This is the interface provided by LeetCode for the NestedInteger class.
// You don't need to implement it.
interface NestedInteger {
    boolean isInteger();
    Integer getInteger();
    List<NestedInteger> getList();
}

class NestedIterator implements Iterator<Integer> {
    private Deque<Iterator<NestedInteger>> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        hasNext(); // Ensure the stack contains an iterator pointing to an integer
        return stack.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (!stack.peek().hasNext()) {
                stack.pop();
            } else {
                NestedInteger nestedInteger = stack.peek().next();
                if (nestedInteger.isInteger()) {
                    stack.push(Collections.singleton(nestedInteger).iterator());
                    return true;
                }
                stack.push(nestedInteger.getList().iterator());
            }
        }
        return false;
    }

}
// second solution

 class NestedIterator1 implements Iterator<Integer> {
    List<Integer> list=null;
    int curr=0;
    public NestedIterator1(List<NestedInteger> nestedList) {
        list=new ArrayList<>();
        for(NestedInteger i:nestedList){
            helper(i);
        }
    }

    @Override
    public Integer next() {
        return list.get(curr++);
    }

    @Override
    public boolean hasNext() {
        return curr<list.size();
    }
    public void helper(NestedInteger value){
        if(value.isInteger()) list.add(value.getInteger());
        else {
            for(NestedInteger i:value.getList())helper(i);
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

// third solution

 class NestedIterator3 implements Iterator<Integer> {

    List<Integer> result = new ArrayList<>();
    int i =0;


    public NestedIterator3(List<NestedInteger> nestedList) {
        for(int i=0;i<nestedList.size();i++) {
            if(nestedList.get(i).isInteger())
                result.add(nestedList.get(i).getInteger());
            else
                helper(nestedList.get(i));
        }
    }

    public void helper(NestedInteger data) {
        if(data.isInteger())
            result.add(data.getInteger());

        else {
            for(int i=0;i<data.getList().size();i++)
                helper(data.getList().get(i));
        }

    }

    @Override
    public Integer next() {
        return result.get(i++);
    }

    @Override
    public boolean hasNext() {
        return (i<result.size());
    }
}
