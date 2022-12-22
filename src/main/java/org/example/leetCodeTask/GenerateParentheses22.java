package org.example.leetCodeTask;

import java.util.*;

public class GenerateParentheses22 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis1(n));
    }
    public static List<String> generateParenthesis1(int n) {
        List<String> list= new ArrayList<>();
        if (n == 0) list.add("");
        else {
            for (int i = n - 1; i >= 0; i--) {
                List<String> first = generateParenthesis1(i);
                List<String> second = generateParenthesis1(n - 1 - i);
                for (String firstParent : first) {
                    for (String secondParent : second) {
                        list.add("(" + firstParent + ")" + secondParent);
                    }
                }
            }
        }
        return list;
    }
    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<>();
        int open = n, close = n;
        String output = "";
        helper(ans, n, open, close, output);
        return ans;
    }

    public void helper(List<String> ans, int n, int open, int close, String output) {

        if (open == 0 && close == 0) {
            ans.add(output.toString());
            return;
        }

        // we can open the brackets all the time unless the count of open is 0.
        if (open != 0) {
            helper(ans, n, open - 1, close, output + "(");
        }

        // we can use open bracket only when the count of open is lesser than the count of close bracket.
        if (open < close) {
            helper(ans, n, open, close - 1, output + ")");
        }
    }
    public List<String> generateParenthesis3(int n) {
        List<String> res = new ArrayList<>();
        rec(res, new StringBuilder(""), 0, 0, n);
        return res;
    }
    void rec(List<String> res, StringBuilder tmp, int curropen, int totalopen, int n){
        if(curropen==0){
            if(totalopen==n) res.add(tmp.toString());
            else {
                curropen++;
                totalopen++;
                tmp = new StringBuilder(tmp.toString()+"(");
                rec(res, tmp, curropen, totalopen, n);
            }
        }
        else{ // curropen>0
            if(totalopen == n) {
                tmp = new StringBuilder(tmp.toString()+")");
                curropen--;
                rec(res, tmp, curropen, totalopen, n);
            }
            else{
                tmp = new StringBuilder(tmp.toString()+"(");
                curropen++;
                totalopen++;
                rec(res, tmp, curropen, totalopen, n);
                tmp.delete(tmp.length()-1, tmp.length());
                curropen--;
                totalopen--;
                tmp = new StringBuilder(tmp.toString()+")");
                curropen--;
                rec(res, tmp, curropen, totalopen, n);
            }
        }
    }
    public List<String> generateParenthesis4(int n) {
        List<String> li=new LinkedList<String>();
        if(n<=0)return li;
        dfs(0,n,"",li);
        return li;
    }

    public void dfs(int left,int right,String res,List<String> list){
        if(left==0 && right==0){
            list.add(res);
            return;
        }
        if(left>0) dfs(left-1,right,res+")",list);
        if(right>0)dfs(left+1,right-1,res+"(",list);
    }
    public List<String> generateParenthesis5(int n) {
        int open=n;
        int close=n;
        List<String> s1=new ArrayList<>();
        String s="";
        generate(0,0,s1,"",n);
        return s1;


    }
    public void generate(int open,int close,List<String> s1,String s,int n){
        if(open==n && close==n && s.length()==2*n){
            s1.add(s);
            return;
        }

        if(open<n){
            s+='(';
            generate(open+1,close,s1,s,n);
            s=s.substring(0,s.length()-1);

        }
        if(open>close && open<=n){
            s+=')';
            generate(open,close+1,s1,s,n);
            s=s.substring(0,s.length()-1);
        }
        return;
    }
    public List<String> generateParenthesis6(int n) {
        List<String>li=new ArrayList<>();
        backtrack(li,"",0,0,n);
        return li;
    }
    static void backtrack(List<String> li,String str,int o,int c,int n){
        if(str.length()==2*n){
            li.add(str);
            return;
        }

        if(o<n){
            backtrack(li,str+"(",o+1,c,n);
        }
        if(c<o){
            backtrack(li,str+")",o,c+1,n);
        }
    }
    List<String> ans;
    public List<String> generateParenthesis7(int n) {
        ans = new ArrayList<>();
        generate(n * 2, new String(), 0, 0);
        return ans;
    }

    private void generate(int remaining, String current, int opening, int closing) {
        if(remaining == 0) {
            if(opening == closing) {
                ans.add(current);
            }
            return;
        }
        if(opening == closing) {
            generate(remaining - 1, current + "(", opening + 1, closing);
        }
        else if(opening > closing) {
            generate(remaining - 1, current + "(", opening + 1, closing);
            generate(remaining - 1, current + ")", opening, closing + 1);
        }
        else {
            return;
        }
    }
    private static final String OPEN_PARENTHESIS = "(";
    private static final String CLOSED_PARENTHESIS = ")";

    public List<String> generateParenthesis8(int n) {
        List<String>        res   = new ArrayList<>();
        Map<String,Integer> open  = new HashMap<>();
        Map<String,Integer> close = new HashMap<>();
        Queue<String>       values  = new ArrayDeque<>();
        values.add("(");
        open.put("(",1);
        close.put("(",0);
        while (!values.isEmpty()){
            String v = values.poll();
            Integer i1 = open.get(v);
            Integer i2 = close.get(v);
            if(i1 < n){
                open.put(v + OPEN_PARENTHESIS,i1+1);
                close.put(v + OPEN_PARENTHESIS,i2);
                values.add(v + OPEN_PARENTHESIS);
            }
            if(i2 < i1){
                close.put(v + CLOSED_PARENTHESIS,i2+1);
                open.put(v + CLOSED_PARENTHESIS,i1);
                values.add(v + CLOSED_PARENTHESIS);
            }
            if(i2 == n && i1 == n){
                res.add(v);
            }
        }
        return res;
    }
    public List<String> generateParenthesis9(int n) {
        HashSet<String> h = new HashSet<>();
        List<String> res = new ArrayList<>();
        if(n==0)    return res;
        if(n==1)    {res.add("()"); return res;}
        StringBuilder sb = new StringBuilder();
        List<String> pre = generateParenthesis9(n-1);
        for(String s : pre){
            for(int i=0; i<s.length();i++){
                sb.setLength(0);
                sb.append(s);
                sb.insert(i,"()");
                if(!h.contains(sb.toString())){
                    h.add(sb.toString());
                    res.add(sb.toString());
                }
            }
        }
        return res;
    }
    public List<String> generateParenthesis10(int n) {
        List<String> res = new ArrayList<>();
        dfs(0, 0, n, res, new StringBuilder());
        return res;
    }
    private void dfs(int left, int right, int n, List<String> res, StringBuilder sb) {
        if (left == n && right == n) {
            res.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append('(');
            dfs(left + 1, right, n, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(')');
            dfs(left, right + 1, n, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> generateParenthesis11(int n) {
        List<String> res = new ArrayList<>();
        helper(res, "", n, n);
        return res;
    }
    void helper( List<String> res, String cur, int left, int right){
        if( right == 0 ){
            res.add(cur);
            return;
        }
        if( left > 0 ){
            helper(res, cur+'(', left - 1, right);
        }
        if ( right > 0 && right > left ){
            helper(res, cur+')', left, right - 1 );
        }
    }
    public List<String> generateParenthesis12(int n) {
        List<String> ans = new ArrayList<>();
        dfs(n, 0, 0, "", ans);

        return ans;
    }

    void dfs(int n, int open, int close, String s, List<String> ans) {
        if(open > n || close > n || close > open) return;
        if(2 * n == open + close) {
            ans.add(s);
        }

        dfs(n, open + 1, close, s + "(", ans);
        dfs(n, open, close + 1, s + ")", ans);
    }
    public List<String> generateParenthesis13(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append("(");
            backtrack(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(")");
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
    public List<String> generateParenthesis14(int n) {
        List<String> list = new ArrayList<String>();
        generateOneByOne("", list, n, n);
        return list;
    }
    public void generateOneByOne(String sublist, List<String> list, int left, int right){
        if(left > right){
            return;
        }
        if(left > 0){
            generateOneByOne( sublist + "(" , list, left-1, right);
        }
        if(right > 0){
            generateOneByOne( sublist + ")" , list, left, right-1);
        }
        if(left == 0 && right == 0){
            list.add(sublist);
            return;
        }
    }
    List<String> ret;
    public List<String> generateParenthesis15(int n) {
        ret = new ArrayList<>();
        dfs(n, n, "") ;
        return ret ;
    }

    void dfs (int l, int r, String cur){
        if (l == 0 && r == 0) {
            ret.add(cur) ;
            return  ;
        }
        if (l < 0 || r < 0) return ;

        if (l <= r) {
            dfs (l - 1, r, cur + "(") ;
            dfs(l, r - 1, cur + ")") ;
        }

    }
    public List<String> generateParenthesis16(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, n, "", 0, 0);
        return res;
    }
    public void backtrack(List<String> res, int n, String curr, int open, int close){
        if(curr.length() == 2*n){
            res.add(curr);
            return;
        }
        if(open < n) backtrack(res, n, curr+"(", open+1, close);
        if(close < open) backtrack(res, n, curr+")", open, close+1);
    }
    public List<String> generateParenthesis17(int n) {
        // Resultant list
        List<String> result = new ArrayList<>();
        /// Recursively generate parentheses
        generateParenthesiss(result, "", 0, 0, n);
        return result;
    }

    private void generateParenthesiss(List<String> result, String s, int open, int close, int n) {
        // Base case
        if (open == n && close == n) {
            result.add(s);
            return;
        }
        // If the number of open parentheses is less than the given n
        if (open < n) {
            generateParenthesiss(result, s + "(", open + 1, close, n);
        }
        // If we need more close parentheses to balance
        if (close < open) {
            generateParenthesiss(result, s + ")", open, close + 1, n);
        }
    }
    public List<String> generateParenthesis18(int n) {
        List<String> res = new ArrayList<>();
        rec1(res, new StringBuilder(""), 0, 0, n);
        return res;
    }
    void rec1(List<String> res, StringBuilder tmp, int curropen, int totalopen, int n){
        if(curropen==0){
            if(totalopen==n) res.add(tmp.toString());
            else {
                curropen++;
                totalopen++;
                tmp = new StringBuilder(tmp.toString()+"(");
                rec(res, tmp, curropen, totalopen, n);
            }
        }
        else{ // curropen>0
            if(totalopen == n) {
                tmp = new StringBuilder(tmp.toString()+")");
                curropen--;
                rec(res, tmp, curropen, totalopen, n);
            }
            else{
                tmp = new StringBuilder(tmp.toString()+"(");
                curropen++;
                totalopen++;
                rec(res, tmp, curropen, totalopen, n);
                tmp.delete(tmp.length()-1, tmp.length());
                curropen--;
                totalopen--;
                tmp = new StringBuilder(tmp.toString()+")");
                curropen--;
                rec(res, tmp, curropen, totalopen, n);
            }
        }
    }
}
