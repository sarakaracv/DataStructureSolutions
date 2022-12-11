package org.example.leetCodeTask;

import java.util.Arrays;

public class SearchInsertPosition35 {
    public static void main(String[] args) {

    }
    public int searchInsert1(int[] A, int target) {
        int low = 0, high = A.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(A[mid] == target) return mid;
            else if(A[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
    public int searchInsert2(int[] nums, int target) {
        //Binary Search.
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Integer index = Arrays.binarySearch(nums, target);
        if (index < 0) {
            index = -index - 1;
        }
        return index;
    }
    public int searchInsert3(int[] nums, int target) {
        //Binary Search.
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
    public int searchInsert4(int[] A, int target) {
        if(A.length == 0)return 0;
        int left = 0, right = A.length - 1;
        int mid = 0;
        while(left <= right){
            if(target<A[left])return left;
            if(target>A[right])return right+1;

            mid = (left+right)/2;

            if(A[mid]==target)return mid;
            else if(target < A[mid]){
                right = mid-1;
            }else{
                left = mid +1;
            }
        }
        return -1;
    }
    public int searchInsert5(int[] nums, int target) {
        int n = 0;
        while(n <= nums.length-1 && nums[n] < target){
            n++;
        }
        return n;
    }
    public int searchInsert6(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        //if target > all numbers
        if(nums[hi] < target) return nums.length;
        //general binary search
        while(lo < hi) {
            int mid = lo + (hi - lo)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target){
                lo = mid + 1;
            } else {
                hi = mid;// take seriously! NOT hi = mid - 1;
            }
        }
        return  lo;
    }
    public int searchInsert7(int[] nums, int target) {
        int n = 0;
        if(nums[0]>target){
            return 0;
        }
        if(nums[nums.length-1]<target){
            return nums.length;
        }
        for(int i=0; i<nums.length; i++){
            if (nums[i]==target){
                return i;
            }
            if(nums[i]<target && nums[i+1]>target){
                return i+1;
            }
        }
        return n;
    }
}
