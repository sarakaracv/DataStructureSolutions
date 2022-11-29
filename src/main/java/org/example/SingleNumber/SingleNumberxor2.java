package org.example.SingleNumber;

public class SingleNumberxor2 {
    public static void main(String[] args) {
        int nums[]={2,2,7,8,8};

        System.out.println(singleNumber2(nums));
}

    private static int singleNumber2(int[] nums) {
        // that is the XOR impl. like x and 0 result=x x and x result=0; compare bit

        int uniqNum = 0;
        for (int each : nums) {
            uniqNum ^= each;
        } return uniqNum;
    }
    }

