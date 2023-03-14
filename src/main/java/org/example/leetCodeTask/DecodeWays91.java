package org.example.leetCodeTask;

public class DecodeWays91 {
    public static void main(String[] args) {

    }
    public int numDecodings(String s){
    if (s.charAt(0)=='0') return 0;
    if (s.length()==1) return 1;
    int prev=1,pCount=1;
        for (int i = 0; i <s.length() ; i++) {
            int single=s.charAt(i)-'0';
            int d=(s.charAt(i)-'0')*10+single;
            int cr=0;
            if (single>0)cr+=pCount;
            if (d>=10&&d<=26) cr+=prev;
            prev=pCount;
            pCount=cr;
        }
        return pCount;
    }
    public int numDecodings1(String s) {

        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int pre = 1; // dp[i-2]
        int cur = 1; // dp[i-1]

        for (int i = 1; i < s.length(); i++) {
            int sum = 0; // dp[i]
            if (s.charAt(i) != '0') {
                sum = cur;
            }
            int num = Integer.parseInt(s.substring(i - 1, i + 1));
            if (num >= 10 && num <= 26) {
                sum += pre;
            }

            pre = cur;
            cur = sum;
        }

        return cur;
    }
}
