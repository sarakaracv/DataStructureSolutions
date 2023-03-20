package org.example.leetCodeTask;

public class SurroundedRegions130 {


        public void solve1(char[][] board) {
            if (board == null || board.length == 0) {
                return;
            }
            int m = board.length, n = board[0].length;
            for (int i = 0; i < m; i++) {
                if (board[i][0] == 'O') {
                    dfs(board, i, 0);
                }
                if (board[i][n - 1] == 'O') {
                    dfs(board, i, n - 1);
                }
            }
            for (int j = 0; j < n; j++) {
                if (board[0][j] == 'O') {
                    dfs(board, 0, j);
                }
                if (board[m - 1][j] == 'O') {
                    dfs(board, m - 1, j);
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    } else if (board[i][j] == '#') {
                        board[i][j] = 'O';
                    }
                }
            }
        }

        private void dfs(char[][] board, int i, int j) {
            int m = board.length, n = board[0].length;
            if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') {
                return;
            }
            board[i][j] = '#';
            dfs(board, i - 1, j);
            dfs(board, i + 1, j);
            dfs(board, i, j - 1);
            dfs(board, i, j + 1);
        }

        public void solve2(char[][] board) {
            if (board == null || board.length == 0) {
                return;
            }
            int m = board.length, n = board[0].length;
            // Mark all the 'O' cells connected to the borders as '-'
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                        if (board[i][j] == 'O') {
                            mark(board, i, j);
                        }
                    }
                }
            }
            // Convert all the remaining 'O' cells to 'X', and all the '-' cells to 'O'
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j]=='O') board[i][j]='X';
                    else if (board[i][j]=='-') board[i][j]='O';
                }
            }
        }

        private void mark(char[][] board, int i, int j) {
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
                return;
            }
            board[i][j] = '-';
            mark(board, i - 1, j);
            mark(board, i + 1, j);
            mark(board, i, j - 1);
            mark(board, i, j + 1);
        }

    public void solve3(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] != 'X') DFS(i, 0, grid);
            if (grid[i][grid[0].length - 1] != 'X') DFS(i, grid[0].length - 1, grid);
        }
        for (int i = 0; i < grid[0].length - 1; i++) {
            if (grid[0][i] != 'X') DFS(0, i, grid);
            if (grid[grid.length - 1][i] != 'X') DFS(grid.length - 1, i, grid);
        }
        swap(grid, 'O', 'X');
        swap(grid, 'p', 'O');
    }

    void swap(char[][] grid, char p, char q) {
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == p) grid[i][j] = q;
    }

    void DFS(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 'O') return;
        grid[i][j] = 'p';
        DFS(i + 1, j, grid);
        DFS(i, j + 1, grid);
        DFS(i - 1, j, grid);
        DFS(i, j - 1, grid);
    }



    }


