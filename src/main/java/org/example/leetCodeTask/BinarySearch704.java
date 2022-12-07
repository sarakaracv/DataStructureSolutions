package org.example.leetCodeTask;

import java.util.Arrays;

public class BinarySearch704 {
    public static void main(String[] args) {

    }
    public int search(int[] nums, int target) {

        for(int i =0; i< nums.length; i++){
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }
    public int search1(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid = (start+end)/2;
        while(start <= end){
            if(nums[mid] == target) return mid;
            if(target < nums[mid])
                end = mid-1;
            else
                start = mid+1;
            mid = (start+end)/2;
        }

        return -1;
    }
    // Recursive solution
    public int search2(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length/2, nums.length-1, target);
    }

    public int binarySearch(int[] nums, int start, int mid, int end, int target){
        if(nums[mid] == target)
            return mid;
        if(start == end)
            return -1;
        else if(target < nums[mid])
            return binarySearch(nums, start, (start+mid-1)/2, mid-1, target);
        else
            return binarySearch(nums, mid+1, (mid+1+end)/2, end, target);
    }

    public int search3(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while(start + 1< end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                start = mid;
            }
            else if(nums[mid] > target){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(nums[start] == target){
            return start;
        }
        if(nums[end] == target){
            return end;
        }
        return -1;
    }

    public int search4(int[] nums, int target)
    {
        int lo = 0;
        int hi = nums.length - 1;

        while(lo <= hi)
        {
            int mid = (lo + hi) >> 1;

            if(nums[mid] < target)
                lo = mid + 1;
            else if(nums[mid] > target)
                hi = mid - 1;
            else
                return mid;
        }

        return -1;
    }
    public int search5(int [] nums, int target){
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid= left+(right-left)/2;
            if (nums[mid]==target){
                return mid;
            }else if (target>nums[mid]) left=mid+1;
            else right=mid+1;

        }
        return -1;
    }

    public int search6(int[] nums, int target) {

        if(nums== null || nums.length<0)
            return -1;
        int found = Arrays.binarySearch(nums,target);
        if(found <=-1){
            return -1;
        }
        return found;

    }
    public int search7(int[] nums, int target) {
        int l =0;
        int r = nums.length-1;
        int m;
        while(l<=r) {
            m = l+(r-l)/2;
            if(target==nums[m]) {
                return m;
            } else if (target<nums[m]) {
                r=m-1;
            } else {
                l=m+1;
            }
        }
        return -1;
    }
    public int search8(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l++;
            else r--;
        }
        return -1;
    }

    public int search9(int[] nums, int target) {

        int indexofvariable = -1;
        for(int i =0 ; i< nums.length; i++)
        {
            if(target == nums[i])
                indexofvariable = i;

        }
        return indexofvariable;
    }

    public int search10(int[] nums, int target) {
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==target) return i;
        }
        return -1;
    }
    public int search11(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public int binarySearch(final int[] nums, final int target, final int left, final int right) {
        if (left > right) {
            return -1;
        }
        var mid = (left + right) / 2;
        if (target == nums[mid]) {
            return mid;
        }
        if (target < nums[mid]) {
            return binarySearch(nums, target, left, mid - 1);
        }
        return binarySearch(nums, target, mid + 1, right);
    }
    public int search12(int[] nums, int target) {
        int start=0,end=nums.length-1;

        while(start<=end){
            int mid=start+(end-start)/2;
            if(target==nums[mid])
                return mid;
            if(target<nums[mid])
                end=mid-1;
            else

                start=mid+1;
        }
        return -1;
    }
    public int search13(int[] nums, int target) {
        return searchs(nums, target, 0, nums.length-1);
    }

    public int searchs(int[] nums, int target, int l, int r) {

        if(l > r) {
            return -1;
        }
        int mid = r-l;

        if(target == nums[mid]) {
            return mid;
        }
        if(target > nums[mid]) {
            return searchs(nums, target, mid+1, r);
        }
        else {
            return searchs(nums, target, l, mid-1);
        }

    }
    public int search14(int[] nums, int target) {
        int mid = nums.length/2;
        int a = 0;
        int b = nums.length - 1;

        while (a <= b) {
            System.out.println("a: " + a + " b: " + b);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                a = mid + 1;
            } else {
                b = mid - 1;
            }
            mid = (a + b)/2;
        }

        return -1;
    }
    public int search15(int[] nums, int target) {
        return binarySearch(0,nums.length-1,nums,target);
    }
    public int binarySearch(int left, int right,int[] nums,int target){
        if (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (target < nums[mid])
                return binarySearch(left, mid - 1, nums, target);
            else if (target > nums[mid])
                return binarySearch(mid + 1, right, nums, target);
        }
        return -1;
    }
}
