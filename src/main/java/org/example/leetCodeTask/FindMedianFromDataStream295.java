package org.example.leetCodeTask;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream295 {
    public static void main(String[] args) {
   String [] num= {"MedianFinder","addNum","addNum","findMedian","addNum","findMedian"};
    }
    private PriorityQueue<Integer> max;
    private PriorityQueue<Integer> min;

    public FindMedianFromDataStream295() {
        max= new PriorityQueue<>((a,b)->b-a);
        min= new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(max.isEmpty()||num<=max.peek()) max.offer(num);
        else min.offer(num);
        if(max.size()>min.size()+1) min.offer(max.poll());
        else if(min.size()>max.size()) max.offer(min.poll());

    }

    public double findMedian() {
        if(min.size()==max.size()) return (max.peek()+min.peek())/2.0;
        else return max.peek();
    }
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
class MedianFinder {

    Queue<Integer> minHeap = new PriorityQueue<>(), maxHeap = new PriorityQueue<>((a, b) -> b - a);
    double median = 0.0;

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (num > median) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }

        int dist = Math.abs(minHeap.size() - maxHeap.size());

        if (dist == 1) {
            if (minHeap.size() > maxHeap.size()) {
                median = minHeap.peek();
            } else {
                median = maxHeap.peek();
            }
        }
        else if (dist == 2) {
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.remove());
            } else {
                minHeap.offer(maxHeap.remove());
            }
            dist = 0;
        }

        if (dist == 0) {
            median = (maxHeap.peek()+ minHeap.peek())/2.0;
        }
    }

    public double findMedian() {
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
class MedianFinder2 {
    private PriorityQueue<Integer> leftHeap;
    private PriorityQueue<Integer> rightHeap;

    public MedianFinder2() {
        leftHeap = new PriorityQueue<>((a, b) -> b - a);  // maxHeap
        rightHeap = new PriorityQueue<>((a, b) -> a - b);  // minHeap
    }

    public void addNum(int num) {
        leftHeap.add(num);
        // remove and put element in right if:
        // 1. if left is longer than right.
        // 2. if max element in left is greater than min element in right
        if ((leftHeap.size() - rightHeap.size() > 1) || (!rightHeap.isEmpty() && leftHeap.peek() > rightHeap.peek()))
            rightHeap.add(leftHeap.poll());

        // remove and put element in left if right is longer than left
        if (rightHeap.size() - leftHeap.size() > 1)
            leftHeap.add(rightHeap.poll());
    }

    public double findMedian() {
        if (leftHeap.size() == rightHeap.size()){
            return (double) (leftHeap.peek() + rightHeap.peek())/2;

        }
        else if (leftHeap.size() > rightHeap.size())
            return (double)leftHeap.peek();
        else
            return (double)rightHeap.peek();
    }
    }

