package org.example.leetCodeTask;

import java.util.Stack;

public class MinStack155 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack155() {
        stack=new Stack<>();
        minStack=new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()||val<=minStack.peek()){
            minStack.push(val);
        }
    }

    public void pop() {
        int val=stack.pop();
        if(val==minStack.peek())minStack.pop();
        // if(stack.isEmpty()){ return;}
        //int popped=stack.pop();
        // if(!minStack.isEmpty()&&popped==stack.peek())minStack.pop();
    }

    public int top() {
        //  if(stack.isEmpty()) {return -1;}
        return stack.peek();

    }

    public int getMin() {
        // if(minStack.isEmpty()){ return -1;}
        return minStack.peek();

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
