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
    public int largestRectangleArea3(int[] heights) {
        int[] left = new int[heights.length];
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0;i<heights.length;i++){
            if(st.empty())
                left[i]=1;
            else if(heights[st.peek()]<heights[i])
                left[i]=1;
            else{
                while(st.empty()==false && heights[st.peek()]>=heights[i])
                    st.pop();
                if(st.empty())
                    left[i]=i+1;
                else
                    left[i]=i-st.peek();
            }
            st.push(i);
        }
        while(st.empty()==false)
            st.pop();
        int[] right = new int[heights.length];
        for(int i=heights.length-1;i>=0;i--){
            if(st.empty())
                right[i]=1;
            else if(heights[st.peek()]<heights[i])
                right[i]=1;
            else{
                while(st.empty()==false && heights[st.peek()]>=heights[i])
                    st.pop();
                if(st.empty())
                    right[i]=heights.length-i;
                else
                    right[i]=st.peek()-i;
            }
            st.push(i);
        }
        int max=0;
        for(int i=0;i<heights.length;i++){
            if((left[i]+right[i]-1)*heights[i]>max)
                max=(left[i]+right[i]-1)*heights[i];
        }
        return max;

    }
    public int largestRectangleArea4(int[] heights) {
        int max = 0;
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            int in = i;
            while (!stack.isEmpty() && (stack.peek())[0] > heights[i]) {
                int[] temp = stack.pop();
                int area = (i - temp[1]) * temp[0];
                max = Math.max(max, area);
                in = temp[1];
            }
            stack.push(new int[] {heights[i], in});
        }
        for (int[] temp : stack) {
            int area = (heights.length - temp[1]) * temp[0];
            max = Math.max(max, area);
        }
        return max;
    }

}
