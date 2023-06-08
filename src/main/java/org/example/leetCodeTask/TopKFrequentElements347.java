package org.example.leetCodeTask;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentElements347 {
    public static void main(String[] args) {

    }
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer,Integer> freg= new HashMap<>();
        for(int num:nums){
            freg.put(num,freg.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> pg=new PriorityQueue<>((a, b)->freg.get(a)-freg.get(b));
        for(int num:freg.keySet()){
            pg.offer(num);
            if(pg.size()>k){
                pg.poll();
            }
        }
        int list[]= new int[k];
        int ex=0;
        while(!pg.isEmpty()){
            list[ex++]=pg.poll();
        }
        return list;
    }
    public int[] topKFrequent2(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //  Find min and max number
        for(int num:nums){
            if(num > max) max = num;
            if(num < min) min = num;
        }
        //  Build frequence array
        int[] freq = new int[max - min + 1];
        for(int num:nums){
            freq[num - min] ++;
        }
        //  Put numbers with same frequence into a bucket
        List<Integer>[] bucket = new List[nums.length + 1];
        int max_freq = 0;
        for(int i=0; i<freq.length; i++){
            if(freq[i] > 0){
                if(bucket[freq[i]] == null) bucket[freq[i]] = new ArrayList<>();
                bucket[freq[i]].add(i + min);
                if(freq[i] > max_freq) max_freq = freq[i];
                // max_freq = Math.max(max_freq, freq[i]);
            }
        }
        //Loop through buckets to find top k frequent element
        int[] res = new int[k];
        int i = 0;
        for(int j=max_freq; j>=0 && i<k; j--){
            if(bucket[j] != null){
                for(int num : bucket[j]) {
                    if(i == k) break;
                    res[i++] = num;
                }
            }
        }
        return res;
    }
    public int[] topKFrequent3(int[] nums, int k) {
        if (k == nums.length) return nums;

        int max = nums[0];
        int min = nums[0];
        for(int num : nums){
            if(num > max) max = num;
            if(num < min) min = num;
        }

        // Build frequence array
        int[] freq = new int[max - min + 1];
        for(int num : nums)
            freq[num - min] ++;

        // Put numbers with same frequence into a bucket
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        int max_freq = 0;
        for(int i = 0; i < freq.length; i++){
            if(freq[i] > 0){
                if (bucket[freq[i]] == null) bucket[freq[i]] = new ArrayList<>();
                bucket[freq[i]].add(i + min);
                if(freq[i] > max_freq) max_freq = freq[i];
            }
        }

        //Loop through buckets to find top k frequent element
        int[] res = new int[k];
        for(int i = 0, j = max_freq; j > 0 && i < k; j--){
            if(bucket[j] != null){
                for(int num : bucket[j]) {
                    if (i == k) break;
                    res[i++] = num;
                }
            }
        }
        return res;
    }
    public int[] topKFrequent4(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //  Find min and max number
        for(int num:nums){
            if(num > max) max = num;
            if(num < min) min = num;
        }
        //  Build frequence array
        int[] freq = new int[max - min + 1];
        for(int num:nums){
            freq[num - min] ++;
        }
        //  Put numbers with same frequence into a bucket
        List<Integer>[] bucket = new List[nums.length + 1];
        int max_freq = 0;
        for(int i=0; i<freq.length; i++){
            if(freq[i] > 0){
                if(bucket[freq[i]] == null) bucket[freq[i]] = new ArrayList<>();
                bucket[freq[i]].add(i + min);
                if(freq[i] > max_freq) max_freq = freq[i];
                // max_freq = Math.max(max_freq, freq[i]);
            }
        }
        //Loop through buckets to find top k frequent element
        int[] res = new int[k];
        int i = 0;
        for(int j=max_freq; j>=0 && i<k; j--){
            if(bucket[j] != null){
                for(int num : bucket[j]) {
                    if(i == k) break;
                    res[i++] = num;
                }
            }
        }
        return res;
    }
    public int[] topKFrequent5(int[] nums, int k) {
        int[] freq = new int[20001];
        for (int i : nums) freq[i + 10000]++;

        final PriorityQueue<Pair> queue = new PriorityQueue<>((e1, e2) -> e2.value - e1.value);
        for (int i = 0; i < freq.length; i++)
            if (freq[i] != 0)
                queue.add(new Pair(i - 10000, freq[i]));

        int[] result = new int[k];
        while (--k >= 0) result[k] = queue.poll().key;
        return result;
    }

    private static class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
//    public int[] topKFrequent6(int[] nums, int k) {
//        List<Integer> lst = Arrays.stream(nums).boxed().toList();
//        List<Pair<Integer, Long>> counts = lst.stream()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet().stream()
//                .map(entry -> new Pair<>(entry.getKey(), entry.getValue()))
//                .sorted(Comparator.comparing((Pair<Integer, Long> p) -> p.getValue()).reversed())
//                .collect(Collectors.toList());
//
//        int[] result = new int[k];
//        for (int i = 0; i < k; i++) {
//            result[i] = counts.get(i).getKey();
//        }
//
//        return result;
//    }
public int[] topKFrequent7(int[] nums, int k) {
    Map<Integer, Long> countMap = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.groupingBy(
                    Function.identity(),
                    Collectors.counting()
            ));

    return countMap.entrySet().stream()
            .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
            .limit(k)
            .mapToInt(Map.Entry::getKey)
            .toArray();
}
    public int[] topKFrequent8(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            if(!map.containsKey(i)){
                map.put(i,1);
            }else{
                map.put(i,map.get(i)+1);
            }
        }
        Map<Integer, Integer> temp
                = map.entrySet()
                .stream()
                .sorted((i1, i2)
                        -> i2.getValue().compareTo(
                        i1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        int[] a = new int[k];
        int i=0;
        for (Map.Entry<Integer,Integer> entry : temp.entrySet()){
            a[i++] = entry.getKey();
            if(i==k){
                break;
            }
        }
        return a;

    }
    public int[] topKFrequent9(int[] nums, int k) {
        Map<Integer, Integer> hm = new LinkedHashMap<>();

        for (int num : nums) {
            Integer val = hm.getOrDefault(num, 0);
            hm.put(num, (val + 1));
        }

        System.out.println("key: " + hm.keySet() + ", values: " + hm.values());

        List<Integer> sortedNums = hm.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        System.out.println(sortedNums);

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = sortedNums.get(i);
        }
        return result;
    }

}
