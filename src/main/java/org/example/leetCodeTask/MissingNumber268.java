package org.example.leetCodeTask;

public class MissingNumber268 {
    public static void main(String[] args) {

    }
    public int findMissingNumber(int [] nums){
        int n= nums.length;
        int expectedSum= n*(n+1)/2;
        int actualSum=0;
        for (int i = 0; i < n; i++) {
            actualSum+=nums[i];

        }
        System.gc();
        return expectedSum-actualSum;
    }
    public int missingNumber(int[] nums) {

        int total = 0;

        for(int i = 1; i <= nums.length; i++) {
            total += i;
        }

        for(int i = 0; i < nums.length; i++) {
            total -= nums[i];
        }
        System.gc();
        return total;
    }
    public int missingNumber2(int[] nums) {
            int sum = (nums.length * (nums.length + 1)) / 2;
            for (int num : nums) {
                sum -= num;
            }
            System.gc();
            return sum;
    }
}
