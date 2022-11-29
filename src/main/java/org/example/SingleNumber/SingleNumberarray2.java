package org.example.SingleNumber;

import java.util.Arrays;

public class SingleNumberarray2 {
    public int singleNumber(int[] nums) {
        int i;
        Arrays.sort(nums);
        for (i = 0 ; i < nums.length-1 ; i++){
            if(nums[i] != nums[i+1]){
                break;
            }
            else {
                i++;
            }
        }
        return nums[i];
    }
}
