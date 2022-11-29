package org.example.SingleNumber;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SingleNumberHashSet {
    public static void main(String[] args) {
        int nums[] = {2, 2, 7, 8, 8};

        System.out.println(singleNumber4(nums));
    }

    public static int singleNumber4(int[] nums)
    {
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0; i<nums.length ;i++)
        {
            if(set.contains(nums[i]))
                set.remove(nums[i]);
            else
                set.add(nums[i]);
        }
        int out=0;
        Iterator<Integer> itr = set.iterator();
        while(itr.hasNext())
            out=itr.next();
        return out;
    }
}
