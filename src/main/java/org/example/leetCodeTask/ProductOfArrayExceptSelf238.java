package org.example.leetCodeTask;

public class ProductOfArrayExceptSelf238 {

        public int[] productExceptSelf1(int[] nums) {
            int n = nums.length;
            int[] output = new int[n];
            output[0] = 1;
            for (int i = 1; i < n; i++) {
                output[i] = output[i-1] * nums[i-1];
            }
            int rightProduct = 1;
            for (int i = n-1; i >= 0; i--) {
                output[i] *= rightProduct;
                rightProduct *= nums[i];
            }
            return output;
        }
    public int[] productExceptSelf2(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] arr = new int[nums.length];
        left[0] = 1;
        right[nums.length-1] = 1;
        for(int i = 1; i < nums.length; i++){
            left[i] = left[i-1] * nums[i-1];
        }

        for(int i = nums.length-2; i > -1; i--){
            right[i] = right[i+1] * nums[i+1];

        }

        for(int i = 0; i < nums.length; i++){
            arr[i] = left[i] * right[i];
        }
        return arr;
    }
    public int[] productExceptSelf3(int[] nums) {
        int result [] = new int [nums.length];

        int runningProduct = 1;

        //left Pass
        for(int i = 0; i < nums.length; i++){

            result[i] = runningProduct;//for every index we will put runningProduct
            runningProduct = runningProduct * nums[i];//update the runningProduct
        }

        //rightPass
        //for rightPass Again update runningProduct as 1

        runningProduct = 1;

        for(int i = nums.length -1 ; i >= 0; i--){

            //multiply the value present on ith index with rightPass Value

            result[i] = result[i] * runningProduct;
            runningProduct = runningProduct * nums[i];//update the runningProduct
        }
        return result;
    }
    public int[] productExceptSelf4(int[] nums) {
        int len=nums.length;
        int fin[]=new int[len];
        int prev=1;
        for(int i=0;i<len;i++)
        {
            fin[i]=prev;
            prev*=nums[i];
        }
        prev=nums[len-1];
        for(int i=len-2;i>=0;i--)
        {
            fin[i]=fin[i]*prev;
            prev*=nums[i];
        }
        return fin;
    }
    public int[] productExceptSelf5(int[] nums)
    {
        int prev=1;
        int next=1;
        int a[]=new int[nums.length];
        // int n=nums.length;
        for(int i=0;i<nums.length;i++)
        {
            a[i]=prev;
            prev*=nums[i];
        }
        for(int i=nums.length-2;i>=0;i--)
        {
            next=next*nums[i+1];
            a[i]=a[i]*next;
        }
        return a;
    }
    }

