package org.example.week32;

import java.util.Arrays;

public class MissingNumberQ1 {
    public static void main(String[] args) {
        MissingNumberQ1 miss = new MissingNumberQ1();

        int arr[] = {1, 3, 7, 5, 6, 2};
        int n = arr.length;

         System.out.println(missingNum3(arr));
    }
    public static int missingNum2(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        for (int each : arr) {
            sum += each;
        }
        int sum2 = 0;
        for (int i = arr[0]; i < arr[arr.length - 1] + 1; i++) {

            sum2 += i;
        }
        return sum2 - sum;

    }
    public static int missingNum3(int[] arr) {

        Arrays.sort(arr);

        int sum = 0;

        for (int each : arr) {

            sum -= each;
        }

        for (int i = arr[0]; i < arr[arr.length - 1] + 1; i++) {

            sum += i;
        }

        return sum;

    }
    public static int missingNumber16(int[] nums) {
        int array_sum = Arrays.stream(nums).sum();

        // expected sum
        int n = nums.length;
        int expected_sum = (n * (n - 1)) / 2;
        return expected_sum - array_sum;
    }

    public static int missingNumber15(int[] nums) {
        int sum = 0, len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return (len*(len+1)/2 - sum);
    }
    public static int missingNumber14(int[] nums) {
        int n = nums.length;
        int sum = (n)*(n+1)/2;

        for(int i=0; i<n; i++){
            sum -= nums[i];
        }

        return sum;
    }
    public static int missingNumber13(int[] nums) {
        int missed = -1;
        int n = nums.length;
        int numSum = 0;
        for (int num: nums) {
            numSum = numSum+num;
        }
        int totalSum = (n*(n+1))/2;
        missed = totalSum-numSum;
        return missed;
    }
    public static int missingNumber12(int[] nums) {
        int sum = (0+nums.length)*(nums.length+1) / 2;
        for(int i=0;i<nums.length;i++){
            sum-=nums[i];
        }
        return sum;
    }
    public static int missingNumber11(int[] nums) {
        int n = nums.length;
        int original = 0;
        int current = 0;

        for(int i=0;i<nums.length;i++){
            original+=i;
            current+=nums[i];
        }

        return original+n-current;
    }

    public static int missingNumber10(int[] nums) {
        int low = 0;
        int high = nums.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            int c = 0;
            for (int num : nums) {
                if (num <= mid) c++;
            }

            if (c == mid + 1) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
    public static int missingNumber9(int[] nums) {
        int s = nums.length;
        for (int i = 0; i < nums.length; i++) {
            s += i - nums[i];
        }
        return s;
    }
    public static int missingNumber8(int[] nums) {
        int sum=(nums.length+1)*(nums.length)/2;
        for(int i=0; i<nums.length; i++){
            sum-=nums[i];
        }
        return sum;
    }
        public static int missingNumber7 (int[] nums) {
            Arrays.sort(nums);
            for(int i=0; i<nums.length; i++){
                if(nums[i] != i) return i;
            }
            return nums.length;
        }

    public static void findMissing(int arr[], int N){
        int i;
        int temp[] = new int[N + 1];
        for (i = 0; i <= N; i++) {
            temp[i] = 0;}
        for (i = 0; i < N; i++) {
            temp[arr[i] - 1] = 1;
        }
        int ans = 0;
        for (i = 0; i <= N; i++) {
            if (temp[i] == 0)
                ans = i + 1;}
        System.out.println(ans);
    }
    public static int missingNumber1(int[] arr){
        int n=arr.length+1;
        int sum=n*(n+1)/2;
        int restSum=0;
        for (int i = 0; i < n-1; i++) {
            restSum+=arr[i];
        }
        int missingNumber=sum-restSum;
        return missingNumber;
    }

    public static int missingNumber2(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length, mid;
        while(left<right){
            mid = (left + right)/2;
            if(nums[mid]>mid) right = mid+1;
            else left = mid+1;
        }
        return left;
    }
    public int missingNumber3(int[] nums) {
        int sum = 0;
        int n=nums.length;
        for(int each: nums)
            sum += each;
        return (n * (n + 1) )/2 -sum;
    }
    public int missingNumber4(int[] nums) {

        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < nums.length; i++) {
            sum1 = sum1 + i;
            sum2 = sum2 + nums[i];
        }

        return Math.abs(sum2 - sum1 - nums.length);
    }
}



