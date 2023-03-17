package org.example.leetCodeTask;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak139 {
    public static void main(String[] args) {

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak1(0,s,new HashSet(wordDict));
    }
    private boolean wordBreak1(int p, String s, Set<String> dict){
        int n=s.length();
        if(p==n) {
            return true;
        }
        for(int i=p+1;i<=n;i++) {
            if(dict.contains(s.substring(p,i)) && wordBreak1(i,s,dict)) {
                return true;
            }
        }
        return false;
    }
    public boolean wordBreak3(String s,Set<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        int n = s.length();
        boolean[] db = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);
                if (wordDict.contains(sub) && (j == 0 || db[j - 1])) {
                    db[i] = true;
                    break;
                }
            }
        }
        return db[n - 1];
    }

        public boolean wordBreak3(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && set.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }