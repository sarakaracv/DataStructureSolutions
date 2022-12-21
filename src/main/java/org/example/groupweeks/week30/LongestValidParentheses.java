package org.example.groupweeks.week30;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
    LongestValidParentheses as= new LongestValidParentheses();

        String m=")()()()()()()())(";
        System.out.println(as.Parentheses(m));
        System.out.println(as.longestValidParentheses10(m));
        System.out.println(as.longestValidParenthesesOpen(m));
        System.out.println(as.longestValidParentheses0(m));

    }

    public int Parentheses(String str){
        if (str==null|| str.length()==0) return 0;
        int count= 0;
        Stack<Integer> stack= new Stack<>();
        stack.push(-1); // instead of starting with this ')'
        for (int i = 0; i < str.length() ; i++) {
            char chars=str.charAt(i);
            if (chars==')' && stack.peek()==-1){
                stack.pop();
                stack.push(i);
            }else if (chars==')' && str.charAt(stack.peek())=='('){
                stack.pop();
                int remaining= i-stack.peek();
                count=Math.max(count,remaining);

            }else {
                stack.push(i);
            }
        }
        return count;
    }
    public int longestValidParentheses8(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max=0;
        int left = -1;
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='(') stack.push(j);
            else {
                if (stack.isEmpty()) left=j;
                else{
                    stack.pop();
                    if(stack.isEmpty()) max=Math.max(max,j-left);
                    else max=Math.max(max,j-stack.peek());
                }
            }
        }
        return max;
    }
    public int longestValidParentheses0(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);// instead of beginning ')'
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
          max = Math.max(max, i - stack.peek());
                }
            }
        }return max;
    }

    public  int longestValidParentheses1(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int len = s.length(), maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                if (stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    maxLen = Integer.max(i - stack.peek(), maxLen);
                } else
                    stack.push(i);
            }
        }
        return maxLen;
    }

    public  int longestValidParentheses2(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') stack.push(i);
            else if (c == ')') {
                if (stack.size() > 1 && s.charAt(stack.peek()) == '(') stack.pop();
                else stack.push(i);
            }
        }
        int res = 0, last = s.length();
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            res = Math.max(last-curr-1, res);
            last = curr;
        }
        return res;
    }
    public int longestValidParentheses3(String s) {
        Stack<Integer> nm = new Stack<>();
        int m=0;
        int left=-1;
        for(int j=0;j<s.length();j++)
        {
            if(s.charAt(j)=='(')
                nm.push(j);
            else
            {
                if (nm.isEmpty())
                    left=j;
                else
                {
                    nm.pop();
                    if(nm.isEmpty())
                        m=Math.max(m,j-left);
                    else
                        m=Math.max(m,j-nm.peek());
                }
            }
        }
        return m;
    }
    public int longestValidParentheses4(String s)
    {
        Stack<Integer> stk=new Stack<>();
        stk.push(-1);
        int maxi=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
                stk.push(i);
            else
            {
                stk.pop();
                if(stk.isEmpty())
                    stk.push(i);
                maxi=Math.max(maxi,i-stk.peek());
            }
        }
        return maxi;
    }

    public int longestValidParentheses5(String s) {
        boolean[] check = new boolean[s.length()];
        Stack<Node> stack = new Stack<>();

        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if(c == ')') {
                if(!stack.isEmpty()) {
                    Node curr = stack.pop();
                    check[curr.index] = true;
                    check[i] = true;
                }
            } else {
                stack.push(new Node(i, '('));
            }
        }
        int longest = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0; i < check.length; ++i) {
            System.out.print(check[i] + " ");
            if(check[i]) ++count;
            if(!check[i]) {
                longest = Math.max(longest, count);
                count = 0;
            }
        }
        longest = Math.max(longest, count);
        return longest;
    }

    private class Node {
        public int index;
        public char character;

        public Node(int index, char character) {
            this.index = index;
            this.character = character;
        }
    }
    public int longestValidParentheses6(String s) {
        if(s.length()==0) return 0;
        int max = 0, count = 0;
        Deque<Integer> stack = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            Integer p;
            char c = s.charAt(i);
            if(c==')'){
                if((p = stack.pollLast())!=null){
                    // recording confirmed valid length
                    count += p+2;
                    max = Math.max(count, max);
                }else{
                    // invalid, reset valid length
                    count = 0;
                }
            }
            if(c=='('){
                // when push a '(' means it is uncertainly, recording history valid length in the stack and reset the valid length
                stack.offerLast(count);
                count = 0;
            }
        }
        return max;
    }
    public int longestValidParenthesesOpen(String s) {
        int open=0;
        int close=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                open++;
            }else {
                close++;
            }

            if(open==close){
                max=Math.max(max,open+close);
            }else if(close>open){
                open=close=0;
            }
        }
        open=close=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='('){
                open++;
            }else {
                close++;
            }

            if(open==close){
                max=Math.max(max,open+close);
            }else if(open>close){
                open=close=0;
            }
        }
        return max;
    }
    public int longestValidParentheses10(String s) {
        if (s.length() == 1 || s.length() == 0) return 0;

        int count = 0;
        String dot = "";
        for (int i = 0; i < s.length(); i++) {
            s=s.replace("("+dot+")", dot+".");
            dot+=".";
        }
        String[] res= s.replace("("," ").replace(")"," ").split(" ");

        for (int i = 0; i < res.length; i++) {
            int countRes = res[i].length();
            if (count < countRes)
                count = countRes;
        }

        return count * 2;
    }
}
//    public int longestValidParentheses7(String s) {
//
//        if(s.length() == 0) return 0;
//
//        Stack<Integer> st = new Stack<>();
//        st.push(-1); // just in case the string starts with ')', so it will be handled by this
//        // used as a precaution and helps in calculation
//        int ans = 0;
//
//        /*
//                   just take example of ")()())" Stack is represented as []
//
//                   firstly the stack has -1 on top. As a default incorrent place [-1]
//                   Now after looking as ')', we can find that this is a wrong entry as there must be a '(' before it. So, we will update the incorrect place. [0]
//                   Now for '(' we will be incorrect for now, but we can hope that in future we can find the ')'.
//                   So, [0,1]
//                   Now, we will see ')', and we check the character at stack top index, we find it is '('. So pop it out. [0], now find the length which will be 2 - 0 = 2. [0]
//
//                   Repeat the same
//        */
//
//
//        // checking all the incomplete values and putting them into the stack
//        for(int i = 0; i < s.length(); i++){
//            char c = s.charAt(i);
//
//            if(c == ')' && st.peek() == -1){ // in case the 1st character is ')' then simply replace the -1
//                st.pop();
//                st.push(i);
//            }else if(c == ')' && s.charAt(st.peek()) == '('){ // in case the stack top is '(' and we got ')' so, remove the index from the stack and calculate the length
//                st.pop();
//                int len = i - st.peek();
//                ans = Math.max(ans, len);
//            }else{
//                st.push(i);
//            }
//        }
//        return ans;
//    }

