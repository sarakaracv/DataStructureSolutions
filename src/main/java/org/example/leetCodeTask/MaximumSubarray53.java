package org.example.leetCodeTask;

public class MaximumSubarray53 {
    public static void main(String[] args) {
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println();
    }
    public static int maxSubArray(int []nums){
        int first= nums[0];
        int max= nums[0];

        for (int i=1;i<nums.length; i++ ){
            first=Math.max(nums[i],nums[i]+first);
            max=Math.max(first,max);
        }
        return max;
    }

}
