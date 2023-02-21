package org.example.leetCodeTask;

public class Sqrt69 {
    public static void main(String[] args) {
    int num=4;
        System.out.println(mySqrt(num));
    }
    public static int mySqrt(int x){
        int start = 0, end = x;
        while (start < end) {
            int mid = (start + end + 1)/2;
            if (mid <= x / mid) {
                start= mid;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

}
