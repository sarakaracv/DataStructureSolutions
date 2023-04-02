package org.example.leetCodeTask;

import java.util.Arrays;

public class LongestSubstringWithKRepeatingCharacters395 {
        public int longestSubstring1(String s, int k) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int[] count = new int[26];
            int maxLen = 0;
            for (int i = 0; i < s.length(); i++) {
                Arrays.fill(count, 0);
                for (int j = i; j < s.length(); j++) {
                    count[s.charAt(j) - 'a']++;
                    if (isValid(count, k)) {
                        maxLen = Math.max(maxLen, j - i + 1);
                    }
                }
            }
            return maxLen;
        }

        private boolean isValid(int[] count, int k) {
            for (int i = 0; i < count.length; i++) {
                if (count[i] > 0 && count[i] < k) {
                    return false;
                }
            }
            return true;
        }
    public int longestSubstring2(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = new char[26];
        for (int i = 0; i < s.length(); i += 1) chars[s.charAt(i) - 'a'] += 1;
        boolean flag = true;
        for (int i = 0; i < chars.length; i += 1) {
            if (chars[i] < k && chars[i] > 0) flag = false;
        }
        if (flag == true) return s.length();
        int result = 0;
        int start = 0, cur = 0;
        while (cur < s.length()) {
            if (chars[s.charAt(cur) - 'a'] < k) {
                result = Math.max(result, longestSubstring2(s.substring(start, cur), k));
                start = cur + 1;
            }
            cur++;
        }
        result = Math.max(result, longestSubstring2(s.substring(start), k));
        return result;
    }
    public int longestSubstring3(String s, int k) {
        int n=s.length();

        return longest(0,n,s,k);
    }
    int longest(int start,int end,String s,int k)//recursive function to divide the array at freq<k
    {
        int n=end-start;
        int a=start;
        int freq[]=new int[123];
        for(int i=start;i<end;i++)
        {
            freq[s.charAt(i)]++;
        }

        while(start<end)
        {
            if(freq[s.charAt(start)]<k)
            {

                return Math.max(longest(a,start,s,k),longest(start+1,end,s,k));//since n is used in main longestfunction
                //call we will use only start(exclusive type) in first longest function call;
                //and not start-1;
            }
            start++;
        }

        return n;
    }
    public int longestSubstring4(String s, int k) {
        int n = s.length();
        return longest(s,0,n-1,k);
    }
    public int longest(String s, int low, int high, int k)
    {

        if(high-low+1<k)
            return 0;
        int[] arr = new int[26];
        for(int i=low;i<=high;i++)
            arr[s.charAt(i)-'a']++;
        for(int i=low;i<=high;i++)
        {
            if(arr[s.charAt(i)-'a']<k)
            {
                int a = longest(s,low,i-1,k);
                int b = longest(s,i+1,high,k);
                return Math.max(a,b);
            }
        }
        return high-low+1;
    }
    public int longestSubstring5(String s, int k) {
        int n = s.length(); int j = 0;
        int[] ff = new int[26];
        char[] c = s.toCharArray();
        for(int i = 0; i < n; i++){
            ff[c[i]-'a']++;
        }
        for(int i = 0; i < n; i++){
            if(ff[c[i]-'a'] < k){
                int lf = longestSubstring5(s.substring(0,i), k);
                int rt = longestSubstring5(s.substring(i+ 1, s.length()), k);

                return Math.max(lf , rt);
            }
        }
        return n;
    }
}


