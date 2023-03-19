package org.example.leetCodeTask;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges163 {

        public List<String> findMissingRanges(int[] nums, int lower, int upper) {
            List<String> result = new ArrayList<>();
            int i = 0;
            while (i < nums.length && nums[i] < lower) {
                i++;
            }
            int prev = lower - 1;
            for (; i <= nums.length; i++) {
                int curr = (i == nums.length) ? upper + 1 : nums[i];
                if (curr - prev > 1) {
                    result.add(getRange(prev + 1, curr - 1));
                }
                prev = curr;
            }
            return result;
        }

        private String getRange(int start, int end) {
            return (start == end) ? Integer.toString(start) : start + "->" + end;
        }
        public List<String> findMissingRanges2(int[] nums, int lower, int upper) {
            List<String> result = new ArrayList<>();
            int i = 0;
            while (i < nums.length && nums[i] < lower) {
                i++;
            }
            int prev = lower - 1;
            for (; i <= nums.length; i++) {
                int curr = (i == nums.length) ? upper + 1 : nums[i];
                if (curr - prev > 1) {
                    result.add(getRange2(prev + 1, curr - 1));
                }
                prev = curr;
            }
            return result;
        }

        private String getRange2(int start, int end) {
            return (start == end) ? Integer.toString(start) : start + "->" + end;
        }
    }

