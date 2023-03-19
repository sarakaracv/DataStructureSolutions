package org.example.leetCodeTask;

public class ReverseBits190 {
    public static void main(String[] args) {

    }
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result=0;
        for (int i = 0; i < 32; i++) {
            result<<=1;
            result|=n&1;
            n>>>=1;
        }
        return result;

    }
    public int reverseBits2(int n) {

        return Integer.reverse(n);
    }
}
