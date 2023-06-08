package org.example.leetCodeTask;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsonALine149 {
    public static void main(String[] args) {

    }

    //second not passed
    public int maxPoints1(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int n = points.length;
        if (n == 1) {
            return 1;
        }
        int maxPoints = 0;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopeCount = new HashMap<>();
            int samePointCount = 1;
            int localMax = 0;
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                if (x1 == x2 && y1 == y2) {
                    samePointCount++;
                } else {
                    String slope = getSlope1(x1, y1, x2, y2);
                    int count = slopeCount.getOrDefault(slope, 1) + 1;
                    slopeCount.put(slope, count);
                    localMax = Math.max(localMax, count);
                }
            }
            maxPoints = Math.max(maxPoints, samePointCount + localMax - 1);
        }
        return maxPoints;
    }

    private String getSlope1(int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        if (dx == 0) {
            return "inf";
        }
        int gcd = gcd(dx, dy);
        dx /= gcd;
        dy /= gcd;
        return dy + "/" + dx;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // second
    public int maxPoints2(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int n = points.length;
        if (n == 1) {
            return 1;
        }
        int maxPoints = 0;
        for (int i = 0; i < n; i++) {
            int samePointCount = 1;
            int localMax = 0;
            Map<Double, Integer> slopeCount = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                if (x1 == x2 && y1 == y2) {
                    samePointCount++;
                } else {
                    double slope = getSlope2(x1, y1, x2, y2);
                    int count = slopeCount.getOrDefault(slope, 1) + 1;
                    slopeCount.put(slope, count);
                    localMax = Math.max(localMax, count);
                }
            }
            maxPoints = Math.max(maxPoints, samePointCount + localMax);
        }
        return maxPoints;
    }

    private double getSlope2(int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            return Double.POSITIVE_INFINITY;
        }
        return (double) (y2 - y1) / (double) (x2 - x1);
    }

    // letcode
    public int maxPoints3(int[][] points) {
        final int pointsLength = points.length;

        if (pointsLength <= 2) {
            return pointsLength;
        }

        int max = 2;

        for (int i = 0; i < pointsLength; i++) {
            max = Math.max(max, getMax(points[i][0], points[i][1], i + 1, points, pointsLength));
        }

        return max;
    }

    private int getMax(int x, int y, int j, int[][] points, int length) {
        int max = 2;
        Map<Double, int[]> lines = new HashMap<>(length - j + 1, .95f);

        while (j < length) {
            Double slope = points[j][1] == y ? 0.0 : points[j][0] == x ? Double.POSITIVE_INFINITY : (double) (points[j][1] - y) / (points[j][0] - x);

            int[] occurrences = lines.get(slope);

            if (occurrences == null) {
                lines.put(slope, new int[]{2});

            } else {
                max = Math.max(max, ++occurrences[0]);
            }

            j++;
        }

        return max;
    }


/*Time complexity : O(N^2)since one draws not more than N - 1 lines passing through the point 0, not more than N - 2 lines for the point 1, and the only one line for the point N - 2. That results in (N - 1) + (N - 2) + .. + 1 = N(N - 1)/2 operations, i.e. O(N^2) time complexity.

Space complexity : O(N) to track down not more than N - 1 lines.*/

    public int maxPoints4(int[][] points) {
        int n = points.length, max = 2;
        if (n < 3) return n;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int xconst = points[j][0] - points[i][0], yconst = points[j][1] - points[i][1], count = 2;
                for (int k = j + 1; k < n; k++) {
                    if (xconst * (points[k][1] - points[i][1]) == yconst * (points[k][0] - points[i][0]))
                        count += 1;
                }
                max = Math.max(max, count);
                if (max >= n - 1) return max;
            }
        }
        return max;
    }

    public int maxPoints5(int[][] arrays) {
        if(arrays.length<3){
            return arrays.length;
        }
        int count=0,max=0;
        for (int i = 0; i < arrays.length - 2; i++) {
            for (int j = i + 1; j < arrays.length - 1; j++) {
                count=0;
                int x1 = arrays[i][0] - arrays[j][0];
                int y1 = arrays[i][1] - arrays[j][1];
                for (int k = j + 1; k < arrays.length; k++) {
                    int x2 = arrays[i][0] - arrays[k][0];
                    int y2 = arrays[i][1] - arrays[k][1];
                    if (x1 * y2 == x2 * y1 ) {
                        count++;
                    }
                }
                if(count>0) {
                    count+=2;
                    if(count>max) max=count;
                }
            }
        }
        if(max==0) return 2;
        return max;
    }
    public int maxPoints6(int[][] points) {
        int ans = 1;
        int n = points.length;

        for (int i = 0; i < n; i++) {
            HashMap<Double, Integer> slope = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                double k = calculateSlope(points[i], points[j]);
                slope.put(k, 1 + slope.getOrDefault(k, 0));
            }
            int max = 0;
            for (int m : slope.values()) max = Math.max(max, m);
            ans = Math.max(ans, max + 1);
        }
        return ans;
    }

    private double calculateSlope(int[] p1, int[] p2) {
        int x1 = p1[0], x2 = p2[0];
        int y1 = p1[1], y2 = p2[1];

        if (x1 == x2) return Double.MAX_VALUE;
        if (y1 == y2) return 0;
        return (double) (y2 - y1) / (double) (x2 - x1);
    }

    public int maxPoints7(int[][] points) {
        int n= points.length;
        if(n<=2)
            return n;
        int max=2;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int total=2;
                for(int k=0;k<n;k++){
                    if(k!=i &&k!=j){
                        if((points[j][1]-points[i][1])*(points[i][0]-points[k][0])==
                                (points[i][1]-points[k][1])*(points[j][0]-points[i][0]))
                            total++;
                    }
                }
                max=Math.max(max,total);
            }
        }
        return max;
    }
}