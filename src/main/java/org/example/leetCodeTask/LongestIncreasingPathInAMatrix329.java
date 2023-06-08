package org.example.leetCodeTask;

import java.util.Arrays;

public class LongestIncreasingPathInAMatrix329 {
    public static void main(String[] args) {

    }
    private int[][] dp;
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int longestIncreasingPath1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        dp = new int[rows][cols]; // initialize memoization array with zeros

        int maxLength = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxLength = Math.max(maxLength, dfs(matrix, i, j));
            }
        }

        return maxLength;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if (dp[i][j] != 0)
            return dp[i][j];

        int maxLength = 1;
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];

            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
                maxLength = Math.max(maxLength, 1 + dfs(matrix, x, y));
            }
        }

        dp[i][j] = maxLength; // store the computed path length
        return maxLength;
    }
    //second

    private int[][] visited;
    private int max = 0;

    public int longestIncreasingPath2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        visited = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] == 0) search(i, j, matrix);
            }
        }
        return max;
    }

    private int search(int i, int j, int[][] matrix){
        if(visited[i][j] != 0) return visited[i][j];

        int cur = matrix[i][j];
        int neighbor = 0;
        if(i > 0 && cur < matrix[i - 1][j]){
            neighbor = Math.max(neighbor, search(i - 1, j, matrix));
        }
        if(i < matrix.length - 1 && cur < matrix[i + 1][j]){
            neighbor = Math.max(neighbor, search(i + 1, j, matrix));
        }
        if(j > 0 && cur < matrix[i][j - 1]){
            neighbor = Math.max(neighbor, search(i, j - 1, matrix));
        }
        if(j < matrix[0].length - 1 && cur < matrix[i][j + 1]){
            neighbor = Math.max(neighbor, search(i, j + 1, matrix));
        }
        int result = neighbor + 1;
        visited[i][j] = result;
        max = Math.max(max, result);
        return result;
    }
    static int globalMax = 0;
    public int longestIncreasingPath(int[][] matrix) {
        int r= matrix.length;
        int c = matrix[0].length;

        globalMax = 0;
        int dp[][] = new int[r][c];
        for(int i=0;i<r;i++){
            Arrays.fill(dp[i],0);
        }
        // dp[i][j] denotes maximum increasing path starting at mat[i][j]

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                fill(dp,matrix,i,j,r,c);
            }
        }
        return globalMax;
    }

    public int fill(int dp[][], int mat[][], int i, int j, int r, int c){

        if(dp[i][j]!=0){
            return dp[i][j];
        }

        int xm[] = {-1,0,1,0};
        int ym[] = {0,1,0,-1};

        int element = mat[i][j];
        int max =0;
        for(int z=0;z<xm.length;z++){
            int nx = i + xm[z];
            int ny = j + ym[z];

            if(nx>=0 && ny>=0 && nx<r && ny<c && mat[nx][ny] > element){
                int getSub = fill(dp,mat,nx,ny,r,c);
                max = Math.max(max,getSub);
            }
        }
        dp[i][j]=max +1;
        globalMax = Math.max(globalMax,dp[i][j]);
        return dp[i][j];
    }
//third
public int helper(int dp[][], int matrix[][], int i, int j){
    if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length){
        return 0;
    }

    if(dp[i][j] != 0){
        return dp[i][j];
    }
    int a = 1;
    int b = 1;
    int c = 1;
    int d = 1;
    // down
    if(i + 1 < matrix.length && matrix[i][j] < matrix[i + 1][j]){
        a = helper(dp, matrix, i + 1, j) + 1;
    }
    // up
    if(i - 1 >= 0 && matrix[i][j] < matrix[i - 1][j]){
        b = helper(dp, matrix, i - 1, j) + 1;
    }
    // left
    if(j + 1 < matrix[0].length && matrix[i][j] < matrix[i][j + 1]){
        c = helper(dp, matrix, i, j + 1) + 1;
    }
    // right
    if(j - 1 >= 0 && matrix[i][j] < matrix[i][j - 1]){
        d = helper(dp, matrix, i, j - 1) + 1;
    }
    return dp[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
}
    public int longestIncreasingPath3(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];

        int ans = 0;
        // helper(dp, matrix, 0, 0);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans = Math.max(ans, helper(dp, matrix, i, j));
            }
        }
        return ans;
    }
//forth
public int longestIncreasingPath4(int[][] matrix) {
    int ans = 1;
    Integer[][] f = new Integer[matrix.length][matrix[0].length];
    for (int i=0; i<matrix.length; i++) {
        for (int j=0; j<matrix[0].length; j++) {
            boolean[][] visited = new boolean[matrix.length][matrix[0].length];
            visited[i][j] = true;
            ans = Math.max(ans, dfs(f, matrix, i, j, visited));
        }
    }
    return ans;
}

    private int dfs(Integer[][] f, int[][] matrix, int x, int y, boolean[][] visited) {
        if (f[x][y] != null) {
            return f[x][y];
        } else {
            int fromTop = 0;
            int fromBottom = 0;
            int fromLeft = 0;
            int fromRight = 0;

            if (x-1 >= 0 && !visited[x-1][y] && matrix[x][y] < matrix[x-1][y]) {
                visited[x-1][y] = true;
                fromTop = dfs(f, matrix, x-1, y, visited);
                visited[x-1][y] = false;
            }
            if (x+1 < matrix.length && !visited[x+1][y] && matrix[x][y] < matrix[x+1][y]) {
                visited[x+1][y] = true;
                fromBottom = dfs(f, matrix, x+1, y, visited);
                visited[x+1][y] = false;
            }
            if (y-1 >= 0 && !visited[x][y-1] && matrix[x][y] < matrix[x][y-1]) {
                visited[x][y-1] = true;
                fromLeft = dfs(f, matrix, x, y-1, visited);
                visited[x][y-1] = false;
            }
            if (y+1 < matrix[0].length && !visited[x][y+1] && matrix[x][y] < matrix[x][y+1]) {
                visited[x][y+1] = true;
                fromRight = dfs(f, matrix, x, y+1, visited);
                visited[x][y+1] = false;
            }
            int longestPath =
                    Math.max(Math.max(Math.max(fromTop, fromBottom), fromLeft), fromRight) + 1;
            f[x][y] = longestPath;
            return longestPath;
        }
    }

}
