package org.example.leetCodeTask;

import java.util.LinkedList;

public class FindTheIndexOfTheFirstOccurrenceInAString28 {
    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";
        System.out.println(strStr2(haystack, needle));
    }

    public int strStr1(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            for (int j = 0; j < haystack.length(); j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
        return -1;
    }

    public static int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int strStr3(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() > haystack.length()) break;
            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(i + j))
                    break;
                if (j == needle.length() - 1)
                    return i;
            }
        }
        return -1;
    }

    public int strStr4(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        } else if (haystack.length() == 1 && needle.length() == 1) {
            return haystack.charAt(0) == needle.charAt(0) ? 0 : -1;
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                } else if (j == needle.length() - 1) {
                    return i;
                }
            }
        }

        return -1;
    }

    public int strStr5(String haystack, String needle) {
        int j = 0;
        int res = -1;
        LinkedList<Integer> startIndicesQueue = new LinkedList<>();
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0) && j > 0) {
                startIndicesQueue.add(i);
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            } else if (haystack.charAt(i) != needle.charAt(j)) {
                j = 0;
                if (!startIndicesQueue.isEmpty()) {
                    i = startIndicesQueue.removeFirst() - 1;
                }
            }
            if (j >= needle.length()) {
                res = i - (needle.length() - 1);
                break;
            }
        }
        return res;
    }

    public int strStr6(String haystack, String needle) {
        haystack = haystack.replaceAll(needle, "-");

        for (int i = 0; i < haystack.length(); i++) {

            if (haystack.charAt(i) == '-')

                return i;

        }

        return -1;
    }

    public int strStr7(String s1, String s2) {
        int ans = 0;
        if (s1.length() == 1 && s2.length() == 1 && s1.charAt(0) == s2.charAt(0))
            return 0;

        if (s2.length() == 1) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(0))
                    return i;
            }
        }
        for (int i = 0; i < s1.length() - 1; i++) {
            if (s1.charAt(i) == s2.charAt(0)) {
                System.out.println("4");
                ans = i;
                int temp = i + 1;
                for (int j = 1; j < s2.length(); j++) {
                    if (temp >= s1.length()) {
                        ans = -1;
                        break;
                    }
                    if (!(s1.charAt(temp) == s2.charAt(j))) {
                        ans = -1;
                        break;
                    }
                    if (j == s2.length() - 1) {
                        return ans;
                    }
                    temp++;
                }
            }
        }
        return -1;
    }

    public int strStr8(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            int startIndex = i;
            int matchCount = 0;

            for (int j = 0; j < needle.length(); j++) {
                if (startIndex < haystack.length() && needle.charAt(j) == haystack.charAt(startIndex)) {
                    matchCount += 1;
                    startIndex += 1;
                }
            }

            if (matchCount == needle.length()) {
                return i;
            }
        }

        return -1;
    }

    public int strStr9(String haystack, String needle) {
        int index = -1;
        for (int j = 0, i = 0; j < haystack.length(); j++) {
            if (needle.charAt(i) == haystack.charAt(j) && i < needle.length()) {
                if (i == needle.length() - 1) {
                    index = j - (needle.length() - 1);
                    break;
                }
                i++;
            } else {
                j = j - i;
                i = 0;
            }
        }
        return index;
    }

    public int strStr10(String haystack, String needle) {


        int i, j;
        int k;
        int r;


        for (i = 0; i < haystack.length(); i++) {
            k = 1;
            r = i;

            for (j = 0; j < needle.length(); j++) {


                if (r == haystack.length()) return -1;
                if (haystack.charAt(r) != needle.charAt(j)) k = 0;

                r++;

            }


            if (k == 1) return i;

        }

        return -1;

    }

    public int strStr11(String haystack, String needle) {
        int n1 = haystack.length();
        int n2 = needle.length();
        if (n2 > n1) return -1;
        for (int i = 0; i <= n1 - n2; i++) {
            boolean match = true;
            for (int j = 0; j < n2 && match; j++)
                if (needle.charAt(j) != haystack.charAt(i + j))
                    match = false;
            if (match) return i;
        }
        return -1;
    }

    public int strStr12(String haystack, String needle) {
        if (!haystack.contains(needle)) {
            return -1;
        }
        return haystack.indexOf(needle);
    }

    public int strStr13(String haystack, String needle) {
        if (haystack == null || needle == null)
            return 0;

        if (needle.length() == 0)
            return 0;

        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() > haystack.length())
                return -1;

            int m = i;
            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) == haystack.charAt(m)) {
                    if (j == needle.length() - 1)
                        return i;
                    m++;
                } else {
                    break;
                }
            }
        }

        return -1;
    }

    public int strStr14(String haystack, String needle) {
        int ind = haystack.indexOf(needle);
        return ind;
    }

    public int strStr15(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
    public int strStr16(String haystack, String needle) {

        for (int i=0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j=0; j < needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    //i = i+j;
                    break;
                }
                if (j==needle.length()-1) {
                    return i;
                }
            }
        }

        return -1;
    }
    public int strStr17(String haystack, String needle) {
        for(int i=0;i<haystack.length();i++){
            if( i+needle.length()<=haystack.length() && haystack.substring(i,i+needle.length()).equals(needle) ){
                return i;
            }
        }
        return -1;
    }
    public int strStr18(String haystack, String needle) {
        final int m = haystack.length();
        final int n = needle.length();

        for (int i = 0; i < m - n + 1; ++i)
            if (haystack.substring(i, i + n).equals(needle))
                return i;

        return -1;

    }
    public int strStr19(String haystack, String needle) {
        for(int i=0;i<haystack.length();i++){
            if( i+needle.length()<=haystack.length() && haystack.substring(i,i+needle.length()).equals(needle) ){
                return i;
            }
        }
        return -1;
    }
    public int strStr20(String haystack, String needle) {
        return strStrHelper(haystack, needle, 0);
    }

    private int strStrHelper(String haystack, String needle, int i) {
        if (haystack.length() == 0) {
            return -1;
        }
        if (haystack.startsWith(needle)) {
            return i;
        }
        return strStrHelper(haystack.substring(1), needle, i+1);
    }
    public int strStr21(String haystack, String needle) {

        for (int i = 0; i < haystack.length(); i++) {
            if ((i + needle.length() <= haystack.length() ) && haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
    public int strStr22(String haystack, String needle) {

        if(haystack.length() < needle.length()) {
            System.out.println("length condition");

            return -1;
        }

        int hLength=haystack.length();
        int nLength=needle.length();
        for(int i = 0 ; i <= (hLength-nLength); i++ ){
            String newHaystack = haystack.substring(i, i+(nLength));
            System.out.println(newHaystack);
            if(needle.equals(newHaystack) ) {
                System.out.println("Inside if");
                return i;
            }
        }

        return -1;

    }

}
