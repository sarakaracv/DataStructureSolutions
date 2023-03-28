package org.example.leetCodeTask;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumII4_454 {
    public int fourSumCount1(int []A, int[]B,int[]C, int D[]){
        Map<Integer,Integer> mp= new HashMap<>();
        int count=0;

        for(int a:A){
            for(int b:B){
                int sum=a+b;
                mp.put(sum,mp.getOrDefault(sum,0)+1);
            }
        }
        for(int c:C){
            for(int d:D){
                int neg=-(c+d);
                count+=mp.getOrDefault(neg,0);
            }
        }
        return count;
    }
    public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> counter = new HashMap<>();
        for(int n1 : nums1) {
            for(int n2 : nums2) {
                counter.put(n1 + n2, counter.getOrDefault(n1 + n2, 0) + 1);
            }
        }
        int res = 0;
        for(int n3 : nums3) {
            for(int n4 : nums4) {
                if(counter.containsKey(-n3 - n4)) {
                    res += counter.get(-n3 - n4);
                }
            }
        }
        return res;
    }
    public int fourSumCount3(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer, Integer> m = new HashMap<>();

        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                m.put(sum, m.getOrDefault(sum, 0) + 1);
            }
        }

        for (int c : nums3) {
            for (int d : nums4) {
                int sum = c + d;
                count += m.getOrDefault(-1 * sum, 0);
            }
        }

        return count;
    }
    public int fourSumCount4(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        for(int k:nums3){
            for(int l:nums4){
                map.put(k+l,map.getOrDefault(k+l,0)+1);
            }
        }
        for(int i:nums1){
            for(int j:nums2){
                count+=map.getOrDefault(-(i+j),0);
            }
        }
        return count;
    }
    public int fourSumCount5(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> hashmap = new HashMap<>();

        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                int temp = hashmap.getOrDefault(nums1[i] + nums2[j], 0);
                hashmap.put(nums1[i] + nums2[j], temp + 1);
            }
        }
        int count = 0;
        for(int i = 0; i < nums3.length; i++){
            for(int j = 0; j < nums4.length; j++){
                int temp = nums3[i] + nums4[j];
                if(hashmap.containsKey(-temp)){
                    count += hashmap.get(-temp);
                }
            }
        }
        return count;
    }
    public int fourSumCount6(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Arrays.sort(nums3);
        Arrays.sort(nums4);
        int count = 0;

        var map = new HashMap<Integer, Integer>();
        for (int m: nums1) {
            for (int n: nums2) {
                map.compute(m + n, (k, v) -> v == null ? 1: v + 1);
            }
        }

        for (int m: nums3) {
            for (int n: nums4) {
                count += map.getOrDefault(-(m + n),0);
            }
        }

        return count;
    }
    public int fourSumCount7(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> m1= new HashMap<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Arrays.sort(nums3);
        Arrays.sort(nums4);
        for(int i : nums1)
            for(int j :nums2)
                m1.put(i+j,m1.getOrDefault(i+j,0)+1);

        int ans=0;
        for(int i : nums3)
            for(int j :nums4)
                ans+=m1.getOrDefault(-(i+j),0);

        return ans;
    }
}
