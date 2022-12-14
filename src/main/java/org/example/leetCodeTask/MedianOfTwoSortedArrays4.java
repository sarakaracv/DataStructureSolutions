package org.example.leetCodeTask;

import java.util.*;

public class MedianOfTwoSortedArrays4 {
    public static void main(String[] args) {
        int [] nums1 = {1,3} , nums2 = {2};
        MedianOfTwoSortedArrays4 task= new MedianOfTwoSortedArrays4();

        System.out.println(task.findMedianSortedArrays2(nums1,nums2));
    }
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int size = nums1.length+nums2.length;
        int[] array = new int[size];
        int count=0;
        if(nums1.length!=0){
            for(int i=0;i<nums1.length;i++){
                array[i]=nums1[i];
                count=i;
            }
            count++;
        }
        for(int j=0;j<nums2.length;j++){
            array[count]=nums2[j];
            count++;
        }

        Arrays.sort(array);

        for(int k=0;k<array.length;k++){
            System.out.print(" "+array[k]);
        }

        double median=0;

        if(array.length%2==1){
            median=array[size/2];
            System.out.println(median);
            return median;
        }
        else{
            median=(array[size/2-1]+array[size/2])/2.0;
            System.out.println(median);
            return median;
        }

    }
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int pointer1 = 0;
        int pointer2 = 0;
        ArrayList<Integer> arList = new ArrayList<Integer>();
        while(pointer1 < nums1.length || pointer2 < nums2.length){
            if(pointer2 == nums2.length){
                arList.add(nums1[pointer1++]);
            }
            else if(pointer1 == nums1.length){
                arList.add(nums2[pointer2++]);
            }
            else if(nums1[pointer1] < nums2[pointer2]){
                arList.add(nums1[pointer1++]);
            }
            else{
                arList.add(nums2[pointer2++]);
            }
        }
        int aSize = arList.size();
        if(aSize % 2 ==1){
            return (double) arList.get(aSize/2);
        } else {
            return (double) ((arList.get(aSize/2)) + (arList.get(aSize/2-1))) / 2;
        }
    }
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.stream(nums1).forEach(a->pq.add(a));
        Arrays.stream(nums2).forEach(a->pq.add(a));
        int size = pq.size();
        int mid = size%2==0 ?  (size/2) -1 : size/2;
        int counter = 0;
        while(counter<mid){
            counter++;
            pq.poll();
        }
        double res = pq.poll();
        if(size%2==0){
            res+=pq.poll();
            res/=2;
        }
        return res;
    }
    public double findMedianSortedArrays4(int[] nums1, int[] nums2) {
        // Merge the two input arrays into a single sorted array
        int[] merged = new int[nums1.length + nums2.length];
        int i = 0;  // Pointer for nums1
        int j = 0;  // Pointer for nums2
        int k = 0;  // Pointer for merged
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                merged[k] = nums1[i];
                i++;
            } else {
                merged[k] = nums2[j];
                j++;
            }
            k++;
        }

        // Add any remaining elements from nums1 or nums2 to the merged array
        while (i < nums1.length) {
            merged[k] = nums1[i];
            i++;
            k++;
        }
        while (j < nums2.length) {
            merged[k] = nums2[j];
            j++;
            k++;
        }

        // Find the median of the merged array
        if (merged.length % 2 == 1) {
            // If the length of the merged array is odd, return the middle element
            return merged[merged.length / 2];
        } else {
            // If the length of the merged array is even, return the average of the two middle elements
            int middle1 = merged[merged.length / 2];
            int middle2 = merged[merged.length / 2 - 1];
            return (middle1 + middle2) / 2.0;
        }
    }
    public double findMedianSortedArrays5(int[] nums1, int[] nums2) {
        int pointer1 = 0;
        int pointer2 = 0;
        ArrayList<Integer> arList = new ArrayList<Integer>();
        while(pointer1 < nums1.length || pointer2 < nums2.length){
            if(pointer2 == nums2.length){
                arList.add(nums1[pointer1++]);
            }
            else if(pointer1 == nums1.length){
                arList.add(nums2[pointer2++]);
            }
            else if(nums1[pointer1] < nums2[pointer2]){
                arList.add(nums1[pointer1++]);
            }
            else{
                arList.add(nums2[pointer2++]);
            }
        }
        int aSize = arList.size();
        if(aSize % 2 ==1){
            return (double) arList.get(aSize/2);
        } else {
            return (double) ((arList.get(aSize/2)) + (arList.get(aSize/2-1))) / 2;
        }
    }
    public double findMedianSortedArrays6(int[] nums1, int[] nums2) {
        int index1 = 0,index2 = 0;
        int mid1 = (nums1.length+nums2.length)/2 -1;
        int mid2 = (nums1.length+nums2.length)/2;
        int[] result = new int[2];

        while(index1 + index2 <= mid2 && (index1 < nums1.length || index2 < nums2.length)){
            int num = 0;
            if(index1 < nums1.length && index2 < nums2.length){
                if(nums1[index1] < nums2[index2]){
                    num = nums1[index1++];
                }else{
                    num = nums2[index2++];
                }
            }else if(index1 < nums1.length){
                num = nums1[index1++];
            }else{
                num = nums2[index2++];
            }
            if(index1 + index2 - 1 == mid1){
                result[0] = num;
            }else if(index1 + index2 - 1 == mid2){
                result[1] = num;
            }
        }

        if((nums1.length + nums2.length)%2 == 0){
            return (result[0] + result[1])/2.0;
        }
        return result[1];
    }
    public double findMedianSortedArrays7(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length+nums2.length];
        int j=0;
        int k=0;
        for(int i=0;i<result.length;i++){
            if(j<nums1.length && k<nums2.length){
                if(nums1[j]<nums2[k]) result[i] = nums1[j++];
                else result[i] = nums2[k++];
            }else if(j>=nums1.length) result[i] = nums2[k++];
            else if(k>=nums2.length)result[i] = nums1[j++];
        }

        int len = result.length;
        double median=0;

        if(len%2==1) median = result[len/2];
        else median = (double) (result[len/2]+result[(len/2)-1])/2;

        return median;


    }
    public double findMedianSortedArrays8(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        List<Integer> merged = new ArrayList();

        for (int i = 0, j = 0; i < m || j < n; ) {
            if (i >= m) {
                merged.add(nums2[j++]);
                continue;
            }

            if (j >= n) {
                merged.add(nums1[i++]);
                continue;
            }

            if (nums1[i] <= nums2[j]) {
                merged.add(nums1[i++]);
            } else if (nums1[i] > nums2[j]){
                merged.add(nums2[j++]);
            }
        }


        int mid = ((m + n) / 2);

        if ((m + n) % 2 == 0) {
            return ((double)(merged.get(mid) + merged.get(mid - 1))) / 2;
        } else {
            return merged.get(mid);
        }
    }
    public double findMedianSortedArrays9(int[] nums1, int[] nums2) {
        int nums3[]= new int[nums1.length + nums2.length];
        for (int i=0;i<nums1.length;i++) {
            nums3[i] = nums1[i];
        }
        for (int i=0;i<nums2.length;i++) {
            nums3[i + nums1.length] = nums2[i];
        }

        Arrays.sort(nums3);
        double ans = 0;
        if (nums3.length % 2 == 0) {
            int index = nums3.length/2;
            ans = (nums3[index] + nums3[index-1]) / 2.0;
        } else {
            int index = nums3.length / 2;
            ans = (nums3[index] + nums3[index]) / 2.0;
        }
        return ans;
    }
    public double findMedianSortedArrays10(int[] nums1, int[] nums2) {
        List<Integer> arr = new ArrayList<>();

        for(int i = 0; i<nums1.length; i++){
            arr.add(nums1[i]);
        }

        for(int i = 0; i<nums2.length; i++){
            arr.add(nums2[i]);
        }

        Collections.sort(arr);

        if(arr.size()%2!=0){
            return(arr.get((arr.size()-1)/2));
        }
        else{
            int x = arr.get(arr.size()/2-1);
            int y = arr.get(arr.size()/2);
            return((double)(x+y)/2);
        }
    }
    public double findMedianSortedArrays11(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
    }

    public double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length - 1) return B[bStart + k - 1];
        if (bStart > B.length - 1) return A[aStart + k - 1];
        if (k == 1) return Math.min(A[aStart], B[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1];
        if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];

        if (aMid < bMid)
            return getkth(A, aStart + k/2, B, bStart,       k - k/2);// Check: aRight + bLeft
        else
            return getkth(A, aStart,       B, bStart + k/2, k - k/2);// Check: bRight + aLeft
    }
    public double findMedianSortedArrays12(int[] nums1, int[] nums2) {
        int totalItems = nums1.length + nums2.length;
        if(totalItems == 0) return -1.0D;

        int mid = (totalItems - 1)/2;
        boolean needsAverage = (totalItems - 1)%2 != 0;

        Integer cur = null, prev = null;
        int i=0, j=0, k = 0;
        int end = needsAverage ? mid+1 : mid;
        while(i < nums1.length || j < nums2.length){
            prev = cur;
            if(i >= nums1.length) cur = nums2[j++];
            else if(j >= nums2.length) cur = nums1[i++];
            else if(nums1[i] <= nums2[j]) cur = nums1[i++];
            else cur = nums2[j++];
            if(k==end) break;
            k++;
        }

        if(needsAverage){
            return (cur+prev)/2d;
        }

        return cur;
    }
    public double findMedianSortedArrays13(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if(m<n)return findMedianSortedArrays13(nums2, nums1);
        int low = 0;
        int high = n;
        int mid = (n+m+1)/2;
        while(low <= high){
            int cut1 = (low+high)/2;
            int cut2 = mid-cut1;
            int l1 = cut1==0?Integer.MIN_VALUE:nums1[cut1-1];
            int l2 = cut2==0?Integer.MIN_VALUE:nums2[cut2-1];
            int r1 = cut1==n?Integer.MAX_VALUE:nums1[cut1];
            int r2 = cut2==m?Integer.MAX_VALUE:nums2[cut2];
            if(l1<=r2 && l2<=r1){
                if((n+m)%2==1)return Math.max(l1,l2);
                else return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
            }else if(l1>r2) high = cut1-1;
            else low = cut1+1;
        }
        return 0.0;
    }
    public double findMedianSortedArrays14(int[] nums1, int[] nums2) {
        // Merge the two sorted arrays into a single array
        int[] nums = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, nums, 0, nums1.length);
        System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);
        Arrays.sort(nums);

        // Calculate the median
        if (nums.length % 2 == 0) {
            // If there are an even number of elements, return the average of the two middle elements
            int i = nums.length / 2;
            return (nums[i-1] + nums[i]) / 2.0;
        } else {
            // If there are an odd number of elements, return the middle element
            int i = nums.length / 2;
            return nums[i];
        }
    }
    public int findMedianSortedArrays15(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;
        int med1 = 0;
        int med2 = 0;
        for (int i=0; i<=(nums1.length+nums2.length)/2; i++) {
            med1 = med2;
            if (index1 == nums1.length) {
                med2 = nums2[index2];
                index2++;
            } else if (index2 == nums2.length) {
                med2 = nums1[index1];
                index1++;
            } else if (nums1[index1] < nums2[index2] ) {
                med2 = nums1[index1];
                index1++;
            }  else {
                med2 = nums2[index2];
                index2++;
            }
        }

        // the median is the average of two numbers
        if ((nums1.length+nums2.length)%2 == 0) {
            return (med1+med2)/2;
        }

        return med2;
    }
    public static int findMedianSortedArrays16(int[] nums1, int[] nums2) {
        int now=0;
        int pre=0;
        int n = (nums1.length+nums2.length)/2+1;
        int i=0;
        int j=0;
        int k=0;
        while(k<n){
            pre = now;
            if(i==nums1.length){
                now = nums2[j++];
            }
            else if(j==nums2.length){
                now = nums1[i++];
            }
            else now = nums1[i]<nums2[j]?nums1[i++]:nums2[j++];
            k++;
        }
        return (nums1.length+nums2.length)%2==1?now:(pre+now)/2;
    }
    public int findMedianSortedArrays17(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int k=(m+n)/2;
        int i=0, j=k;
        int lo=0, hi=Math.min(k,m);

        while (true) {
            i=lo+(hi-lo)/2;
            j=k-i;
            if (get(nums1,i)>=get(nums2,j-1)) {
                if (get(nums2,j)>=get(nums1,i-1)) break;
                else hi=i-1;
            }
            else lo=i+1;
        }
        if ((m+n)%2==1) return Math.min(get(nums1,i),get(nums2,j)); //odd
        return (Math.min(get(nums1,i),get(nums2,j))+Math.max(get(nums1,i-1),get(nums2,j-1)))/2;//even
    }
    private int get(int[] nums, int i) {
        if (i<0) return Integer.MIN_VALUE;
        if (i>=nums.length) return Integer.MAX_VALUE;
        return nums[i];
    }
}
