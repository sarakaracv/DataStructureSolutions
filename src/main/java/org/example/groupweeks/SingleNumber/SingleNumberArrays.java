package org.example.groupweeks.SingleNumber;

import java.util.ArrayList;
import java.util.List;

public class SingleNumberArrays {
    public static void main(String[] args) {
        int nums[] = {2, 2, 7, 8, 8};

        System.out.println(singleNumberarray(nums));

    }
    public static int singleNumberarray(int[] nums)
    {
        List<Integer> list=new ArrayList<>();

        for(int i=0; i< nums.length; i++){

            if(list.contains(nums[i])){
                Integer obj=new Integer(nums[i]);
                list.remove(obj);
            }
            else
                list.add(nums[i]);

        }
        int unique=list.get(0);
        return unique;
    }
}
