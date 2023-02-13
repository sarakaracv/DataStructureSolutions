package org.example.leetCodeTask;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindFirstAndLastPositionOfElementInSortedArray34 {
    public static void main(String[] args) {

        int[]arr= {1,2,8,8,3,5};
        System.out.println(Arrays.toString(searchRange1(arr,8)));

    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                ans[0] = i;
                while(i<nums.length && nums[i] == target){
                    ans[1] = i;
                    i++;

                }
                break;
            }
        }
        return ans;
    }

    public static int[] searchRange1(int[] nums, int target) {
        int[] arr=new int[2];
        int m=0;
        for(int i=0;i<nums.length;i++)
            if(nums[i]==target){
                if(m==0)
                    arr[0]=arr[1]=i;
                else
                    arr[1]=Math.max(arr[1], i);
                m++;
            }
        if(m<1){
            return new int[]{-1,-1};
        } else return arr;

    }
}
