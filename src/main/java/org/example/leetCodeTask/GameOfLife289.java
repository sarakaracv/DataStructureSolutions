package org.example.leetCodeTask;

import java.util.Arrays;

public class GameOfLife289 {
    public void gameOfLife1(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        int[][] newBoard = Arrays.stream(board).map(int[]::clone).toArray(int[][]::new);
        int[][] index=new int[][]{{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                int cnt=0;
                for(int[] ind:index) {
                    int row=i+ind[0];
                    int col=j+ind[1];
                    if(row<m && row>=0 && col<n && col>=0 && newBoard[row][col]==1)
                        cnt++;
                }
                if(newBoard[i][j]==1 && (cnt<2 || cnt>3))
                    board[i][j]=0;
                else if(newBoard[i][j]==0 && cnt==3)
                    board[i][j]=1;
            }
        }
    }
    public void gameOfLife3(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] newBoard = new int[m][n];

        // loop through each cell in the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // count the live neighbors of the current cell
                int count = countLiveNeighbors(board, i, j);

                // apply the rules of the game to determine the new state of the cell
                if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    newBoard[i][j] = 0; // cell dies
                } else if (board[i][j] == 0 && count == 3) {
                    newBoard[i][j] = 1; // cell becomes alive
                } else {
                    newBoard[i][j] = board[i][j]; // cell remains the same
                }
            }
        }

        // copy the new board to the original board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = newBoard[i][j];
            }
        }
    }

    // helper method to count the live neighbors of a cell
    private int countLiveNeighbors(int[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;

        int count = 0;

        // loop through the 8 neighbors of the cell
        for (int row = i-1; row <= i+1; row++) {
            for (int col = j-1; col <= j+1; col++) {
                if (row >= 0 && row < m && col >= 0 && col < n && !(row == i && col == j)) {
                    count += board[row][col];
                }
            }
        }

        return count;
    }

    class Solution {
        public void gameOfLife(int[][] board) {
            int rows = board.length;
            int cols = board[0].length;

            int[][] newBoard = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int neighbors = countLiveNeighbors(board, i, j);

                    if (board[i][j] == 1) {
                        if (neighbors < 2 || neighbors > 3) {
                            newBoard[i][j] = 0;
                        } else {
                            newBoard[i][j] = 1;
                        }
                    } else {
                        if (neighbors == 3) {
                            newBoard[i][j] = 1;
                        }
                    }
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    board[i][j] = newBoard[i][j];
                }
            }
        }

        private int countLiveNeighbors(int[][] board, int x, int y) {
            int count = 0;

            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && !(i == x && j == y)) {
                        count += board[i][j] & 1;
                    }
                }
            }

            return count;
        }
    }
    public void gameOfLife(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int a[]= new int[]{-1,-1,-1,0,0,1,1,1};
        int b[]= new int[]{-1,0,1,-1,1,-1,0,1};
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int count=0;
                for(int p=0;p<8;p++)
                {
                    if(check(i+a[p],j+b[p],arr) && (arr[i+a[p]][j+b[p]]==1 || arr[i+a[p]][j+b[p]]==2 || arr[i+a[p]][j+b[p]]==3) )
                        count++;
                }
                if((arr[i][j]==0 || arr[i][j]==4 || arr[i][j]==5) && count==3)
                {
                    arr[i][j]=5;
                }
                else if(arr[i][j]==1 || arr[i][j]==2 || arr[i][j]==3)
                {
                    if(count<2)
                        arr[i][j]=3;
                    else if(count==2 || count==3)
                        arr[i][j]=2;
                    else if(count>3)
                        arr[i][j]=3;
                }
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(arr[i][j]==2 || arr[i][j]==5)
                    arr[i][j]=1;
                else if(arr[i][j]==3 || arr[i][j]==4)
                    arr[i][j]=0;
            }
        }

    }

    public boolean check(int i, int j,int arr[][])
    {
        int n=arr.length,m=arr[0].length;
        if(i<0 || i>=n || j<0 || j>=m)
            return false;
        return true;
    }

}
