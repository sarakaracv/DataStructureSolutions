package org.example.leetCodeTask;

import java.util.Stack;

public class TrappingRainWater42 {
    public static void main(String[] args) {
        int [] height={1,2,3,2,5,1,6};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int n = height.length;

        //calculate leftmax - array
        int[] leftmax = new int[n];
        leftmax[0] = height[0];
        for(int i = 1; i < n; i++) {
            leftmax[i] = Math.max(height[i], leftmax[i-1]);
        }

        //calculate rightmax - array
        int[] rightmax = new int[n];
        rightmax[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--) {
            rightmax[i] = Math.max(height[i], rightmax[i+1]);
        }

        int trappedWater = 0;
        //loop
        for(int i = 0; i < n; i++) {
            int waterlevel = Math.min(leftmax[i], rightmax[i]);
            trappedWater += waterlevel - height[i];
        }

        return trappedWater;
    }
    public int trap2(int[] height) {
        int l=height.length;

        int[] left= new int[l];
        left[0]=height[0];
        for(int i=1; i<l; i++){
            left[i]=Math.max(height[i],left[i-1]);
        }

        int[] right= new int[l];
        right[l-1]= height[l-1];
        for(int i=l-2; i>=0;i--){
            right[i]=Math.max(height[i], right[i+1]);
        }

        int water=0;
        for(int i=0; i<l; i++){
            int level= Math.min(left[i], right[i]);
            water+=level-height[i];
        }
        return water;
    }
    public int trap3(int[] height) {
        int n = height.length;
        int net_water = 0;
        int end_index = -1;
        int start_height;
        for(int i = 0 ; i < n ; i++){
            start_height = height[i];
            int end_height = 0;
            for(int j = i+1; j<n ;j++){
                if(height[j]>end_height) {
                    end_height = height[j];
                    end_index = j;
                };
                if(height[j]>=start_height){
                    end_height = height[j];
                    end_index = j;
                    break;
                }
            }
            int min_height = (start_height > end_height) ? end_height : start_height;
            int water = 0;
            for(int j = i+1 ; j<end_index ; j++){
                net_water += min_height - height[j];
            }
            net_water += water;
            if(i != end_index && end_index-1 >= i) {
                i = end_index-1;
            }
            if(i == n-1) break;
        }
        return net_water;
    }
    public int trap4(int[] height) {
        //create a left array and right array
        int n  = height.length;
        int [] left = new int [n];
        int [] right = new int [n];
        left [0] = height[0];
        for(int i = 1; i < n; i++){
            if(height[i] < left[i -1]){
                left[i] = left[i - 1];
            }
            else{
                left[i] = height[i];
            }
            // System.out.println(left[i]);
        }

        //construct a right array now
        right[n -1 ] = height[ n-1];
        for(int i = n - 2; i >= 0; i--){
            if(height[i] <= right[i + 1]){
                right[i] = right[i+ 1];
            }
            else{
                right[i] = height[i];
            }
            // System.out.println(right[i]);
        }

        int ans = 0;
        for(int i = 1; i < n -1; i++){
            int waterLevel = Math.min(left[i -1], right[i + 1]);
            int tempLevel = waterLevel - height[i];
            if(tempLevel > 0){
                ans = ans + tempLevel;
            }
        }
        return ans;

    }
    public int trap5(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.empty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current);
            current++;
        }
        return sum;
    }
}
