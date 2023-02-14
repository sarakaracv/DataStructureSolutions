package org.example.leetCodeTask;

import java.util.Arrays;

public class RotateImage48 {
    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3},{4,5,6},{7,8,9}};
        Arrays.stream(nums).forEach(System.out::println);
        rotate(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate (int [][]matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = i; i1 < matrix[0].length; i1++) {
                int temp=0;
                temp= matrix[i][i1];
                matrix[i][i1]=matrix[i1][i];
                matrix[i1][i]=temp;

            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix.length/2; i1++) {
                int temp=0;
                temp=matrix[i][i1];
                matrix[i][i1]=matrix[i][matrix.length-1-i1];
                matrix[i][matrix.length-1-i1]=temp;
            }
        }
    }
}
