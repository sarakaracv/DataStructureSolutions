package org.example.leetCodeTask;

public class SearchA2DMatrixII240 {
        public boolean searchMatrix1(int[][] matrix, int target) {
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false; // empty matrix
            }
            int m = matrix.length, n = matrix[0].length;
            int i = 0, j = n-1; // start from top-right corner

            while(i < m && j >= 0) {
                if(matrix[i][j] == target) {
                    return true; // target found
                }
                else if(matrix[i][j] < target) {
                    i++; // move down
                }
                else {
                    j--; // move left
                }
            }
            return false; // target not found
        }
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            if(matrix[i][0] <= target && target <= matrix[i][n-1]){
                int l = 0;
                int r = n - 1;

                while(l<=r){
                    int mid = (l+r)/2;

                    if(matrix[i][mid] == target){
                        return true;
                    }else if(matrix[i][mid] > target){
                        r = mid - 1;
                    }else {
                        l = mid + 1;
                    }
                }
            }
        }
        return false;
    }
    public boolean searchMatrix3(int[][] matrix, int target)
    {
        //Time - O(m+n), Space -O(1)
    /*int row = 0;
    int column = matrix[0].length-1;
    while(row < matrix.length && column >= 0)
        {
            if(matrix[row][column] == target){
                return true;
            }
            else if(matrix[row][column] < target)
            {
                row++;
            }
            else
                column--;

        }
        return false;*/

//Using Binary Search in every row until the element is found or we reach at the end of the matrix.

        for(int i = 0; i < matrix.length; i++)
        {
            int low = 0;
            int high = matrix[0].length - 1;

            while(low <= high)
            {
                int mid = (low+high)/2;
                if(matrix[i][mid] == target)
                    return true;
                if(matrix[i][mid] > target)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }

        return false;
    }
    public boolean searchMatrix4(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            int start = 0;
            int end = n - 1;

            int res = -1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (matrix[i][mid] == target) {
                    res = mid;
                    break;
                } else if (matrix[i][mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            if (res != -1) {
                return true;
            }
        }
        return false;
    }
    public boolean searchMatrix5(int[][] matrix, int target) {
        int top = 0, bot = matrix.length - 1, row = 0;

        while (top <= bot) {
            int mid = top + (bot - top)/2;

            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                row = mid;
                top = mid + 1;
            } else {
                bot = mid - 1;
            }
        }

        int left = 0, right = matrix[0].length - 1, col = 0;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (matrix[0][mid] == target) {
                return true;
            } else if (matrix[0][mid] < target) {
                col = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        for (int i = 0; i <= row; i++) {
            left = 0;
            right = col;

            while (left <= right) {
                int mid = left + (right - left)/2;

                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] < target) {
                    col = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
    public boolean searchMatrix6(int[][] matrix, int target) {
            int m= matrix.length, n=matrix[0].length;
            for (int i=0; i<m;i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == target) return true;

                }

            }
        return false;
        }
    }

