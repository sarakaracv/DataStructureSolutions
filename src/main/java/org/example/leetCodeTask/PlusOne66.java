package org.example.leetCodeTask;

import java.util.Arrays;

public class PlusOne66 {
    public static void main(String[] args) {
        int [] digits={1,2,3};
        System.out.println(plusOne(digits));
    }
    public static int [] plusOne(int [] digits){
        for(int i = digits.length - 1; i >= 0; i--){
            if(++digits[i] != 10) return digits;
            digits[i] = 0;
        }
        int [] res = new int[digits.length + 1];

        res[0] = 1;
        return res;
    }

    public int[] plusOne1(int[] digits) {
        int num= digits.length;
        for (int i=num-1;i>=0; i--){
            if (digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        int [] nums1= new int [num+1];
        nums1[0]=1;

        return nums1;

    }
}
