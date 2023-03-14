package org.example.leetCodeTask;

public class WordSearch79 {
    public static void main(String[] args) {

    }
    public boolean exist(char [][] board, String word){
        int m= board.length;
        int n= board[0].length;
        boolean [][] visited= new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board,visited,i,j,word,0)) return true;
            }
        }
        return false;
    }
    private boolean search(char [][] board, boolean[][] visited, int i, int j, String word, int k){
        if (k==word.length()) return true;
        if (i<0||i>=board.length||j<0||j>=board[0].length||visited[i][j]||board[i][j]!=word.charAt(k))return false;
        visited[i][j] =true;
        if (search(board,visited,i+1,j,word,k+1) || search(board,visited,i-1,j,word,k+1)||
        search(board,visited,i,j+1,word,k+1)|| search(board,visited,i,j-1,word,k+1)) return true;
        visited[i][j]= false;
        return false;
    }

    public boolean exist1(char[][] board, String word) {
        for(int i =0 ; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j]==word.charAt(0) && checkWord(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkWord(char [][]board, String word, int i, int j, int indx){
        if(indx==word.length()){
            return true;
        }
        if(i>=board.length || j>=board[0].length || i<0 || j<0) return false;
        if(board[i][j]!=word.charAt(indx)) return false;
        char temp = board[i][j];
        board[i][j] = '1';

        boolean b1 = checkWord(board, word, i, j+1, indx+1);
        boolean b2 = checkWord(board, word, i+1, j, indx+1);
        boolean b3 = checkWord(board, word, i-1, j, indx+1);
        boolean b4 = checkWord(board, word, i, j-1, indx+1);
        board[i][j] = temp;
        return b1||b2||b3||b4;
    }

}
