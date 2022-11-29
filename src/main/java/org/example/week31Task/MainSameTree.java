package org.example.week31Task;

public class MainSameTree {
    public static void main(String[] args) {

    SameTree sameTree= new SameTree();


        MyTree myTree = new MyTree();

        int[] number = new int[]{8, 10, 12, 5, 9, 7};
        for (int i = 0; i < number.length; i++) {
            myTree.insert(number[i]);
        }

        System.out.println(sameTree.isSameTree(myTree.left,myTree.right));
    }
}
