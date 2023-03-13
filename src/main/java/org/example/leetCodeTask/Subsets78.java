package org.example.leetCodeTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets78 {
    public static void main(String[] args) {
        int [] num= {1,2,3};
        System.out.println(subset(num));
    }
    public static List<List<Integer>> subset(int [] nums){
        List<List<Integer>> ans= new ArrayList<>();
        Arrays.sort(nums);
        ans.add(new ArrayList<>());
        for (int num:nums) {
            int siz=ans.size();
            for (int i = 0; i < siz; i++) {
                List<Integer> list = new ArrayList<>(ans.get(i));
                list.add(num);
                ans.add(list);
            }

        }
        return ans;
    }
}
