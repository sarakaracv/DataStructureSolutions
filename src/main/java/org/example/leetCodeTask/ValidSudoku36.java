package org.example.leetCodeTask;

import kotlin.Pair;

import java.util.*;

public class ValidSudoku36 {
    public static void main(String[] args) {

    }
    public boolean isValidSudoku1(char[][] board) {
        boolean [][] left= new boolean[9][9];
        boolean[][] mid = new boolean[9][9];
        boolean[][] right = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char s = board[i][j];
                if (s != '.') {
                    s -= '1';
                    int third = j/3 + i/3*3;

                    if (left[i][s] || mid[j][s] || right[third][s])
                        return false;

                    left[i][s] = true;
                    mid[j][s] = true;
                    right[third][s] = true;
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku2(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int[] colCount = new int[9];
            int[] rowCount = new int[9];
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (rowCount[board[i][j]- 49] != 0) {
                        return false;
                    } else {
                        rowCount[board[i][j]- 49]++;
                    }
                }
                if (board[j][i] != '.') {
                    if (colCount[board[j][i]- 49] != 0) {
                        return false;
                    } else {
                        colCount[board[j][i]- 49]++;
                    }
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int[] count = new int[9];
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (board[x + 3*i][y + 3*j] != '.') {
                            if (count[board[x + 3*i][y + 3*j] - 49] != 0) {
                                return false;
                            } else {
                                count[board[x + 3*i][y + 3*j] - 49]++;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku3(char[][] board) {
        HashSet<Character> set1=new HashSet<>();
        HashSet<Character> set2=new HashSet<>();
        HashSet<Character> set3=new HashSet<>();

        for (int i=0;i<9;++i){
            HashSet<Character> set=new HashSet<>();
            if(i%3==0){
                set1.clear();
                set2.clear();
                set3.clear();
            }
            for(int j=0;j<9;++j){
                if(board[i][j]!='.'){
                    if(set.contains(board[i][j]))
                        return false;
                    else
                        set.add(board[i][j]);
                }
                if(j<3 && board[i][j]!='.'){
                    if(set1.contains(board[i][j]))
                        return false;
                    else
                        set1.add(board[i][j]);
                }
                else if(j<6 && board[i][j]!='.'){
                    if(set2.contains(board[i][j]))
                        return false;
                    else
                        set2.add(board[i][j]);
                }
                else if (j<9 && board[i][j]!='.'){
                    if(set3.contains(board[i][j]))
                        return false;
                    else
                        set3.add(board[i][j]);
                }
            }
        }
        for (int i=0;i<9;++i){
            HashSet<Character> set=new HashSet<>();
            for(int j=0;j<9;++j){
                if(board[j][i]!='.'){
                    if(set.contains(board[j][i]))
                        return false;
                    else
                        set.add(board[j][i]);
                }
            }
        }
        return true;
    }
    Map<Integer, Set<Character>> rowMap = null;
    Map<Integer, Set<Character>> columnMap = null;
    Map<Integer, Set<Character>> blockMap = null;

    public boolean isValidSudoku4(char[][] board) {

        rowMap = new HashMap<>();
        columnMap = new HashMap<>();
        blockMap = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            rowMap.put(i, new HashSet<>());

            columnMap.put(i, new HashSet<>());


            blockMap.put(i, new HashSet<>());

        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;

                }

                if (rowMap.get(i).contains(board[i][j])) {
                    return false;
                }

                if (columnMap.get(j).contains(board[i][j])) {
                    return false;
                }

                if (blockMap.get(i / 3 * 3 + j / 3).contains(board[i][j])) {
                    return false;
                }

                rowMap.get(i).add(board[i][j]);
                columnMap.get(j).add(board[i][j]);
                blockMap.get(i / 3 * 3 + j / 3).add(board[i][j]);
            }
        }

        return true;
    }
    public boolean isValidSudoku5(char[][] board) {
        boolean isSudoku = true;

        HashMap<Character, Boolean> hash_rows = new HashMap<Character, Boolean>();
        //checking for all rows
        for(int i = 0; i < board.length; i++) {             //we can also hard code 9 lol
            for(int j = 0; j < board[i].length; j++) {      // REMEMBER FOR FUTURE !!!
                if(hash_rows.containsKey(board[i][j]) && board[i][j] != '.') {
                    return false;
                }
                else {
                    hash_rows.put(board[i][j], true);
                }
            }
            hash_rows.clear();
        }

        HashMap<Character, Boolean> hash_cols = new HashMap<Character, Boolean>();
        //checking for all cols
        for(int j = 0; j < 9; j++) {
            for(int i = 0; i < 9; i++) {
                if(hash_cols.containsKey(board[i][j]) && board[i][j] != '.') {
                    return false;
                }
                else {
                    hash_cols.put(board[i][j], true);
                }
            }
            hash_cols.clear();
        }

        int i_counter = 0;
        int j_counter = 0;
        HashMap<Character, Boolean> hash_square = new HashMap<Character, Boolean>();
        //checking for the 3x3 squares
        for(int i = 0; i < 3; i++) {
            i_counter = i*3;
            j_counter = 0;
            for(int j = 0; j < 3; j++) {
                for(int m = i_counter; m < i_counter + 3; m++) {
                    for(int n = j_counter; n < j_counter + 3; n++) {
                        if(hash_square.containsKey(board[m][n]) && board[m][n] != '.') {
                            return false;
                        }
                        else {
                            hash_square.put(board[m][n], true);
                        }
                    }
                }
                hash_square.clear();
                //i_counter = i*3;
                j_counter = j_counter +3;
            }

        }
        return isSudoku;
    }
    public boolean isValidSudoku6(char[][] board) {
        HashMap<Integer, HashSet<Character>> rows = new HashMap<>();
        HashMap<Integer, HashSet<Character>> cols = new HashMap<>();
        HashMap<Pair<Integer, Integer>, HashSet<Character>> sqrs = new HashMap<>();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') continue;
                rows.computeIfAbsent(r, x -> new HashSet<>());
                cols.computeIfAbsent(c, x -> new HashSet<>());
                sqrs.computeIfAbsent(new Pair(r / 3, c / 3), x -> new HashSet<>());
                if (rows.get(r).contains(ch) ||
                        cols.get(c).contains(ch) ||
                        sqrs.get(new Pair(r / 3, c / 3)).contains(ch)) {
                    return false;
                }
                rows.get(r).add(ch);
                cols.get(c).add(ch);
                sqrs.get(new Pair(r / 3, c / 3)).add(ch);
            }
        }
        return true;
    }
    public boolean isValidSudoku7(char[][] board) {
        boolean result = true;

        for (int i = 0; i < board.length; i++) {
            if (!isValidRow(board[i]) || (!isValidColumn(board, i))) {
                return false;
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                final Set<Character> set = new HashSet<>(9);
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        final char c = board[i + row][j + col];
                        if ('.' == c) {
                            continue;
                        }
                        if ((!Character.isDigit(c)) || (set.contains(c))) {
                            return false;
                        }
                        set.add(c);
                    }
                }
            }
        }

        return result;
    }

    private boolean isValidRow(char[] row) {
        final boolean result = true;
        final Set<Character> set = new HashSet<>(row.length);

        for (final char c : row) {
            if ('.' == c) {
                continue;
            }
            if ((!Character.isDigit(c)) || (set.contains(c))) {
                return false;
            }
            set.add(c);
        }

        return result;
    }

    private boolean isValidColumn(char[][] board, int colIndex) {
        final int length = board.length;
        char[] col = new char[length];

        for (int i = 0; i < length; i++) {
            col[i] = board[i][colIndex];
        }

        return isValidRow(col);
    }

    public boolean isValidSudoku8(char[][] board) {
        Set[] rows = new HashSet[9];
        Set[] cols = new HashSet[9];
        Set[] grid = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>(9);
            cols[i] = new HashSet<>(9);
            grid[i] = new HashSet<>(9);
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){

                if(board[i][j] != '.' && (!rows[i].add(board[i][j]) ||
                        !cols[j].add(board[i][j]) || !grid[i/3 + j/3*3].add(board[i][j]))){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku9(char[][] board) {
        return checkHorizontal(board) && checkSmall(board);
    }

    public boolean checkHorizontal(char[][] board) {
        for (int i = 0; i < 9; i++) {
            var arr = new int[10];
            var vert_arr = new int[10];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && arr[board[i][j] - '0'] == 1) return false;
                if (board[j][i] != '.' && vert_arr[board[j][i] - '0'] == 1) return false;
                if (board[i][j] != '.') arr[board[i][j] - '0'] += 1;
                if (board[j][i] != '.') vert_arr[board[j][i] - '0'] = 1;
            }
        }
        return true;
    }

    public boolean checkSmall(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                var small = new int[10];
                for (int k = 0; k < 9; k++) {
                    int row = i * 3 + k/3;
                    int col = j * 3 + (k % 3);
                    if (board[row][col] != '.' && small[board[row][col] - '0'] == 1) return false;
                    if (board[row][col] != '.') small[board[row][col] - '0'] = 1;
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku10(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for(int i=0 ; i<9; i++){
            for(int j=0 ; j<9; j++){
                if(board[i][j] != '.'){
                    int x = (i/3)*3+j/3;
                    if(!set.add("R"+i+board[i][j]) || !set.add("C"+j+board[i][j]) || !set.add("G"+x+board[i][j])){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku11(char[][] board) {
        Set<String> set=new HashSet<>();
        for(int row=0;row<board.length;row++)
        {
            for(int col=0;col<board[0].length;col++)
            {
                if(board[row][col]!='.'){
                    String rowStr="row"+row+board[row][col];
                    String colStr="col"+col+board[row][col];
                    String gridStr="grid"+(((row/3)) + ((col/3)*3) )+board[row][col];

                    boolean a=set.add(rowStr);
                    boolean b=set.add(colStr);
                    boolean c=set.add(gridStr);
                    if(!a || !b || !c)
                        return false;
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku12(char[][] board) {
        HashSet<String> exists = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int squareR = i / 3;
                    int squareC = j / 3;
                    if (exists.contains(i + "r" + board[i][j]) || exists.contains(j + "c" + board[i][j]) || exists.contains("" + squareR + squareC  + "s" + board[i][j])) {
                        return false;
                    } else {
                        exists.add(i + "r" + board[i][j]);
                        exists.add(j + "c" + board[i][j]);
                        exists.add("" + squareR + squareC + "s" + board[i][j]);
                    }

                }
            }
        }
        return true;
        //validate column
    }
    public boolean isValidSudoku13(char[][] a) {
        Set<Character> row = new HashSet<>();
        Set<Character> col = new HashSet<>();
        Set<Character> grid = new HashSet<>();

        for(int i =0;i<9;i++){
            row.clear();
            col.clear();
            grid.clear();
            for(int j =0;j<9;j++){
                // if(a[i][j]=='.') continue;

                int m = (i/3)*3+j/3;
                int n = (i%3)*3+j%3;
                if(row.contains(a[i][j]) || col.contains(a[j][i]) || grid.contains(a[m][n])) {

                    // System.out.println(row.toString());
                    // System.out.println(col.toString());
                    // System.out.println(grid.toString());
                    // System.out.println("i="+i+"j="+j+"a[i][j]="+a[i][j]);
                    return false;
                }
                if(a[i][j]!='.')row.add(a[i][j]);
                if(a[j][i]!='.')col.add(a[j][i]);
                if(a[m][n]!='.')grid.add(a[m][n]);
            }
        }
        return true;
    }
    public boolean isValidSudoku14(char[][] board) {
        int[] validate = new int[10];
        validate[0] = -1;
        //check row-wise
        for(int i = 0; i < 9; i++)
        {
            for(int k = 1; k < 10; k++)
                validate[k] = 0;

            for(int j = 0; j < 9; j++)
            {
                if(board[i][j] != '.')
                {
                    int temp = (int)board[i][j] - 48;
                    validate[temp]++;
                    if(validate[temp] > 1)
                        return false;
                }

            }
        }


        //check column-wise
        for(int i = 0; i < 9; i++)
        {
            for(int k = 1; k < 10; k++)
                validate[k] = 0;

            for(int j = 0; j < 9; j++)
            {

                if(board[j][i] != '.')
                {
                    int temp = (int)board[j][i] - 48;
                    validate[temp]++;
                    if(validate[temp] > 1)
                        return false;
                }

            }
        }
        //check block wise
        for(int l = 0; l < 9; l+=3)
        {
            for(int m = 0; m < 9; m+=3)
            {
                for(int k = 1; k < 10; k++)
                    validate[k] = 0;

                for(int i = l ; i < l+3; i++)
                {

                    for(int j= m; j < m+3 ; j++)
                    {
                        if(board[i][j] != '.')
                        {
                            int temp = (int)board[i][j] - 48;
                            validate[temp]++;
                            if(validate[temp] > 1)
                                return false;
                        }

                    }
                }
            }
        }
        return true;

    }
    private boolean isValid(int row, int col, char c, char board[][]) {
        for(int i = 0 ; i < 9; i++) {
            if(i != col && board[row][i] == c) return false;
            if(i != row && board[i][col] == c) return false;
            if(board[3*(row/3) + i/3][3*(col/3) + i%3] == c
                    && (3*(row/3) + i/3)  != row && (3*(col/3) + i%3) != col) return false;

        }
        return true;
    }
    public boolean isValidSudoku15(char[][] board) {
        for(int i = 0 ; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if(!isValid(i, j, board[i][j], board)) return false;
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku16(char[][] board) {
        boolean [] visited = new boolean[9];

        // row
        for (int i =0; i<board.length; i++){
            Arrays.fill(visited,false);
            for (int j =0; j<board[i].length; j++){
                if (board[i][j] != '.'){
                    int cur = board[i][j] - '1';
                    if (visited[cur]){
                        return false;
                    }else {
                        visited[cur] = true;
                    }
                }
            }
        }

        // column
        for (int i =0; i<board.length; i++){
            Arrays.fill(visited,false);
            for (int j =0; j<board[i].length; j++){
                if (board[j][i] != '.') {
                    int cur = board[j][i] - '1';
                    if (visited[cur]) {
                        return false;
                    } else {
                        visited[cur] = true;
                    }
                }
            }
        }

        // box
        for (int i =0; i <board.length; i+=3){
            for (int j =0; j<board[i].length; j+=3){
                Arrays.fill(visited,false);
                for (int m =0; m<3;m++){
                    for (int n =0; n<3; n++){
                        if (board[i + m][j+n] != '.') {
                            int cur = board[i + m][j + n] - '1';
                            if (visited[cur]) {
                                return false;
                            } else {
                                visited[cur] = true;
                            }
                        }
                    }
                }
            }
        }
        return  true;
    }
    public boolean isValidSudoku17(char[][] board) {
        int[] row = new int[9], col = new int[9];
        int[][] grid = new int[3][3];

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    continue;
                }

                int num = (int) (board[i][j] - '0');

                if(isDuplicate(num, row[i]) || isDuplicate(num, col[j]) || isDuplicate(num, grid[i/3][j/3])){
                    return false;
                }

                row[i] = row[i] | (1 << num);
                col[j] = col[j] | (1 << num);
                grid[i/3][j/3] = grid[i/3][j/3] | (1 << num);
            }
        }

        return true;
    }

    private boolean isDuplicate(int num1, int num2){
        if(((num2 >> num1) & 1) == 1){
            return true;
        }

        return false;
    }
    public boolean isValidSudoku18(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] box = new int[9];
        for(int i = 0;i<9;i++){
            for(int j =0;j<9;j++){
                char c= board[i][j];
                if(c != '.'){
                    if((row[i]&(1<<(c-'0')))>0)
                        return false;
                    if((col[j]&(1<<(c-'0')))>0)
                        return false;
                    if((box[i/3*3+j/3]&(1<<(c-'0')))>0)
                        return false;
                    row[i]|=1<<(c-'0');
                    col[j]|=1<<(c-'0');
                    box[i/3*3+j/3]|=1<<(c-'0');
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku19(char[][] board) {

        for(int i = 0;i < board.length; i++){

            for(int j = 0 ; j < board[0].length; j++){

                if( board[i][j] != '.' ){
                    if( !valid(board,i,j) ) return false;
                }
            }
        }
        return true;
    }

    public boolean valid(char[][] board,int row , int col ){

        char curr = board[row][col];
        // checking for row and col

        for(int i = 0; i < 9; i++){

            if( board[row][i] == curr && i != col ) return false;
            if( board[i][col] == curr && i != row) return false;

        }

        // checking for 3x3 square

        int nRow = row - row%3;
        int nCol = col - col%3;

        for(int i = nRow; i < nRow+3; i++){

            for(int j = nCol ; j < nCol+3; j++){

                if( i == row && j == col ) continue;

                if( board[i][j] == curr ) return false;
            }

        }
        return true;
    }
    public boolean isValidSudoku20(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int[] colCount = new int[9];
            int[] rowCount = new int[9];
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (rowCount[board[i][j]- 49] != 0) {
                        return false;
                    } else {
                        rowCount[board[i][j]- 49]++;
                    }
                }
                if (board[j][i] != '.') {
                    if (colCount[board[j][i]- 49] != 0) {
                        return false;
                    } else {
                        colCount[board[j][i]- 49]++;
                    }
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int[] count = new int[9];
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (board[x + 3*i][y + 3*j] != '.') {
                            if (count[board[x + 3*i][y + 3*j] - 49] != 0) {
                                return false;
                            } else {
                                count[board[x + 3*i][y + 3*j] - 49]++;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku21(char[][] board) {


        for(int i=0;i<board.length;i++){
            Set<Character> set = new HashSet<>();
            Set<Character> set2 = new HashSet<>();
            for(int j=0;j<board[0].length;j++){
                char ch = board[i][j];

                if(ch!='.'){
                    if(set.contains(ch)) return false;
                    else set.add(ch);
                }
                char row_ch = board[j][i];
                if(row_ch!='.'){
                    if(set2.contains(row_ch)) return false;
                    set2.add(row_ch);
                }
            }
        }
        for(int row=0;row<9;row += 3){
            for(int col=0;col<9;col +=3){
                Set<Character> set = new HashSet<>();
                for(int i=row;i<row+3;i++){

                    for(int j=col;j<col+3;j++){
                        char ch = board[i][j];
                        if(ch!='.'){
                            if(set.contains(ch)) return false;
                            else set.add(ch);
                        }
                    }
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku22(char[][] board) {
        for(int i = 0; i<9; i++){
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for (int j = 0; j < 9;j++){
                if(board[i][j]!='.' && !rows.add(board[i][j]))
                    return false;
                if(board[j][i]!='.' && !columns.add(board[j][i]))
                    return false;
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                    return false;
            }
        }
        return true;
    }
}
