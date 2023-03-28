package org.example.leetCodeTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectSquares279 {
    public int numSquares1(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j*j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
    public int numSquares2(int n){
        if (Math.pow((int)Math.sqrt(n),2) == n) return 1;
        for (int i = 1; i <= (int)Math.sqrt(n); ++i)
            if (n - i*i == Math.pow((int)Math.sqrt(n - i*i),2))
                return 2;

        while (n % 4 == 0) n /= 4;
        if   (n % 8 != 7) return 3;

        return 4;
    }
    public int numSquares3(int n) {

        int a=(int) Math.sqrt(n);
        if(a*a==n) return 1;

        List<Integer> list=new ArrayList<>();
        list.add(0);
        while(list.size()<=n){
            int max=Integer.MAX_VALUE;
            int size=list.size();
            for(int j=1;j*j<=size;j++)
            {
                max=Math.min(max,list.get(size-j*j)+1);
            }
            list.add(max);
        }
        return list.get(n);
    }
    public int numSquares4(int n) {
        int res=n,p=2;
        while((p*p)<=n){
            int x=n/(p*p);
            int y=n%(p*p);
            res= Math.min(res,x+numSquares4(y));
            p++;
        }
        return res;
    }
    public int numSquares5(int n) {
        if (n < 4) {
            return n;
        }
        int s = (int)Math.floor(Math.sqrt(n));
        int ps = s * s;
        if (ps == n) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        do {
            min = Math.min(min, n / ps + numSquares5(n % ps));
            s = (int)Math.floor(Math.sqrt(ps - 1));
            ps = s * s;
        } while (s > 1 && n / ps <= min);
        return min;
    }
    public int numSquares6(int n) {
        if (Math.ceil(Math.sqrt(n)) == Math.floor(Math.sqrt(n))) return 1;
        while (n % 4 == 0) n /= 4;
        if (n % 8 == 7) return 4;
        for (int i = 0; i * i <= n; ++i) {
            int num = (int) Math.sqrt(n - i * i);
            if (num * num == (n - i * i)) return 2;
        }
        return 3;
    }
    public int numSquares7(int n) {
        int c = (int) Math.sqrt(n);
        if (c * c == n) return 1;
        while (n % 4 == 0)
            n = n / 4;

        if (n % 8 == 7) return 4;

        for (int i = 1; i * i <= n; i++) {
            int a = i * i;
            int b = (int) Math.sqrt(n - a);
            if (b * b == n - a) return 2;
        }
        return 3;
    }
    public int numSquares8(int n) {
        int [] memo = new int[n+1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0]=0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                int sq = j * j;
                if((i-sq) >= 0){
                    memo[i] = Math.min(memo[i], memo[i-sq] + 1);
                }
            }
        }
        return memo[n];
    }
}

/*
1: 1 of 1 -> 1
2: 2 of 1 -> 2
3: 1 of 1 and 2 -> 2
12: 3 of 4 -> 3


Find out all perfect squares...see if they add up to X.
1. We iterate from 1,2,3,4 ... X
2. Square those numbers
3. Current number X - Squared = k. If memo[k] != 0, then memo[X] = Min(memo[X], memo[k] + 1)

*/
