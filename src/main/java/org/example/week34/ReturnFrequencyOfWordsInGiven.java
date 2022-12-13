package org.example.week34;

import java.util.Map;
import java.util.TreeMap;

public class ReturnFrequencyOfWordsInGiven {
    public static void main(String[] args) {
        String str = "Geeks For Geeks";
        countFreq(str);
    }
    public static void countFreq(String str){
        Map <String,Integer> map= new TreeMap<>();
        String arr[]= str.split("");
       for (int i = 0; i < arr.length; i++) {
           if (map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i]) +1 );
           else map.put(arr[i],1);

       }
       for (Map.Entry<String,Integer> each: map.entrySet()){
           System.out.println(each.getKey()+" - "+ each.getValue());
        }

    }
}
