package org.example.leetCodeTask;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class RemoveDuplicateFromSortedArray26 {
    public static void main(String[] args) {
    int [] nums= {1,1,2,2,3,3,4,4};
        System.out.println(removeDuplicates2(nums));
    }

    public int removeDuplicates1(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;


    }
    public static int removeDuplicates2(int[] nums) {
        if (nums.length==0) return 0;
        int m=0;
        for (int i=0; i<nums.length; i++)
            if (nums[i]!=nums[m]) nums[++m]=nums[i];
        return ++m;
    }
    public int removeDuplicates3(int[] nums) {
        int count = 1;
        int p1 = 0;
        int p2 = 1;
        while(p1 < nums.length && p2 < nums.length){
            if(nums[p1] != nums[p2]){
                nums[++p1] = nums[p2];
                count++;
            }
            p2++;
        }
        return count;

    }
    public int removeDuplicates4(int[] nums) {

        int k = 1; // #non-duplicates

        //System.out.println(Arrays.toString(nums));

        for (int i = 1; i < nums.length; i++ ) {
            if (nums[i] == nums[i-1]) {
                nums[i-1] = 101;
            }
            else k++;
        }
        //System.out.println(Arrays.toString(nums));
        //System.out.println(k);
        for (int i=0; i < k; i++) {
            if (nums[i] == 101) {
                int j = i+1;
                while (nums[j] == 101) {
                    j++;
                }
                nums[i] = nums[j];
                nums[j] = 101;
            }
        }
        //System.out.println(Arrays.toString(nums));
        return k;
    }
    public int removeDuplicates5(int[] nums) {
        Set<Integer> ns = new TreeSet<Integer>();

        for(int i : nums){
            ns.add(i);
        }

        //Set<Integer> ts = new TreeSet<>(ns);

        int k = 0;
        for(int i : ns){
            nums[k++] = i;
        }
        return ns.size();
    }
    public int removeDuplicates6(int[] nums) {
        Set<Integer> ns = new HashSet<Integer>();

        for(int i : nums){
            ns.add(i);
        }

        Set<Integer> ts = new TreeSet<>(ns);

        int k = 0;
        for(int i : ts){
            nums[k++] = i;
        }
        return ts.size();
    }
    public int removeDuplicates7(int[] nums) {
        AtomicInteger uniqueCount = new AtomicInteger(-1);
        Arrays.stream(nums).distinct().forEach(element -> nums[uniqueCount.incrementAndGet()] = element);
        return uniqueCount.incrementAndGet();
    }
    public int removeDuplicates8(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int[] temp = new int[nums.length];
        Arrays.sort(nums);
        int j=0;
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i]!=nums[i+1])
                temp[j++]=nums[i];
        }
        temp[j++]=nums[nums.length-1];
        for (int i=0; i<j; i++){
            nums[i] = temp[i];
        }
        return j;
    }
    public int removeDuplicates9(int[] nums) {
        int counter=0;
        for(int i=0;i<nums.length;i++){
            if(i!=0 && nums[i-1]==nums[i]){
                nums[i-1]=nums[nums.length-1]+1;
            }
            else{
                counter++;
            }
        }
        Arrays.sort(nums);
        return counter;
    }
    public int removeDuplicates10(int[] nums) {
        int counter=0;
        for(int i=0;i<nums.length;i++){
            if(i!=0 && nums[i-1]==nums[i]){
                nums[i-1]=Integer.MAX_VALUE;
            }
            else{
                counter++;
            }
        }
        Arrays.sort(nums);
        return counter;
    }
    public int removeDuplicates11(int[] nums) {

        Set<Integer> set = new TreeSet<>() ;
        for(Integer i: nums){
            set.add(i);
        }

        int i=0;
        for(int num: set){
            nums[i++] = num;
        }
        return set.size() ;

    }
    public int removeDuplicates12(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }else
                nums[i] = 1000;
        }
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        int k = map.size();
        //nums = map.keySet().toArray();
        return k;

    }
    public int removeDuplicates13(int[] nums) {
        Iterator<Integer> iter = Arrays.stream(nums).boxed().collect(Collectors.toSet()).stream().sorted().iterator();

        int i = 0;
        while (iter.hasNext()) {
            int next = iter.next();
            nums[i] = next;
            i++;
        }
        return i;
    }
    public int removeDuplicates14(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; ) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
                i++;
            } else {
                i++;
            }
        }
        return j;
    }
    public int removeDuplicates15(int[] nums) {
        int insertIndex = 1;
        for(int i = 1;i < nums.length; i++)
        {
            if(nums[i-1]!=nums[i])
            {
                nums[insertIndex]=nums[i];
                insertIndex++;
            }
        }
        return insertIndex;
    }
    public int removeDuplicates16(int[] nums) {

        int insertIndex = 1;

        for(int i = 1; i< nums.length; ++i) {
            if(nums[i-1] != nums[i]) {
                nums[insertIndex] = nums[i];
                ++insertIndex;
            }

        }

        return insertIndex;
    }
    public int removeDuplicates17(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int k=1;
        for(int i=0; i<nums.length; i++){
            System.out.println(nums[i]);
            if(stack.empty()){
                stack.push(nums[i]);
            }else if(stack.peek()!=nums[i]){
                stack.push(nums[i]);
                nums[k]=nums[i];
                k++;

            }
        }
        return k;
    }
    public int removeDuplicates18(int[] nums) {

        Map <String,Integer> map= new HashMap<>();
        int cnt = 0;
        for(int i:nums){
            String st = Integer.toString(i);
            if(map.get(st)==null){
                nums[cnt]=i;
                cnt++;
                map.put(st,1);
            }
        }
        return cnt;
    }
    public int removeDuplicates19(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();

        for(int i : nums)
            set.add(i);

        Iterator<Integer> it = set.iterator();
        int i = 0;
        while(it.hasNext()) {
            nums[i++] = it.next();
        }

        return set.size();
    }
    public int removeDuplicates20(int[] nums) {
        HashMap<Integer, Integer> numbers = new HashMap<Integer, Integer>();
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!(numbers.containsValue(nums[i]))) {
                numbers.put(i, nums[i]);
                nums[counter] = nums[i];
                counter++;
            }
        }
        return counter;
    }
    public int removeDuplicates21(int[] nums) {
        Set<Integer> ns = new HashSet<Integer>();

        for(int i : nums){
            ns.add(i);
        }

        Set<Integer> ts = new TreeSet<>(ns);

        int k = 0;
        for(int i : ts){
            nums[k++] = i;
        }
        return ts.size();
    }
    public int removeDuplicates22(int[] arr)
    {
        int n = arr.length;

        if(arr[0] == arr[n-1])
        {
            return 1;
        }

        int j = 0;

        for(int i=0; i<n-1; i++)
        {
            if(arr[i] != arr[i+1])
            {
                arr[j] = arr[i];
                j++;
            }
        }

        arr[j] = arr[n-1];
        j++;

        return j;
    }
}