package org.example.leetCodeTask;

import java.util.Stack;

public class FindPeakElement162 {
    public int findPeekElement(int []nums){
        int left=0,right= nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if (nums[mid]<nums[mid+1]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
    public int findPeakElement2(int[] nums) {
        int max=Integer.MIN_VALUE;
        int index=0;
        for(int i =0; i<nums.length; i++){
            if(nums[i]>max){
                max= nums[i];
                index=i;
            }
        }
        return index;
    }
    public int findPeekElement5(int [] nums){// it is not passed
        Stack<Integer> stack= new Stack<>();
        stack.push(0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>nums[i-1]) stack.push(i);
            else{
                while(!stack.isEmpty()&&nums[i]<nums[stack.peek()]){
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return stack.pop();
    }
}
