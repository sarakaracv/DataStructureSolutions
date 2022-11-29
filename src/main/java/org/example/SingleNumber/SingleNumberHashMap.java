package org.example.SingleNumber;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberHashMap {
    public static void main(String[] args) {
        int nums[]={2,2,7,8,8};

        System.out.println(singleNumber3(nums));

    }
    public static int singleNumber3(int[] nums){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i]))
                map.replace(nums[i],map.get(nums[i]),map.get(nums[i])+1);
            else
                map.put(nums[i],1);
        }

        for(int i=0;i<nums.length;i++)
        {
            if(map.get(nums[i])==1)
                return nums[i];
        }
        return 0;
    }

}
