package org.example.leetCodeTask;

import java.util.HashMap;

public class TwoSum1 {
    public static void main(String[] args) {

    }
    public int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> tracker = new HashMap<Integer, Integer>();
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(tracker.containsKey(nums[i])){
                int left = tracker.get(nums[i]);
                return new int[]{left+1, i+1};
            }else{
                tracker.put(target - nums[i], i);
            }
        }
        return new int[2];
    }
    public int[] twoSum2 (int[] nums, int target) {
        if (nums == null || nums.length < 2)
            return null;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.println(i + " " + j);
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }
}
