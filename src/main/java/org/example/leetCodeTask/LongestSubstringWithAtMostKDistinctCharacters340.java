package org.example.leetCodeTask;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters340 {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            if (s == null || s.length() == 0 || k == 0) {
                return 0;
            }

            int n = s.length();
            int left = 0, right = 0;
            int maxLen = 1;
            Map<Character, Integer> map = new HashMap<>();

            while (right < n) {
                char c = s.charAt(right);
                map.put(c, map.getOrDefault(c, 0) + 1);

                while (map.size() > k) {
                    char d = s.charAt(left);
                    int count = map.get(d);
                    if (count == 1) {
                        map.remove(d);
                    } else {
                        map.put(d, count - 1);
                    }
                    left++;
                }

                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            }

            return maxLen;
        }
    }
