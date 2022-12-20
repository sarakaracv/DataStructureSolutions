package org.example.leetCodeTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LongestCommonPrefix14 {
    public static void main(String[] args) {

    }
    public String longestCommonPrefix1(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        for(int i=0; i<strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for(String s:strs)
                if(s.length() == i || s.charAt(i) != c)
                    return strs[0].substring(0,i);
        }
        return strs[0];
    }
    public String longestCommonPrefix2(String[] strs) {

        if(strs==null) return "";

        String prefix = strs[0];
        for(int i=1; i<strs.length;i++){

            while(strs[i].indexOf(prefix)!=0) {
                prefix = prefix.substring(0, prefix.length()-1);
            }
            if(prefix.length()==0){
                return "";
            }

        }
        return prefix;
    }
    public String longestCommonPrefix3(String[] strs) {
        int n = strs.length;
        for (int i = 0; i < strs[0].length(); ++i) {
            for (int j = 1; j < n; ++j) {
                if (strs[j].length() <= i || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
    public String longestCommonPrefix4(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int ii = 0;
        char current = '0';
        int len = strs.length;
        int[] lens = new int[len];
        int maxL = 0;
        int currL = 0;
        for(int i = 0 ; i < len ;i++){
            lens[i] = strs[i].length();
            maxL=Math.max(maxL,lens[i]);
        }
        while(currL<maxL){
            for(int i = 0 ; i < len ;i++){
                if(currL<lens[i]){
                    char c = strs[i].charAt(currL);
                    if(i==0){
                        current=c;System.out.print(currL);
                    }else{
                        if(c!=current){
                            return sb.toString();
                        }
                    }
                }else{
                    return sb.toString();
                }
            }

            sb.append(current);
            current = '0';
            currL++;
            ii++    ;
        }
        return sb.toString();
    }
    public String longestCommonPrefix5(String[] strs) {
        if(strs.length == 1)
            return strs[0];
        StringBuilder smallest_prefix = new StringBuilder();
        int count = 0;
        for(int i = 0; i < strs.length - 1; i++){
            StringBuilder prefix = new StringBuilder();
            String w1 = strs[i];
            String w2 = strs[i + 1];
            int size = Math.min(w2.length(), w1.length());
            int index = 0;
            while(index < size){
                if(w1.charAt(index) == w2.charAt(index))
                    prefix.append(w1.charAt(index));
                else
                    break;
                index++;
            }
            if(prefix.length() < smallest_prefix.length() || count == 0) {
                count++;
                smallest_prefix = prefix;
            }
        }
        return smallest_prefix.toString();
    }
    public String longestCommonPrefix6(String[] strs) {
        //First set first word to be the prefix
        ArrayList<Character> prefix = new ArrayList<>();
        for (char ch : strs[0].toCharArray()) {
            prefix.add(ch);
        }

        for(int i=1;i<strs.length;i++){
            char[] comparedWord = strs[i].toCharArray();
            int j = 0;
            ArrayList<Character> newPrefix = new ArrayList<Character>();
            while(j<prefix.size()&&j<comparedWord.length){
                if(prefix.get(j)==comparedWord[j]){
                    newPrefix.add(prefix.get(j));
                }else {
                    break;
                }
                j++;
            }
            prefix=newPrefix;
        }
        StringBuilder builder = new StringBuilder(prefix.size());
        for(Character ch: prefix){
            builder.append(ch);
        }
        return builder.toString();
    }
    public String longestCommonPrefix7(String[] strs) {
        ArrayList<String> toSortStrings = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            toSortStrings.add(strs[i]);
        }
        Collections.sort(toSortStrings);
        if (toSortStrings.size() == 0) {
            return "";
        }
        String output = "";
        for (int i = 0; i < toSortStrings.get(0).length() && i < toSortStrings.get(toSortStrings.size() - 1).length(); i++) {
            if (toSortStrings.get(0).charAt(i) == toSortStrings.get(toSortStrings.size() - 1).charAt(i)) {
                output = output + toSortStrings.get(0).charAt(i);
            } else {
                break;
            }
        }
        return output;
    }
    public String longestCommonPrefix8(String[] strs) {
        String res = "";

        for(int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return res;
                }
            }
            res += c;
        }
        return res;
    }
    public String longestCommonPrefix9(String[] strs) {
        if (strs == null)
        {
            return null;
        }
        if (strs.length == 0)
        {
            return "";
        }

        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char[] last  = strs[strs.length - 1].toCharArray();

        int i = 0;
        int len = Math.min(first.length, last.length);
        while (i < len && first[i] == last[i])
        {
            i++;
        }
        return strs[0].substring(0, i);
    }
    public String longestCommonPrefix10(String[] strs) {
        Arrays.sort(strs);
        int n=0;
        String res="";
        for(int j=0;j<strs[0].length();j++)
        {
            for(int i=1;i<strs.length;i++)
            {
                if(strs[i].charAt(j)!=strs[0].charAt(j))
                    n=1;

            }

            if(n==1)
            {

                break;
            }

            char t=strs[0].charAt(j);
            String temp=String.valueOf(t);
            res=res.concat(temp);

        }


        return res;


    }
    public String longestCommonPrefix11(String[] strs) {
        if(strs[0].isEmpty()) return "";
        int[] arr= new int[strs[0].length()];
        Arrays.fill(arr,strs.length);
        String first=strs[0];
        for(String str : strs)
        {
            for(int i=0; i<str.length(); i++)
            {

                if(i<first.length() && str.charAt(i) == first.charAt(i))
                {
                    arr[i]=arr[i]-1;
                }
                else
                    break;
            }
        }
        int i=0;
        for(i=0; i<arr.length; i++)
        {
            if(arr[i]==0)
                continue;
            else
                break;
        }
        if(arr[0]!=0) return "";
        return first.substring(0,i);
    }
    public String longestCommonPrefix12(String[] strs) {
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(prefix) != 0)
                prefix = prefix.substring(0,prefix.length() - 1);
        }
        return prefix;
    }
    public String longestCommonPrefix13(String[] strs) {
        if(strs.length == 1) return strs[0];

        String ans = "";
        int n = strs.length;

        for(int i = 0; i < 200; i++) {
            if(i >= strs[0].length()) break;

            char pre = strs[0].charAt(i);
            for(int j = 1; j < n; j++) {
                if(i >= strs[j].length()) return ans;
                if(strs[j].charAt(i) != pre) return ans;
            }

            ans += pre;
        }

        return ans;

    }
    public String longestCommonPrefix14(String[] strs) {
        String output = "";
        // String actual, nextOne;
        output = strs[0];
        for (int i = 0; i < strs.length - 1; i++) {
            output = output.length() < strs[i + 1].length() ? output :
                    output.substring(0, strs[i + 1].length());
            while (output.compareTo(strs[i + 1].substring(0, output.length())) != 0) {
                output = output.substring(0, output.length() - 1);
            }
        }
        return output;
    }
    public String longestCommonPrefix15(String[] strs) {
        String shorted = strs[0];
        for (String str : strs) {
            shorted = shorted.length() < str.length() ? shorted : str;
        }
        System.out.println(shorted);
        while (shorted.length() != 0){
            boolean check = true;
            for (int i = 0; i < strs.length; i++) {
                if (!strs[i].startsWith(shorted)) check = false;
            }
            if (check) return shorted; else shorted = shorted.substring(0, shorted.length() - 1);
        }
        return "";
    }
    public String longestCommonPrefix16(String[] strs) {
        int prefixLength = strs[0].length();
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){
            int j = 0;
            for (; j < Math.min(prefixLength, strs[i].length()); j++){
                if (prefix.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }

            if (j == 0){
                return "";
            }

            prefixLength = j;
        }

        return prefix.substring(0, prefixLength);

    }
    public String longestCommonPrefix17(String[] strs) {

        int size = strs.length;

        /* if size is 0, return empty string */
        if (size == 0)
            return "";

        if (size == 1)
            return strs[0];

        /* sort the array of strings */
        Arrays.sort(strs);

        /* find the minimum length from first and last string */
        int end = Math.min(strs[0].length(), strs[size-1].length());

		/* find the common prefix between the first and
		last string */
        int i = 0;
        while (i < end && strs[0].charAt(i) == strs[size-1].charAt(i) )
            i++;

        String pre = strs[0].substring(0, i);
        return pre;


    }
    public String longestCommonPrefix18(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        String prefix = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(prefix) != 0)
                prefix = prefix.substring(0,prefix.length()-1);
            i++;
        }
        return prefix;
    }
    public String longestCommonPrefix19(String[] strs) {
        if (strs.length == 1) return strs[0];
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int c = 0;
        while(c < first.length() && first.charAt(c) == last.charAt(c)) c++;
        return c == 0 ? "" : first.substring(0, c);
    }
    public String longestCommonPrefix20(String[] strs) {
        if (strs.length == 0)
            return "";
        for (int i=0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (String str : strs) {
                if (str.length() == i || str.charAt(i) != c) {
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
    public String longestCommonPrefix22(String[] strs) {
        int i = 0;
        int min = getMinStrsLen(strs);

        while (i < min && isAllCharsEquals(strs, i)) {
            i++;
        }
        return strs[0].substring(0, i);
    }

    boolean isAllCharsEquals(String[] strs, int i) {
        char c = strs[0].charAt(i);
        for(String str : strs) {
            if (str.charAt(i) != c) {
                return false;
            }
        }
        return true;
    }

    int getMinStrsLen(String[] strs) {
        int min = Integer.MAX_VALUE;
        for(String str : strs) {
            min = Math.min(min, str.length());
        }
        return min;
    }
    public String longestCommonPrefix23(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while(strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length()-1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
