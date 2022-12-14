package org.example.leetCodeTask;

public class LongestPalindromicSubstring5 {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println();
    }

    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int start = 0;
        int end = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
                if (dp[j][i] && max < i - j + 1) {
                    max = i - j + 1;
                    start = j;
                    end = i;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 2) return s;
        int start = 0;
        int end = 0;
        for (int i = 1; i < s.length(); i++) {
            int low = i;
            int high = i;
            while (low - 1 >= 0 && s.charAt(low) == s.charAt(low - 1)) {
                low--;
            }
            while (high + 1 < s.length() && s.charAt(high) == s.charAt(high + 1)) {
                high++;
            }
            while (low - 1 >= 0 && high + 1 < s.length() && s.charAt(low - 1) == s.charAt(high + 1)) {
                low--;
                high++;
            }
            if (high - low > end - start) {
                start = low;
                end = high;
            }
        }
        return s.substring(start, end + 1);
    }

    int start = 0, end = 0;

    public String longestPalindrome3(String s) {
        if (s.length() < 2)
            return s;
        char[] c = s.toCharArray();
        longestPallindromeAt3(c, 0);
        return s.substring(start, end + 1);
    }

    private void longestPallindromeAt3(char[] c, int p) {
        int a = p;
        int b = p;
        int n = c.length;
        if ((p == n - 1 || (n - p) < (end - start + 1) / 2))
            return;
        while (b < n - 1 && c[b] == c[b + 1])
            b++;
        p = b;
        while (a > 0 && b < n - 1 && c[a - 1] == c[b + 1]) {
            a--;
            b++;
        }
        if ((b - a) > (end - start)) {
            end = b;
            start = a;
        }
        longestPallindromeAt3(c, p + 1);
    }

    public String longestPalindrome4(String s) {
        if (s.isEmpty())
            return "";

        // [start, end] indices of the longest palindrome in s
        int[] indices = {0, 0};

        for (int i = 0; i < s.length(); ++i) {
            int[] indices1 = extend(s, i, i);
            if (indices1[1] - indices1[0] > indices[1] - indices[0])
                indices = indices1;
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                int[] indices2 = extend(s, i, i + 1);
                if (indices2[1] - indices2[0] > indices[1] - indices[0])
                    indices = indices2;
            }
        }

        return s.substring(indices[0], indices[1] + 1);
    }

    // Returns [start, end] indices of the longest palindrome extended from s[i..j]
    private int[] extend(final String s, int i, int j) {
        for (; i >= 0 && j < s.length(); --i, ++j)
            if (s.charAt(i) != s.charAt(j))
                break;
        return new int[]{i + 1, j - 1};
    }

    public String longestPalindrome5(String s) {
        String res = "";
        int reslength = 0;
        for (int i = 0; i < s.length(); i++) {
            //For odd length
            int l = i;
            int r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if ((r - l + 1) > reslength) {
                    reslength = r - l + 1;
                    res = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
            //for even length
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if ((r - l + 1) > reslength) {
                    reslength = r - l + 1;
                    res = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
        }
        return res;
    }
    public String longestPalindrome6(String s) {
        float maxLength = 0;
        float middle = 0;
        int x;
        int length;

        if(s.length() == 1){
            return s;
        }

        for(float i = 0; i < s.length() - 1; i += 0.5) {
            boolean ifPalindrome = true;
            x = 0;
            if(i % 1 == 0){
                length = 1;
            } else {
                length = 0;
            }

            while(ifPalindrome && Math.ceil(i) - x > 0 && Math.floor(i) + x < s.length() - 1) {
                x++;
                if(s.charAt((int)Math.floor(i) + x) == s.charAt((int)Math.ceil(i) - x)) {
                    length += 2;
                } else {
                    ifPalindrome = false;
                }

            }

            if (length > maxLength) {
                maxLength = length;
                middle = i;
            }
        }

        return s.substring((int)Math.ceil(middle) - (int)maxLength / 2, (int)Math.ceil(middle) + (int)Math.ceil(maxLength / 2));
    }
    public String longestPalindrome7(String s) {
        String ans = s.substring(0, 1);
        int n = s.length();
        boolean[][] arr = new boolean[n][n];
        char[] chars = s.toCharArray();
        int maxLen = 1;
        int start = 0;
        int end = 1;
        for (int i = 0; i < n - 1; i++) {
            arr[i][i] = true;
            if (chars[i] == chars[i + 1]){
                arr[i][i + 1] = true;
                start = i;
                end = i + 2;
                maxLen = 2;
            }
        }
        arr[n - 1][n - 1] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (chars[j] == chars[j + i] && arr[j + 1][j + i - 1]) {
                    arr[j][j + i] = true;
                    if (maxLen < i + 1) {
                        start = j;
                        end = j + i + 1;
                        maxLen = i + 1;
                    }
                }
            }
        }

        return s.substring(start, end);
    }
    public String longestPalindrome8(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > maxLen) {
                        maxLen = i - j + 1;
                        start = j;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
    public String longestPalindrome9(String s) {
        int A[][] = new int[s.length()][s.length()];
        int maxlength=0,start=0,i=0,j=0;
        //length 1
        maxlength=1;
        for(i=0;i<s.length();i++){
            A[i][i] = 1;
            start=i;
        }
        //length 2
        for(j=0;j<s.length()-1;j++){
            if(s.charAt(j)==s.charAt(j+1)){
                A[j][j+1] = 1;
                start=j;
                maxlength=2;
            }
            else
                A[j][j+1] = 0;
        }
        //length 3
        for(int k=3;k<=s.length();k++){
            for(i=0;i<s.length()-k+1;i++){
                j=i+k-1;
                if(A[i+1][j-1]==1&& (s.charAt(i)==s.charAt(j))){
                    A[i][j] = 1;
                    if(k>maxlength){
                        start =i;
                        maxlength=k;
                    }
                }
                else
                    A[i][j] = 0;
            }
        }
        String sub = "";
        for(int a =start;a<=(start+maxlength)-1;++a){
            if(a<s.length())
                sub+=s.charAt(a);
        }
        return sub;
    }
    public String longestPalindrome10(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
    public String findMaxPallindrome(String s , int left , int right)
    {
        while(left>=0 && right < s.length() && s.charAt(left)==s.charAt(right))
        {
            left--;
            right++;
        }

        return s.substring(left+1,right);

    }

    public String longestPalindrome11(String s) {

        // expand around center

        String result="";

        String maxPallindrome1 , maxPallindrome2;

        for(int i=0;i<s.length();i++)
        {
            maxPallindrome1= findMaxPallindrome(s,i,i);
            maxPallindrome2= findMaxPallindrome(s,i,i+1);

            if(result.length()<maxPallindrome1.length())
                result=maxPallindrome1;

            if(result.length()<maxPallindrome2.length())
                result=maxPallindrome2;

        }
        return result;
    }
    private String result = "";
    private int length = 0;

    public String longestPalindrome12(String s) {
        length = s.length();
        for (int i = 0; i < length; i++) {
            findPalindrom12(s, i, i);
            findPalindrom12(s, i, i + 1);
        }

        return result;
    }

    public void findPalindrom12(String s, int i, int j) {
        StringBuilder sb = new StringBuilder();

        if (i == j) {
            sb.append(s.substring(i, i + 1));
            i--;j++;
        }

        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                sb.insert(0, s.charAt(i--));
                sb.append(s.charAt(j++));
            } else {
                break;
            }
        }

        if (sb.length() > result.length()) {
            result = sb.toString();
        }

        sb = null;
    }
    public String longestPalindrome13(String s) {
        int n = s.length();
        String res;
        int start = 0, maxLen = 0;

        boolean[][] dp = new boolean[n][n];
        // dp[i][j] indicates whether substring s starting at index i and ending at j is palindrome

        for(int i = n -1; i >=0; i--){
            for(int j = i; j <= n -1; j++){
                dp[i][j] = (s.charAt(i) == s.charAt(j))  & (j-i < 3 || dp[i+1][j-1]);

                if(dp[i][j] && (j-i+1 > maxLen)) {
                    start = i;
                    maxLen = j-i+1;
                }
            }
        }

        return s.substring(start, start+maxLen);
    }
    public String longestPalindrome14(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLength = 0;
        int polindromStartAt = 0;

        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                int length = j-i+1;
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (length <= 3 || dp[i+1][j-1]);
                if(dp[i][j] && length > maxLength) {
                    maxLength = length;
                    polindromStartAt = i;
                }
            }
        }

        return s.substring(polindromStartAt, polindromStartAt + maxLength);
    }
    public String longestPalindrome15(String s) {
        int result=0;
        int index=0;
        for(int i=0;i<s.length();i++){
            int maxLeng=Math.max(longestLength(i,i,s),longestLength(i,i+1,s));
            if(maxLeng>result){
                index=i-(maxLeng-1)/2;
                result=maxLeng;
            }
        }
        return s.substring(index,index+result);
    }

    public Integer longestLength(Integer start, Integer end, String s) {
        int len=s.length();
        while(start>=0&&end<len&&s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        return end-start-1;
    }
    public String longestPalindrome16(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            // odd length
            result = getLongestPalindrome(i, i, s, result);

            // even length
            result = getLongestPalindrome(i, i + 1, s, result);
        }
        return result;

    }

    private String getLongestPalindrome(Integer left, Integer right, String s, String result) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left -= 1;
            right += 1;
        }
        return (right - left - 1 > 0 && right - (left + 1) > result.length())? s.substring(left + 1, right): result;
    }
    public String longestPalindrome17(String s) {
        String result = "";
        Integer resultLength = 0;
        for(int i = 0; i < s.length(); i ++) {
            Integer right = i;
            Integer left = i;
            while (right < s.length() && left >= 0 && s.charAt(left) == s.charAt(right)) {
                if (resultLength < right - left + 1) {
                    result = s.substring(left, right + 1);
                    resultLength = right - left + 1;
                }
                right++;
                left--;
            }
            right = i+1;
            left = i;
            while (right < s.length() && left >= 0 && s.charAt(left) == s.charAt(right)) {
                if (resultLength < right - left + 1) {
                    result = s.substring(left, right + 1);
                    resultLength = right - left + 1;
                }
                right++;
                left--;
            }
        }
        return result;
    }
}
