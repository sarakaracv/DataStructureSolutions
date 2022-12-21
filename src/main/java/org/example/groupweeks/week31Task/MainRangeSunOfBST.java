package org.example.groupweeks.week31Task;

public class MainRangeSunOfBST {
    public static void main(String[] args) {

        RangeSumOfBST rangeSumOfBST = new RangeSumOfBST();
        MyTree myTree = new MyTree();
        int[] number = new int[]{8, 10, 12, 5, 9, 7};
        for (int i = 0; i < number.length; i++) {
            myTree.insert(number[i]);
        }

        VisualizeTree.printTree(myTree.root,null,false);

        System.out.println( rangeSumOfBST.rangeSumBST6(myTree.root,5,15));


    }
}
