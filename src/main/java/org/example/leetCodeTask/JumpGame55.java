package org.example.leetCodeTask;

public class JumpGame55 {
    public static void main(String[] args) {
        int nums[] = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        int count=0;
        for (int i = 0; i <= count ; i++) {
            if (count < i) return true;
            count=Math.max(count,i+nums[i]);
            if (count>=nums.length-1) return true;}
        return false;
    }
}
