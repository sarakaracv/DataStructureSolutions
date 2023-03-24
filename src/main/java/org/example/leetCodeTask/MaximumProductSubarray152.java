package org.example.leetCodeTask;

public class MaximumProductSubarray152 {
    public static int maxProduct1(int [] nums){
        int max=nums[0];
        int min=nums[0];
        int result=nums[0];
        for (int i = 1; i <nums.length ; i++) {
            int cur=nums[i];
            int temp=Math.max(cur,Math.max(max*cur,min*cur));
            min=Math.min(cur,Math.min(max*cur,min*cur));
            max=temp;
            result=Math.max(result,max);
        }
        return  result;
    }

    public int maxProduct2(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int result = nums[0];
        int min = 1, max = 1;

        for(int num : nums){
            int tmp = max * num;
            max = Math.max(num, Math.max(tmp, min * num));
            min = Math.min(num, Math.min(tmp, min * num));
            result = Math.max(result, max);
        }

        return result;
    }
}
