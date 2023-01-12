package org.example.groupweeks;

import java.util.*;

public class FirstMissingPositive41 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        System.out.println(firstMissingPositive1(nums));
}
    public static int firstMissingPositive1(int[] nums) {
        if(nums.length == 0) return 1;
        int[] arrays = new int[nums.length];
        for(int i=0; i< nums.length; i++){
            if(nums[i]>0 && nums[i]<= nums.length){
                arrays[nums[i]-1] = 1;
            }
        }
        for(int i=0; i< nums.length; i++){
            if(arrays[i] == 0) return i+1;
        }
        return nums.length+1;
    }
    public int firstMissingPositive2(int[] nums) {
        long min = Long.MAX_VALUE;
        for (int num : nums)
            if (num > 0)
                min = Math.min(num, min);

        if (min != 1)
            return 1;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == (i+1) || nums[i] < 1 || nums[i] > nums.length)
                continue;

            int prevIndex = i;
            int nextIndex = nums[i]-1;
            while (nextIndex != prevIndex && nextIndex >= 0 && nextIndex < nums.length && prevIndex >= 0 && prevIndex < nums.length){
                int tempVal = nums[nextIndex];
                int tempIndex = nextIndex;
                if (nums[prevIndex] != (prevIndex+1))
                    nums[prevIndex] = 0;
                nums[nextIndex] = nextIndex+1;
                prevIndex = tempIndex;
                if (tempVal < 0)
                    break;
                nextIndex = tempVal - 1;
            }
        }

        for (int i = 0; i < nums.length; i++)
            if (nums[i] != i+1){
                return (i+1);
            }
        return (nums.length+1);

    }
    public int firstMissingPositive3(int[] nums) {
        int n = nums.length;

        for(int i=0;i<n;i++)
        {
            if(nums[i] <= 0 || nums[i] > n)
            {
                nums[i]  = n+1;
            }
        }

        for(int i=0;i<n;i++)
        {
            int val = Math.abs(nums[i]);

            if(val <= n)
            {
                int idx = val - 1;

                if(nums[idx] > 0)
                {
                    nums[idx] = -1 * nums[idx];
                }
            }
        }

        for(int i=0;i<n;i++)
        {
            if(nums[i] > 0)
            {
                return i+1;
            }
        }
        return n+1;
    }
    public int firstMissingPositive4(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correct=nums[i]-1;
            if(nums[i]>0 && nums[i]<=nums.length && nums[i]!=nums[correct]){
                swap(nums,i,correct);
            }else{
                i++;
            }
        }

        for(int j=0;j<nums.length;j++){
            if(nums[j]!=j+1){
                return j+1;
            }
        }
        return nums.length+1;
    }
    void swap(int[] arr, int start, int end){
        int temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
    }
    public int firstMissingPositive5(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        int min=1;
        int max=arr[n-1];
        for(int i=0;i<n;i++){
            if(arr[i]==min)
                min++;

           /* if(arr[i]!=min){
                return min;
            }
            else if(arr[i+1]!=arr[i]+1){
                return arr[i+1];
            }
            else{
                return max+1;
            }
*/

        }
        return min;

    }
    public int firstMissingPositive6(int[] nums) {
        long max =0;

        for(int i =0;i<nums.length;i++){
            max = Math.max(nums[i],max);
        }
        if(max==0) return 1;
        if(max ==2147483647){
            // long arr[]=new long[(int)max];
            HashSet<Integer> set = new HashSet();

            for(int i =0;i<nums.length;i++){
                set.add(nums[i]);
            }
            for(int i =1;i<=nums.length;i++){
                if(!set.contains(i)) return i;
            }

// for(int i =0;i<nums.length;i++){
//            if(nums[i]>0) arr[nums[i]-1]=1;
//        }
//          for(int i=0;i<arr.length;i++){
//            if(arr[i]==0) return i+1;
//        }

        }

        long arr[]=new long[(int)max+1];
        //    arr[0]=1;
        for(int i =0;i<nums.length;i++){
            if(nums[i]>0) arr[nums[i]-1]=1;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0) return i+1;
        }
        return 0;
    }
    public int firstMissingPositive7(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> a = new ArrayList<Integer>();
        int k=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                if(i!=0 && nums[i]==nums[i-1])
                    continue;
                if(nums[i]==k){
                    k++;
                    a.add(nums[i]);
                }
                else
                    return k;
            }
        }
        return k;
    }
    public int firstMissingPositive8(int[] nums) {

        var s = new HashSet(nums.length *3 /2);

        for(int i = 0 ; i < nums.length; i++ ) {
            s.add(nums[i]);
        }

        for(int i = 1 ; i <= nums.length ; i++) {
            if (!s.contains(i)) {
                return i;
            }
        }

        return nums.length + 1;

    }
    public int firstMissingPositive9(int[] nums) {
        Set<Integer> set=new HashSet<Integer>();

        for(int i:nums)
        {
            if(i>0)
                set.add(i);
        }
        int n=1;
        while(true)
        {
            if(!set.contains(n))
                return n;
            else
                n++;
        }

    }
    public int firstMissingPositive10(int[] a) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<a.length;i++){
            set.add(a[i]);
        }
        int i=1;
        int res = -1;
        while(true){
            if(!set.contains(i)){
                res = i;
                //System.out.println("Not In : "+res);
                break;
            }
            //System.out.println("In :"+i);
            i++;
        }
        return res;
    }
    public int firstMissingPositive11(int[] a) {

        if(a.length==1) {
            if(a[0]>0 && a[0]!=1)
            {
                return 1;
            } else if(a[0]<=0) {
                return 1;
            }
        }
        HashSet<Integer> set = new HashSet<>();

        int min = a[0];
        int max = a[0];
        for(int s:a) {
            set.add(s);
            if(s<min) {
                min = s;
            }
            if(s>max) {
                max = s;
            }
        }
        for(int i=1;i<a.length+1;i++) {
            if(!set.contains(i)) {
                return i;
            }
        }
        return max+1;

    }
    public int firstMissingPositive12(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        int missing = 1;

        for (int num : nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
            if (num > missing){
                missing = num;
            }
        }

        for (int i=1;i<=missing;i++){
            if (!freq.containsKey(i))
                return i;
        }

        return missing+1;
    }
    public int firstMissingPositive13(int[] nums) {
        int len = nums.length;
        int last = rearrangeArray(nums);
        for(int i=0;i<=last;i++){
            if(nums[i]!=0)
                nums[(nums[i]-1)%len]+= len;
        }
        int ans = 1;

        for(int i=0;i<=last;i++){
            if(nums[i]<=len){
                return i+1;
            }
        }

        return last+2;
    }

    private int rearrangeArray(int[] nums){
        int last = nums.length-1;

        int current = 0;

        int temp;
        while(current<=last){
            if(nums[current]<=0 || nums[current]>nums.length){
                temp = nums[current];
                nums[current] = nums[last];
                nums[last] = temp;
                last--;
            }else{
                current++;
            }
        }

        System.gc();

        return last;
    }
    public int firstMissingPositive14(int[] arr) {
        int i=0;
        while(i<arr.length){
            int correct=arr[i]-1;
            if(arr[i]<arr.length && arr[i]>0 && arr[i]!=arr[correct]){
                swap3(arr,i,correct);
            } else{
                i++;
            }
        }
        int ans=arr.length+1;
        for(int j=0;j<arr.length;j++){
            if(arr[j]==j+1){
                continue;
            } else{
                return j+1;
            }
        }
        System.out.print(Arrays.toString(arr));
        return ans;
    }
    static void swap3(int[] arr,int first, int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
    public int firstMissingPositive15(int[] nums) {
        // if (nums == null) return 1;

        // int l = nums.length;
        // boolean hasOne = false;
        // for (int i : nums) {
        //     if (i == 1) hasOne = true;
        //     else if (i < 0 || i > l) i = 1;
        // }

        // if (!hasOne) return 1;


        // return l;

        int missingPos = 1;
        TreeSet<Integer> set = new TreeSet<>();

        for (int i : nums) set.add(i);

        while (set.contains(missingPos)) {
            missingPos++;
        }

        return missingPos;
    }
    public int firstMissingPositive16(int[] nums) {
        int[] indices = new int[100000];
        for (int i=0; i<100000; i++){
            indices[i] = 0;
        }
        for (int i=0; i<nums.length; i++){
            if (nums[i]<100001 && nums[i]>0) indices[nums[i]-1]++;
        }
        for (int i=0; i<100000; i++){
            if (indices[i] == 0) return i+1;
        }
        return 100001;
    }
    public static int firstMissingPositive17(int[] nums){
        int n = nums.length;
        int i = 0;
        while(i < n){
            if (nums[i] <= 0){
                int temp = nums[i];
                nums[i] = nums[--n];
                nums[n] = temp;
            } else {
                i++;
            }
        }

        Arrays.parallelSort(nums, 0, n);
        int min = 1;
        for (int j = 0 ; j < n ; j++){
            if (nums[j] == min ){
                min ++;
            } else if (nums[j] < min){
                continue;
            }else {
                break;
            }
        }
        return min;
    }
    public int firstMissingPositive18(int[] arr) {
        int i = 0;
        while(i < arr.length){
            int correct = arr[i] -1;
            if(arr[i] > 0 && arr[i] <= arr.length && arr[correct] != arr[i]){
                swap2(arr, i , correct);
            }else{
                i++;
            }
        }
        for(int index = 0; index < arr.length; index ++){
            if(arr[index] != index + 1){
                return index + 1;
            }
        }
        return arr.length + 1;
    }
    static void swap2(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    public int firstMissingPositive19(int[] nums) {
        Set<Integer> mySet = new HashSet<Integer>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                mySet.add(nums[i]);
            }
        }

        int smallestMissing = 1;

        while (mySet.contains(smallestMissing)) {
            mySet.remove(smallestMissing);
            smallestMissing++;
        }

        return smallestMissing;
    }

    public int firstMissingPositive20(int[] nums) {
        int N = nums.length;
        for (int i=0; i<N; i++){
            if (nums[i]<=0 || nums[i]>N){
                nums[i] = N+1;
            }
        }
        for (int i =0; i<N; i++){
            int ele = Math.abs(nums[i]);
            if (ele>=1 && ele<=N){
                if (nums[ele-1]>0){
                    nums[ele-1]= -1*nums[ele-1];
                }
            }
        }
        for (int i = 0; i<N;i++){
            if (nums[i]>=0){
                return i+1;
            }
        }
        return N+1;
    }
}
