package org.example.leetCodeTask;

import java.util.HashMap;
import java.util.Map;

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
    public int[] twoSum3(int[] nums, int target)
    {
        int output[] = new int[2];

        Map<Integer, Integer> map = new HashMap<>();


        //When put (key, value) with existing key  - the map will update the value to the new one
        for(int i=0; i < nums.length;i++)
        {
            map.put(nums[i], i);
        }

        for(int i = 0 ;i < nums.length;i++)
        {
            int key = target - nums[i];
            int value = map.getOrDefault(key, -1);

            if(value != -1 && value != i) return new int[] {value, i};
        }


        System.out.println(">>map = " + map);




        return new int[] {-1,-1};
    }
    public int[] twoSum4(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = numToIndex.get(target - nums[i]);
            if (index != null) {
                return new int[] {i, index};
            }
            numToIndex.put(nums[i], i);
        }
        return null;
    }
    public int[] twoSum5(int[] nums, int target) {
        final Map<Integer, Integer> diffs = new HashMap<>();
        diffs.put(target - nums[0], 0);

        final int len = nums.length;
        for (int i = 1; i < len; i += 1) {
            int num = nums[i];
            if (diffs.containsKey(num))
                return new int[] { diffs.get(num), i};
            else
                diffs.put(target - num, i);
        }
        return null;
    }
    public int[] twoSum6(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int nf = target-nums[i];
            if(map.containsKey(nf))
                return new int [] {i,map.get(nf)};
            map.put(nums[i],i);
        }
        return null;
    }

    public int[] twoSum7(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i=0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public int[] twoSum8(int[] nums, int target) {

        int[] bob = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int x = i+1; x < nums.length; x++){
                if(nums[i]+nums[x]==target){
                    bob[0]=i;
                    bob[1]=x;
                }
            }
        }
        return(bob);
    }
    public int[] twoSum9(int[] nums, int target) {
        // cretae a new hashmap
        HashMap<Integer, Integer> numsKey = new HashMap<>();

        for(int i = 0; i < nums.length; i++){

            if(numsKey.containsKey(target - nums[i])){
                return new int[] {numsKey.get(target - nums[i]), i};
            }
            else{
                numsKey.put(nums[i], i);
            }
        }
        return null;
    }
    public int[] twoSum10(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};
    }
    public int[] twoSum11(int[] nums, int target) {
        int complement;

        for (int x = 0; x<nums.length; x++) {
            complement = target - nums[x];

            for (int y = 0; y<nums.length; y++) {

                if (x ==  y) { continue; }
                if (nums[y] == complement) {
                    return new int[] {x, y};
                }
            }
        }
        return new int[] {0, 0};
    }
    public int[] twoSum12(int[] nums, int target) {
        for(int i=0; i < nums.length; i++){
            for(int j=i+1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if(sum == target) {
                    nums = new int[]{i, j};
                    System.gc();
                }
            }
        }
        return nums;
    }
}
