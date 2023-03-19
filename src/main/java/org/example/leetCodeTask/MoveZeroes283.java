package org.example.leetCodeTask;

import java.util.Arrays;

public class MoveZeroes283 {
    public static void main(String[] args) {

    }
    public void moveZeroes(int [] nums){
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[count++] = nums[i];
            }
        }
            while (count<nums.length){
                nums[count++]=0;
            }
        }
    }
