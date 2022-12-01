package org.example.leetCodeTask;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome409 {
    public static void main(String[] args) {
        String palindrome= "ajjajajabfjska";
        System.out.println(longestPalindrome2(palindrome));
    }
    public int longestPalindrome1(String s) {
        int[] count = new int[58];
        int ret = 0; boolean odd = false;
        for(int i = 0; i < s.length(); i ++){
            count[s.charAt(i)-'A']++;
        }

        for(int i = 0; i < 58; i++){
            ret += count[i];
            if(count[i]%2 != 0) {
                ret --;
                odd = true;
            }
        }

        return odd ? ret + 1 : ret;
    }
    public static int longestPalindrome2(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) set.remove(c);  // remove every element appears twice
            else set.add(c);
        }
        return set.isEmpty() ? s.length() : s.length() - set.size() + 1;
    }

    public int longestPalindrome3(String s) {
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++)
            if (!set.add(s.charAt(i))) set.remove(s.charAt(i));
        return s.length()-Math.max(set.size()-1, 0);
    }
    public int longestPalindrome4(String s) {
        int[] array = new int[128];
        int sum = s.length();
        for (int i = 0; i < s.length(); i++)
            sum += (array[s.charAt(i)]++)%2==0 ? -1 : 1;
        return Math.min(sum+1, s.length());
    }
    public int longestPalindrome5(String s) {
        if(s.isEmpty()){return 0;}

        int ans = 0;
        boolean odd = false;
        int[] letters = new int[52];

        for(char c: s.toCharArray()){
            if(c >= 97){
                letters[c-72]++;
            }else{
                letters[c-65]++;
            }
        }

        for(int i = 0; i < letters.length;i++){
            if(letters[i] != 0){
                if(letters[i] % 2 == 0){
                    ans += letters[i];
                }else{
                    ans += letters[i] - 1;
                    odd = true;
                }
            }
        }

        ans += odd ? 1 : 0;
        return ans;
    }
    public int longestPalindrome6(String s) {
        if (s == null || s.isEmpty()) return 0;

        final int l = s.length();
        if (l == 1) return 1;

        final int[] counter = new int[52]; // [a-zA-Z]
        for (int i = 0; i < l; i++) {
            final char ch = s.charAt(i);
            if (Character.isUpperCase(ch)) {
                counter[26 + (ch - 'A')]++;
            } else {
                counter[ch - 'a']++;
            }
        }

        int even = 0;
        boolean hasOdd = false;

        for (int i: counter) {
            even += (i & ~1);
            hasOdd = hasOdd || ((i & 1) == 1);
        }

        return even + (hasOdd ? 1 : 0);
    }
    public int longestPalindrome7(String s) {
        if(s==null || s.length()==0) return 0;
        Set<Character> set = new HashSet<>();
        int count = 0;
        char[] chars = s.toCharArray();
        for(char c: chars) {
            if(set.remove(c)) {
                count++;
            } else {
                set.add(c);
            }
        }
        return set.isEmpty() ? count*2 : count*2+1;
    }
    public int longestPalindrome8(String s) {
        int[] counter = new int[128];
        int maxLen = 0;
        for(char c:s.toCharArray()){
            ++counter[c];
        }
        for(int n:counter){
            maxLen += n - (maxLen & n & 1);
        }
        return maxLen;
    }

    public int longestPalindrome9(String s) {
        int[] freq = new int[256];
        int res = 0;

        char[] chars = s.toCharArray();

        for(char c : chars){
            freq[c]++;

            if((freq[c] / 2) == 1 && freq[c] > 0){
                freq[c] = 0;
                res += 1;
            }

        }

        //length of palindrome should be twice
        res *= 2;

        boolean ad = false;

        for (char c : chars){
            if(freq[c] == 1){
                ad = true;
            }
        }

        if(ad == true){
            res += 1;
        }

        return res;
    }
    public int longestPalindrome10(String s) {
        if(s.length()==0) return 0;

        int[] chars=new int[128];
        for(char c:s.toCharArray()) chars[c]++;

        int cnt=0;
        for(int i=0;i<128;i++) cnt+=chars[i]/2;

        cnt=cnt*2;
        return cnt==s.length()?cnt:cnt+1;
    }
    public int longestPalindrome11(String s) {
        Map<Character, Integer> charCount = new HashMap();
        if(s == null || s.length() == 0) return 0;
        boolean isOneFound = false;

        for(char c: s.toCharArray()){
            charCount.put(c, charCount.getOrDefault(c,0) + 1);
        }

        int length = 0;
        for(Map.Entry<Character, Integer> e : charCount.entrySet()){
            int val = e.getValue();
            if(val % 2 == 1 && !isOneFound) {
                isOneFound = true;
                length = length + val;
            } else  {
                length = length +  ((val % 2 == 1) ? (val - 1) : val);
            }
        }
        return length;
    }
    public int longestPalindrome12(String s) {
        if(s.length()==0)
            return 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            char key = s.charAt(i);
            if(map.containsKey(key)) {
                map.put(key, map.get(key)+1);
            }
            else
                map.put(key,1);
        }
        int count=0;
        boolean flag=false;
        for(Integer i : map.values()) {
            if(i%2==0) {
                count+=i;
            }
            else if(!flag) {
                count+=i;
                flag=true;
            }
            else {
                count+=(i-1);
            }
        }
        return count;

    }
    public int longestPalindrome13(String s) {
        int total = 0, index;
        boolean[] set = new boolean[58];
        for(char c: s.toCharArray()) {
            index = c - 'A';
            if(set[index]) {
                total += 2;
            }
            set[index] = !set[index];
        }
        return total + (total == s.length() ? 0 : 1);
    }
    public int longestPalindrome14(String s) {
        int[] char_counts = new int[128];
        for(char c : s.toCharArray()){
            char_counts[c]++;
        }
        int result = 0;
        for(int x : char_counts){
            result += x/2*2;
            if(result%2 == 0 && x%2 == 1){
                result += 1;
            }
        }
        return result;

    }
    public int longestPalindrome15(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap();
        boolean isOddFreqPresent = false;

        for(char ch : s.toCharArray() ){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(char i : map.keySet() ){
            if( map.get(i) % 2 == 1)  isOddFreqPresent = true;

            res += map.get(i)/2;
        }

        return isOddFreqPresent ? 1+ 2*res : 2*res;
    }
    public int longestPalindrome16(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }
        return ans;
    }
    public int longestPalindrome17(String s) {
        int[] temp=new int[58];
        boolean TF=false;
        int length=0;
        for(int i=0;i<s.length();i++) temp[s.charAt(i)-'A']++;
        for(int i:temp){
            length+=i/2*2;
            if(i%2==1) TF=true;
        }
        return TF?length+1:length;
    }
    public int longestPalindrome18(String s) {
        Set<Character> set=new HashSet<>();
        for(char c:s.toCharArray()){
            if(set.contains(c)){
                set.remove(c);
            }
            else{
                set.add(c);
            }
        }
        return set.isEmpty()? s.length():s.length()-set.size()+1;
    }
    public int longestPalindrome19(String s) {
        int count = 0;
        HashSet<Character> data = new HashSet<Character>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (data.contains(c)) {
                count += 2;
                data.remove(c);
            }
            else {
                data.add(c);
            }
        }
        if (data.size() > 0) {
            count ++;
        }
        return count;
    }
    public int longestPalindrome20(String s) {

        if(s.length()==1)
            return 1;

        Set<Character> set = new HashSet<>();
        int count = 0;
        for(char c : s.toCharArray()) {

            if(set.contains(c)) set.remove(c);
            else set.add(c);
        }
        int length = s.length() - set.size() + 1;
        return set.isEmpty() ? s.length() : length;

    }
    public int longestPalindrome21(String s) {
        HashSet<Character> set = new HashSet();
        int count=0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                set.remove(c);
                count+=2;
            }
            else set.add(c);
        }
        if (set.isEmpty()) return count;
        else return count+1;
    }
    public int longestPalindrome22(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int res = 0;
        for(char c:s.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }

        int max_odd=0;
        for(char c:map.keySet()){
            int temp = map.get(c);
            //System.out.println(c+":"+temp);
            if(temp%2==0){
                res += temp;
            }else{
                if(temp>max_odd){
                    if(max_odd!=0) res += (max_odd-1);
                    max_odd = temp;
                }else{
                    res += (temp-1);
                }
            }
        }
        return res+max_odd;

    }
    public int longestPalindrome23(String s) {
        int[] map = new int[126];
        for(char each : s.toCharArray()) {
            map[each]++;
        }
        int total = 0;
        for(int count:map) {
            total+= count / 2 * 2;
        }
        return total < s.length() ? total + 1: total;
    }
}
