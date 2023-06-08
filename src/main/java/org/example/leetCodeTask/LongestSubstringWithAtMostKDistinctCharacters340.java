package org.example.leetCodeTask;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters340 {
        public int lengthOfLongestSubstringKDistinct1(String s, int k) {
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
        public int lengthOfLongestSubstringKDistinct2(String s, int k) {
            if (s == null || s.length() == 0 || k == 0) {
                return 0;
            }
            int[] freq = new int[256];
            int left = 0, right = 0, maxLen = 0, numDistinct = 0;
            while (right < s.length()) {
                if (freq[s.charAt(right)] == 0) {
                    numDistinct++;
                }
                freq[s.charAt(right)]++;
                while (numDistinct > k) {
                    freq[s.charAt(left)]--;
                    if (freq[s.charAt(left)] == 0) {
                        numDistinct--;
                    }
                    left++;
                }
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            }
            return maxLen;
        }
}
