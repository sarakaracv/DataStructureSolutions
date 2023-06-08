package org.example.leetCodeTask;

import java.util.*;

public class SlidingWindowMaximum239 {
    public static void main(String[] args) {

    }
//first is not passing second one is passed
    public int [] maxSlidingWindow1(int[] nums, int k){
        PriorityQueue<Integer> heap= new PriorityQueue<>(Collections.reverseOrder());
        int n=nums.length;
        int [] result= new int[n-k+1];
        int j=0;
        for (int i = 0; i <n ; i++) {
            heap.add(nums[i]);
            if (heap.size()>k) heap.remove(nums[j++]);
            if (i>=k-1)result[i-k+1]=heap.peek();
        }
        return result;
    }

        public int[] maxSlidingWindow2(int[] nums, int k) {
            if (nums.length == 0) return new int[0];
            int n = nums.length;
            int[] result = new int[n - k + 1];
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                    deque.poll();
                }
                while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offer(i);
                if (i >= k - 1) {
                    result[i - k + 1] = nums[deque.peek()];
                }
            }
            return result;
    }
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int N = nums.length;
        int[] res = new int[N - k + 1];
        int[] left = new int[N];
        int[] right = new int[N];
        for (int i = 0; i < N; i += k) {
            int max = Integer.MIN_VALUE;
            int rightBound = Math.min(i + k - 1, N - 1);
            // from left to right -->
            for (int j = i; j <= rightBound; j++) {
                if (nums[j] > max)
                    max = nums[j];
                left[j] = max;
            }
            // from right to left <--
            max = Integer.MIN_VALUE;
            for (int j = rightBound; j >= i; j--) {
                if (nums[j] > max)
                    max = nums[j];
                right[j] = max;
            }
        }
        for (int i = 0; i < N - k + 1; i++) {
            int j = i + k - 1;
            res[i] = Math.max(right[i], left[j]);
        }
        return res;
    }
    public int[] maxSlidingWindow4(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        int [] left = new int[n];
        left[0] = nums[0];
        int [] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            // from left to right
            if (i % k == 0) left[i] = nums[i];  // block_start
            else left[i] = Math.max(left[i - 1], nums[i]);

            // from right to left
            int j = n - i - 1;
            if ((j + 1) % k == 0) right[j] = nums[j];  // block_end
            else right[j] = Math.max(right[j + 1], nums[j]);
        }

        int [] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++)
            output[i] = Math.max(left[i + k - 1], right[i]);

        return output;
    }
    public int[] maxSlidingWindow5(int[] nums, int k) {
        LinkedList<Integer> windowDequeue = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < k - 1; i++) {
            addToDequeue(windowDequeue, nums[i]);
        }
        for (int i = k - 1; i < nums.length; i++) {
            addToDequeue(windowDequeue, nums[i]);
            result[i - (k - 1)] = windowDequeue.peekFirst();

            int valueLeavingWindow = nums[i - k + 1];
            if (windowDequeue.peekFirst() == valueLeavingWindow) {
                windowDequeue.pollFirst();
            }
        }

        return result;
    }
    private void addToDequeue(LinkedList<Integer> dequeue, int value) {
        while(dequeue.peekLast() != null && dequeue.peekLast() < value) {
            dequeue.pollLast();
        }
        dequeue.addLast(value);
    }
    /*

     1 1 3
     ->
     dequeue
     3 */
    public int[] maxSlidingWindow6(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> maxInWindow = new ArrayDeque<>(k);

        for (int i = 0; i < k; i++) {
            int num = nums[i];
            while (!maxInWindow.isEmpty() && num > maxInWindow.peekLast()) {
                maxInWindow.removeLast();
            }

            maxInWindow.addLast(num);
        }

        int[] res = new int[n - k + 1];
        res[0] = maxInWindow.peekFirst();

        for (int i = k; i < n; i++) {
            int num = nums[i];

            if (nums[i - k] == maxInWindow.peekFirst()) maxInWindow.removeFirst();

            while (!maxInWindow.isEmpty() && num > maxInWindow.peekLast()) {
                maxInWindow.removeLast();
            }
            maxInWindow.addLast(num);

            res[i - k + 1] = maxInWindow.peekFirst();
        }

        return res;
    }
    public int[] maxSlidingWindow7(int[] nums, int k) {
        int n=nums.length;
        int []r=new int[n-k+1];

        int ri=0;
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            if(!dq.isEmpty() && dq.peek()==i-k){
                dq.poll();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i>=k-1){
                r[ri++]=nums[dq.peek()];

            }
        }
        return r;
    }

}
