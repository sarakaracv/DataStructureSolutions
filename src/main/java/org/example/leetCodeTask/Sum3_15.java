package org.example.leetCodeTask;

import java.util.*;
import java.util.stream.Collectors;

public class Sum3_15 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            int left = i+1, right = len-1, sum = 0;
            while(left < right) {
                sum= nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left<right && nums[left+1] == nums[left]) left++;
                    while(right>1 && nums[right-1] == nums[right]) right--;
                    left++;
                    right--;
                } else if(sum<0) left++;
                else right--;
            }
            while(i < len-1 &&nums[i+1] == nums[i]) i++;
        }
        return list;
    }
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0, j = 0, n = nums.length, k = n - 1;
        if (k < 2 || nums[k] < 0) {
            return res;
        }
        while (i < n - 2) {
            if (nums[i] > 0) {
                break;
            }
            int target = -nums[i];
            j = i + 1;
            k = n - 1;
            while (j < k) {
                if (nums[k] < 0) {
                    break;
                }
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j < k && nums[j] == nums[++j]);
                    while(j < k && nums[k] == nums[--k]);
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
            while (i < n - 2 && nums[i] == nums[++i]);
        }
        return res;
    }
    public List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        int hi;
        int lo;
        int temp;

        // System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length - 2;) {
            lo = i + 1;
            hi = nums.length - 1;
            while (lo < hi) {
                // System.out.println("i/lo/hi " + i + "/" + lo + "/" + hi);
                temp = nums[i] + nums[lo] + nums[hi];
                if (temp == 0) {
                    set.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[lo], nums[hi])));
                    do {lo++;} while(lo < hi && nums[lo - 1] == nums[lo]);
                } else if (temp > 0)
                    hi--;
                else
                    lo++;
            }
            do {i++;} while(i < nums.length - 2 && nums[i - 1] == nums[i]);
        }
        return new ArrayList(set);
    }
    public List<List<Integer>> threeSum4(int[] nums) {
        return findTriplets(nums, nums.length, 0);
    }
    public List<List<Integer>> findTriplets(int a[], int n, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        int i;
        Arrays.sort(a);
        for (i = 0; i < n - 2; i++) {
            if (i == 0 || a[i] > a[i - 1]) {
                int start = i + 1;
                int end = n - 1;
                int target = sum - a[i];
                while (start < end)  {
                    if (start > i + 1 && a[start] == a[start - 1]) {
                        start++;
                        continue;
                    }
                    if (end < n - 1 && a[end] == a[end + 1]) {
                        end--;
                        continue;
                    }
                    if (target == a[start] + a[end]) {
                        List<Integer> list_temp = new ArrayList<>();
                        list_temp.add(a[i]);
                        list_temp.add(a[start]);
                        list_temp.add(a[end]);
                        list.add(list_temp);
                        start++;
                        end--;
                    }
                    else if (target > (a[start] + a[end])) {
                        start++;
                    }
                    else {
                        end--;
                    }
                }
            }
        }
        return list;
    }
    public List<List<Integer>> threeSum5(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> temp;
        Arrays.sort(nums);
        if (nums[0] == 0 && nums[0] == nums[nums.length - 1]) {
            temp = new ArrayList<>();
            temp.add(nums[0]);
            temp.add(nums[0]);
            temp.add(nums[0]);
            ans.add(temp);
            return ans;
        }
        int num = 0;
        int currentSum = 0;
        int l = 1;
        int r = nums.length - 1;
        while (num < nums.length  && l < nums.length) {
            currentSum = 0;
            if (num >= 1 && nums[num]==nums[num - 1]) {
                num++;
                l = num + 1;
                r = nums.length - 1;
                continue;
            }
            if (r == l) {
                num++;
                l = num + 1;
                r = nums.length - 1;
                continue;
            }
            currentSum += nums[num] + nums[l] + nums[r];
            if (currentSum < 0) {
                l++;
//                while (l < r - 1 && nums[l] == nums[l-1]) {
//                    l++;
//                }
            } else if (currentSum > 0) {
                r--;
            } else {
                temp = new ArrayList<>();

                temp.add(nums[num]);
                temp.add(nums[l]);
                temp.add(nums[r]);
//                if (!ans.contains(temp)) {
                ans.add(temp);
//                }

                l++;
                while (l < r - 1 && nums[l] == nums[l-1]) {
                    l++;
                }
                r = nums.length - 1;
            }
        }
        // System.out.println("I = " + num);
        return ans.stream().distinct().collect(Collectors.toList());
    }
    public List<List<Integer>> threeSum6(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        quickSort(nums, 0, n-1);
        int left;
        int right;
        for(int i=0; i < n-2; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            left=i+1;
            right=n-1;
            while(left < right){
                List<Integer> list = new ArrayList<>();
                if(nums[i]+nums[left]+nums[right] == 0){
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    left++;

                    while(nums[left] == nums[left-1] && left<right){
                        left++;
                    }
                }

                else if(nums[i]+nums[left]+nums[right] < 0){
                    left++;
                }

                else if(nums[i]+nums[left]+nums[right] > 0){
                    right--;
                }
            }
        }
        return result;
    }

    private static int partition(int[] nums, int low, int high){
        int pivot = nums[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(nums[j] < pivot){
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i+1, high);
        return i+1;
    }

    private static void quickSort(int[] nums, int low, int high){
        if(low < high){
            int pi = partition(nums, low, high);
            quickSort(nums, low, pi-1);
            quickSort(nums, pi+1, high);
        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public List<List<Integer>> threeSum7(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if(nums.length < 3 || nums[0] > 0 || nums[nums.length-1] < 0)
            return result;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int k=0; k<nums.length; k++){
            if(nums[k] < 0) continue;
            map.put(nums[k], k);
        }
        for(int i=0; i<nums.length-2; i++){
            if(nums[i] > 0)
                return result;
            if(i!= 0 && nums[i] == nums[i-1])
                continue;
            for(int j=i+1; j<nums.length-1; j++){
                if(j!= i+1 && nums[j] == nums[j-1])
                    continue;
                int sum = -1*(nums[i] + nums[j]);
                if(sum > nums[nums.length-1])
                    continue;
                else{
                    if(map.containsKey(sum) && map.get(sum) > j){
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], sum);
                        result.add(temp);
                    }
                }
            }
        }
        return result;
    }
    public List<List<Integer>> threeSum8(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> lists = new LinkedList<>();
        for (int i = 0; i < n-2 && nums[i] <= 0; ++i) {
            if (i == 0 || nums[i] != nums[i-1]) {
                for (int j = i+1; j < n; ++j) {
                    if (j == i+1 || nums[j] != nums[j-1]) {
                        if (Arrays.binarySearch(nums, j+1, n, -nums[i]-nums[j]) > 0) {
                            List<Integer> list = new LinkedList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(-nums[i]-nums[j]);
                            lists.add(list);
                        }
                    }
                }
            }
        }
        return lists;
    }
    public List<List<Integer>> threeSum9(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Hashtable<Integer, Integer> hm = new Hashtable<Integer, Integer>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
        }
        List<Integer> l = new ArrayList<>();
        int curr;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                curr = -nums[i]-nums[j];
                if (hm.containsKey(curr) && hm.get(curr) > j) {
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(curr);
                    result.add(l);
                    l = new ArrayList<>();
                }
                while (j+1 < nums.length && nums[j] == nums[j+1]) {
                    j++;
                }
            }
            while (i+1 < nums.length && nums[i] == nums[i+1]) {
                i++;
            }

        }
        return result;
    }
    public List<List<Integer>> threeSum10(int[] nums) {
        Set<List<Integer>> threeSum = new HashSet();
        Arrays.sort(nums);
        Set<Integer> numbers = new HashSet();
        for(int i=0;i<nums.length && nums[i]<=0;i++){
            if(numbers.contains(nums[i])) continue;
            else numbers.add(nums[i]);

            for(int j=i+1;j<nums.length;j++){
                int value = 0 - nums[i] - nums[j];
                int found = Arrays.binarySearch(nums,j+1,nums.length,value);
                if(found >= 0) threeSum.add(Arrays.asList(nums[i],nums[j],value));
            }
        }
        return new ArrayList(threeSum);
    }
    public List<List<Integer>> threeSum11(int[] nums) {
//         List<List<Integer>> list = new ArrayList<>();

//         int i, j, k;
//         for(i=0;i<nums.length-2;i++){
//             for(j=i+1;j<nums.length-1;j++){
//                 for(k=j+1;k<nums.length;k++){
//                     if(nums[i]+nums[j]+nums[k]==0){
//                         List<Integer> current = new ArrayList<>();
//                         current.add(nums[i]);
//                         current.add(nums[j]);
//                         current.add(nums[k]);
//                         Collections.sort(current);
//                         if (!list.contains(current)) {
//                             list.add(current);
//                         }
//                     }
//                 }
//             }
//         }
//         return list;

        Arrays.sort(nums);
        List<List<Integer>> result =new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
            map.put(nums[i], i);
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                int target=0-nums[i]-nums[j];
                if(map.containsKey(target) && map.get(target)>j){
                    result.add(Arrays.asList(nums[i], nums[j], target));
                    j=map.get(nums[j]);
                }
                i=map.get(nums[i]);
            }
        }
        return result;
    }
    public List<List<Integer>> threeSum12(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        Arrays
                .stream(nums)
                .forEach((num) -> {
                    if (map.containsKey(num)) {
                        map.put(num, map.get(num) + 1);
                    } else {
                        map.put(num, 1);
                    }
                });

        List<Integer> plusDigits = new ArrayList<>();
        List<Integer> minusDigits = new ArrayList<>();

        map.keySet()
                .forEach(num -> {
                    if (num > 0) plusDigits.add(num);
                    else if (num < 0) minusDigits.add(num);
                });

        List<List<Integer>> answer = new ArrayList<>();
        minusDigits.forEach(minusDigit -> {
            Set<Integer> usedPluses = new HashSet<>();
            plusDigits.forEach(plusDigit -> {

                int difference = minusDigit + plusDigit;
                if (proof(minusDigit, plusDigit, -difference, map)) {
                    if (!usedPluses.contains(plusDigit)) {
                        answer.add(new ArrayList<>(List.of(plusDigit, minusDigit, -difference)));
                        usedPluses.add(-difference);
                    }
                }
            });
            map.remove(minusDigit);
        });

        if (map.containsKey(0) && map.get(0) > 2) {
            answer.add(new ArrayList<>(List.of(0,0,0)));
        }

        return answer;
    }

    private  boolean proof(int minusDigit, int plusDigit, int needToAdd, Map<Integer, Integer> map) {

        if (needToAdd != minusDigit && needToAdd != plusDigit) {
            return map.containsKey(needToAdd);
        } else {
            return map.get(needToAdd) > 1;
        }
    }
    public List<List<Integer>> threeSum13(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        //Step1: sort the array
        Arrays.sort(nums);

        //Step2: loop over all elemnts
        //nums.length -2 as we require 2 numbers
        for(int i = 0; i < nums.length - 2; i++){
            //Step3: put condition to check next next elements are not same
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])){
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];

                //step4: two pointer loop to get the next 2 nos
                while(low < high){
                    //step5: check for confition on which side to move the high and low pointer
                    if(nums[low] + nums[high] == sum){
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        //check that next elements are not same
                        while(low < high && nums[low] == nums[low + 1])low++;
                        while(low < high && nums[high] == nums[high - 1])high--;
                        low++;
                        high--;
                    }
                    else if(nums[low] + nums[high] > sum)
                        high--;
                    else
                        low++;
                }
            }
        }
        return res;
    }
    public List<List<Integer>> threeSum14(int[] nums) {
        //List<List<Integer>> sol = new ArrayList();
        HashSet<List<Integer>> sol = new HashSet();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            int target = nums[i];

            HashSet<Integer> set = new HashSet();
            for(int j = i + 1; j < nums.length; j++){
                int temp = 0-target-nums[j];
                if(set.contains(temp)){
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(target);
                    l.add(temp);
                    l.add(nums[j]);
                    sol.add(l);
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(sol);
    }
    public List<List<Integer>> threeSum15(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return result;
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for(int i = 0;i<nums.length;i++)
        {
            map.put(nums[i],i);
        }
        Set<String> used = new HashSet<>();

        for(int i=0;i<nums.length;i++)
        {
            for(int j = i + 1;j<nums.length;j++)
            {
                int currSum = nums[i]+nums[j];
                if(map.containsKey(-1 * currSum))
                {
                    int k =  map.get(-1 * currSum);
                    if(!used.contains(nums[i] + ":" + nums[j] + ":" + nums[k]) && k>i && k>j)
                    {
                        //-1 0 1 1
                        result.add(Arrays.asList(nums[i],nums[j], nums[k]));
                        used.add(nums[i] + ":" + nums[j] + ":" + nums[k]);// -1:-1:2
                    }
                }
            }
        }
        return result;
    }
    public List<List<Integer>> threeSum16(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int[] positivesPresence = new int[100001];
        int[] negativesPresence = new int[100001];

        List<Integer> zeroes = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num >= 0) {
                positivesPresence[num] = positivesPresence[num] + 1;
            } else {
                negativesPresence[-num] = negativesPresence[-num] + 1;
            }
        }


        for (int i = 0; i < nums.length; i++) {
            int firstNum = nums[i];

            for (int j = i +1; j < nums.length; j++) {
                int secondNum = nums[j];
                int sumOfTwo = firstNum + secondNum;
                int expectedOccurence = 1;
                int expectedNum = -sumOfTwo;

                if (expectedNum == firstNum) {
                    expectedOccurence++;
                }

                if (expectedNum == secondNum) {
                    expectedOccurence++;
                }

                if (Math.abs(sumOfTwo) > 100000) {
                    continue;
                }

                if (firstNum + secondNum > 0 && negativesPresence[sumOfTwo] >= expectedOccurence) {
                    result.add(toOrderedList(firstNum, secondNum, -sumOfTwo));
                } else if (firstNum + secondNum < 0 && positivesPresence[-sumOfTwo] >= expectedOccurence) {
                    result.add(toOrderedList(firstNum, secondNum, -sumOfTwo));
                } else if (firstNum + secondNum == 0 && positivesPresence[0] >= expectedOccurence) {
                    result.add(toOrderedList(firstNum, secondNum, 0));
                }
            }
        }

        return new ArrayList<>(result);
    }

    private List<Integer> toOrderedList(int a, int b, int c) {
        List<Integer> result = new ArrayList<>(List.of(a, b, c));
        Collections.sort(result);
        return result;
    }
    public List<List<Integer>> threeSum17(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> toreturn = new LinkedList<List<Integer>>();
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        HashSet<List<Integer>> check = new HashSet<List<Integer>>();
        for (int i = 0; i < nums.length; i++)   hm.put(nums[i], i);
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(hm.get(-nums[i]-nums[j]) != null && check.add(Arrays.asList(nums[i], nums[j])) && hm.get(-nums[i]-nums[j]) > j){
                    toreturn.add(List.of(nums[i],nums[j],-nums[i]-nums[j]));
                    check.add(List.of(nums[i],nums[j]));
                }
            }
        }
        return toreturn;
    }
    public List<List<Integer>> threeSum18(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> toreturn = new LinkedList<List<Integer>>();
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        HashSet<List<Integer>> check = new HashSet<List<Integer>>();
        for (int i = 0; i < nums.length; i++)   hm.put(nums[i], i);
        for (int i = 0; i < nums.length - 1; i++)
            for (int j = i + 1; j < nums.length; j++)
                if(hm.get(-nums[i]-nums[j]) != null && check.add(Arrays.asList(nums[i], nums[j])) && hm.get(-nums[i]-nums[j]) > j)
                    toreturn.add(Arrays.asList(nums[i], nums[j], -nums[i]-nums[j]));
        return toreturn;
    }
    public List<List<Integer>> threeSum19(int[] nums) {
        //O(n^2)
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList();
        int n = nums.length;

        for(int i = 0; i < n - 2; i++){
            if(i > 0 && nums[i-1] == nums[i]){
                continue;
            }
            int left = i+1;
            int right = n-1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum < 0){
                    left++; //because in the left of sorting array are bgger numbers
                }
                else if(sum > 0){
                    right--;
                }
                else if(sum == 0){
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));

                    while(left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return list;
    }
    public List<List<Integer>> threeSum20(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashMap<Integer, HashSet<Integer>> visited = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int left = 0;
            int right = nums.length-1;
            int target = -nums[i];
            List<Integer> temp = new ArrayList<>();
            while(left<right){
                if(left == i){
                    left++;
                    continue;
                }

                if(right == i){
                    right--;
                    continue;
                }

                if(nums[left]+nums[right]>target){
                    right--;
                }else if(nums[left]+nums[right] == target){
                    if(visited.containsKey(nums[i]) && (visited.get(nums[i]).contains(nums[left]) || visited.get(nums[i]).contains(nums[right]))){

                    }else{
                        temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        result.add(temp);
                        HashSet h1 = visited.get(nums[i]) != null ? visited.get(nums[i]):new HashSet<>();
                        h1.add(nums[left]);
                        h1.add(nums[right]);
                        visited.put(nums[i], h1);
                        h1 = visited.get(nums[left]) != null ? visited.get(nums[left]):new HashSet<>();
                        h1.add(nums[i]);
                        h1.add(nums[right]);
                        visited.put(nums[left], h1);
                        h1 = visited.get(nums[right]) != null ? visited.get(nums[right]):new HashSet<>();
                        h1.add(nums[left]);
                        h1.add(nums[i]);
                        visited.put(nums[right], h1);
                    }
                    while(left<nums.length-1&&nums[left+1] == nums[left]&&left<right){
                        left++;
                    }
                    while(right>0&&nums[right-1] == nums[right]&&left<right){
                        right--;
                    }
                    left++;
                    right--;
                }else{
                    left++;
                }
            }
        }
        return result;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            int low = i +1;
            int high = nums.length-1;
            if( i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            while(low < high){
                if(nums[low]+nums[high] == -nums[i]){
                    list.add(Arrays.asList(nums[low], nums[high], nums[i]));

                    while(low < high && nums[low] == nums[low+1]){
                        low++;
                    }
                    while(low < high && nums[high] == nums[high-1]){
                        high--;
                    }
                    low++;
                    high--;


                }
                else if(nums[low] + nums[high] > -nums[i]){
                    high--;
                }
                else{
                    low++;
                }
            }
        }
        return list;
    }
    public List<List<Integer>> threeSum21(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3) return result;
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length - 2) {
            if(nums[i] > 0) break;
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                if(sum <= 0) while(nums[j] == nums[++j] && j < k);
                if(sum >= 0) while(nums[k--] == nums[k] && j < k);
            }
            while(nums[i] == nums[++i] && i < nums.length - 2);
        }
        return result;
    }
    public List<List<Integer>> threeSum22(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        for(int i = 0; i < nums.length - 2; i++) {
            if(i != 0 && nums[i - 1] == nums[i]) continue;

            int firstNum = nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            int target = -firstNum;
            while(j < k) {
                if(nums[j] + nums[k] > target)
                    k--;
                else if(nums[j] + nums[k] < target)
                    j++;
                else {
                    List<Integer> res = new ArrayList();
                    res.add(firstNum);
                    res.add(nums[j]);
                    res.add(nums[k]);
                    result.add(res);
                    j++;
                    while(j < nums.length && nums[j] == nums[j-1]) j++;
                }
            }
        }
        return result;
    }
}
