package org.example.leetCodeTask;

public class Flatten2DVector251 {
    public class Vector2D {
        private int[][] vec;
        private int row;
        private int col;

        public Vector2D(int[][] vec) {
            this.vec = vec;
            row = 0;
            col = 0;
        }

        public int next() {
            if (!hasNext()) {
                return -1;
            }
            int val = vec[row][col];
            col++;
            if (col == vec[row].length) {
                row++;
                col = 0;
            }
            return val;
        }

        public boolean hasNext() {
            while (row < vec.length && col == vec[row].length) {
                row++;
                col = 0;
            }
            return row < vec.length;
        }
    }

}
