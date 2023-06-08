package org.example.leetCodeTask;
import java.util.*;

public class CountOfSmallerNumbersAfterSelf315 {
    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf315 count = new CountOfSmallerNumbersAfterSelf315();
        int[] nums = {5, 2, 6, 1};
        List<Integer> result = count.countSmaller1(nums);
        System.out.println(result); // Output: [2, 1, 1, 0]
    }
        public List<Integer> countSmaller1(int[] nums) {
            int n = nums.length;
            int[] count = new int[n];
            int[] indexes = new int[n];
            for (int i = 0; i < n; i++) {
                indexes[i] = i;
            }
            mergeSort(nums, indexes, count, 0, n - 1);
            List<Integer> result = new ArrayList<>();
            for (int num : count) {
                result.add(num);
            }
            return result;
        }

        private void mergeSort(int[] nums, int[] indexes, int[] count, int start, int end) {
            if (start >= end) {
                return;
            }
            int mid = start + (end - start) / 2;
            mergeSort(nums, indexes, count, start, mid);
            mergeSort(nums, indexes, count, mid + 1, end);
            merge(nums, indexes, count, start, mid, end);
        }

        private void merge(int[] nums, int[] indexes, int[] count, int start, int mid, int end) {
            int[] mergedIndexes = new int[end - start + 1];
            int leftIndex = start;
            int rightIndex = mid + 1;
            int rightCount = 0;
            int mergedIndex = 0;
            while (leftIndex <= mid && rightIndex <= end) {
                if (nums[indexes[rightIndex]] < nums[indexes[leftIndex]]) {
                    mergedIndexes[mergedIndex] = indexes[rightIndex];
                    rightCount++;
                    rightIndex++;
                } else {
                    mergedIndexes[mergedIndex] = indexes[leftIndex];
                    count[indexes[leftIndex]] += rightCount;
                    leftIndex++;
                }
                mergedIndex++;
            }
            while (leftIndex <= mid) {
                mergedIndexes[mergedIndex] = indexes[leftIndex];
                count[indexes[leftIndex]] += rightCount;
                leftIndex++;
                mergedIndex++;
            }
            while (rightIndex <= end) {
                mergedIndexes[mergedIndex] = indexes[rightIndex];
                rightIndex++;
                mergedIndex++;
            }
            System.arraycopy(mergedIndexes, 0, indexes, start, mergedIndexes.length);
        }

    public List<Integer> countSmaller2(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            final int v = nums[i];
            if (v < min) {
                min = v;
            } else if (v > max) {
                max = v;
            }
        }
        final int delta = -min + 1;
        final int[] arr = new int[max + delta + 1];
        final int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            final int v = nums[i] + delta;
            res[i] = get(arr, v - 1);
            add(arr, v);
        }
        return new java.util.AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                return res[index];
            }
            @Override
            public int size() {
                return res.length;
            }
        };
    }
    static int get(final int[] arr, int v) {
        int sum = 0;
        for (; v > 0; v -= v & -v)
            sum += arr[v];
        return sum;
    }
    static void add(final int[] arr, int v) {
        for (; v < arr.length; v += v & -v)
            arr[v]++;
    }
    // third sol
    public List<Integer> countSmaller3(int[] nums) {

        int offset = 10000;
        int size = 2 * 10000 + 2;  // 0 is dummy root, 1~20001
        int[] tree = new int[size]; // 0 ~ 20001
        List<Integer> res = new ArrayList<>();

        for(int i = nums.length - 1; i >= 0; i--){
            int val = query(nums[i] + offset, tree);
            res.add(val);
            update(nums[i] + offset, 1, size, tree);
        }
        Collections.reverse(res);
        return res;
    }

    private int query(int index, int[] tree){

        int res = 0;
        while(index >= 1){
            res += tree[index];
            index -= index & -index;
        }
        return res;
    }

    private void update(int index, int value, int size, int[] tree){

        index++;
        while(index < size){
            tree[index] += value;
            index += index & -index;
        }
    }
    //forth sol

    int[] index;
    int[] temp;
    int[] res;

    public List<Integer> countSmaller4(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int len = nums.length;
        if(len==0) return new ArrayList<>();

        index = new int[len];
        for(int i=0; i<len; i++) index[i] = i;

        res = new int[len];
        temp = new int[len];

        divide(nums, 0, len-1);

        for(int i=0; i<len; i++){
            result.add(res[i]);
        }
        return result;
    }

    private void divide(int[] nums, int start, int end){
        if(start == end) return;

        int mid = (end-start)/2 + start;

        divide(nums, start, mid);
        divide(nums, mid+1, end);
        if(nums[index[mid]]<=nums[index[mid+1]]) return;
        conquer(nums, start, mid, end);
    }

    private void conquer(int[] nums, int start, int mid, int end){
        for(int i=start; i<=end; i++) temp[i] = index[i];

        int i=start, j=mid+1;
        int k = start;
        while(i<=mid || j<=end){
            if(i>mid) index[k++] = temp[j++];
            else if(j>end){
                index[k] = temp[i++];
                res[index[k++]] += (end-mid);
            }else if(nums[temp[i]]<=nums[temp[j]]){
                index[k] = temp[i++];
                res[index[k++]] += (j - mid - 1);
            }else{
                index[k++] = temp[j++];
            }
        }

    }

    //fifth sol

    public List<Integer> countSmaller6(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] indices = new int[n];
        int[] aux = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        mergeSort(indices, 0, n-1, result, nums, aux);
        // change int[] to List to return
        List<Integer> resultToReturn = new ArrayList<Integer>(n);
        for (int i : result) {
            resultToReturn.add(i);
        }
        return resultToReturn;
    }

    private void mergeSort(int[] indices, int left, int right, int[] result, int[] nums, int[] aux) {
        if (right <= left) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(indices, left, mid, result, nums, aux);
        mergeSort(indices, mid+1, right, result, nums, aux);
        merge(indices, left, right, mid, result, nums, aux);
    }

    private void merge(int[] indices, int left, int right, int mid, int[] result, int[] nums, int[] aux) {
        int i = left;
        int j = mid + 1;

        for (int k = left; k <= right; k++) {
            if (i > mid) {
                aux[k] = indices[j];
                j++;
            } else if (j > right) {
                aux[k] = indices[i];
                result[indices[i]] += j - mid - 1;
                i++;
            } else if (nums[indices[i]] <= nums[indices[j]]) {
                aux[k] = indices[i];
                result[indices[i]] += j - mid - 1;
                i++;
            } else {
                aux[k] = indices[j];
                j++;
            }
        }

        for (int k = left; k <= right; k++) {
            indices[k] = aux[k];
        }
    }
    
    }

