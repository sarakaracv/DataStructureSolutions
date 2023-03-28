package org.example.leetCodeTask;

import java.util.Arrays;

public class HouseRobber198 {
    public int rob1(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        return dp[n-1];
    }
    public int func(int[] nums,int n,int[] dp)
    {

        if(n<0)
        {
            return 0;
        }
        if(n==0)
        {
            return  nums[0];
        }
        if(dp[n]!=-1)
        {
            return dp[n];
        }
        int lena_hai=nums[n]+func(nums,n-2,dp);
        int nahi_lena_hai=func(nums,n-1,dp);
        return  dp[n]=Math.max(lena_hai,nahi_lena_hai);
        // return dp[n];
    }
    public int rob(int[] nums) {

        int n=nums.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return func(nums,n-1,dp);

    }
    public int rob2(int[] nums) {
        int n=nums.length;
        int prev=nums[0];
        int prev2=0;
        for(int i=1;i<n;i++){
            int left=nums[i];
            if(i>1) left=nums[i]+prev2;
            int right=0+prev;
            int cur=Math.max(left,right);
            prev2=prev;
            prev=cur;
        }
        return prev;
    }
    public int rob3(int[] nums) {
       /* int incl[]=new int[nums.length];
        int excl[]=new int[nums.length];
        incl[0]=nums[0];
        excl[0]=0;
        for(int i=1;i<nums.length;i++){
            incl[i]=excl[i-1]+nums[i];
            excl[i]=Math.max(incl[i-1],excl[i-1]);
        }
        return Math.max(incl[nums.length-1],excl[nums.length-1]);*/
        int rob1=0,rob2=0,max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(nums[i]+rob1,rob2);
            rob1=rob2;
            rob2=max;
        }
        return max;
    }
    public int rob4(int[] nums) {
        return driver(nums.length-1, nums);
    }
    public int driver(int index, int[] nums){
        int prev = nums[0];
        int prev2 = 0;
        int curr=0;
        for(int i=1; i<nums.length; i++){
            curr = Math.max((nums[i]+prev2), prev);
            prev2 =prev;
            prev = curr;
        }
        return prev;
    }

}
