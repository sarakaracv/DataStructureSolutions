package org.example.leetCodeTask;

import java.util.Arrays;
import java.util.HashMap;

public class SearchInRotatedSortedArray33 {
    public static void main(String[] args) {

    }

    public int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[left] <= nums[mid]){
                if (target < nums[mid] && target >= nums[left])
                    right = mid - 1;
                else
                    left = mid + 1;
            }

            if (nums[mid] <= nums[right]){
                if (target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int l = nums.length;
        int i=0;
        int j=l-1;
        int pivot=0;
        while(i<=j){
            int mid = (i+j)>>1;
            if(nums[mid]>=nums[0]){
                i=mid+1;
            }
            else{
                pivot=mid;
                j=mid-1;
            }
        }
        i=0;
        j=l-1;
        int ans=0;
        while(i<=j){
            int mid = (i+j)>>1;
            if(nums[(mid+pivot)%l]==target) return (mid+pivot)%l;
            else if(nums[(mid+pivot)%l]<target){
                i=mid+1;
                ans = mid;
            }
            else{
                j=mid-1;
            }
        }
        System.out.println(pivot);
        System.out.println(nums[(pivot+ans)%l]);
        return -1;
    }

    public int search3(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
            map.put(nums[i],i);
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target)
                return map.get(nums[mid]);
            else if(nums[mid]>target)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
    public int search4(int[] nums, int target) {
        int i = -1;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == target) return j;
        }
        return i;
    }

    public int search5(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;

        while(s <= e) {
            int m = (s+e)/2;
            if(nums[m] == target) {
                return m;
            }

            // 1. left part is sorted
            if(nums[m] >= nums[s]) {
                // 1a. element lie in sorted part
                if(nums[s] <= target && target < nums[m]) {
                    e = m - 1;
                }
                // 1b. element lie in unsorted part
                else {
                    s = m + 1;
                }
            }

            //  2. right part is sorted
            else {
                // 2a. element lie in sorted part
                if(nums[m] < target && target <= nums[e]) {
                    s = m + 1;
                }
                // 2b. element lie in unsorted part
                else {
                    e = m - 1;
                }
            }
        }

        return -1;
    }
    public int search6(int[] nums, int target) {
        int i,j=0;
        for(i=0;i<nums.length;i++) {
            if(nums[i]==target) {
                j=i;
                break;
            } else {
                j=-1;
            }
        }
        return j;
    }
    public int binarySearch1(int[] nums, int target, int left, int right) {

        if (left > right) return -1;

        int mid = (right+left)/2;

        if (nums[mid] == target) return mid;

        boolean leftSortedPortion = nums[mid] >= nums[left];

        if (leftSortedPortion) {
            if (target < nums[mid] && target >= nums[left]) return binarySearch1(nums, target, left, mid - 1);
            else return binarySearch1(nums, target, mid + 1, right);
        } else {
            if (target > nums[mid] && nums[right] >= target) return binarySearch1(nums, target, mid + 1, right);
            else return binarySearch1(nums, target, left, mid - 1);
        }

    }

    public int search7(int[] nums, int target) {

        return binarySearch1(nums, target, 0, nums.length - 1 );
    }
    public int search8(int[] nums, int target) {
        int pivot = findPivot(nums);
        int firsthalf = BinarySearch2(nums, target, 0, pivot);
        int secondhalf = BinarySearch2(nums, target, pivot + 1, nums.length - 1);
        if(firsthalf == -1 && secondhalf != -1) {
            return secondhalf;
        }
        else if(firsthalf != -1 && secondhalf == -1) {
            return firsthalf;
        }
        return -1;
    }
    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1 ;
        while(start <= end){
            int mid = start +  (end - start)/2;
            if(mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }
            else if(mid > start && arr[mid] < arr[mid - 1]){
                return mid - 1;
            }
            else if (arr[start] >= arr[mid]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return -1;
    }
    static int BinarySearch2(int[] arr, int target, int start, int end){
        while(start<=end){
            int mid = start + (end - start)/2;
            if(target < arr[mid]){
                end = mid - 1;
            }
            else if(target > arr[mid]){
                start = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

    private int searchPivot(int[] nums){
        int start = 0;
        int end = nums.length-1;
        if(nums.length<=1)
            return 0;
        if(nums[0]<nums[end])
            return 0;
        if(nums[end]<nums[end-1])
            return end;
        while(end>=start){
            int mid = start+(end-start)/2;
            if(nums[mid]<nums[mid+1]&&nums[mid]<nums[mid-1])
                return mid;
            if(nums[mid]>=nums[0]){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }
    public int search9(int[] nums, int target) {
        int pivot = searchPivot(nums);
        System.out.println(pivot);
        int ans1 = Arrays.binarySearch(nums,0,pivot,target);
        int ans2 = Arrays.binarySearch(nums,pivot,nums.length,target);
        System.out.println(pivot);
        System.out.println(ans1);
        System.out.println(ans2);
        if(ans1>=0)
            return ans1;
        if(ans2>=0)
            return ans2;
        return -1;
    }
    public int search10(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],i);
        }

        if(map.containsKey(target))
        {
            return map.get(target);
        }
        else
        {
            return -1;
        }
    }
    public int search11(int[] nums, int target) {
        /*
        nums[5]>nums[6] --> nums[6] was nums[0] --> shift: 6
        1. find the offending position in logn  --> shift
        2. find target in logn time --> index
        3. return index of target - shift
        */

        int hi = nums.length;
        int lo = 0;
        int shift = 0;
        while(hi-lo>1) {
            int mid = avg(hi, lo);
            if (nums[mid]>nums[lo]) lo = mid;
            else hi = mid;
            shift = hi;
        }
        hi = nums.length;
        lo = 0;
        while(hi-lo>1) {
            int mid = avg(hi, lo);
            if (nums[(shift+mid)%nums.length]>target) hi = mid;
            else lo =mid;
        }
        return (nums[(lo+shift)%nums.length]==target) ? (lo+shift)%nums.length : -1;
    }
    private int avg(int a, int b) {return (a+(b-a)/2);
    }

    public int search13(int[] arr, int target) {

        int pivot=findPivot2(arr);
        if(pivot==-1)
            return search12(arr, target, 0, arr.length-1);
        else if(arr[pivot]==target)
            return pivot;
        else {
            int index =  search12(arr, target, 0, pivot);
            if(index!=-1) return index;
            return search12(arr, target, pivot+1, arr.length-1);
        }

    }

    public int  search12(int[] a,int target,int start,int end) {

        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(a[mid]==target)
                return mid;
            else if (a[mid]>target) {
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return -1;
    }

    public  int findPivot2(int[] a) {
        int start=0;
        int end=a.length-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(mid<end && a[mid]>a[mid+1])
                return mid;
            if (mid>start &&a[mid]<a[mid-1]) {
                return mid-1;
            }
            if(a[start]>=a[mid])
                end=mid-1;
            else
                start=mid+1;

        }
        return -1;
    }
    public int search14(int[] nums, int target) {
        int l =0, r=nums.length-1;
        if(nums[l] == target) return l;
        if(nums[r] == target) return r;
        while(l < r){
            int mid = (l+r)/2;
            System.out.println(nums[l] + " " + nums[mid] + " " + nums[r]);
            int a = nums[l], b = nums[mid], c = nums[r];
            if(nums[mid] == target) return mid;
            if(nums[l] == target) return l;
            if(nums[r] == target) return r;
            if(a < b && (a > target || b < target) || b < target && target < c && b < c) // take right side
                l = mid +1;
            else if(a > b && (target < b || target > a) || a < b && a < target && target < b) // take left side
                r = mid;
            else
                break;
        }
        return -1;
    }

}
