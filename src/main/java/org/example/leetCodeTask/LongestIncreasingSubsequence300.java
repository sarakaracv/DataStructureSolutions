package org.example.leetCodeTask;

import java.util.*;

public class LongestIncreasingSubsequence300 {

        public int lengthOfLIS1(int[] nums) {
            int n= nums.length;
            int [] dp= new int[n];

            int max=1;
            Arrays.fill(dp,max);
            for (int i=1; i<n;i++){
                for (int j=0;j<i;j++){
                    if (nums[i]>nums[j]){
                        dp[i]=Math.max(dp[i],dp[j]+1);
                    }
                }
                max=Math.max(max,dp[i]);
            }
            return max;
        }
    public int lengthOfLIS2(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size];
        dp[0] = nums[0];
        int max = 1;

        int j = 0;
        for(int i = 1; i< size; i++) {
            if(nums[i] > dp[j]) {
                j = j+1;
                dp[j] = nums[i];
                max++;
            } else {
                int ref = j;
                while(ref>=0 && dp[ref] >= nums[i]) {
                    ref--;
                }
                dp[ref+1] = nums[i];
            }
        }
        return max;
    }
    public int lengthOfLIS3(int[] nums) {
        LinkedList<Integer> lis = new LinkedList<>();
        for (int n : nums) {
            if (lis.isEmpty() || lis.getLast() < n) {
                lis.add(n);
            } else {
                int i = lis.size() - 1;
                for (; i >= 0 && lis.get(i) >= n; i--);
                lis.set(i + 1, n);
            }
        }

        return lis.size();
    }
    public int lengthOfLIS4(int[] nums) {
        int max = 0;
        final TreeMap<Integer, Integer> checkpoints = new TreeMap<>();
        final Map<Integer, Integer> freqs = new HashMap<>();
        for (final int num: nums) {
            final Integer prev = checkpoints.floorKey(num - 1);
            final int count = (prev == null ? 0 : checkpoints.get(prev)) + 1;
            checkpoints.put(num, count);
            if (freqs.get(count) == null) {
                freqs.put(count, num);
            } else if (freqs.get(count) > num) {
                checkpoints.remove(freqs.get(count));
                freqs.put(count, num);
            }
            max = Math.max(max, count);

        }
        return max;
    }
    public int lengthOfLIS5(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i]>dp.get(dp.size()-1))
                dp.add(nums[i]);
            else{
                int[] arr = dp.stream().mapToInt(Integer::intValue).toArray();
                int index = Arrays.binarySearch(arr,nums[i]);
                if(index<0){
                    if(Math.abs(index)-1==0)
                        index=0;
                    else if(Math.abs(index)>=dp.size())
                        index = dp.size()-1;
                    else
                        index = Math.abs(index)-1;
                }
                dp.set(index,nums[i]);

            }
        }
        return dp.size();
    }
    public int lengthOfLIS6(int[] nums) {
        List<Integer> memory = new ArrayList<>();

        for (int i = nums.length - 1; i >=0; i--) {
            int candidate = nums[i];
            int length = 0;
            for (Integer best : memory){
                if (candidate < best) {
                    length++;
                }
            }

            if (length == memory.size()){
                memory.add(candidate);
            } else {
                memory.set(length, Math.max(candidate, memory.get(length)));
            }
        }

        return memory.size();
        }
    public int lengthOfLIS7(int[] nums) {
        int []dp=new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=0; i<nums.length; i++){
            for(int j=i-1; j>=0; j--){
                if(dp[j]>=dp[i] && nums[j]<nums[i]){
                    dp[i]=dp[j]+1;

                }
            }
        }
        int max=0;
        for(int i=0; i<dp.length; i++){
            if(max<dp[i]){
                max=dp[i];
            }
        }
        return max;
    }
    public int lengthOfLIS8(int[] nums) {
        int maxLen = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i=1;i<nums.length;i++){
            int max = 1;
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    max = Math.max(max, dp[j]);
                    dp[i] = max+1;
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for(int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }
    }


