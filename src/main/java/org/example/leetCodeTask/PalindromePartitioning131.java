package org.example.leetCodeTask;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning131 {
    public static void main(String[] args) {

    }
    // Globally initialise a list to store our answers
    private List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        // call the recursive function which takes the string s, index 0 as the start
        // and an empty list to store the partitions
        help(s, 0, new ArrayList<>());
        return ans;     // return our answer list
    }

    private void help(String s, int idx, List<String> currParts) {
        // BASE CASE:
        // If we see that we are trying to put a partition at the end of string
        // we stop and return
        // but before that we add our current partitioned string (stored in currParts) to ans
        if (idx == s.length()) {
            ans.add(new ArrayList<>(currParts));
            return;
        }
        // if we are at an index say i,
        // we will try to put partitions at every index after i
        // and see which one of the substrings from i to the partition is a palindrome
        for (int i = idx; i < s.length(); i++) {
            // we check using this method if the substring is a palindrome
            if (isPalindrome(s, idx, i)) {
                // if it is, we add the subtring to currParts
                currParts.add(s.substring(idx, i + 1));
                // we will call the recursion from the next index of i
                // by fixing the current state of partitions so far,
                // we will see how we can make more partitions in the remaining substring
                // Say we have "a|abb", we will try to make partitions on "abb" by keeping "a|" fixed
                // the function will go to the depth and make partitions and come back
                help(s, i + 1, currParts);
                // as "a|" was fixed, we will remove it from currParts
                // i will move to next index and we will fix "aa|" that time
                // and check possible partitions after "aa|"
                // this is how the whole thing will work everytime,
                // Try -> Add (if potential) -> Discard -> Try new
                currParts.remove(currParts.size() - 1);
            }
        }
    }

    // Simple method to check if a string is palidrome or not
    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }

        return true;
    }

    public List<List<String>> partition2(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        dfs(0, result, new ArrayList<String>(), s);
        return result;
    }

    void dfs(int start, List<List<String>> result, List<String> currentList, String s) {
        if (start >= s.length()) result.add(new ArrayList<String>(currentList));
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome2(s, start, end)) {
                // add current substring in the currentList
                currentList.add(s.substring(start, end + 1));
                dfs(end + 1, result, currentList, s);
                // backtrack and remove the current substring from currentList
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    boolean isPalindrome2(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
    public List<List<String>> partition3(String s) {
        List<List<String>> list = new ArrayList();
        traverse(list, 0, s, new ArrayList<String>());
        return list;
    }

    public void traverse(List<List<String>> list, int index, String s, List<String> current){
        if(s.length() == index){
            list.add(new ArrayList<String>(current));
            return;
        }

        for(int i = index; i < s.length(); i++){
            if(isPalindrome3(s, index, i)){
                current.add(s.substring(index, i+1));
                traverse(list, i+1, s, current);
                current.remove(current.size()-1);
            }
        }
    }

    public boolean isPalindrome3(String s, int low, int high){
        while(low<=high)
            if(s.charAt(low++) != s.charAt(high--))
                return false;
        return true;
    }
}
