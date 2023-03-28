package org.example.leetCodeTask;

public class FactorialTrailingZeroes172 {
    public int trailingZeroes(int n) {

        if (n<5) return 0;
        return n/5+trailingZeroes(n/5);

    }
    public int trailingZeroes2(int n) {
        int count=0;
        while(n>0){
            count+=n/5;
            n/=5;
        }
        return count;
    }
}
