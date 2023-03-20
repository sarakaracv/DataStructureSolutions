package org.example.leetCodeTask;

import java.util.*;

public class IntersectionOfTwoArraysII350 {
    public static void main(String[] args) {

    }

        public int[] intersect1(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int i = 0, j = 0, k = 0;
            int[] result = new int[Math.min(nums1.length, nums2.length)];
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    i++;
                } else if (nums1[i] > nums2[j]) {
                    j++;
                } else {
                    result[k] = nums1[i];
                    i++;
                    j++;
                    k++;
                }
            }
            System.gc();
            return Arrays.copyOfRange(result, 0, k);
        }



    public int[] intersect2(int[] nums1,int[] nums2){
        HashMap<Integer,Integer> hm= new HashMap<>();
        ArrayList<Integer> arrayList= new ArrayList<>();
        for (int num:nums1){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        for (int num:nums2){
            if (hm.containsKey(num)&&hm.get(num)>0){
                arrayList.add(num);
                hm.put(num,hm.get(num)-1);
            }
        }
        int [] result= new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            result[i]= arrayList.get(i);
        }
        return result;
    }
    public int[] intersect3(int[] nums1, int[] nums2) {
        //Set<Integer> set=new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int k=Math.min(nums1.length,nums2.length);
        int i=0;
        int j=0;
        List<Integer> list=new ArrayList<>();
        while(i<nums1.length && j<nums2.length)
        {
            if(nums1[i] < nums2[j])
                i++;
            else if(nums1[i]>nums2[j])
                j++;
            else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        System.gc();
        return list.stream().mapToInt(e->e).toArray();

    }
    public int[] intersect(int[] nums1, int[] nums2) {
        // make int arraylist to store the intersection to be flexible without keeping track of pointers
        // make a map for nums1 storing ints as keys and count as values
        // loop through nums1
        // if int is not in map, insert it to a map<int, count>
        // else update count by 1

        // loop through nums2
        // check if int is in map
        // if in map and count > 0, -1 to count
        // add number to intersection array

        // create an int array the size of arraylist
        // loop through the arraylist to insert it in the arr
        // return the arr

        List<Integer> intersection = new ArrayList<>();
        Map<Integer, Integer> nums1IntCount = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (nums1IntCount.get(nums1[i]) == null) {
                nums1IntCount.put(nums1[i], 1);
            } else {
                nums1IntCount.put(nums1[i], nums1IntCount.get(nums1[i]) + 1);
            }
        }

        for (int j = 0; j < nums2.length; j++) {
            if (nums1IntCount.get(nums2[j]) != null && nums1IntCount.get(nums2[j]) > 0) {
                nums1IntCount.put(nums2[j], nums1IntCount.get(nums2[j]) - 1);
                intersection.add(nums2[j]);
            }
        }

        int[] intersectionArray = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            intersectionArray[i] = intersection.get(i);
        }
        return intersectionArray;
    }
}
