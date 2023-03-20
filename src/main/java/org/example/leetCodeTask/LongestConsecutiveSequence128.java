package org.example.leetCodeTask;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence128 {


        public int longestConsecutive(int[] nums) {
            Set<Integer> set= new HashSet<>();
            for (int num:nums) {
                set.add(num);
            }
            int max=0;
            for (int num:nums) {
                if (!set.contains(num - 1)) {
                    int cur = 1;
                    while (set.contains(num + cur)) {
                        cur++;
                    }
                    max = Math.max(max, cur);
                }
            }

            return max;
        }
}
