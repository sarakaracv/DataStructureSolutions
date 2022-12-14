package org.example.week34;

import java.util.Arrays;

public class RotateAndMultiply {
    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 5, 6};
//        rotateMultiply(arr,arr.length);
        for (int i=0; i< arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    //    static int[] mul(int nums[]){
//        int[] temp = new int[nums.length];
//        temp[0] = nums[1];
//        temp[nums.length-1] = nums[nums.length-2];
//        for(int i=1; i<nums.length-1; i++ )
//        {
//            temp[i] = nums[i-1] * nums[i+1];
//        }
//        return temp;
//    }
    public static int rotateMultiply(int [] arr, int n){
        int prev=arr[0];
        arr[0]=arr[0]*arr[1];
        for (int i = 1; i <n-1 ; i++) {
            int current= arr[i];
            arr[i]=prev*arr[i+1];
            prev=current;
        }
        arr[n-1]= prev*arr[n-1];
        return -1;
    }

    public static int modify(int[] arr, int n)
    {
        // Nothing to do when array size is 1
        if (n <= 1)
            return n;

        // store current value of arr[0] and update it
        int prev = arr[0];
        arr[0] = arr[0] * arr[1];

        // Update rest of the array elements
        for (int i=1; i<n-1; i++)
        {
            // Store current value of next interaction
            int curr = arr[i];

            // Update current value using previous value
            arr[i] = prev * arr[i+1];

            // Update previous value
            prev = curr;
        }

        // Update last array element
        arr[n-1] = prev * arr[n-1];
        return n;
    }


}
