package org.example.leetCodeTask;

import java.util.*;

public class WiggleSortII324 {
    public void wiggleSort1(int []nums){
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);

        int n = nums.length;
        int mid = (n % 2 == 0) ? (n / 2 - 1) : (n / 2);

        int j = mid, k = n - 1;

        for (int i = 0; i < n; i++) {
            nums[i] = (i % 2 == 0) ? sorted[j--] : sorted[k--];
        }
    }
    public void wiggleSort2(int[] nums) {

        //Since we cant sort the arr as it might take nlogn time and the length of array is constant we can maintain the count array to do so, we cant even use Map as it doesnt have the order.
        int[] count = new int[5001];
        for (int num : nums) count[num]++;
        int n = count.length - 1;

        //updating the odd indices with greater ele so we move from backwards and place all the larger ele into the nums.
        for (int i = 1; i < nums.length; i += 2) {
            while (count[n] == 0) n--;
            nums[i] = n;
            count[n]--;
        }

        //updating the even places we need to see that they are small compared to their odd neighbors as all the large items from the list are done so we are left with small numbers and we need to place them in reverse order meaning the larget of remaining in the 0th place and second larget in 2nd place and so on.
        for (int i = 0; i < nums.length; i += 2) {
            while (count[n] == 0) n--;
            nums[i] = n;
            count[n]--;
        }
    }
    public void wiggleSort3(int[] nums) {
        int[] counting = new int[5001];
        for(int i=0;i<nums.length;i++){
            counting[nums[i]]++;
        }
        int index = 0;
        for(int i=0;i<=5000;i++){
            while(counting[i]!=0) {
                nums[index]=i;
                counting[i]--;
                index++;
            }
        }
        int[] result = new int[nums.length];
        int s=nums.length%2==0?nums.length/2-1:nums.length/2, e=nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                result[i]=nums[s];
                s--;
            } else {
                result[i]=nums[e];
                e--;
            }
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=result[i];
        }
    }

    public void wiggleSort4(int[] nums) {

        int n=nums.length-1;

        //copy values to new array
        int[] newarr = Arrays.copyOf(nums,nums.length);

        //sort new array
        Arrays.sort(newarr);

        //old arr=1,5,1,1,6,4
        //new arr=1,1,1,4,5,6

        //now lets apply odd position and even position
        //odd position
        for(int i = 1; i < nums.length; i += 2)
            nums[i] = newarr[n--];
        //even position
        for(int i = 0; i < nums.length; i += 2)
            nums[i] = newarr[n--];

    }
    public void wiggleSort5(int[] nums) {
        PriorityQueue<Integer> max=new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++) max.add(nums[i]);
        int m=1,n=0;;
        while(m<nums.length){
            nums[m]=max.poll();
            m=m+2;
        }
        while(n<nums.length){
            nums[n]=max.poll();
            n=n+2;
        }
    }
    public void wiggleSort6(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        for(int i: nums){
            numsList.add(i);
        }
        Collections.sort(numsList);
        int firstHigh;
        if(nums.length%2==0)
            firstHigh = nums.length/2;
        else
            firstHigh = (nums.length/2)+1;
        int highTracker = nums.length-1;
        int lowTracker = firstHigh-1;
        for(int i = 0; i<nums.length; i++){
            if(i%2==0 || i==0){
                nums[i] = numsList.get(lowTracker);
                lowTracker--;
            }
            else{
                nums[i] = numsList.get(highTracker);
                highTracker--;
            }
        }
    }

}
