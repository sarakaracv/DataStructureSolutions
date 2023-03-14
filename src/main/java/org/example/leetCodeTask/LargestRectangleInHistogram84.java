package org.example.leetCodeTask;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LargestRectangleInHistogram84 {
    public static void main(String[] args) {

    }

    public int largestRectangleArea1(int[] heights) {
        int max = 0;
        int h = heights.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < h; i++) {
            while (!stack.isEmpty() && (i == h || heights[stack.peek()] >= heights[i])) {
                int height = heights[stack.peek()];
                stack.pop();
                int width;
                if (stack.isEmpty()) width = i;
                else width = i - stack.peek() - 1;
                max = Math.max(max, width * height);

            }
            stack.push(i);

        }
        return max;
    }
    public int largestRectangleArea2(int[] heights) {
        if (heights == null) throw new IllegalArgumentException("IO");
        int l = heights.length;
        if (l == 0) return 0;
        if (l == 1) return heights[0];
        Deque<Integer> dq = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i < l; i++) {
            while (!dq.isEmpty() && (i == l || heights[dq.peek()] >= heights[i])) {
                int h = heights[dq.pop()];
                int p = dq.isEmpty() ? -1 : dq.peek();
                max = Math.max(max, (i - 1 - p) * h);
            }
            dq.push(i);
        }
        return max;
    }
}
