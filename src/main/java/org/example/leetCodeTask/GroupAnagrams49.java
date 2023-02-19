package org.example.leetCodeTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams49 {
    public static void main(String[] args) {
       String [] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));

    }
    public static List<List<String>> groupAnagrams(String [] strs){
        List<List<String>> list = new ArrayList<>();

        if (strs==null|| strs.length==0) return list;
        HashMap<String,List<String>> hm= new HashMap<>();
        for (String each:strs){
            char[] chars= each.toCharArray();
            Arrays.sort(chars);
            String s= new String(chars);
            if (!hm.containsKey(s)){
                hm.put(s, new ArrayList<String>());
            }
            hm.get(s).add(each);
        }
        for (String st:hm.keySet()){
            list.add(hm.get(st));
        }



        return list;
    }
}
