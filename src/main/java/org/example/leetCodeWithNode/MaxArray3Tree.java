package org.example.leetCodeWithNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class MaxArray3Tree {
    public static void main(String[] args) {

    }


    public static void maxArray(Stack<Integer> nodes,TreeNode root, int size){

        if (root == null) return;

        if (size == nodes.size()) nodes.add(root.val);
        else nodes.set(size, Math.max(nodes.get(size), root.val));

        maxArray(nodes, root.left, size+ 1);
        maxArray(nodes, root.right, size + 1);


    }
    public static Stack<Integer> maxVal(TreeNode root){

        Stack<Integer> res= new Stack<>();
        maxArray(res, root,0);
        return res;
    }

    static int [] largest(int arr[], int size) {
        int i, first, second, third;

        if (size < 3) {
            return null;
        }

        third = first = second = Integer.MIN_VALUE;
        for (i = 0; i < size; i++) {

            if (arr[i] > first) {
                third = second;
                second = first;
                first = arr[i];
            } else if (arr[i] > second) {
                third = second;
                second = arr[i];
            }

            else if (arr[i] > third)
                third = arr[i];
        }
        return new int []{first,second,third};
    }
}
