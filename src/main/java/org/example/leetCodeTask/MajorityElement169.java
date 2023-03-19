package org.example.leetCodeTask;

public class MajorityElement169 {
    public static void main(String[] args) {

    }
    public int majorityElement(int [] nums){
        //Boyer-Moore Voting Algorithm
        Integer candidate=null;
        int count=0;
        for (int num:nums){
            if (count==0){
                candidate=num;
            }
            count+=(num==candidate)? 1: -1;
        }

        return candidate;
    }
}
