package org.example.leetCodeTask;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber179 {
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));
        if (strNums[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strNums) {
            sb.append(str);
        }
        return sb.toString();
    }
    public String largestNumber2(int[] nums) {
        String[] numStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrings[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(numStrings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                for (int i = 0; i < o1.length() + o2.length(); i++) {
                    char c1 = i < o1.length() ? o1.charAt(i) : o2.charAt(i - o1.length());
                    char c2 = i < o2.length() ? o2.charAt(i) : o1.charAt(i - o2.length());
                    int c = c2 - c1;
                    if (c != 0) return c;
                }
                return 0;
            }
        });

        if (numStrings[0].charAt(0) == '0') return "0";

        StringBuilder largestNumber = new StringBuilder();
        for (int i = 0; i < numStrings.length; i++) {
            largestNumber.append(numStrings[i]);
        }

        return largestNumber.toString();
    }
    public String largestNumber3(int[] nums) {
        int n=nums.length;
        String arr[] = new String[n];
        for(int i=0; i<n; ++i) arr[i] = nums[i]+"";
        Arrays.sort(arr, (a, b) -> {
            int na=a.length(), nb=b.length();
            for(int i=0; i<Math.min(na, nb); ++i) {
                if(a.charAt(i) < b.charAt(i)) return 1;
                else if(a.charAt(i) > b.charAt(i)) return -1;
            }
            if(na==nb) return 0;
            String s1=a+b, s2=b+a;
            return s2.compareTo(s1);
        });
        StringBuilder sb = new StringBuilder("");
        for(String s:arr) sb.append(s);
        String s = sb.toString();
        int i=0;
        while(i<s.length() && s.charAt(i)=='0') ++i;
        if(i==s.length()) return "0";
        return s.substring(i);
    }
    static class Node implements Comparable<Node> {
        long val;
        long mask;
        Node(long value) {
            this.val = value;
            calcMask(value);
        }
        private void calcMask(long value) {
            mask = 1L;
            while (value != 0) {
                mask *= 10;
                value /= 10;
            }
        }
        public int compareTo(Node other) {
            if (val == 0) {
                return 1;
            }
            if (other.val == 0) {
                return -1;
            }

            long a = val* other.mask + other.val;
            long b = other.val * mask + val;
            return (int)(b - a);
        }
    }
    public String largestNumber4(int[] nums) {
        int n = nums.length;
        Node[] nodes = new Node[n];
        boolean allZero = true;
        for (int i = 0; i < n; ++i) {
            nodes[i] = new Node(nums[i]);
            if (nums[i] != 0) {
                allZero = false;
            }
        }
        if (allZero) {
            return "0";
        }
        Arrays.sort(nodes);
        StringBuilder sb = new StringBuilder();
        for (Node node: nodes) {
            sb.append(node.val);
        }
        return sb.toString();
    }

}
