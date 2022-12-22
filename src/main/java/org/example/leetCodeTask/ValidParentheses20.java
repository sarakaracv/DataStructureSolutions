package org.example.leetCodeTask;

import java.util.*;

public class ValidParentheses20 {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid1(s));
    }

    public static boolean isValid1(String s) {
        char[] s1 = s.toCharArray();
        Stack st = new Stack();
        for (char ch : s1) {
            if (st.isEmpty()) st.push(ch);
            else {
                char top = (char) st.lastElement();
                if (ch - top == 1 || ch - top == 2) st.pop();
                else st.push(ch);
            }
            if (st.isEmpty()) return true;
        }
        return false;
    }
    public boolean isValid2(String s) {
        /*Stack<Character> stack = new Stack<>();
        int i=0;
        while(i<s.length()){
            char c = s.charAt(i);
            if(c =='('|| c =='['|| c =='{'){
                stack.push(c);
            }
            else{
                if(!stack.isEmpty()) {
                    if(getReverseParenthesis(c)==stack.peek()) stack.pop();
                    else return false;
                }
                else return false;
            }
            i++;
        }
        if(stack.empty()) return true;
        return false;
    }
    */

        char stackArr[] = new char[s.length()];
        int i=0;
        int start=0;
        int size=0;
        while(i<s.length()){
            char c = s.charAt(i);
            if(c =='('|| c =='['|| c =='{'){
                stackArr[start++]=c;
                size++;
            }
            else{
                if(size!=0) {
                    Character rc = getReverseParenthesis(c);
                    Character pc = stackArr[size-1];
                    if(rc==pc) {
                        size--;
                        start--;
                    }
                    else return false;;
                }
                else return false;
            }
            i++;
        }
        if(size==0) return true;
        return false;
    }
    private Character getReverseParenthesis(char c) {
        if(c==')') return '(';
        if(c==']') return '[';
        if(c=='}') return '{';
        return null;
    }
    public boolean isValid3(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if(a == '(' || a == '[' || a == '{') stack.push(a);
            else if(stack.empty()) return false;
            else if(a == ')' && stack.pop() != '(') return false;
            else if(a == ']' && stack.pop() != '[') return false;
            else if(a == '}' && stack.pop() != '{') return false;
        }
        return stack.empty();
    }
    public boolean isValid4(String s) {
        String prefix = "([{";
        String suffix = ")]}";
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if( prefix.indexOf(ch) >=0){
                stack.push(ch);
            }else if(!stack.isEmpty()&& suffix.indexOf(ch) == prefix.indexOf(stack.peek())){
                stack.pop();
            }
            else{
                return false;
            }
        }
        return stack.isEmpty();
    }
    public boolean isValid5(String s) {
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                st.push(')');
            } else if (cur == '{') {
                st.push('}');
            } else if (cur == '[') {
                st.push(']');
            } else if (st.isEmpty() || st.pop() != cur) {
                return false;
            }

        }
        return st.isEmpty();
    }
    public boolean isValid6(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if ((c == ')' && stack.peek() == '(') || (c == ']' && stack.peek() == '[') || (c == '}' && stack.peek() == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
    private Map<Character, Character> match = new HashMap<Character, Character>() {{ put('(', ')'); put('[', ']'); put('{', '}'); }};

    public boolean isValid7(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isOpen(c)) {
                stack.addFirst(c);
            } else if (!stack.isEmpty() && isMatch(stack.peek(), c)) {
                stack.removeFirst();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isOpen(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private boolean isMatch(char left, char right) {
        return match.get(left) == right;
    }
    public boolean isValid8(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (isOpeningValidBracket(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty() && stack.peek() == correspondingOpenBracket(s.charAt(i))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isOpeningValidBracket(char value) {
        return value == '(' || value == '{' || value == '[';
    }

    private char correspondingOpenBracket(char value) {
        switch (value) {
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
            default:
                return ' ';
        }
    }
    public boolean isValid9(String s) {

        int length = s.length();

        if(length == 1 || length % 2 != 0)
            return false;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < length; i++){
            Character bracket = s.charAt(i);

            if(bracket == '(' || bracket == '{' || bracket == '[')
                stack.push(bracket);
            else {

                if(!stack.isEmpty()){
                    Character topBracket = stack.peek();

                    if((topBracket == '(' && bracket == ')') ||
                            (topBracket == '{' && bracket == '}') || (topBracket == '[' && bracket == ']'))
                    {
                        stack.pop();
                    }
                    else
                        return false;
                }
                else
                    return false;
            }

        }

        if(!stack.isEmpty())
            return false;

        return true;
    }
    public boolean isValid10(String s) {
        Stack<String> st = new Stack<String>();
        for(int i=0; i<s.length(); i++){
            String val = s.substring(i,i+1);
            if(val.equals("(") || val.equals("{") || val.equals("[") ){
                st.push(val);
            }else if(st.size()>0 && (val.equals(")") || val.equals("}") || val.equals("]"))){
                String check = st.peek();
                if(check.equals("(") && val.equals(")")){
                    st.pop();
                }
                else if(check.equals("{") && val.equals("}")){
                    st.pop();
                }
                else if(check.equals("[") && val.equals("]")){
                    st.pop();
                }else{
                    st.push(val);
                }
            }
            else{
                return false;
            }
        }
        if(st.size()>0){
            return false;
        }else{
            return true;
        }
    }
    public boolean isValid11(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character x = stack.pop();
                if (!isMatching(x, c)) {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    private boolean isMatching(Character x, Character c) {
        if (x == '(' && c != ')') {
            return false;
        } else if (x == '{' && c != '}'){
            return false;
        } else if ( x == '[' && c != ']') {
            return false;
        }
        return true;
    }
    public boolean isValid12(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ( stack.isEmpty()) {
                stack.push(ch);
            }
            else {
                switch (stack.peek()) {
                    case '[':
                        if (ch == ']') stack.pop();
                        else stack.push(ch);
                        break;
                    case '(':
                        if (ch == ')') stack.pop();
                        else stack.push(ch);
                        break;
                    case '{':
                        if (ch == '}') stack.pop();
                        else stack.push(ch);
                        break;
                    default: return false;
                }
            }
        }
        return stack.size() == 0;
    }
    public boolean isValid13(String s) {
        Stack <Character>st = new Stack<>();
        int n = s.length();
        for(int i=0; i<n; i++){
            //if char at ith pos of string is an open brack, we"ll push it in stack
            if(s.charAt(i) == '(' || s.charAt(i)=='[' || s.charAt(i) == '{'){
                st.push(s.charAt(i));
            }
            else{
                //if stack is empty
                if(st.empty()){
                    return false;
                }


                //if the bracket is opening o
                else if(match(st.peek(),s.charAt(i))){
                    st.pop();
                }
                else
                    return false;
            }
        }
        if(st.empty())
            return true;

        else
            return false;
    }
    //fun to check if opening bracket is same to close brack

    static boolean match(char open, char close){
        if(open =='(' && close ==')')
            return true;

        if(open =='[' && close ==']')
            return true;

        if(open =='{' && close =='}')
            return true;

        return false;
    }
    public boolean isValid14(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<Character>();

        for(int i =0; i < s.length();i++) {
            char curr = s.charAt(i);
            if(curr == '(' || curr == '{' || curr == '[' ) {
                stack.push(s.charAt(i));
            }
            else {
                if(stack.isEmpty() || map.get(curr) != stack.pop() ) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public boolean isValid15(String s) {
        Stack<Character> stk= new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{')
                stk.push(s.charAt(i));
            else if(stk.size()!=0 && s.charAt(i)==')' && stk.peek()=='(')
                stk.pop();
            else if(stk.size()!=0 && s.charAt(i)==']' && stk.peek()=='[')
                stk.pop();
            else if(stk.size()!=0 && s.charAt(i)=='}' && stk.peek()=='{')
                stk.pop();
            else
                return false;

        }
        if(stk.size()==0)
            return true;
        else
            return false;
    }
    public boolean isValid16(String s) {


        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i) =='{' || s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }
            else {

                if(s.charAt(i)==')' || s.charAt(i) == ']' || s.charAt(i)== '}'){
                    if(stack.empty()){
                        return false;
                    }
                    else if(!matching(stack.peek(),s.charAt(i))){
                        return false;
                    }
                    else{
                        stack.pop();
                    }
                }
            }
        }
        return stack.isEmpty();
    }
    boolean matching(char a,char b){
        if(a=='(' && b==')' ||
                a=='[' && b==']' ||
                a=='{' && b=='}'){
            return true;
        }
        return false;
    }
    public boolean isValid17(String s){
        Stack<Character> st=new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(st.isEmpty() && (ch==']' || ch=='}' || ch==')'))
                return false;
            if(ch=='(' || ch=='{' || ch=='[')
                st.push(ch);
            else{
                if(ch==')' && st.pop()!='(')
                    return false;
                if(ch==']' && st.pop()!='[')
                    return false;
                if(ch=='}' && st.pop()!='{')
                    return false;
            }
        }
        return st.isEmpty();
    }
    public boolean isValid18(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
    public boolean isValid19(String s) {
        char[] ca = s.toCharArray();
        Map<Character,Character> op = new HashMap<>();
        op.put(')','(');
        op.put(']','[');
        op.put('}','{');
        Deque<Character> deque = new ArrayDeque<>();
        for(char c : ca){
            if(op.containsKey(c)){
                if(deque.isEmpty() || deque.pop() != op.get(c)) return false;
            } else{
                deque.push(c);
            }
        }
        return deque.isEmpty();
    }
    public boolean isValid20(String s) {
        Stack<Character> stack =new Stack<>();
        for(Character ch:s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='[') stack.push(ch);
            else if((ch==')' && !stack.isEmpty() && stack.peek()=='(')) stack.pop();
            else if((ch=='}' && !stack.isEmpty() && stack.peek()=='{')) stack.pop();
            else if((ch==']' && !stack.isEmpty() && stack.peek()=='[')) stack.pop();
            else return false;
        }
        return stack.isEmpty();
    }
    public boolean isValid21(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for(int i=1; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            if (stack.size() == 0) stack.push(currentChar);
            else if ((currentChar == ')' && stack.peek() == '(') ||
                    (currentChar == '}' && stack.peek() == '{') ||
                    (currentChar == ']' && stack.peek() == '[')) stack.pop();
            else stack.push(currentChar);
        }
        return stack.size() == 0;
    }
    public boolean isValid22(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (stack.empty()) {
                return false;
            } else if (stack.peek() != map.get(s.charAt(i))) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.empty();
    }
    public boolean isValid23(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (stack.empty()) {
                return false;
            } else if (stack.peek() != map.get(s.charAt(i))) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.empty();
    }

}


