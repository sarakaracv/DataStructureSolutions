package org.example.leetCodeTask;

import java.util.*;

public class RotateArray189 {
    public static void main(String[] args) {

    }

    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate2(int[] nums, int k) {
        int length = nums.length;
        int rk = k % length;
        int[] copy = new int[length * 2];
        for (int i = 0; i < 2 * length; i++) {
            copy[i] = nums[i % length];
        }
        for (int t = length - rk, i = 0; t < 2 * length - rk; t++, i++) {
            nums[i] = copy[t];

        }
    }
    public void rotate3(int[] nums, int k) {
        int l = nums.length;
        k %= l;
        if (k > 0) {
            for (int st = 0, current, last = nums[0], swap, step = l; step > 0; ++st) {
                current = st;
                do {
                    swap = nums[current];
                    nums[current] = last;
                    last = swap;
                    current = (current + k) % l;
                    --step;
                } while (current != st);
                nums[st] = last;
            }
        }
    }
    public void rotate4(int[] nums, int k) {
        if(nums == null || nums.length == 0) return;
        int len = nums.length;
        while( k > len){
            k -= len;
        }
        int[] temp = new int[len + len];
        System.arraycopy(nums, 0, temp, 0, len);
        System.arraycopy(nums, 0, temp, len, len);
        for(int i = 0; i < len; i++){
            nums[i] = temp[i + len - k];
        }
    }
    public void rotate5(int[] nums, int k) {
        k = k %nums.length;
        if(k==0)
            return;
        int[] rot = new int[nums.length];
        System.arraycopy(nums, 0, rot, k, nums.length-k);
        System.arraycopy(nums, nums.length-k, rot, 0, k);
        System.arraycopy(rot, 0, nums, 0, rot.length);
    }
    public void rotate6(int[] nums, int k) {
        int[] temp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            temp[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }
    public void rotate7(int[] nums, int k)
    {
        int[] arr = new int[nums.length];
        for( int i=0; i< nums.length; i++ )
        {
            arr[(i+k)% nums.length] = nums[i];
        }

        for( int i=0; i< nums.length; i++ )
        {
            nums[i] = arr[i];
        }

    }
    public void rotate8(int[] nums, int k) {

        k = k%nums.length;
        int noOfRotation = 0;
        int increment = 0;
        boolean flag = true;

        while(nums.length > k + increment && flag){
            noOfRotation++;
            int index = 0 + increment;
            int rotatedIndex = (index + k)%nums.length;
            int tempIndexValue = nums[index];
            int tempRotatedIndexValue = nums[rotatedIndex];

            nums[rotatedIndex] = tempIndexValue;
            index = rotatedIndex;
            tempIndexValue = tempRotatedIndexValue;
            rotatedIndex = (index + k)%nums.length;
            tempRotatedIndexValue = nums[rotatedIndex];

            while(rotatedIndex != k + increment){
                nums[rotatedIndex] = tempIndexValue;
                index = rotatedIndex;
                tempIndexValue = tempRotatedIndexValue;
                rotatedIndex = (index + k)%nums.length;
                tempRotatedIndexValue = nums[rotatedIndex];
                noOfRotation++;
            }

            if(noOfRotation < nums.length)
                increment++;
            else
                flag = false;

        }

    }
    public void rotate9(int[] nums, int k) {
        Queue<Integer> queue = new LinkedList();
        int n = nums.length, t = 0;
        k %= n;
        for(int i = 0; i < n; i++)
            queue.add(nums[i]);

        for(int i = 0; i < n-k; i++)
            queue.add(queue.remove());

        while(!queue.isEmpty())
            nums[t++] = queue.remove();
    }
    public  void rotate10(int[] nums, int k) {
        if(nums == null || nums.length < 2){
            return;
        }
        k = k % nums.length;
        reverse1(nums, 0, nums.length - k - 1);
        reverse1(nums, nums.length - k, nums.length - 1);
        reverse1(nums, 0, nums.length - 1);
    }
    public void reverse1(int[] nums, int i, int j){
        int tmp = 0;
        while(i < j){
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
    public void rotate11(int[] nums, int k) {
        int n=nums.length,i=0,j=n-1;
        k=k%n;
        while(i<j)
        {
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            ++i;
            --j;
        }
        i=0;
        j=k-1;
        while(i<j)
        {
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            ++i;
            --j;
        }
        i=k;
        j=n-1;
        while(i<j)
        {
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            ++i;
            --j;
        }
    }
    public void rotate12(int[] nums, int k) {
        if(k > nums.length)
            k=k%nums.length;
        int[] result = new int[nums.length];
        for(int i=0; i < k; i++){
            result[i] = nums[nums.length-k+i];
        }
        int j=0;
        for(int i=k; i<nums.length; i++){
            result[i] = nums[j];
            j++;
        }
        System.arraycopy( result, 0, nums, 0, nums.length );
    }
    public void rotate13(int[] nums, int k) {
    // Reverse nums array
    k=k%nums.length;

        if(nums.length > 1){
        reverse2(0, nums.length-1, nums);
        reverse2(0, k-1, nums);
        reverse2(k, nums.length-1, nums);
    }
}
    private void reverse2(int left, int right, int[] nums){

        while(left < right){
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left ++;
            right--;
        }
    }
    public void rotate14(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
    public void rotate15(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
    public void rotate16(int[] nums, int k) {
        k = k%nums.length;
        swap(nums, 0, nums.length-1);
        swap(nums, 0, k-1);
        swap(nums, k, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
    static void swap(int[] nums, int left, int right){
        while(left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    public void rotate17(int[] nums, int k) {
        int l = nums.length;
        int[] arr = new int[l];
        if(k>1)
            k = k % l;
        if(l==1)
            k = 1;
        for(int i = 0; i < l-k; i++)
            arr[i] = nums[i];
        for(int i = 0; i < l; i++) {
            if(i<k)
                nums[i] = nums[l-k+i];
            else
                nums[i] = arr[i-k];
        }
        System.out.println(Arrays.toString(nums));
    }
    public int[] reverse3(int[] nums,int l,int m){
        for(int i=l;i<(l+m)/2;i++){
            int k = nums[i];
            nums[i] = nums[m-1-i];
            nums[m-1-i] = k;
        }
        for(int i : nums){
            System.out.print(i + " ");
        }
        System.out.println();
        return nums;
    }
    public int[] reverse_last(int[] nums,int l,int m){
        int j = m-1;
        for(int i=l;i<m;i++){
            if(i>=((m-l)/2)+l && j<i){
                break;
            }
            int k = nums[i];
            nums[i] = nums[j];
            nums[j] = k;
            j--;
        }
        for(int i : nums){
            System.out.print(i + " ");
        }
        System.out.println();
        return nums;
    }
    public void rotate18(int[] nums, int k) {
        int n = nums.length;
        if(k>0 && k!=n){
            k = k%n;
            reverse3(nums,0,n);
            reverse3(nums,0,k);
            reverse_last(nums,k,n);
        }
    }
    public void rotate19(int[] nums, int k) {

        int l=0; int r= nums.length-1;
        if(k> nums.length) k = k% nums.length;
        reverse4(nums,l,r);
        reverse4(nums,l,k-1);
        reverse4(nums,k,r);
        Arrays.stream(nums).forEach(value -> System.out.println(value));
    }

    void reverse4(int[] nums, int l, int r){
        while (l<r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++; r--;
        }
    }
    public void rotate20(int[] nums, int k) {
        // step1: reverse the array
        // step2: split the array into two.
        // step3: reverse both the two parts.

        //taking k modulo for edge cases
        int i;
        k = k%nums.length;
        swap2(nums, 0, nums.length-1);
        for(i=0;i<nums.length;i++)
            System.out.print(nums[i]+" ");
        System.out.println();
        swap2(nums, 0, k-1);
        for(i=0;i<nums.length;i++)
            System.out.print(nums[i]+" ");
        System.out.println();
        swap2(nums, k, nums.length-1);
        for(i=0;i<nums.length;i++)
            System.out.print(nums[i]+" ");
        System.out.println();
    }
    public void swap2(int[] arr, int start, int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public void rotate21(int[] nums, int k) {
        int[] nums_tmp= new int[nums.length];
        int cnt = nums.length - k;
        int start = k;
        int end= nums.length -1 ;
        for (int i = 0; i < nums.length; i++) {
            nums_tmp[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums_tmp[i];
        }
        for(int a=0; a<nums.length;a++)
        {
            System.out.print(nums_tmp[a]+", ");
        }
        System.out.println("-----");

    }
    public void rotate22(int[] nums, int k) {
        int n=nums.length;
        int x=0;
        int result[]= new int[n];
        k = k % n;
        if(k < 0){
            k += nums.length;
        }
        for(int i=n-k;i<n;i++)
        {
            result[x]=nums[i];
            x++;
        }
        for(int j=0;j<n-k;j++)
        {
            result[x]=nums[j];
            x++;
        }
        for(int a=0;a<n;a++)
        {
            nums[a]=result[a];
            System.out.print(nums[a]);
        }
    }
    public void rotate23(int[] nums, int k) {
        int[] cpy = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < nums.length; i++) {
            int newOffset = k + i;
            int newPos;
            if (newOffset >= nums.length) {
                newOffset %= nums.length ;
            }
            System.out.println(newOffset);
            nums[newOffset] = cpy[i];
        }
    }
    public static void reverse5(int[] arr,int a, int b){
        int i = a;
        int j = b;
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }

    }

    public void rotate24(int[] nums, int k) {
        k %= nums.length;

        int part1 = nums.length - k - 1;
        int part2 = nums.length - k;

        reverse5(nums,0,part1);
        reverse5(nums,part2,nums.length - 1);
        reverse5(nums,0,nums.length - 1);

        for(int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }
    public void rotate25(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        int[] result = new int[len];
        int cur = 0, next = 0, curIdx = 0, nextIdx = 0, cnt = k < len ? k : len;

        if (k == 0) {
            return;
        }
        for (int i = 0; i < cnt; i++) {
            curIdx = i;
            cur = nums[curIdx];
            while (!set.contains(curIdx)) {
                nextIdx = (curIdx + k) % len;
                next = nums[nextIdx];
                nums[nextIdx] = cur;
                cur = next;
                set.add(curIdx);
                curIdx = nextIdx;
            }
        }
    }
        public void rotate26 ( int[] nums, int k){
              int n = nums.length;
              int[] result1 = new int[n];
              if (n == 1) return;
              for (int i = n - 1; i >= 0; i--) {
                  int j = i - k;

                while (j < 0) {
                    j = j + n;
                }
                System.out.println(i + ", " + j + ", " + k);
                result1[i] = nums[j];

            }
            System.out.println(Arrays.toString(result1));
            //return result;
            for (int i = 0; i < n; i++)
                nums[i] = result1[i];

        }
    public void rotate27(int[] nums, int k) {
        int i=0,start=0,end=nums.length-1,temp;
        List<Integer> convert=new ArrayList<>();
        for(int cur:nums) convert.add(cur);
        Collections.reverse(convert);
        if(k>nums.length) k=k%nums.length;
        if(k==0) return;
        for(int j=k-1;i<k;i++,j--) {
            nums[j]=convert.get(i);
            System.out.println(j+" "+convert.get(i));
        }
        for(start=k;start<nums.length;start++,end--) {
            nums[start]=convert.get(end);
        }
    }
    public void reverseFromIndex(int arr[], int l, int r){
        // int mid
        // 0,2
        for(int i=l, j=r;i<j;i++,--j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            System.out.println(temp);
        }
        System.out.println(l+" "+r);
        System.out.println(Arrays.toString(arr));
    }

    public void rotate28(int[] nums, int k) {
        k=k%(nums.length);
        reverseFromIndex(nums, 0, nums.length-1);
        reverseFromIndex(nums, 0, k-1);
        reverseFromIndex(nums,k,nums.length-1);

    }
    }

