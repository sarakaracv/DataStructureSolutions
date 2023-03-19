package org.example.leetCodeTask;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle118 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    int left = triangle.get(i-1).get(j-1);
                    int right = triangle.get(i-1).get(j);
                    row.add(left + right);
                }
            }

            triangle.add(row);
        }

        return triangle;
    }
}
