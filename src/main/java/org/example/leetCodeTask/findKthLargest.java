package org.example.leetCodeTask;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class findKthLargest {
    public int findKthLargest0(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
    public int findKthLargest00(int[] nums, int k) {
        Arrays.sort(nums);
        int a=nums.length;
        return nums[a-k];
    }

    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> heap=new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length ; i++) {
            heap.add(nums[i]);
        }
        for (int i = 0; i <k-1 ; i++) {
            heap.poll();
        }
        return heap.peek();
    }
    public int findKthLargest2(int[] nums, int k) {

        PriorityQueue<Integer>pq=new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i=0;i<nums.length;i++){
            pq.offer(nums[i]);
        }

        int i=0;
        while(i<k-1){
            pq.poll();
            i++;
        }
        return pq.peek();
    }
    public int findKthLargest3(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++)
        {
            if(i<k)
                pq.add(nums[i]);
            else
            {
                if(nums[i]>pq.peek())
                {
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
        return pq.peek();
    }
    public int findKthLargest4(int[] nums, int k) {
        k=nums.length-k;
        return quickselect(nums,0,nums.length-1,k);
    }
    public int quickselect(int[] nums,int l, int r,int k)
    {
        int pivot=nums[r];
        int p=l;
        for(int i=l;i<r;i++)
        {
            if(nums[i]<=pivot)
            {
                int temp= nums[i];
                nums[i]=nums[p];
                nums[p]=temp;
                p+=1;
            }
        }
        int temp= nums[p];
        nums[p]=nums[r];
        nums[r]=temp;

        if(p>k)
        {
            return quickselect(nums,l,p-1,k);
        }
        else if(p<k)
        {
            return quickselect(nums,p+1,r,k);
        }
        else
        {
            return nums[p];
        }
    }
    public static int findKthLargest5(int[] nums, int k) {
        Arrays.sort(nums);
        int result = nums[nums.length - k];
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        findKthLargest5(nums,k);
        sc.close();
    }
    public int findKthLargest6(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums){
            minHeap.offer(num);
            if(minHeap.size() > k)
                minHeap.poll();
        }
        return minHeap.peek();
    }
    public int findKthLargest7(int[] nums, int k) {//3ms
        int[]a=new int[10000*2+1];
        for(int i=0;i<nums.length;i++)
        {
            a[nums[i]+10000]+=1;
        }
        for(int i=a.length-1;i>=0;i--)
        {
            k-=a[i];
            if(k<=0)
            {
                return i-10000;
            }
        }
        return -1;
        // Arrays.sort(nums);
        // return nums[nums.length-k];
    }

    //5 ms solutions

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /*private int partition(int[] nums, int left, int right, int pivotIndex) {

        // pick the pivot value
        int pivotValue = nums[pivotIndex];

        // move it to right most position
        swap(right, pivotIndex, nums);

        // start out in the left most
        int storeIndex = left;

        // go from left most to right - 1, avoid the right most used for storing pivot value
        for (int i = left; i <= right - 1; i++) {

            // if current i is less than pivot value, move it to the left
            // and increase it position
            if (nums[i] < pivotValue) {
                swap(storeIndex, i, nums);
                storeIndex++;
            }
        }

        // out of the loop, swap back the pivot value
        swap(right, storeIndex, nums);

        // return the store index
        // total run time : n
        return storeIndex;
    }

    public int quickSelect(int left, int right, int k, int[] nums) {

        // base case
        if (left == right) {
            return nums[left];
        }

        // select random
        int pivotIndex = left + (right - left) / 2;


        pivotIndex = partition(nums, left, right, pivotIndex);
        if (k == pivotIndex) {
            return nums[k];
        } else if (k < pivotIndex) {
            return quickSelect(left, pivotIndex - 1, k, nums);
        } else {
            return quickSelect(pivotIndex + 1, right, k, nums);
        }

    }*/


    public int partition(int[] nums, int left, int right) {
        int pivotIndex = left + (right - left)/2;
        int pivotValue = nums[pivotIndex];

        swap(nums, right, pivotIndex);

        int storeIndex = left;

        for (int i = left; i <= right - 1; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }

        swap(nums, storeIndex, right);

        return storeIndex;
    }

    public int quickSelect(int[] nums, int left, int right, int k) {

        if (left == right) {
            return nums[left];
        }

        int pivotIndex = partition(nums, left, right);

        if (pivotIndex == k) {
            return nums[k];
        } else if (pivotIndex > k) {
            return quickSelect(nums, left, pivotIndex - 1, k);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, k);
        }

    }

    public int findKthLargest8(int[] nums, int k) {


        /*Arrays.sort(nums);
        return nums[nums.length - k];*/

        /*PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer int1, Integer int2) {
                return int2.compareTo(int1);
            }
        });


        for(int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);

        }

        while (k > 1) {
            k--;
            queue.poll();

        }
        return queue.peek();*/


        /*PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        for(int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }

        }

        return queue.peek();*/

        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    public int findKthLargest9(int[] nums, int k) {
        PriorityQueue<Integer>minHeap=new PriorityQueue<Integer>();
        for(int i:nums){
            minHeap.add(i);
            if(minHeap.size()>k){
                minHeap.remove();
            }
        }
        return minHeap.remove();
    }


}
