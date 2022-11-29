package org.example.leetCodeTask;

import java.util.Arrays;

public class FindPivotIndex724 {
    public static void main(String[] args) {
        int[] num = {1,7,3,6,5,6};
        System.out.println(pivotIndex(num));
    }

public static int pivotIndex(int[] nums) {
    int sum = 0, leftSum = 0;
    for(int num: nums)
        sum += num;
    for(int i=0; i<nums.length; i++){
        if(leftSum == sum - leftSum -nums[i])
            return i;
        leftSum += nums[i];
    }
    return -1;
}
public int pivotIndex2(int[] nums) {
    if (nums.length == 0)
        return -1;
    int sum = 0;
    for (int i : nums) {
        sum += i;
    }
    double temp = 0;
    for (int i = 0; i < nums.length; i++) {
        if (temp == (double) (sum - nums[i]) / 2)
            return i;
        else
            temp += nums[i];
    }
    return -1;
}
    public int pivotIndex3(int[] nums) {
        int sum = 0;
        for(int i : nums)
            sum+=i;
        for(int i=0;i<nums.length;++i){
            sum-=nums[i];//take out current
            if(sum==0)
                return i;
            sum-=nums[i];//take out left
        }
        return -1;
    }

    public int pivotIndex4(int[] nums) {
        int total = 0;
        for(int i = 0; i < nums.length; i++){
            total += nums[i];
        }
        int left = 0;
        for(int i = 0; i < nums.length; i++){
            if(i != 0) left += nums[i-1];
            if(total - left - nums[i] == left){
                return i;
            }
        }
        return -1;
    }

    public int pivotIndex5(int[] nums) {

        int sum = 0;

        if (nums.length < 3) {
            return -1;
        }
        //calculate sum of all elements
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        //right = cumulative sum till index i-1
        //left = total sum- cumulative sum till index i
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i-1 >= 0) {
                right += nums[i-1];
            }

            int left = sum - (nums[i] + right);
            if (right == left) {
                return i;
            }
        }
        return -1;
    }
    public int pivotIndex6(int[] nums) {

        int sum = 0;

        if (nums.length < 3) {
            return -1;
        }
        //calculate sum of all elements
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        //right = cumulative sum till index i-1
        //left = total sum- cumulative sum till index i
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i-1 >= 0) {
                right += nums[i-1];
            }

            int left = sum - (nums[i] + right);
            if (right == left) {
                return i;
            }
        }
        return -1;
    }
    public int pivotIndex7(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        int pi = 0;
        int pSum = 0;
        while(pi < nums.length) {
            if(sum - pSum - nums[pi] == pSum) {
                return pi;
            }
            pSum += nums[pi];
            pi++;
        }
        return -1;
    }

    public int pivotIndex8(int[] nums) {
        int n = nums.length;
        int[] L = new int[n];
        L[0] = nums[0];

        for(int i=1; i<n; i++){
            L[i] += L[i-1] + nums[i];
        }
        int[] R = new int[n];
        R[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){
            R[i] += R[i+1] + nums[i];
        }
        int start = 0;
        int end = n-1;
        for(int i=0; i<n; i++){
            if(L[i]==R[i])
                return i;
        }
        return -1;
    }
    public int pivotIndex9(int[] nums) {

    /*
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Find Pivot Index.
    Memory Usage: 39.9 MB, less than 76.70% of Java online submissions for Find Pivot Index.
    */

        // edge case
        if (nums.length == 0) {
            return -1;
        }

        int sumOfAllElements = nums[0];
        int[] cumulativeSum = new int[nums.length];
        cumulativeSum[0] = nums[0];

        for (int index = 1; index < nums.length; ++index) {
            cumulativeSum[index] = cumulativeSum[index - 1] + nums[index];
            sumOfAllElements += nums[index];
        }

        for (int index = 0; index < nums.length; ++index) {

            int leftSide;

            if (index == 0) {
                leftSide = 0; // test cases require us to consider zero as the "sum of numbers left of nums[0]";
            } else {
                leftSide = cumulativeSum[index - 1];
            }

            if (leftSide == sumOfAllElements - nums[index] - leftSide) { // this tests whether sum to left of nums[index] equals sum to right of nums[index]
                return index;
            }

        }

        return -1; // if we haven't returned an index yet, then return -1 to indicate no pivot index found

    }

    public int pivotIndex10(int[] nums) {
        int right = 0;
        for(int num: nums)
            right += num;
        int n = nums.length;
        int left = 0;
        for(int i = 0; i < n; i++) {
            if(i == n - 1) {
                right = 0;
            } else
                right -= nums[i];
            if(left == right)
                return i;
            left += nums[i];
        }
        return -1;
    }
    public static int pivotIndex11(int[] a) {
        int left = 0;
        int right = Arrays.stream(a).sum();
        int n = a.length;

        for (int i = 0; i < n; i++) {
            right -= a[i];
            if (left == right) return i;
            left += a[i];
        }

        return -1;
    }
    public int pivotIndex12(int[] nums) {
        int sum = Arrays.stream(nums).reduce(0, Integer::sum);
        System.out.println("sum = " + sum);
        int leftPart = 0;

        // [left part] [X] [right part]
        // we want the point where left part = right part
        // at i = 0, our "left part" = 0.
        // so we want the sum of everything from i=1 on, which would be
        // sum - nums[0].
        // at i = 1, we add nums[0] to our running total, and compare that value to
        // thes um of everything from i = 2 on, namely sum - runningTotal - nums[1]
        if (leftPart == sum - nums[0]) return 0;

        for (int i = 1; i < nums.length; i++) {
            // add nums[i-1] to leftPart
            leftPart += nums[i-1];

            if (leftPart == sum - leftPart - nums[i])
                return i;

        }
        return -1;
    }

    public int pivotIndex13(int[] arr) {
        int sum=0;
        for(int i:arr) {
            sum+=i;
        }
        int lsum=0;
        for(int i=0;i<arr.length;i++) {
            sum-=arr[i];
            if(lsum==sum) return i;
            lsum+=arr[i];
        }
        return -1;
    }

}
