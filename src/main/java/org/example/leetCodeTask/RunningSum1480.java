package org.example.leetCodeTask;


import java.util.Arrays;

public class RunningSum1480 {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4};
        System.out.println(Arrays.toString(runningSum(num)));
    }

    public static int[] runningSum(int[] nums) {
        for(int i=1; i<nums.length;i++){
            nums[i]+=nums[i-1];
        }
        return nums;
    }
    public int[] runningSum2(int[] nums) {
        int[] result = new int[nums.length];
        int currentSum = nums[0];
        for(int i=0 ; i < nums.length ; i++){
            if (i==0){
                result[i] = currentSum;
            } else {
                result[i] = currentSum + nums[i];
                currentSum = result[i];
            }

        }
        return result;
    }

    public int[] runningSum3(int[] nums) {

        int length = nums.length;
        int[] result = new int[length];
        for (int i =0;i<length;i++)
        {
            int value = 0;
            for(int x = 0;x<i+1;x++)
            {
                value = value + nums[x];
            }
            result[i] = value;
        }

        return result;
    }

    public int[] runningSum4(int[] nums) {
        int[] result = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                sum += nums[j];
            }
            result[i] = sum;
            sum = 0;
        }
        return result;
    }

    public int[] runningSum5(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            ans[i] = ans[i-1] + nums[i];
        return ans;
    }

    public int[] runningSum6(int[] nums) {
        int sum = 0;
        for(int i = 0; i< nums.length; i++){
            sum += nums[i];
            nums[i] = sum;
        }
        return nums;
    }
    public int[] runningSum7(int[] nums) {
        int [] arr = new int [nums.length];
        arr[0]= nums[0];
        for(int i =1;i<nums.length; i++)
        {


            arr[i] = nums[i] + arr[i-1];
        }
        return arr;
    }
    public int[] runningSum8(int[] nums) {
        int[] ans = new int[nums.length];
        int prevSum=0;
        for(int i=0;i<nums.length;i++)
        {
            prevSum+=nums[i];
            ans[i] = prevSum;
        }
        return ans;
    }

    public int[] runningSum9(int[] nums) {
        int output[] = new int[nums.length];
        int sum= 0, index = 0;
        for (int i : nums) {
            sum= sum + i;
            output[index]= sum;
            index++;
        }
        return output;
    }

}
