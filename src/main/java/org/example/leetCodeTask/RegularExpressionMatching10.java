package org.example.leetCodeTask;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class RegularExpressionMatching10 {
    public static void main(String[] args) {

    }
    public boolean isMatchs(String s, String p) {
        return s.matches(p);
    }

    public boolean isMatch1(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        if (p.length() > 1 && p.charAt(1) == '*') {  // second char is '*'
            if (isMatch1(s, p.substring(2))) return true;
            if (s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
                return isMatch1(s.substring(1), p);
            }
            return false;
        } else {                                     // second char is not '*'
            if (s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
                return isMatch1(s.substring(1), p.substring(1));
            }
            return false;
        }
    }

    Boolean[][] dp;

    public boolean isMatch2(String s, String p) {
        // return true;
        dp = new Boolean[s.length() + 1][p.length() + 1];
        return help(0, 0, s, p);
    }

    public boolean help(int i, int j, String s, String p) {
        // if(i>=s.length() && j>=p.length()) return false;
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        boolean ans;

        if (j == p.length()) {
            ans = i == s.length();
        } else {
            boolean match = (i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));

            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                ans = (help(i, j + 2, s, p) || match && help(i + 1, j, s, p));
            } else {
                ans = match && help(i + 1, j + 1, s, p);
            }
        }
        dp[i][j] = ans;
        return ans;
    }
// enum Result {
//     TRUE, FALSE
// }

// class Solution {
//     Result[][] memo;

//     public boolean isMatch(String text, String pattern) {
//         memo = new Result[text.length() + 1][pattern.length() + 1];
//         return dp(0, 0, text, pattern);
//     }

//     public boolean dp(int i, int j, String text, String pattern) {
//         if (memo[i][j] != null) {
//             return memo[i][j] == Result.TRUE;
//         }
//         boolean ans;
//         if (j == pattern.length()){
//             ans = i == text.length();
//         } else{
//             boolean first_match = (i < text.length() &&
//                                    (pattern.charAt(j) == text.charAt(i) ||
//                                     pattern.charAt(j) == '.'));

    //             if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
