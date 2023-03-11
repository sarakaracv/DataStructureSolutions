package org.example.leetCodeWithNode;

import java.util.Arrays;

public class SortColors75 {
    public static void main(String[] args) {
        int[]nums={1,2,3};
        sortColors(nums);
        System.out.println(nums);
    }
    public static void sortColors(int[] nums) {
        Arrays.sort(nums);
        return;
    }
    public void sortColors2(int[] nums) {
        int a = -1, b = 0, c = nums.length;
        while (b < c) {
            if (nums[b] == 0) {
                int temp = nums[++a];
                nums[a] = 0;
                nums[b++] = temp;
            } else if (nums[b] == 2) {
                nums[b] = nums[--c];
                nums[c] = 2;
            } else {
                b++;
            }
        }
    }
    public void sortColors3(int[] nums) {
        //1-pass
        int p1 = 0, p2 = nums.length - 1, index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;
            }
            index++;
        }
    }
    public void sortColors4(int[] nums) {
        int left = 0;


        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 0){
                swap(nums, left++, i);
            }
        }
        for(int i = left;i < nums.length;i++){
            if(nums[i] == 1){
                swap(nums, left++, i);
            }
        }
    }
    public void swap(int nums[], int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
