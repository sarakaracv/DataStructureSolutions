package org.example.leetCodeTask;

import java.util.*;

public class WordBreakII140 {
    public static void main(String[] args) {

    }
    // first solution not pass from leetcode
    public List<String> wordBreak(String s, List<String> wordDict){
        Map<Integer, List<String>> memo= new HashMap<>();
        Set<String> dict= new HashSet<>(wordDict);
        return wordHelper(s,0,dict,memo);
    }
    private List<String> wordHelper(String s,int start, Set<String > dict,Map<Integer,List<String >> memo ){
        if (memo.containsKey(start)) return memo.get(start);
        List<String > result= new ArrayList<>();
        if (start==s.length()){
            result.add("");
            return result;
        }
        for (int i = start+1; i <s.length() ; i++) {
            String prefix= s.substring(start,i);
            if (dict.contains(prefix)){
                List<String> suffixes= wordHelper(s,i,dict,memo);
                for (String suffix:suffixes){
                    String space= suffix.isEmpty()?"":" ";
                    result.add(prefix+space+suffix);
                }
            }
        }
        memo.put(start,result);
        return result;
    }
    // second solution

        public List<String> wordBreak2(String s, List<String> wordDict) {
            Set<String> dict = new HashSet<>(wordDict);
            return wordBreakHelper2(s, dict);
        }

        private List<String> wordBreakHelper2(String s, Set<String> dict) {
            List<String> res = new ArrayList<>();
            if (s.isEmpty()) {
                res.add("");
                return res;
            }
            for (int i = 1; i <= s.length(); i++) {
                String prefix = s.substring(0, i);
                if (dict.contains(prefix)) {
                    List<String> suffixes = wordBreakHelper2(s.substring(i), dict);
                    for (String suffix : suffixes) {
                        String space = suffix.isEmpty() ? "" : " ";
                        res.add(prefix + space + suffix);
                    }
                }
            }
            return res;
        }
    // third solution


        public List<String> wordBreak3(String s, List<String> wordDict) {
            Set<String> dict = new HashSet<>(wordDict);
            Map<String, List<String>> memo = new HashMap<>();
            return wordBreakHelper3(s, dict, memo);
        }

        private List<String> wordBreakHelper3(String s, Set<String> dict, Map<String, List<String>> memo) {
            if (memo.containsKey(s)) {
                return memo.get(s);
            }
            List<String> res = new ArrayList<>();
            if (s.isEmpty()) {
                res.add("");
                return res;
            }
            for (int i = 1; i <= s.length(); i++) {
                String prefix = s.substring(0, i);
                if (dict.contains(prefix)) {
                    List<String> suffixes = wordBreakHelper3(s.substring(i), dict, memo);
                    for (String suffix : suffixes) {
                        String space = suffix.isEmpty() ? "" : " ";
                        res.add(prefix + space + suffix);
                    }
                }
            }
            memo.put(s, res);
            return res;
        }
// forth solution

        public List<String> wordBreak4(String s, List<String> wordDict) {
            Set<String> dict = new HashSet<>(wordDict);
            Map<String, List<String>> memo = new HashMap<>();
            memo.put("", new ArrayList<>(Arrays.asList("")));
            return wordBreakHelper4(s, dict, memo);
        }

        private List<String> wordBreakHelper4(String s, Set<String> dict, Map<String, List<String>> memo) {
            if (memo.containsKey(s)) {
                return memo.get(s);
            }
            List<String> res = new ArrayList<>();
            for (int i = 1; i <= s.length(); i++) {
                String prefix = s.substring(0, i);
                if (dict.contains(prefix)) {
                    List<String> suffixes = wordBreakHelper4(s.substring(i), dict, memo);
                    for (String suffix : suffixes) {
                        String space = suffix.isEmpty() ? "" : " ";
                        res.add(prefix + space + suffix);
                    }
                }
            }
            memo.put(s, res);
            return res;
        }
// from leetcode

    private HashSet<String> dict;
    public List<String> wordBreak5(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }

        dict = new HashSet<>();
        for (String w: wordDict) {
            dict.add(w);
        }
        boolean[] mem = new boolean[s.length()];
        Arrays.fill(mem, true);
        dfs(res, new StringBuilder(), s, 0, mem);
        return res;
    }

    private void dfs(List<String> res, StringBuilder path, String s, int index, boolean[] mem) {
        if (index == s.length()) {
            path.setLength(path.length() - 1);
            res.add(path.toString());
            return;
        }

        if (!mem[index]) {
            return;
        }

        int cacheSize = res.size();
        int cacheLength = path.length();
        for (int i = index; i < s.length(); i++) {
            String str = s.substring(index, i + 1);
            if (dict.contains(str)) {
                path.append(str);
                path.append(' ');
                dfs(res, path, s, i + 1, mem);
                path.setLength(cacheLength);
            }
        }
        if (cacheSize == res.size()) {
            mem[index] = false;
        }
    }
// second leetcode
public List<String> wordBreak6(String wordToBreak, List<String> wordDict) {
    return findSolutions(wordToBreak, wordDict, new HashMap<>());
}

    public List<String> findSolutions(String wordToBreak, List<String> wordDict, Map<String, List<String>> wordBrokenDict){
        if(wordBrokenDict.containsKey(wordToBreak)){
            return wordBrokenDict.get(wordToBreak);
        }

        List<String> solutions = new ArrayList<>();
        for(String word: wordDict){
            if(!wordToBreak.startsWith(word)){
                continue;
            }

            if(wordToBreak.length() == word.length()){
                solutions.add(word);
                continue;
            }

            List<String> subSolutions = findSolutions(wordToBreak.substring(word.length()), wordDict, wordBrokenDict);
            for(String subSolution: subSolutions) {
                StringBuilder strBuilder = new StringBuilder();
                strBuilder.append(word).append(' ').append(subSolution);
                solutions.add(strBuilder.toString());
            }
        }

        wordBrokenDict.put(wordToBreak, solutions);
        return solutions;
    }
// third leetcode

    public List<String> wordBreak7(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();

        Solve(s, wordDict, new StringBuilder(),ans);
        return ans;
    }
    private void  Solve(String s, List<String> list, StringBuilder res,List<String> ans){
        if(s.equals("")){
            System.out.println("njnvikjnvikn = "+res);
            String r  = res.substring(0, res.length()-1);
            ans.add(new String(r));
            // res= new StringBuilder("");
            // res.delete(res.length()-ss.length(), res.length());
            return ;
        }
        for(int i=1;i<=s.length();i++){
            String ss = s.substring(0,i);
            // System.out.println(ss);
            if(list.contains(ss)){
                String ros = s.substring(i);
                res.append(ss+" ");
                //  System.out.println("ss = "+ ss+ ", ros = "+ ros+", res = "+ res);
                Solve(ros,list,res , ans);
                res.delete(res.length()-ss.length()-1, res.length());
            }
        }

    }
    //forth leetcode

    public List<String> wordBreak8(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        traverse(s, wordDict, res, new StringBuilder());
        return  res;
    }

    private void traverse(String s, List<String> wordDict, List<String> res, StringBuilder sb){
        if(s.isEmpty()){
            res.add(sb.toString());
            return;
        }
        for(String word : wordDict){
            if(s.startsWith(word)){
                StringBuilder tempSb = new StringBuilder(sb);
                if(tempSb.length()!=0)
                    tempSb.append(" ");
                tempSb.append(word);
                traverse(s.substring(word.length()), wordDict,res,tempSb);
            }
        }

    }

}
