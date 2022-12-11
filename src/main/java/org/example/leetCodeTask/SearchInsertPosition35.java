package org.example.leetCodeTask;

import java.util.Arrays;

public class SearchInsertPosition35 {
    public static void main(String[] args) {
        int nums[] = {1, 3, 5, 6};
        int target = 5;
        System.out.println(searchInsert4(nums, target));

    }

    public int searchInsert1(int[] A, int target) {
        int low = 0, high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == target) return mid;
            else if (A[mid] > target) high = mid - 1;
            else low = mid + 1;
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

    public static int searchInsert4(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        int middle = 0;
        while (left <= right) {
            if (target < nums[left]) return left;
            if (target > nums[right]) return right + 1;
            middle = left + (right - left) / 2;
            if (nums[middle] == target) return middle;
            else if (target < nums[middle]) right = middle - 1;
            else left = middle + 1;
        }
        return -1;
    }

    public int searchInsert5(int[] nums, int target) {
        int n = 0;
        while (n <= nums.length - 1 && nums[n] < target) {
            n++;
        }
        return n;
    }

    public int searchInsert6(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        //if target > all numbers
        if (nums[hi] < target) return nums.length;
        //general binary search
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;// take seriously! NOT hi = mid - 1;
            }
        }
        return lo;
    }

    public int searchInsert7(int[] nums, int target) {
        int n = 0;
        if (nums[0] > target) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] < target && nums[i + 1] > target) {
                return i + 1;
            }
        }
        return n;
    }

    final int kFirstElementPosition = 0;
    final int kArrayElementOffset = 1;
    final int kDivisionFactor = 2;
    final int kMinSearchableNumberOfElements = 2;

    public int searchInsert8(int[] iNums, int iTarget) {
        SearchDomain aSearchDomain = new SearchDomain(kFirstElementPosition, iNums.length - kArrayElementOffset);

        while (aSearchDomain.size() >= kMinSearchableNumberOfElements) {
            int aMedianValue = aSearchDomain.getMedianValue(iNums);
            if (aMedianValue == iTarget) {
                return aSearchDomain.median;
            } else {
                aSearchDomain.updateDomain(aMedianValue, iTarget);
            }
        }

        return aSearchDomain.getNewElementPosition(iNums, iTarget);
    }

    class SearchDomain {
        SearchDomain(int iFirst, int iLast) {
            first = iFirst;
            last = iLast;
            calculateMedian();
        }

        int getNewElementPosition(int[] iNums, int iTarget) {
            if (empty()) {
                return kFirstElementPosition;
            }

            int aMedianValue = getMedianValue(iNums);
            if (iTarget > aMedianValue) {
                return median + 1;
            } else {
                return median;
            }
        }

        void calculateMedian() {
            median = (first + last + kArrayElementOffset) / kDivisionFactor;
        }

        void updateDomain(int iMedianValue, int iTarget) {
            if (iTarget > iMedianValue) {
                first = median;
            } else {
                last = median - kArrayElementOffset;
            }
            calculateMedian();
        }

        int getMedianValue(int[] iNums) {
            return iNums[median];
        }

        int size() {
            return last - first + kArrayElementOffset;
        }

        boolean empty() {
            return size() == 0;
        }

        int first;
        int last;
        int median;
    }

    public int searchInsert9(int[] nums, int target) {
        int start = 0;
        int end = nums.length;

        while (start < end) {
            if (nums[start] == target) {
                return start;
            }
            if (target < nums[start]) {
                return start;

            }
            start++;

        }
        return nums.length;

    }

    public int searchInsert10(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (true) {
            int midIndex = startIndex + ((endIndex - startIndex) / 2);
            int midValue = nums[midIndex];
            int earliestIndex = endIndex;

            if (target == midValue) {
                return midIndex;
            } else if (target < midValue) {
                endIndex = midIndex - 1;

                if (endIndex == -1) {
                    return 0;
                } else if (target > nums[endIndex]) {
                    return midIndex;
                }


            } else if (target > midValue) {
                startIndex = midIndex + 1;

                if (startIndex == nums.length) {
                    return nums.length;
                } else if (target < nums[startIndex - 1]) {
                    return midIndex;
                }

            }
        }
    }

    public int searchInsert11(int[] nums, int target) {
        if (nums[0] > target) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                return i;
            else if (nums[i] < target) {
                if (i + 1 < nums.length && target < nums[i + 1]) {
                    return i + 1;
                }
            }
        }
        return nums.length;
    }
    public int searchInsert12(int[] nums, int target) {
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(target==nums[i]){index=i;break;}
            if(target<nums[i]){index=i;break;}
            if(i==nums.length-1 && target>nums[i]){index=i+1;}
        }
        return index;
    }
    public int searchInsert13(int[] nums, int target) {
        int pos = -1;
        int first_highest_index = nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>target){
                first_highest_index = Math.min(first_highest_index, i);
            }
            if(nums[i]==target){
                pos=i;
            }
        }
        if(pos==-1){
            return first_highest_index;
        }
        return pos;
    }
    public int searchInsert14(int[] nums, int target) {
        int n=nums.length;
        int result=0;
        for(int i = 0;i<n;i++)
        {
            if(nums[i]==target)
            {
                result = i;
                //return result;
            }
            else if(nums[i]<target)
            {
                result=i+1;
                //return result;
            }
        }

        return result;
    }
    public int searchInsert15(int[] nums, int target) {
        for(int i=0; i<nums.length;i++){
            if(nums[i]>=target){
                return i;
            }
        }
        return nums.length;
    }
    public int searchInsert16(int[] nums, int target) {
        return binarySearchLowerBound(nums, target);
    }

    public int binarySearchLowerBound(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while(lo < hi) {
            int mid = lo + (hi - lo)/2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else if (nums[mid] >= target) {
                hi = mid;
            }
        }
        return lo;
    }
    public int searchInsert17(int[] nums, int target) {

        int start =0;
        int end = nums.length;
        int mid =-1;
        if(target > nums[end-1]){
            return nums.length;
        }
        if(target < nums[0]){
            return 0;
        }
        while (start <= end ){
            mid = start + (end -start)/2;
            if(nums[mid] ==target){
                return mid;
            }else if (target > nums[mid]){
                start = mid +1;
            }else{
                end = mid -1;
            }
        }
        return start;
    }
    public int searchInsert18(int[] nums, int target) {
        int finalAnswer = 0;
        Boolean duh = false;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target) {
                finalAnswer = i;
            }
            if(i+1 < nums.length && (nums[i] < target && nums[i+1] > target)){
                finalAnswer = i+1;
            }
            if(nums[nums.length-1] < target){
                finalAnswer = nums.length;
            }
        }
        return finalAnswer;
    }
    public int searchInsert19(int[] nums, int target) {
        int i=0;
        while( i<nums.length && target>nums[i]){
            i++;
        }
        return i;
    }
    public int searchInsert20(int[] nums, int target) {

        return binarySearch(0,nums.length-1,nums,target);

    }

    int binarySearch(int startIndex, int endIndex, int[] nums, int target){

        int middleIndex = (startIndex+endIndex)/2;
        if(startIndex >= endIndex){
            if(nums[middleIndex] != target){
                if(target>nums[startIndex]) return ++startIndex;
                else return startIndex;
            }else return middleIndex;
        }

        if(nums[middleIndex] == target) return middleIndex;
        else if(nums[middleIndex] > target) return binarySearch(startIndex,middleIndex-1,nums,target);
        else  return binarySearch(middleIndex+1,endIndex,nums,target);
    }
    public int searchInsert21(int[] nums, int target) {
        int firstIndex = 0;
        int lastIndex = nums.length - 1;

        while (lastIndex >= firstIndex)
        {
            int firstDiff = Math.abs(nums[firstIndex] - target);
            int lastDiff = Math.abs(nums[lastIndex] - target);

            if (nums[firstIndex] >= target)
            {
                return firstIndex;
            }
            else if (nums[lastIndex] == target)
            {
                return lastIndex;
            }
            else if (nums[lastIndex] < target)
            {
                return lastIndex + 1;
            }
            else if (firstDiff > lastDiff)
            {
                firstIndex = Math.floorDiv((lastIndex + firstIndex), 2);
                lastIndex--;
            }
            else
            {
                lastIndex = Math.floorDiv((lastIndex + firstIndex + 1), 2);
                firstIndex++;
            }
        }

        return firstIndex;
    }
}
