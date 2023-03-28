package org.example.leetCodeTask;

public class SumOfTwoIntegers372 {
    public int getSum1(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
    public int getSum2(int a, int b) {
        return a+b;
    }
    public int getSum3(int a, int b){
        int c;
        while(b!=0){
            c=(a&b);
            a=a^b;
            b=c<<1;
        }
        return a;
    }
    public int getSum4(int a, int b){
        int sum=Integer.sum(a,b);
        return sum;
    }
    public int getSum5(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }

        return (int) Math.log10(Math.pow(10,a)*Math.pow(10,b));
    }

    }

