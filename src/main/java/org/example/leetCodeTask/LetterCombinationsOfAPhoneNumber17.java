package org.example.leetCodeTask;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber17 {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations1(digits));

    }
    public static List<String> letterCombinations1(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) return list;
        list.add("");
        String[] create = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); i++){
            List<String> newList = new ArrayList<>();
            char[] charArray= create [digits.charAt(i) - '0'].toCharArray();
            for (String each : list){
                for (char newEach : charArray){
                    newList.add( new String(each + newEach));
                }
            }
            list = newList;
        }
        return list;
    }
    public List<String> letterCombinations2(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        HashMap<Character,String> hm = new HashMap<>();
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");
        backtrack(digits,0,hm,new StringBuilder(),res);
        return res;
    }
    public void  backtrack(String digits,int i,HashMap<Character,String> hm,StringBuilder sb, List<String> res ){
        if(i==digits.length()){
            res.add(sb.toString());
            return;
        }
        String curr = hm.get(digits.charAt(i));
        for(int k=0;k<curr.length();k++){
            sb.append(curr.charAt(k));
            backtrack(digits,i+1,hm,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    List<String> result;
    StringBuilder sb;
    Map<Character, String> map;
    public List<String> letterCombinations3(String digits) {
        if(digits.length() == 0) {
            return new ArrayList<>();
        }
        map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        result = new ArrayList<>();
        sb = new StringBuilder();
        backtrack(digits, 0);
        return result;
    }

    private void backtrack(String input, int index) {
        if (index == input.length()) {
            result.add(sb.toString());
            return;
        }
        String current = map.get(input.charAt(index));
        for (char cc : current.toCharArray()) {
            sb.append(cc);
            backtrack(input, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations4(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) {
            return result;
        }

        HashMap<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"edf");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        StringBuilder sb = new StringBuilder();
        backtrack(map, 0, digits, result, sb);
        return result;

    }

    private void backtrack(HashMap<Character, String> map, int index, String digits, List<String> result, StringBuilder sb) {
        if (index == digits.length()){
            result.add(sb.toString());
            return;
        }

        String mapping = map.get(digits.charAt(index));
        for (char c : mapping.toCharArray()) {
            sb.append(c);
            backtrack(map, index+1, digits, result, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    Map<String, List<String>> mapping = new HashMap();
    private void buildMapping() {
        if(mapping.isEmpty()) {
            mapping.put("2", Arrays.asList(new String[]{"a","b","c"}));
            mapping.put("3", Arrays.asList(new String[]{"d","e","f"}));
            mapping.put("4", Arrays.asList(new String[]{"g","h","i"}));
            mapping.put("5", Arrays.asList(new String[]{"j","k","l"}));
            mapping.put("6", Arrays.asList(new String[]{"m","n","o"}));
            mapping.put("7", Arrays.asList(new String[]{"p","q","r", "s"}));
            mapping.put("8", Arrays.asList(new String[]{"t","u","v"}));
            mapping.put("9", Arrays.asList(new String[]{"w","x","y","z"}));
        }
    }
    public List<String> letterCombinations5(String digits) {
        buildMapping();
        List<String> ans = new ArrayList();
        if(digits.length() != 0) create(ans, new ArrayList(), digits, 0);
        return ans;

    }

    void create(List<String> ans, List<String> current, String digits, int index) {
        if(index == digits.length()) {
            String s = "";
            for(String val : current)
                s+=val;
            ans.add(s);
            return;
        }
        String number = digits.substring(index,index+1);
        List<String> chars = mapping.get(number);
        for(int i=0;i<chars.size();i++) {
            current.add(chars.get(i));
            create(ans, current, digits, index+1);
            current.remove(current.size()-1);
        }
    }
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations6(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length()==0){
            return result;
        }
        int j = Integer.valueOf(String.valueOf(digits.charAt(0)));
        int k = KEYS[j].length();
        int[] arr = new int[k];
        for(int l=0;l<k;l++) {
            arr[l]=0;
        }
        dfs(digits, arr, "", result);
        return result;
    }

    public void dfs(String numStr,int[] arr,String prev,List<String> result){
        if(numStr.length() ==1) {
            for(int i=0;i<arr.length;i++) {
                if(arr[i]==0){
                    arr[i]=1;
                    int j = Integer.valueOf(numStr);
                    result.add(prev+String.valueOf(KEYS[j].charAt(i)));
                }
            }
        }else {
            for(int i=0;i<arr.length;i++) {
                if(arr[i]==0){
                    arr[i]=1;
                    int j = Integer.valueOf(String.valueOf(numStr.charAt(0)));
                    int k = Integer.valueOf(String.valueOf(numStr.charAt(1)));
                    System.out.println(k);
                    int[] arr2 = new int[KEYS[k].length()];
                    for(int l=0;l<KEYS[k].length();l++) {
                        arr2[l]=0;
                    }
                    dfs(numStr.substring(1),arr2,prev+String.valueOf(KEYS[j].charAt(i)),result);
                }
            }
        }


        //return result;
    }

    //newwwwsss
    String[] keyMapping = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public void comboRecursive(String digits, String asf, List<String> ans){

        if(digits.length()==0){
            ans.add(asf);
            return;
        }

        char firstDigit = digits.charAt(0);
        String digitLeft = digits.substring(1);

        String key = keyMapping[Integer.parseInt(""+firstDigit)];
        for(char ch : key.toCharArray()){
            comboRecursive(digitLeft,""+asf+ch,ans);
        }

    }

    public List<String> letterCombinations7(String digits) {

        List<String> ans = new ArrayList<>();
        if(digits.equals("")) return ans;

        comboRecursive(digits,"",ans);
        return ans;

    }
    //newssss
    Map<Integer, String> map2 = Map.ofEntries(
            Map.entry(2, "abc"),
            Map.entry(3, "def"),
            Map.entry(4, "ghi"),
            Map.entry(5, "jkl"),
            Map.entry(6, "mno"),
            Map.entry(7, "pqrs"),
            Map.entry(8, "tuv"),
            Map.entry(9, "wxyz")
    );

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations8(String digits) {
        if(digits.length() == 0) {
            return List.of();
        }
        return letterCombinations(digits, 0);
    }

    public List<String> letterCombinations(String digits, int i) {
        int digit = digits.charAt(i) - '0';
        if(i == digits.length()-1) {
            return new ArrayList<>(map.get(digit)
                    .chars()
                    .mapToObj(c -> (char)c)
                    .map(String::valueOf)
                    .toList());
        }
        List<String> l = letterCombinations(digits, i+1);
        List<String> adds = new ArrayList<>();

        for(char ch: map.get(digit).toCharArray()) {
            for(String s: l) {
                adds.add(String.valueOf(ch) + s);
            }
        }
        return adds;
    }
    //newsss
    static Map<Character,String> map3 = new HashMap();

    static {
        map3.put('2',"abc");
        map3.put('3',"def");
        map3.put('4',"ghi");
        map3.put('5',"jkl");
        map3.put('6',"mno");
        map3.put('7',"pqrs");
        map3.put('8',"tuv");
        map3.put('9',"wxyz");
    }

    public List<String> letterCombinations9(String digits) {

        List<String> result = new ArrayList();

        if( digits.length() == 0 )
            return result;

        if( digits.length() == 1 ){
            String temp = map.get( digits.charAt(0) );
            for( char c : temp.toCharArray() ){
                result.add( c + "" );
            }

            return result;
        }

        List<String> list = letterCombinations9( digits.substring(1,digits.length() ) );

        String str = map.get( digits.charAt(0) );
        for( char c : str.toCharArray() ){
            for( String each : list ){
                result.add( c + each );
            }
        }

        return result;
    }
    public List<String> letterCombinations10(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        if (digits.length() == 0) {
            return new ArrayList();
        }
        List<String> res = new ArrayList<>();
        String cur = "";
        helper(digits, map, res, cur, 0);
        return res;

    }

    private void helper(String digits, Map<Character, String> map, List<String> res, String cur, int index) {
        if (cur.length() == digits.length()) {
            res.add(cur);
            return;
        } else if (index >= digits.length()) {
            return;
        } else {
            String s = map.get(digits.charAt(index));
            for (char c : s.toCharArray()) {
                helper(digits, map, res, cur + c, index + 1);
            }
        }

    }
    //newsss

    public List<String> letterCombinations11(String digits) {
        List<String> result = new ArrayList();
        if (digits == null || digits.length() == 0) return result;
        Map<Character, ArrayList<String>> map = new HashMap<>();
        map.put('2', new ArrayList<>(List.of("a","b","c")));
        map.put('3', new ArrayList<>(List.of("d","e","f")));
        map.put('4', new ArrayList<>(List.of("g","h","i")));
        map.put('5', new ArrayList<>(List.of("j","k","l")));
        map.put('6', new ArrayList<>(List.of("m","n","o")));
        map.put('7', new ArrayList<>(List.of("p","q","r","s")));
        map.put('8', new ArrayList<>(List.of("t","u","v")));
        map.put('9', new ArrayList<>(List.of("w","x","y","z")));
        int i = 0;

        while(i < digits.length()){
            char number = digits.charAt(i);
            List<String> lst = map.get(number);
            if(result.isEmpty()){
                result.addAll(lst);
                i++;
                continue;
            }
            List<String> temp = new ArrayList<>();
            for(int j=0; j<result.size(); j++){
                for(int k=0; k<lst.size(); k++){
                    temp.add(result.get(j)+lst.get(k));
                }
            }
            result = new ArrayList<>(temp);
            i++;
        }
        return result;
    }
    public List<String> letterCombinations12(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9',"wxyz");
        List<String> result = new ArrayList<>();
        generateLetters(digits.toCharArray(), 0, "", result, map);
        return result;
    }

    public void generateLetters(char digits[], int index, String res, List<String> result, Map<Character, String> map ){
        if(index>=digits.length){
            if(res.length()!=0){
                result.add(res);
            }
            return;
        }

        String mapping = map.get(digits[index]);
        for(int i = 0; i<mapping.length();i++){
            generateLetters(digits, index+1, res+mapping.charAt(i),result, map);
        }
    }
    List<String> res13 = new LinkedList<>();
    char[][] map13 = new char[][]{
            {},
            {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations13(String digits) {
        if(digits.length() == 0 || digits == null) return res13;

        dfs(digits, new StringBuilder(), 0);

        return res13;
    }

    private void dfs(String nums, StringBuilder comb, int size){
        if(size == nums.length()){
            res13.add(comb.toString());
            return;
        }

        int num = nums.charAt(size) - '0';
        for(int i = 0; i < map13[num].length; i++){
            char letter = map13[num][i];
            comb.append(letter);
            dfs(nums, comb, size + 1);
            comb.deleteCharAt(comb.length() - 1);
        }
    }
    public List<String> letterCombinations14(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return ans;
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        ans.add("");
        for (int i = 0; i < digits.length(); i ++) {
            ArrayList<String> temp = new ArrayList<>();
            String option = map.get(digits.charAt(i));
            for (int j = 0; j < ans.size(); j ++)
                for (int k = 0; k < option.length(); k ++)
                    temp.add(new StringBuilder(ans.get(j)).append(option.charAt(k)).toString());
            ans.clear();
            ans.addAll(temp);
        }
        return ans;
    }
    Map<Character, String> alphaNumeric = new HashMap<>();
    List<String> result15 = new ArrayList<>();
    public List<String> letterCombinations15(String digits) {
        if(digits.length() == 0){
            return result;
        }
        alphaNumeric.put('2',"abc");
        alphaNumeric.put('3',"def");
        alphaNumeric.put('4',"ghi");
        alphaNumeric.put('5',"jkl");
        alphaNumeric.put('6',"mno");
        alphaNumeric.put('7',"pqrs");
        alphaNumeric.put('8',"tuv");
        alphaNumeric.put('9',"wxyz");
        int i = 0;
        StringBuilder currentCombination = new StringBuilder();
        backtracking(digits,0,currentCombination);
        return result15;
    }

    private void backtracking(String digits, int i, StringBuilder currentCombination){
        if(i == digits.length()){
            result15.add(currentCombination.toString());
            return;
        }
        String curr = alphaNumeric.get(digits.charAt(i));
        for(int j = 0; j < curr.length(); j++){
            currentCombination.append(curr.charAt(j));
            backtracking(digits, i+1, currentCombination);
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }

    //newsss

    List<String> l1=new ArrayList<>();;
    void printStrings(String phNo, int i,
                      HashMap<Character, String> hm,
                      StringBuilder str)
    {
        if (i == phNo.length())
        {
            String s2=str.toString();
            l1.add(s2);
            System.out.print(str + " ");
            return;
        }
        String s = hm.get(phNo.charAt(i));
        for (int j = 0; j < s.length(); j++)
        {
            str.append(s.charAt(j));
            printStrings(phNo, i+1, hm, str);
            str.deleteCharAt(str.length()-1);
        }
    }

    public List<String> letterCombinations16(String digits) {

        HashMap<Character, String> hm = new HashMap<Character, String>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");
        hm.put('1', "");
        hm.put('0', "");
        StringBuilder str = new StringBuilder();

        if(digits.equals("")) return l1;
        printStrings(digits, 0, hm, str);
        return l1;
    }
    String[][] numbers = {
            {},
            {},
            {"a","b","c"},
            {"d","e","f"},
            {"g","h","i"},
            {"j","k","l"},
            {"m","n","o"},
            {"p","q","r","s"},
            {"t","u","v"},
            {"w","x","y","z"}
    };

    public List<String> letterCombinations17(String digits) {
        if(digits == null || digits.length() == 0) return new ArrayList();
        List<String> result = new ArrayList();
        backtrack(result, digits, 0, "");
        return result;
    }

    public void backtrack(List<String> result, String digits, int idx, String curr) {
        if (idx >= digits.length()) {
            result.add(curr);
            return;
        }

        for(String ch : numbers[ Character.getNumericValue(digits.charAt(idx))]) {
            backtrack(result, digits, idx + 1, curr + ch);
        }
    }
    public List<String> letterCombinations18(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        HashMap<Character,String> hm = new HashMap<>();
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");
        backtrack(digits,0,hm,new StringBuilder(),res);
        return res;
    }
    public void  backtrack1(String digits,int i,HashMap<Character,String> hm,StringBuilder sb, List<String> res ){
        if(i==digits.length()){
            res.add(sb.toString());
            return;
        }
        String curr = hm.get(digits.charAt(i));
        for(int k=0;k<curr.length();k++){
            sb.append(curr.charAt(k));
            backtrack1(digits,i+1,hm,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    private List<List<Character>> chars;
    public List<String> letterCombinations19(String digits) {
        this.chars = new ArrayList<>();

        if(digits.equals("")) return new ArrayList<>();

        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        char[] arr = digits.toCharArray();

        for(char c: arr){
            this.chars.add(map.get(c));
        }

        String curr = "";

        List<String> ans = new ArrayList<>();

        backtrack(curr, ans, 0, digits.length());

        return ans;
    }

    private void backtrack(String s, List<String> ans, int index, int len){
        if(s.length() == len){
            ans.add(s);
            return;
        }

        List<Character> possibleChars = this.chars.get(index);
        for(int i=0; i<possibleChars.size(); i++){
            backtrack(s+possibleChars.get(i), ans, index+1, len);
        }
    }
    public List<String> letterCombinations21(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if(digits.length() == 0) return ans;
        ans.add("");
        String phone[] = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for(int i = 0; i < digits.length(); i++){
            int ind = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length() == i){
                String soz = ans.remove();
                for(char c : phone[ind].toCharArray()){
                    ans.add(soz + c);
                }
            }
        }

        return ans;
    }

    public List<String> letterCombinations22(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.isEmpty()) return combinations;

        Map<Character, String> mapping = new HashMap<>();
        mapping.put('2', "abc");
        mapping.put('3', "def");
        mapping.put('4', "ghi");
        mapping.put('5', "jkl");
        mapping.put('6', "mno");
        mapping.put('7', "pqrs");
        mapping.put('8', "tuv");
        mapping.put('9', "wxyz");

        letterCombinationsHelper("", digits, mapping, combinations);
        return combinations;
    }

    private void letterCombinationsHelper(String combination, String digits, Map<Character, String> mapping, List<String> combinations) {
        if (digits.isEmpty()) {
            combinations.add(combination);
            return;
        }

        char digit = digits.charAt(0);
        String letters = mapping.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            letterCombinationsHelper(combination + letters.charAt(i), digits.substring(1), mapping, combinations);
        }
    }
    public List<String> letterCombinations23(String digits) {
        List<String> ans = new LinkedList<String>();
        if (digits.isEmpty())
            return ans;
        String[] mapping = new String[] { "0", "1", "abc", "def", "ghi",
                "jkl", "mno", "pqrs", "tuv", "wxyz" };
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            int size = ans.size();
            while (size-- > 0) {
                String t = ans.remove(0);
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }
}
