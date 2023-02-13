package org.example.leetCodeTask;

import java.util.ArrayList;
import java.util.List;

public class Permutations46 {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        System.out.println(permute(arr));
    }
    public static List<List<Integer>> permute(int[]nums){
        List<List<Integer>>list= new ArrayList<>();
        permutation(nums,list,0);
        return list;
    }
    public static void permutation(int[] num, List<List<Integer>> ans, int index){
        if (index>=num.length) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (Integer each : num) {
                arr.add(each);
            }
            ans.add(arr);
            return;
        }
        for (int i=index; i<num.length; i++){
            int temp= num[index];
            num[index]=num[i];
            num[i]=temp;
            permutation(num,ans,index+1);
            temp= num[index];
            num[index]=num[i];
            num[i]=temp;
        }

    }
}