//                 ans = (dp(i, j+2, text, pattern) ||
//                        first_match && dp(i+1, j, text, pattern));
//             } else {
//                 ans = first_match && dp(i+1, j+1, text, pattern);
//             }
//         }
//         memo[i][j] = ans ? Result.TRUE : Result.FALSE;
//         return ans;
//     }
// }
    public boolean isMatch3(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public boolean isMatch4(String s, String p) {
        //dp[i][j] s的前i个字符和p的前i个字符是否匹配
        // if(charAt(j-1) == charAt(i-1)) dp[i][j] = dp[i-1][j-1]
        //if(p.charAt(j-1) == '.') dp[i][j] = dp[i-1][j-1]
        // if(p.charAt(j-1) == '*') dp[i][j] = dp[i][j-1] || (dp[i-1][j] && charAt(i-1) == charAt(j-2)
        // aaaba "a*ba"
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 2; i <= m; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    // 1. 取0个或1个
                    dp[i][j] = dp[i][j - 2] || dp[i][j - 1];
                    // 3. 取1个及以上
                    if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[n][m];
    }

//leetcode submit region end(Prohibit modification and deletion)
//Wrong Answer: input:"aab" "c*a*b" Output:false Expected:true stdout:
//Finished: Your input:"ab" ".*" Output:false Expected:true stdout:
public boolean isMatch5(String s, String p) {
    if(s == null && p == null) {
        return true;
    }

    if(s == null || p == null) {
        return false;
    }

    boolean[][] dp = new boolean[s.length()+1][p.length()+1];
    dp[0][0] = true;
    for(int i=0; i<p.length(); i++) {
        if(p.charAt(i) == '*') {
            dp[0][i+1] = dp[0][i-1];
        }
        else {
            dp[0][i+1] = false;
        }
    }

    for(int i=0; i<s.length(); i++) {
        for(int j=0; j<p.length(); j++) {
            if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                dp[i+1][j+1] = dp[i][j];
            }
            else if(p.charAt(j) == '*') {
                dp[i+1][j+1] = dp[i+1][j-1];
                if(p.charAt(j-1) == '.' || s.charAt(i) == p.charAt(j-1)) {
                    dp[i+1][j+1] = dp[i+1][j+1] || dp[i][j+1];
                }
            }
        }
    }

    return dp[s.length()][p.length()];
}
    public boolean isMatch6(String s, String p) {
        if(p.length() == 0 && s.length() == 0) {
            return true;
        } else if(p.length() == 0) {
            return false;
        }
        //simplifyPattern
        String nextPat = getNextPat(p);
        if(nextPat.length() == 1) {
            if(s.length() == 0) {
                return false;
            }
            if(nextPat.equals(".") || s.substring(0,1).equals(nextPat)) {
                return isMatch6(s.substring(1,s.length()),p.substring(1,p.length()));
            } else {
                return false;
            }
        }
        String nextNextPat = getNextPat(p.substring(nextPat.length(),p.length()));
        if(nextNextPat.length() == 2 && nextPat.charAt(0) == nextNextPat.charAt(0)) {
            return isMatch6(s, p.substring(2,p.length()));
        } else if(nextNextPat.length() == 1 && nextPat.charAt(0) == nextNextPat.charAt(0)) {
            return isMatch6(s, nextNextPat + nextPat + p.substring(3,p.length()));
        }
        int i = 0;
        while(i <= s.length()) {
            boolean result = isMatch6(s.substring(i,s.length()),p.substring(2,p.length()));
            if(result) {
                return true;
            }
            i++;
            if(i > s.length() || (s.charAt(i-1) != nextPat.charAt(0) && nextPat.charAt(0) != '.')) {
                return false;
            }
        }
        return false;
    }
    public String getNextPat(String p) {
        if(p.length() ==0) {
            return "";
        }
        String nextPat = "" + p.charAt(0);
        if(p.length()>1 && p.charAt(1) == '*') {
            nextPat +="*";
        }
        return nextPat;
    }
    public boolean isMatch7(String s, String p) {
        int sSize = s.length();
        int pSize = p.length();
        boolean[][] isMatch = new boolean[sSize+1][pSize+1];
        isMatch[0][0] = true;
        for (int i=1; i<=sSize; ++i) {
            isMatch[i][0] = false;
        }
        for (int j=1; j<=pSize; ++j) {
            if (j%2!=0) isMatch[0][j] = false;
            else {
                isMatch[0][j] = true;
                for(int k=0;k<j;++k){
                    if (k%2==1 && p.charAt(k) != '*'){
                        isMatch[0][j] = false;
                        break;
                    }
                }
            }

        }

        // for (int j=1; j<pSize; ++j) {
        //     boolean match = true;
        //     for (int k=0; k<j; ++k) {
        //         if (p.charAt(k) != '*') {
        //             match = false;
        //             break;
        //         }
        //     }
        //     isMatch[0][j] = match;
        // }

        if (p.charAt(0)=='.' || p.charAt(0)=='*' || p.charAt(0)==s.charAt(0)) isMatch[1][1] = true;
        else isMatch[1][1] = false;

        for (int i=1; i<=sSize; ++i) {
            for (int j=1; j<=pSize; ++j) {
                if (p.charAt(j-1) == '.') {
                    isMatch[i][j] = isMatch[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    boolean match = false;
                    for (int k=0; k<=i; ++k) {
                        if (isMatch[k][j-2] && containsOnly(s.substring(k, i), p.charAt(j-2))) match=true;
                    }
                    isMatch[i][j] = match;
                } else {
                    isMatch[i][j] = (s.charAt(i-1) == p.charAt(j-1)) && isMatch[i-1][j-1];
                }
            }
        }
        return isMatch[sSize][pSize];
    }

    public boolean containsOnly(String s, char c) {
        if (s.length()==0) return true;
        boolean res = true;
        if (c=='.') return true;
        for (int i=0; i<s.length(); ++i) {
            if (s.charAt(i) != c) res = false;
        }
        return res;
    }
    private static final char WILD = '*';
    private static final char ANY  = '.';

    private final Map<String, Boolean> map = new HashMap<>();

    private boolean charMatches(char c, char p) {
        return p == '.' || p == c;
    }

    public boolean isMatch8(String s, String p) {
        return strMatches(s, 0, p, 0);
    }

    private boolean sizeOk(String s, int is, String p, int ip) {
        int length = s.length() - is;
        int minLength = p.length() - ip;
        int maxLength = p.indexOf(WILD, ip) != -1 ? Integer.MAX_VALUE : p.length() - ip;

        for (int i=ip; i<p.length(); i++) {
            if (p.charAt(i) == WILD) {
                minLength -= 2;
            }
        }

        return minLength <= length
                && length <= maxLength;
    }

    private boolean strMatches(String s, int is, String p, int ip) {
        if (ip >= p.length()) {
            return is >= s.length();
        }

        final boolean ret;
        final boolean isLong = is+5 <= s.length();

        String key = null;

        if (isLong) {
            key = s.substring(is) + '|' + p.substring(ip);
            Boolean val = map.get(key);

            if (val != null) {
                return val;
            }
        }

        if (! sizeOk(s, is, p, ip)) {
            ret = false;
        } else if (is >= s.length()) {
            ret = ip <= p.length()-2 && p.charAt(ip+1) == WILD
                    && strMatches(s, is, p, ip+2);
        } else if (ip == p.length()-1) {
            ret = charMatches(s.charAt(is), p.charAt(ip))
                    && strMatches(s, is+1, p, ip+1);
        } else {    // p.length() >= 2
            boolean firstMatches = charMatches(s.charAt(is), p.charAt(ip));

            if (p.charAt(ip+1) != WILD) {
                ret = firstMatches && strMatches(s, is+1, p, ip+1);
            } else {
                if (firstMatches) {
                    ret = strMatches(s, is+1, p, ip)
                            || strMatches(s, is, p, ip+2);
                } else {
                    ret = strMatches(s, is, p, ip+2);
                }
            }
        }
        if (isLong) {
            map.put(key, ret);
        }
        return ret;
    }
    Map<String, Boolean> map2=new HashMap();
    public Boolean isMatch9(String s, String p) {
        // int m=s.length();
        // int n=p.length();
        // dp=new Boolean[m+1][n+1];
        return isMatchHelper1(s,p);
    }
    public boolean isMatchHelper1(String s, String p) {
        int m=s.length();
        int n=p.length();
        if(m==0&&n==0||(n==2&&m==0&&p.charAt(1)=='*')){
            return true;
        }
        // if(n==0||m==0){
        //     return false;
        // }
        if(map2.containsKey(s+"_-_"+p)){
            return map2.get(s+"_-_"+p);
        }
        boolean ans=false;
        // System.out.println(s+" - "+p);
        if(n>1&&p.charAt(1)=='*'){
            if(m>0&&(p.charAt(0)==s.charAt(0) || p.charAt(0)=='.')){

                if( isMatchHelper1(s,p.substring(2))
                        || isMatchHelper1(s.substring(1),p.substring(0))){
                    // System.out.println("case 1");
                    ans=ans||true;
                }
            }else{
                // System.out.println("case 2");
                ans =ans|| isMatchHelper1(s,p.substring(2));
            }
        } else if(n>0&&m>0&&(p.charAt(0)==s.charAt(0) || p.charAt(0)=='.')){
            // System.out.println("case 3");
            ans = ans||isMatchHelper1(s.substring(1),p.substring(1));
        }
        map2.put(s+"_-_"+p, ans);
        return ans;
    }
    Map<String, Boolean> map3=new HashMap();
    public Boolean isMatch10(String s, String p) {
        // int m=s.length();
        // int n=p.length();
        // dp=new Boolean[m+1][n+1];
        return isMatchHelper2(s,p);
    }
    public boolean isMatchHelper2(String s, String p) {
        int m=s.length();
        int n=p.length();
        if(m==0&&n==0||(n==2&&m==0&&p.charAt(1)=='*')){
            return true;
        }
        // if(n==0||m==0){
        //     return false;
        // }
        if(map3.containsKey(s+"_-_"+p)){
            return map3.get(s+"_-_"+p);
        }
        boolean ans=false;
        // System.out.println(s+" - "+p);
        if(n>1&&p.charAt(1)=='*'){
            if(m>0&&(p.charAt(0)==s.charAt(0) || p.charAt(0)=='.')){

                if( isMatchHelper2(s,p.substring(2))
                        || isMatchHelper2(s.substring(1),p.substring(0))){
                    // System.out.println("case 1");
                    ans=ans||true;
                }
            }else{
                // System.out.println("case 2");
                ans =ans|| isMatchHelper2(s,p.substring(2));
            }
        } else if(n>0&&m>0&&(p.charAt(0)==s.charAt(0) || p.charAt(0)=='.')){
            // System.out.println("case 3");
            ans = ans||isMatchHelper2(s.substring(1),p.substring(1));
        }
        map3.put(s+"_-_"+p, ans);
        return ans;
    }
    HashSet<String> hs;
    public boolean isMatch11(String s, String p)
    {
        hs = new HashSet<String>();
        return dfs(s, p, 0, 0);
    }
    boolean dfs(String s, String p, int sind, int pind)
    {
        if(hs.contains(p))
            return false;
        hs.add(p);
        if(sind == s.length() && pind == p.length())
            return true;
        int ind = pind;
        while(sind < s.length())
        {
            if(pind + 1 < p.length() && p.charAt(pind + 1) == '*')
                break;
            if(pind == p.length() || p.charAt(pind) != '.' && p.charAt(pind) != s.charAt(sind))
                return false;
            sind++;
            pind++;
        }
        if(sind == s.length() && pind == p.length())
            return true;
        if(pind == p.length())
            return false;
        char t = p.charAt(pind);
        int i = 0;
        if(pind + 1 == p.length())
            return false;
        if(p.charAt(pind + 1) != '*')
            return false;
        String prevStr = p.substring(0, pind);
        String nextStr = p.substring(pind + 2, p.length());
        String currStr = "";
        do
        {
            if(dfs(s, prevStr + currStr + nextStr, sind + i, prevStr.length() + i))
                return true;
            currStr += t;
            if(sind + i == s.length() || currStr.charAt(i) != '.' && currStr.charAt(i) != s.charAt(sind + i))
                break;
            i++;

        }while(true);
        return false;
    }
    public boolean isMatch12(String s, String p) {
        return isMatchs(s, 0, p, 0);
    }

    private boolean isMatchs(String s, int i, String p, int j) {
        if (j == p.length()) {
            return i == s.length();
        }

        if (j == p.length() - 1 || p.charAt(j + 1) != '*') {
            if (i == s.length() || (s.charAt(i) != p.charAt(j) && p.charAt(j) != '.')) {
                return false;
            }
            return isMatchs(s, i + 1, p, j + 1);
        }

        while (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
            if (isMatchs(s, i, p, j + 2)) {
                return true;
            }
            i++;
        }

        return isMatchs(s, i, p, j + 2);
    }
    public boolean isMatch13(String s, String p) {
        return match(s, p, 0, 0);
    }
    private boolean match(String s, String p, int s1, int s2) {
        if (s1 == s.length() && s2 == p.length()) {
            return true;
        }
        if (s2 == p.length()) {
            return false;
        }
        if (s2 == p.length() - 1 || p.charAt(s2 + 1) != '*') {

            if (s1 < s.length() && (p.charAt(s2) == '.' || s.charAt(s1) == p.charAt(s2))) {
                return match(s, p, s1 + 1, s2 + 1);
            }
            else {
                return false;
            }
        }
        else {
            if (match(s, p, s1, s2 + 2)) {
                return true;
            }
            if (s1 < s.length() && ((p.charAt(s2) == '.' ||s.charAt(s1) == p.charAt(s2)) && match(s, p, s1 + 1, s2))) {
                return true;
            }
        }
        return false;
    }
    public boolean isMatch14(String s, String p) {
        return match(0, 0, s, p);
    }
    public boolean match(int i, int j, String s, String p){
        if(j == p.length()) return i == s.length();
        boolean firstMatch = i <s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        boolean ans = false;
        if(j + 1 <p.length() && p.charAt(j+1) == '*'){
            ans = (firstMatch && match(i+1,j,s,p)) || match(i,j+2,s,p);
        }else{
            ans = firstMatch && match(i+1,j+1,s,p);
        }
        return ans;
    }
    public boolean isMatch15(String s, String p) {
        return match15(0, 0, s, p);
    }
    public boolean match15(int i, int j, String s, String p){
        if(j == p.length()) return i == s.length();
        boolean firstMatch = i <s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        boolean ans = false;
        if(j + 1 <p.length() && p.charAt(j+1) == '*'){
            ans = (firstMatch && match(i+1,j,s,p)) || match(i,j+2,s,p);
        }else{
            ans = firstMatch && match(i+1,j+1,s,p);
        }
        return ans;
    }
    public boolean isMatch16(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }
    public boolean isMatch17(String s, String p) {

        // Base case
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        else if (s.isEmpty()) {
            if (p.charAt(p.length() - 1) == '*') {
                return isMatch17(s, p.substring(0, p.length() - 2));
            }
        }
        else if (s.charAt(s.length() - 1) == p.charAt(p.length() - 1) ||
                p.charAt(p.length() - 1) == '.') {
            return isMatch17(s.substring(0, s.length() - 1), p.substring(0, p.length() - 1));
        }
        else if (p.charAt(p.length() - 1) == '*') {
            if (p.length() > 1) {
                if (s.charAt(s.length() - 1) == p.charAt(p.length() - 2) ||
                        p.charAt(p.length() - 2) == '.') {
                    return isMatch17(s.substring(0, s.length() - 1), p) ||
                            isMatch17(s, p.substring(0, p.length() - 2));
                }
                return isMatch17(s, p.substring(0, p.length() - 2));
            }
        }

        return false;
    }
}