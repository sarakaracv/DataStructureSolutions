package org.example.leetCodeTask;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MostCommonWord819 {
    public static void main(String[] args) {
       String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
       String banned[] = {"hit"};
        System.out.println(mostCommonWord1(paragraph,banned));
    }
    public static String mostCommonWord1(String paragraph, String[] banned) {

        paragraph = paragraph.replaceAll("[\\!\\?',;\\.]", " ").toLowerCase();

        Map<String, Integer> counts = new HashMap<>();
        Set<String> bans = Arrays.stream(banned).collect(Collectors.toSet());

        Arrays.stream(paragraph.split("\\s+"))
                .filter(s -> !bans.contains(s))
                .forEach(s -> counts.put(s, counts.getOrDefault(s, 0) + 1));

        return counts.keySet().stream()
                .reduce((a,b) -> counts.get(a) > counts.get(b) ? a : b)
                .get();
    }

    public String mostCommonWord2(String paragraph, String[] banned) {
        String mostFrequentWord = "";
        int highestFreq = 0;
        Map<String, Integer> wordToFreq = new HashMap<>();
        Set<String> bannedSet = new HashSet<>(banned.length);

        for(String ban : banned)
            bannedSet.add(ban);

        // remove punctuation
        paragraph = paragraph.replaceAll("\\p{Punct}", " ");

        for(String word : paragraph.split(" ")) {
            if(word.isEmpty()) continue;

            word = word.toLowerCase();

            if(!bannedSet.contains(word)) {
                int freq = wordToFreq.getOrDefault(word, 0) + 1;

                wordToFreq.put(word, freq);
                if (freq > highestFreq) {
                    highestFreq = freq;
                    mostFrequentWord = word;
                }
            }
        }

        return mostFrequentWord;
    }
    public String mostCommonWord3(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

        Map<String, Long> wordCounts = Stream.of(paragraph.split("!|\\?|'|\\,|;|\\.|\\s"))
                .filter( word -> !word.isEmpty() )
                .map( word -> word.toLowerCase() )
                .filter( word -> !bannedSet.contains(word) )
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        return wordCounts.keySet().stream()
                .max(Comparator.comparingLong( word -> wordCounts.get(word) )).get();
    }
    public String mostCommonWord4(String paragraph, String[] banned) {
        Set<String> banSet = new HashSet();
        for(String word:banned) banSet.add(word);
        Map<String,Integer> strCount = new HashMap();
        int n = paragraph.length();

        int left=0,right=1;
        if(Character.isLetter(paragraph.charAt(n-1))) paragraph+=".";
        char[] charParagraph = paragraph.toCharArray();
        int max=0;
        String maxWord="";
        while(left<n){
            while(Character.isLetter(charParagraph[right])){
                right++;
            }
            String currWord = paragraph.substring(left,right).toLowerCase();
            if(!banSet.contains(currWord)){
                int newCount = strCount.getOrDefault(currWord,0)+1;
                strCount.put(currWord,newCount);
                if(newCount>max){
                    max=newCount;
                    maxWord=currWord;
                }
            }
            while(right < n && !Character.isLetter(charParagraph[right])) right++;
            left=right;
        }
        return maxWord;
    }
    public String mostCommonWord5(String paragraph, String[] banned) {
        Map<String,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        for(String word:banned){
            set.add(word);
        }
        set.add("");
        for(int i=0;i<paragraph.length();i++){
            char c = paragraph.charAt(i);
            if(Character.isLetter(c)){
                sb.append(Character.toLowerCase(c));
            }else{
                String s = sb.toString();
                sb.setLength(0);
                if(!set.contains(s))
                    map.put(s,map.getOrDefault(s,0)+1);
            }
        }
        int max = 0;
        String maxi =null;
        for(String s : map.keySet()){
            if(map.get(s)>max){
                max = map.get(s);
                maxi =s;
            }
        }
        return maxi;
    }
    public String mostCommonWord6(String paragraph, String[] banned) {
        if(paragraph == null) return "";
        String[] words = paragraph.toLowerCase().split("\\W+");
        Set<String> banSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        String res = "";
        int max = 0;
        for(String w: words) {
            if(banSet.contains(w)){
                continue;
            }
            int freq = map.getOrDefault(w, 0) + 1;
            map.put(w, freq);
            if(freq > max) {
                max = freq;
                res = w;

            }
        }
        return res;
    }
    StringBuilder sb;

    public String mostCommonWord7(String paragraph, String[] banned){
        Trie root = new Trie();
        sb = new StringBuilder();
        int max = 0;
        for(String s : banned){
            Trie node = root;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(node.children[c-'a'] == null){
                    node.children[c-'a'] = new Trie();
                }
                node = node.children[c-'a'];
            }
            node.count = -1;
        }
        boolean lastIsLetter = false;
        Trie node = root;
        for(int i = 0; i < paragraph.length(); i++){
            char c = paragraph.charAt(i);
            int idx = -1;
            if(c >= 'a' && c <= 'z'){
                idx = c-'a';
            }else if(c >= 'A' && c <= 'Z'){
                idx = c-'A';
            }
            if(idx != -1){//这次是字母
                if(!lastIsLetter){
                    node = root;
                }
                lastIsLetter = true;
                if(node.children[idx] == null){
                    node.children[idx] = new Trie();
                }
                node = node.children[idx];
            }else{
                if(lastIsLetter){
                    if(node.count != -1){
                        node.count++;
                        max = Math.max(node.count, max);
                    }
                }
                lastIsLetter = false;
            }
        }
        if(lastIsLetter){
            if(node.count != -1){
                node.count++;
                max = Math.max(node.count, max);
            }
        }      			dfs(root,max);

        return sb.reverse().toString();
    }

    private boolean dfs(Trie node, int max){
        if(node == null){
            return false;
        }
        if(node.count == max){
            return true;
        }
        for(int i = 0; i < 26; i++){
            boolean res = dfs(node.children[i], max);
            if(res){
                sb.append((char)(i+'a'));
                return true;
            }
        }
        return false;
    }

    private class Trie{
        Trie[] children;
        int count;

        public Trie(){
            children = new Trie[26];
            count = 0;//banned:-1
        }
    }
    public String mostCommonWord8(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap();
        String[] tokens = paragraph.split("[\s!?',;.]");

        for (String token : banned) {
            map.put(token, -1);
        }

        for (String token : tokens) {
            token = token.toLowerCase();

            if (token.compareTo("") != 0 && map.getOrDefault(token, 0) != - 1) {
                map.put(token, map.getOrDefault(token, 0) + 1);
            }
        }

        int max = Integer.MIN_VALUE;
        String ans = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String token = entry.getKey();
            int count = entry.getValue();

            if (count != -1 && count > max) {
                max = count;
                ans = token;
            }
        }

        return ans;
    }
    public String mostCommonWord9(String paragraph, String[] banned) {
        HashMap<String, Boolean> banMap = new HashMap<>();
        for(String b: banned){
            banMap.put(b, true);
        }
        banMap.put("", true);
        paragraph = paragraph.replaceAll("[!?',;.]", " ");
        paragraph = paragraph.toLowerCase();
        String[] ps = paragraph.split(" ");
        HashMap<String, Integer> count = new HashMap<>();
        for(String s: ps){
            if(count.containsKey(s)){
                count.put(s, count.get(s)+1);
            }
            else{
                count.put(s,1);
            }
        }
        int max = 0;
        String result = "";
        for(String k: count.keySet()){
            if(!banMap.containsKey(k)){
                if(count.get(k) > max){
                    result = k;
                    max = count.get(k);
                }
            }
        }
        return result;
    }
    public String mostCommonWord10(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for(String word : banned)
            set.add(word);

        Map<String, Integer> map = new HashMap<>();
        for(String word : paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ")){
            if(!set.contains(word))
                map.put(word, map.getOrDefault(word, 0)+1);
        }

        map.remove("");
        String res = "";

        for(String key : map.keySet()){
            if(res.equals("") || map.get(key) > map.get(res)){
                res = key;
            }
        }
        return res;
    }
    public String mostCommonWord11(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for (String s : banned) set.add(s);

        Map<String, Integer> map = new HashMap<>();
        String[] para = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ");

        for (String w : para) {
            if (!set.contains(w)) {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (String key : map.keySet()) {
            if (ans.toString().equals("") || map.get(key) > map.get(ans.toString())) {
                ans.setLength(0);
                ans.append(key);
            }
        }

        return ans.toString();
    }
    public String mostCommonWord12(String paragraph, String[] banned) {

        // 1). replace the punctuations with spaces,
        // and put all letters in lower case
        String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();

        // 2). split the string into words
        String[] words = normalizedStr.split("\\s+");

        Set<String> bannedWords = new HashSet();
        for (String word : banned)
            bannedWords.add(word);

        Map<String, Integer> wordCount = new HashMap();
        // 3). count the appearance of each word, excluding the banned words
        for (String word : words) {
            if (!bannedWords.contains(word))
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // 4). return the word with the highest frequency
        return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
    public String mostCommonWord13(String paragraph, String[] banned) {
        String[] strs = paragraph.split("\\W+");
        HashMap<String, Integer> map = new HashMap();
        for (String str: strs)
            map.put(str.toLowerCase(), map.getOrDefault(str.toLowerCase(), 0) + 1);
        for (String str:banned)
            map.remove(str.toLowerCase());
        int max = 0;
        String res = "";
        for (Map.Entry<String, Integer> entry: map.entrySet())
            if (entry.getValue() > max) {
                max = entry.getValue();
                res = entry.getKey();
            }
        return res;
    }
    public String mostCommonWord14(String paragraph, String[] banned) {

        String[] words = paragraph.split("[ !?',;.]+");
        Map<String, Integer> wordCtMap = new HashMap<String, Integer>();
        for (String word : words) {
            word = word.toLowerCase();
            int value = wordCtMap.getOrDefault(word, 0);
            value++;
            wordCtMap.put(word, value);
        }

        Set<String> bannedWords = new HashSet<String>();
        for (String bannedWord : banned) {
            bannedWords.add(bannedWord.toLowerCase());
        }

        int rank = 0;
        String mostFreqWord = null;
        for (Map.Entry<String,Integer> wordCtEntry: wordCtMap.entrySet()){
            String word = wordCtEntry.getKey();
            int value = wordCtEntry.getValue();
            if (rank < value && !bannedWords.contains(word)) {
                rank = value;
                mostFreqWord = word;
            }
        }
        return mostFreqWord;

    }
    public String mostCommonWord15(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("[ !?',.;)]+");
        HashMap<String,Integer>map = new HashMap<>();
        for(String word: words)map.put(word, map.getOrDefault(word,0)+1);
        for(String word : banned)if(map.containsKey(word))map.remove(word);
        String res = null;
        for(String word: map.keySet()){
            if(res == null || map.get(word) > map.get(res)){
                res = word;
            }
        }
        return res;

    }
    public String mostCommonWord16(String st, String[] banned) {
        st = st.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
        String[] words = st.split("\\s+");
        Set<String> set = new HashSet<>();
        for(String s : banned)
            set.add(s);
        Map<String, Integer> map = new HashMap<>();
        for(String s : words)
            map.put(s, map.getOrDefault(s, 0)+1);
        String res = "";
        for(String s : map.keySet())
            if(!set.contains(s) && map.getOrDefault(res, 0) < map.get(s))
                res = s;
        return res;
    }
    public String mostCommonWord17(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        String res = "";
        int max = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
                if (i != paragraph.length() - 1) {
                    continue;
                }
            }
            if (sb.length() > 0) {
                String cur = sb.toString();
                if (!ban.contains(cur)) {
                    int count = map.getOrDefault(cur, 0) + 1;
                    map.put(cur, count);
                    if (count > max) {
                        max = count;
                        res = cur;
                    }
                }
                sb.setLength(0);
            }
        }

        return res;
    }
    public String mostCommonWord18(String paragraph, String[] bannedWords) {

        // Convert paragraph and banned words to lowercase
        paragraph = paragraph.toLowerCase();
        for (int i = 0; i < bannedWords.length; i++) {
            bannedWords[i] = bannedWords[i].toLowerCase();
        }
        Set<String> banned = new HashSet<>(Arrays.asList(bannedWords));

        // Split paragraph into words
        String[] words = paragraph.split("[^a-z]+");

        // Count the occurrences of each word
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (!banned.contains(word)) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        // Find the most frequent word
        String mostFrequentWord = "";
        int mostFrequentCount = 0;
        for (String word : wordCount.keySet()) {
            int count = wordCount.get(word);
            if (count > mostFrequentCount) {
                mostFrequentWord = word;
                mostFrequentCount = count;
            }
        }

        return mostFrequentWord;
    }
}
