package org.example.groupweeks.week34;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class ReturnFrequencyOfWordsInGiven {
    public static void main(String[] args) {
        String str = "sara sara memo ozzy mike memo sara";
        countFreq4(str);
    }

    public static void countFreq(String str) {
        Map<String, Integer> map = new TreeMap<>();
        String arr[] = str.split("");
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i]) + 1);
            else map.put(arr[i], 1);

        }
        for (Map.Entry<String, Integer> each : map.entrySet()) {
            System.out.println(each.getKey() + "-" + each.getValue());
        }


    }

    public static void countFreq2(String str) {
        Map<String, Integer> freqMap = new HashMap<>();
        String[] arrs = str.split(" ");
        Arrays.stream(arrs).forEach(s -> {
            if (freqMap.containsKey(s)) {
                Integer count = freqMap.get(s);
                freqMap.put(s, count + 1);
            } else {
                freqMap.put(s, 1);
            }
        });
        System.out.println(freqMap.toString());
    }

    public static void countFreq3(String str) {
        Map<String, Integer> map = new HashMap<>();
        String[] arrs = str.split(" ");
        Arrays.stream(arrs).forEach(word -> {
            map.merge(word, 1, Integer::sum);
        });
        System.out.println(map.toString());
    }

    public static void countFreq4(String str) {
        Map<String, Integer> maps = new HashMap<>();
        String[] arrs = str.split(" ");
        Arrays.stream(arrs).forEach(word -> maps.merge(word, 1, Integer::sum));
        System.out.println(maps.toString());
    }

    //    public static void textWordFreq() {
//        String text = "Ann while Bob had had had had had had had had had had had a better effect on on the teacher";
//        ConcurrentMap<String, Integer> freqMap =
//                asList(text.split("[\\s.]"))
//                        .parallelStream()
//                        .filter(s -> !s.isEmpty())
//                        .collect(Collectors.toConcurrentMap(w -> w.toLowerCase(), w -> 1, Integer::sum));
//        System.out.println(freqMap.toString());
//    }
//public static void textWordFreq() {
//    String text = "Ann while Bob had had had had had had had had had had had a better effect on on the teacher";
//    ConcurrentMap<String, Integer> freqMap =
//            asList(text.split("[\\s.]"))
//                    .parallelStream()
//                    .filter(s -> !s.isEmpty())
//                    .collect(Collectors.toConcurrentMap(w -> w.toLowerCase(), w -> 1, Integer::sum));
//    System.out.println(freqMap.toString());
//
//    //Priority queue that uses frequency as the comparator and size as 3
//    PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(freqMap::get));
//    for(String key: freqMap.keySet()) {
//        pq.add(key);
//        if(pq.size() > 3) {
//            pq.poll();
//        }
//    }
//    System.out.println("Top 3 words by occurrences  : " + pq);
//}
//    public static void countFreq5(String str) {
//        Map<String, Integer> freqMap = new HashMap();
//        PriorityQueue<String> pq = new PriorityQueue<>();
//        if (!str.isEmpty()) pq.add(str);
//        for (String key : freqMap.keySet()) {
//            pq.add(key);
//            if (pq.size() > 1) {
//                pq.poll();
//            }
//        }
//}
//    public static void countFreq6(String str) {
//        Map<String, Integer> counterMap = new HashMap<>();
//            counterMap.get(str);
//        for (String country : counterMap.keySet()) {
//            Integer compute = counterMap.compute(country, (k, v) -> v == null ? 1 : v + 1);
//            System.out.println(compute+" hh");
//        }
//
//    }
}

