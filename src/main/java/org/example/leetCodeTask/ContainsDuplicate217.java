package org.example.leetCodeTask;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate217 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 5, 6};
        System.out.println(containDuplicate1(nums));
    }

    public static boolean containDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;

    }
    public boolean containDuplicate2(int [] nums){
        HashMap hashMap= new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) return true;
            hashMap.put(nums[i],i);
        }
        return false;
    }
    public boolean contain(int[] nums){
        Set<Integer> set= new HashSet<>();
        for (int i = 0; i <nums.length ; i++) {
            if (!set.add(nums[i])) return true;
            
        }
        return false;
    }
}
