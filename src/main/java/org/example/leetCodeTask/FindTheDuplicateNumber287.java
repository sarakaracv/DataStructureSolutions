package org.example.leetCodeTask;

public class FindTheDuplicateNumber287 {
    public int findDuplicate1(int[] nums) {
        int left = nums[0];
        int right = nums[0];
        do {
            left = nums[left];
            right = nums[nums[right]];
        } while (left != right);
        int part1 = nums[0];
        int part2 = left;
        while (part1 != part2) {
            part1 = nums[part1];
            part2 = nums[part2];
        }
        return part1;
    }
    public int findDuplicate2(int[] nums) {
        boolean [] arr= new boolean[nums.length+1];
        for(int i:nums){
            if (arr[i]==true)return i;
        }
        return -1;
    }
    public int findDuplicate3(int[] nums) {
        boolean nums1[] = new boolean[nums.length];
        for(int i=0; i<nums.length; i++){
            if(!nums1[nums[i]]){
                nums1[nums[i]] = true;
            } else{
                return nums[i];
            }
        }
        return 0;
    }
    public int findDuplicate4(int[] nums) {
        int k=0,st=0;
        int a[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){k=nums[i];
            if(a[k]==0)a[k]=k;
            else st=k;}
        return st;
    }
    public int findDuplicate5(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] != i+1) {
                int correct = nums[i] - 1;

                if(nums[i] != nums[correct]) {
                    swap(nums, i, correct);
                } else {
                    return nums[i];
                }
            } else {
                i++;
            }
        }

        return -1;
    }

    public void swap(int[] arr, int a, int b) {

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }
    public int findDuplicate6(int[] nums) {
        int i=0;
        while(i<nums.length){
            if(nums[i]==nums[nums[i]-1]){
                i++;
            }
            else{
                swap(nums,i, nums[i]-1);
            }
        }
        for(i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return nums[i];
            }
        }
        return -1;
    }
    public int findDuplicate7(int[] nums) {
        //first paragraph of the problem description is important
        //because we need to traverse with pointers to the array,
        // but we do not know
        //what we can use as index. In this point, max int in the array
        // + 1 is must be equal to the length of array. So we can use
        //integers as index.

        int fast = 0;
        int slow = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }
        int slow2 = 0;
        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if (slow == slow2) return slow;
        }

    }

}
