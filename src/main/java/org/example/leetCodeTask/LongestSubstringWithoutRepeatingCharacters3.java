package org.example.leetCodeTask;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public static void main(String[] args) {
        String as="abcabcbb";
        System.out.println();
    }
    public int lengthOfLongestSubstring1(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }
    public int lengthOfLongestSubstring2(String s) {
        int size=s.length();
        if (size==0) return 0;

        int MAX=1;

        //i points to the current element under comparisom
        //j saves the length of the current substring from index i-j to i-1
        int i,j;
        for(i=0,j=0; i<size;i++){
            int pre=s.substring(i-j,i).indexOf(s.charAt(i));
            if (pre!=-1) MAX=Math.max(j,MAX); //update MAX
            j=j-pre;  //update the length. if pre==-1, meaning no duplicate found, j++; else j becomes smaller
            //j is the max length of the subtring without repetition of chars WITH the current char i, before the next char indexed i+1 is added
        }
        MAX=Math.max(j,MAX);
        return MAX;
    }
    public int lengthOfLongestSubstring3(String str) {
        LinkedHashSet<Character> mapper = new LinkedHashSet<Character>();
        int maxlen = 0;
        for(int i=0; i<str.length(); i++){
            if(mapper.contains(str.charAt(i))){
                maxlen = Math.max(maxlen, mapper.size());
                while(mapper.contains(str.charAt(i))){
                    for(char k : mapper){
                        mapper.remove(k);
                        break;
                    }
                }
                mapper.add(str.charAt(i));
            }
            else{
                mapper.add(str.charAt(i));
                maxlen = Math.max(maxlen, mapper.size());
            }
        }
        return maxlen;
    }
    public int lengthOfLongestSubstring4(String s) {

        //it is DP problem with O(n)
        int l = s.length();
        int maxl = 0;
        int dupindex =-1;
        int count =0;
        if(l==1) return 1;
        //map char to its index
        Map<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<l;i++){
            //not only check if it  has duplicate
            //but also check if  the duplicate  appear before dupindex (should not be used)
            //(in other words, be updated by new index)
            if(hm.containsKey(s.charAt(i)) && hm.get(s.charAt(i))>dupindex){
                //get length
                count=i-1-dupindex;
                dupindex = hm.get(s.charAt(i));//new substring will start form dupindex+1
                //update its value(index)
                hm.put(s.charAt(i),i);
                if(count>maxl) maxl = count;
            }else{
                hm.put(s.charAt(i),i);
            }

        }
        //reach the end, process last substring
        if(((l-1)-dupindex)>maxl) return ((l-1)-dupindex);
        else return maxl;
    }
    public static int lengthOfLongestSubstring5(String s) {

        if(s.length()<=1) { return s.length();}
        Set<Character> set = new HashSet<>();

        int start = 0;
        int end = 1;
        int max = 1;
        set.add(s.charAt(start));
        while(end < s.length()){
            set.add(s.charAt(end));
            //System.out.println("Set is "+set);
            max = Math.max(set.size(),max);
            end++;
            //System.out.println("Set Size = "+set.size()+"\t"+(end-start));
            while(set.size()<(end-start)){
                if(s.charAt(start)!=s.charAt(end-1)){
                    set.remove(s.charAt(start));
                }
                start++;
                //System.out.println("Moving start : Set Size = "+set.size()+"\t"+(end-start)+"\t"+set);
            }
            // System.out.println("Start is "+start);
            //  System.out.println("End is "+end);
        }

        return max;
    }
    public int lengthOfLongestSubstring6(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        final StringBuilder current = new StringBuilder();
        int max = 0;

        for (int i=0; i<s.length(); i++) {
            int indexOf = current.indexOf(String.valueOf(s.charAt(i)));
            if (indexOf != -1) {
                if (current.length() > max) {
                    max = current.length();
                }
                current.delete(0, indexOf + 1);
            }
            current.append(s.charAt(i));
        }

        if (current.length() > max) {
            max = current.length();
        }
        return max;
    }
    public int lengthOfLongestSubstring7(String s) {
        char[] sc = s.toCharArray();
        int[] map = new int[256];
        Arrays.fill(map,-1);

        int max = 0, start=0;
        for(int i=0;i<=sc.length;i++){
            if(i==sc.length){
                max = Math.max(max, i-start);
                break;
            }
            int index = map[sc[i]];
            if(index>=0){
                max   = Math.max(max, i - start);
                start = Math.max(start,index+1);
            }
            map[sc[i]] = i;
        }
        return max;
    }
    public int lengthOfLongestSubstring8(String s) {
        char[] sc = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int i = 0; i <= sc.length; i++) {
            if (i == sc.length) {
                max = Math.max(max, i - start);
                break;
            }
            int index = map.getOrDefault(sc[i], -1);
            if (index < 0) {
                map.put(sc[i], i);
            } else {
                max = Math.max(max, i - start);
                start = Math.max(start, index + 1);
                map.put(sc[i], i);
            }
        }
        return max;
    }
    public int lengthOfLongestSubstring9(String s) {
        char[] sc = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start=0;
        for(int i=0;i<=sc.length;i++){
            if(i==sc.length){
                max = Math.max(max, i-start);
                break;
            }
            int index = map.getOrDefault(sc[i],-1);
            if(index<0){
                map.put(sc[i],i);
            }else{
                max = Math.max(max, i - start);
                start = Math.max(start,index+1);
                map.put(sc[i],i);
            }
        }
        return max;
    }
    public int lengthOfLongestSubstring10(String s) {
        int ret = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, start = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c))
                start = Math.max(map.get(c)+1, start);
            ret = Math.max(ret, i-start+1);
            map.put(c, i);
        }
        return ret;
    }
    public int lengthOfLongestSubstring11(String s) {
        if(s.length()==0){
            return 0;
        }
        //use to record the position which current char appear last time
        int[] position=new int[128];
        for(int i=0;i<128;i++){
            position[i]=-1;
        }
        char[] chars=s.toCharArray();
        int index=0;
        int max=0;
        for(int i=0;i<chars.length;i++){
            int p=position[chars[i]];
            if(p>=index){
                max=Math.max(max,i-index);
                index=p+1;
            }
            position[chars[i]]=i;
        }
        max=Math.max(max,chars.length-index);
        return max;
    }
    public int lengthOfLongestSubstring12(String s) {
        int max = 0;
        int[] lastIndexMap = new int[128];
        int[] cache = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int repeatedLen = i - lastIndexMap[c];
            int prevLen = cache[i];
            int len = (repeatedLen > prevLen ? prevLen : repeatedLen) + 1;
            if (len > max) max = len;
            cache[i + 1] = len;
            lastIndexMap[c] = i + 1;
        }
        return max;
    }
    public int lengthOfLongestSubstring13(String s) {
        HashSet<Character> hash = new HashSet<Character>();
        int n = s.length();
        int max = 0;
        for(int i = 0; i < n; i++){
            int j = i;
            int an = 0;
            while(j < n&&hash.add(s.charAt(j))){
                j++;
                an++;
            }
            max = Math.max(max, an);
            hash.clear();
        }
        return max;
    }
    public int lengthOfLongestSubstring14(String s) {

        if(s == null || s.length() == 0){return 0;}
        int[] positions = new int[128];
        int j = 0;
        int max = 0;
        int cur = 0;
        for(int i = 0; i < s.length(); i++){
            if(positions[s.charAt(i)] == 0){
                positions[s.charAt(i)] = i + 1; // we add 1 so that it would not conflict with index 0.
                cur++;
                if(cur > max){max = cur;}
            }
            else{
                int index = positions[s.charAt(i)] - 1;
                while(j <= index){
                    positions[s.charAt(j)] = 0;
                    j++;
                }
                cur = i - j + 1;
                positions[s.charAt(i)] = i + 1;
            }
        }
        return max;
    }
    public int lengthOfLongestSubstring15(String s) {
        boolean values[]=new boolean[256];
        int max_count=0,j=0,temp_count=0;
        char[] array=s.toCharArray();
        for(int i=j;i<array.length;i++){
            if(!values[array[i]]){
                temp_count++;
                values[array[i]]=true;
                if(temp_count>=max_count)
                    max_count=temp_count;
            }
            else{
                temp_count=0;
                values=new boolean[256];
                i=j;
                j++;
            }
        }
        return max_count;
    }
    public int lengthOfLongestSubstring18(String s) {
        TreeSet treeset = new TreeSet();
        for(int i = 0; i < s.length(); i++){
            treeset.add(""+s.charAt(i));
        }
        return treeset.size();
    }
}
