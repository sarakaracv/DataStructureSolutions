package org.example.leetCodeTask;

import java.util.*;
import java.util.stream.Collectors;

public class SquaresOfASortedArray977 {
    public static void main(String[] args) {
    int [] nums= {-4,-1,0,3,10};
    SquaresOfASortedArray977 sort= new SquaresOfASortedArray977();
        Arrays.stream(sort.sortedSquares2(nums)).forEach(System.out::println);
    }
    public int[] sortedSquares1(int[] A) {
        int[] result = new int[A.length];
        Arrays.setAll(result, n -> (int) Math.pow(A[n], 2));
        Arrays.sort(result);
        return result;
    }
    public int[] sortedSquares2(int[] A) {
        for(int i = 0; i < A.length; i++) {
            A[i]=A[i]*A[i];
           }
        Arrays.sort(A);
        return A;
    }
    public int[] sortedSquares3(int[] nums) {
        int left = 0, right = nums.length - 1, index = 0;
        int[] sol = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        while (left <= right) {
            if (nums[left] * -1 > nums[right]) {
                stack.push(nums[left] * nums[left]);
                left++;
            } else {
                stack.push(nums[right] * nums[right]);
                right--;
            }
        }
        while (!stack.isEmpty()) {
            sol[index++] = stack.pop();
        }

        return sol;
    }
    public int[] sortedSquares4(int[] nums) {
        int ans[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i]=nums[i]*nums[i];
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(ans[i]);
        }
        int k=0;
        while(!pq.isEmpty()){
            ans[k++]=pq.poll();
        }
        return ans;
    }
    public int[] sortedSquares5(int[] nums) {
        List<Integer> l1 = new ArrayList();
        for(Integer i:nums){
            l1.add(i);
        }
        List<Integer> l2 =l1.stream().map(x->x*x).sorted().collect(Collectors.toList());
        int res[] = new int[l2.size()];
        for(int i=0;i<l2.size();i++){
            res[i]+=l2.get(i);
        }
        return res;
    }
    public int[] sortedSquares6(int[] nums) {
        List<Integer> rs = Arrays.stream(nums).boxed().map((e) -> e * e).sorted().collect(Collectors.toList());
        return rs.stream().mapToInt(Integer::intValue).toArray();
    }
    public int[] sortedSquares7(int[] nums) {
        int firstPositive=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                firstPositive++;
            }
        }


        int [] firstArr = new int[nums.length-firstPositive];
        int j=0;
        for(int i=firstPositive;i<nums.length;i++){
            firstArr[j]=nums[i];
            j++;
        }

        int [] secondArr = new int[firstPositive];

        int i=0;
        for(int k=firstPositive-1; k>=0;k--){
            secondArr[i]=nums[k]*-1;
            i++;
        }

        nums = mergeSort(firstArr, secondArr);

        for(int l=0;l<nums.length;l++){
            nums[l]=nums[l]*nums[l];
        }

        return nums;
    }

    public int [] mergeSort(int [] firstArr, int [] secondArr){

        int i=0;
        int j=0;
        int k=0;
        int [] nums= new int [firstArr.length+secondArr.length];
        while(i<firstArr.length || j< secondArr.length){
            if(i>=firstArr.length){
                while(j< secondArr.length){
                    nums[k]=secondArr[j];
                    j++;k++;
                }
                return nums;
            }
            if(j>=secondArr.length){
                while(i< firstArr.length){
                    nums[k]=firstArr[i];
                    i++;k++;
                }
                return nums;
            }
            if(firstArr[i]<=secondArr[j]){
                nums[k]=firstArr[i];
                i++;k++;
            }else{
                nums[k]=secondArr[j];
                j++;k++;
            }
        }
        return nums;
    }
    public int[] sortedSquares8(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int)Math.pow(nums[i], 2);
        }
        Arrays.sort(nums);
        return nums;
    }
    public int[] sortedSquares9(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int i = 0, j = n - 1;
        for (int p = n - 1; p >= 0; p--) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                result[p] = nums[i] * nums[i];
                i++;
            } else {
                result[p] = nums[j] * nums[j];
                j--;
            }
        }
        return result;
    }
    public int[] sortedSquares10(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        int[] result = new int[nums.length];
        int index = nums.length - 1;


        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        while (start <= end) {
            if (nums[start] > nums[end]) {
                result[index--] = nums[start++];
            }
            else {
                result[index--] = nums[end--];
            }
        }

        return result;
    }
    public int[] sortedSquares11(int[] nums) {
        if (nums.length == 1) {
            nums[0] = nums[0] * nums[0];
            return nums;
        }
        int i = 0, j = 0, k = 0, f = 0;

        while (nums[i] < 0 && i < nums.length - 1)
            i++;
        if (i == nums.length)
            i--;
        j = i;
        k = j - 1;
        f = k;
        for (int s = 0; s < nums.length; s++) {
            nums[s] = nums[s] * nums[s];
        }

        while (k >= 0) {
            f = k;
            j = k + 1;
            while (j < nums.length && nums[j] < nums[k])
                j++;
            j--;
            int temp = nums[k];
            while (k != j) {
                nums[k] = nums[k + 1];
                k++;
            }
            nums[k] = temp;
            k = f - 1;
        }

        return nums;
    }
    public int[] sortedSquares12(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            nums[i] *= nums[i];
        }
        for(int i = nums.length - 1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if(nums[j] > nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
    public int[] sortedSquares13(int[] nums) {

        return Arrays.stream(nums).map(r -> r*r).sorted().toArray();

    }
    public int[] sortedSquares14(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            nums[i] *= nums[i];
        }

        int minIndex;
        int min;

        for (int i = 0; i < len; i++) {
            min = nums[i];
            minIndex = i;

            for (int j = i; j < len; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                nums[minIndex] = nums[i];
                nums[i] = min;
            }
        }
        return nums;
    }
    public int[] sortedSquares15(int[] nums)
    {
        for (int i = 0; i < nums.length; i++)
        {
            nums[i] = nums[i] * nums[i];

            int key = nums[i];
            int j = i - 1;

            while (j >= 0 && nums[j] > key)
            {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = key;
        }
        return nums;
    }
    public int[] sortedSquares16(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] res = new int[nums.length];
        for(int index = nums.length - 1; index >= 0; index--)
            res[index] = Math.abs(nums[left]) > Math.abs(nums[right]) ? nums[left] * nums[left++] : nums[right] * nums[right--];
        return res;
    }
    public int[] sortedSquares17(int[] A) {
        final int n = A.length;
        int[] ans = new int[n];
        int i = n - 1;

        for (int l = 0, r = n - 1; l <= r;)
            if (Math.abs(A[l]) > Math.abs(A[r]))
                ans[i--] = A[l] * A[l++];
            else
                ans[i--] = A[r] * A[r--];

        return ans;
    }
}
