package org.example.leetCodeTask;

public class ClimbingStairs70 {
    public static void main(String[] args) {
        int stair=8;
        System.out.println(climbStairs(stair));
    }
    public static int climbStairs(int n){
        if (n<=1) return 1;
         int first=1;
         int second=2;
         int res=0;
        for (int i = 3; i <=n ; i++) {
             res=first+second;
             first=second;
             second=res;

        }
        return second;
    }
}
