package org.example.leetCodeTask;

public class IncreasingTripletSubsequence334 {
    public boolean increasingTriplet1(int[] nums) {
        if(nums == null || nums.length < 3) {
            return false;
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int num : nums) {
            if(num <= first) {
                first = num;
            } else if(num <= second) {
                second = num;
            } else {
                return true;
            }
        }

        return false;
    }
    public boolean increasingTriplet2(int[] nums) {
        int[] preMin = new int[nums.length];

        preMin[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preMin[i] = Math.min(preMin[i - 1], nums[i]);
        }

        int max = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (preMin[i] < nums[i] && nums[i] < max) {
                return true;
            }
            max = Math.max(max, nums[i]);
        }

        return false;
    }
    public boolean increasingTriplet3(int[] nums) {
        Integer[] arr = new Integer[2];
        for (int num : nums) {
            if (arr[1] != null && arr[1] < num) return true;

            if (arr[1] != null) {
                if (arr[0] < num && num <= arr[1]) arr[1] = num;
                else if (num <= arr[0])            arr[0] = num;
            } else if (arr[0] != null) {
                if (num < arr[0])      arr[0] = num;
                else if (arr[0] < num) arr[1] = num;
            } else {
                arr[0] = num;
            }
        }
        return false;
    }
    public boolean increasingTriplet4(int[] nums) {
        int n = nums.length;
        int maxArray[] = new int [n];
        int minArray[] = new int[n];
        int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE;
        int count = 0;
        for(int num:nums) {
            min = Math.min(min , num);
            minArray[count++] = min;
        }
        for(int i = n-1 ; i>=0 ; i--) {
            max = Math.max(max , nums[i]);
            maxArray[i] = max;
        }
        for(int i = 0 ; i<n ; i++) {
            if(nums[i]<maxArray[i] && nums[i]>minArray[i])
                return true;
        }
        return false;
    }

}
