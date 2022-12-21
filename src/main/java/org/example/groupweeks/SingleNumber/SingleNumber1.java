package org.example.groupweeks.SingleNumber;

import java.util.Arrays;

public class SingleNumber1 {
    public static void main(String[] args) {
        int nums[]={2,2,1};
        int nums2[]={8,5,5,8,6,4,4};
        System.out.println(singleNumber(nums2));

        SingleNumberWtihxor singleNumberWtihxor=new SingleNumberWtihxor();
        System.out.println(singleNumberWtihxor.singleNumberXOR(nums));
    }
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int lastindex=nums.length-1;
        for (int i=0; i<lastindex; i+=2){
            if (lastindex==1){
                return nums[0];
            }else if (nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return nums[0];
    }
}