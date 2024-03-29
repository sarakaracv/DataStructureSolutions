package org.example.leetCodeTask;

public class GasStation134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n= gas.length;
        int start=0;
        int tank=0;
        int total=0;

        for (int i = 0; i < n; i++) {
            tank+=gas[i]-cost[i];
            total+=gas[i]-cost[i];
            if (tank<0){
                start=i+1;
                tank=0;
            }

        }
        return total<0? -1:start;

    }
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n=gas.length;
        int tank=0,start=0, total=0;
        for (int i = 0; i < n; i++) {
            int diff=gas[i]-cost[i];
            total+=diff;
            tank+=diff;
            if (tank<0){
                start=i+1;
                tank=0;
            }

        }
        System.gc();
        return total<0?-1:start%n;

    }
}
