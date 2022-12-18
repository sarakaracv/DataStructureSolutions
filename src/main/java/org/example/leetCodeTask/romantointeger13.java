package org.example.leetCodeTask;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class romantointeger13 {
    public static void main(String[] args) {

    }
    public int romanToInt1(String s) {
        if (s.equals(s.toLowerCase())) s=s.toUpperCase();
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (i > 0 && map.get(character) > map.get(s.charAt(i - 1))) {
                char prevChar = s.charAt(i - 1);
                res += map.get(character) - 2 *map.get(prevChar);
            }
            else
                res += map.get(character);
        }
        return res;
    }
    public int romanToInt2(String s) {

        int sum=0;
        int preVal=Integer.MAX_VALUE;

        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            int val = getValue(c);
            sum+=val;

            if (preVal< val) sum-= 2* preVal;
            preVal = val;
        }
        return sum;
    }

    static int getValue(char c){
        if (c=='I'){
            return 1;
        }
        else if(c=='V'){
            return 5;
        }
        else if(c=='X'){
            return 10;
        }
        else if(c=='L'){
            return 50;
        }
        else if(c=='C'){
            return 100;
        }
        else if(c=='D'){
            return 500;
        }
        else{
            return 1000;
        }
    }
    public int romanToInt3(String s) {
        int Integer = 0;
        char tempString;
        for (int i = 0; i < s.length(); i++) {
            tempString = s.charAt(i);
            if (i >= 1 && s.charAt(i-1) == 'I' && (s.charAt(i) == 'V' ||s.charAt(i) == 'X')) {
                Integer = Integer - 2;
            } else if (i >= 1 && s.charAt(i-1) == 'X' && (s.charAt(i) == 'L' || s.charAt(i) == 'C')) {
                Integer = Integer - 20;
            } else if (i >= 1 && s.charAt(i-1) == 'C' && (s.charAt(i) == 'D' || s.charAt(i) == 'M')) {
                Integer = Integer - 200;
            }
            if (s.charAt(i) == 'I') {
                Integer++;
            } else if (s.charAt(i) == 'V') {
                Integer = Integer + 5;
            } else if (s.charAt(i) == 'X') {
                Integer = Integer + 10;
            } else if (s.charAt(i) == 'L') {
                Integer = Integer + 50;
            } else if (s.charAt(i) == 'C') {
                Integer = Integer + 100;
            } else if (s.charAt(i) == 'D') {
                Integer = Integer + 500;
            } else if (s.charAt(i) == 'M') {
                Integer = Integer + 1000;
            }
        }
        return Integer;
    }
    public int romanToInt4(String s) {
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();
        m.put('I',1);
        m.put('V',5);
        m.put('X',10);
        m.put('L',50);
        m.put('C',100);
        m.put('D',500);
        m.put('M',1000);
        char [] c = s.toCharArray();
        int [] n = new int[c.length];
        for(int i=0;i<n.length;i++) n[i]=m.get(c[i]);
        int sum=0;
        for(int i=0;i<n.length;i++) sum= i==c.length-1||n[i]>=n[i+1]?sum+n[i]:sum-n[i];
        return sum;

    }
    public int romanToInt5(String s) {
        Stack<Character> stack = new Stack<Character>();

        int result = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            int val = translate(c);

            result += val;

            if(!stack.isEmpty()) {
                char last = stack.pop();
                int lastVal = translate(last);
                if(lastVal < val) {
                    result -= 2 * lastVal;
                }
            }

            stack.push(c);
        }

        return result;
    }

    private int translate(char c) {
        if(c == 'I') {
            return 1;
        }

        if(c == 'V') {
            return 5;
        }

        if(c == 'X') {
            return 10;
        }

        if(c == 'L') {
            return 50;
        }

        if(c == 'C') {
            return 100;
        }

        if(c == 'D') {
            return 500;
        }

        if(c == 'M') {
            return 1000;
        }

        return 0;
    }
    public int romanToInt6(String s) {
        var romans = new HashMap<String, Integer>();
        romans.put("I", 1);
        romans.put("V", 5);
        romans.put("X", 10);
        romans.put("L", 50);
        romans.put("C", 100);
        romans.put("D", 500);
        romans.put("M", 1000);
        romans.put("IV", 4);
        romans.put("IX", 9);
        romans.put("XL", 40);
        romans.put("XC", 90);
        romans.put("CD", 400);
        romans.put("CM", 900);

        var i = 0;
        var sum = 0;
        while (i < s.length()) {
            if (i < s.length() - 1) {
                var doubleSymbol = s.substring(i, i + 2);
                if (romans.containsKey(doubleSymbol)) {
                    sum += romans.get(doubleSymbol);
                    i += 2;
                    continue;
                }
            }
            // Continue with single symbol (length - 1) case
            var singleSymbol = s.substring(i, i + 1);
            sum += romans.get(singleSymbol);
            i += 1;
        }
        return sum;
    }
    public int romanToInt7(String s) {
        Stack<Roman> romanStack = new Stack();
        for (int i = s.length()-1; i>=0; i--){
            romanStack.push(Roman.of(s.charAt(i)));
        }
        int finalInt = 0;
        while (!romanStack.isEmpty()){
            Roman r = romanStack.pop();
            if (!romanStack.isEmpty()&&r.getValue()<romanStack.peek().getValue())
                finalInt+=(romanStack.pop().getValue()-r.getValue());
            else finalInt+=r.getValue();
        }
        return finalInt;
    }

    private enum Roman {

        I ('I',1),
        V ('V',5),
        X('X',10),
        L('L',50),
        C('C',100),
        D('D',500),
        M('M',1000);

        private final char symbol;
        private final int value;

        Roman(char s, int v){
            symbol = s;
            value = v;
        }

        public static Roman of (char c){
            if (c=='I') return I;
            else if (c=='V') return V;
            else if (c=='X') return X;
            else if (c=='L') return L;
            else if (c=='C') return C;
            else if (c=='D') return D;
            else if (c=='M') return M;
            else throw new IllegalArgumentException(c+" is not a valid roman numeral.");
        }

        public int getValue(){
            return value;
        }
    }
    public int romanToInt8(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0, i=0;
        while(i < s.length()-1) {
            String tmp = s.substring(i, i+2);
            if(s.substring(i, i+2).equals("IV")) {
                result += 4;
                i+=2;
            } else if(s.substring(i, i+2).equals("IX")) {
                result += 9;
                i+=2;
            } else if(s.substring(i, i+2).equals("XL")) {
                result += 40;
                i+=2;
            } else if(s.substring(i, i+2).equals("XC")) {
                result += 90;
                i+=2;
            } else if(s.substring(i, i+2).equals("CD")) {
                result += 400;
                i+=2;
            } else if(s.substring(i, i+2).equals("CM")) {
                result += 900;
                i+=2;
            } else {
                result += map.get(s.charAt(i));
                i++;
            }
        }
        while(i < s.length()) {
            result += map.get(s.charAt(i));
            i++;
        }
        return result;
    }
    public int value(char s)
    {
        char arr[]={'I','V','X','L','C','D','M'};
        int val[]={1,5,10,50,100,500,1000};
        int i;
        for(i=arr.length-1;i>=0;i--)
        {
            if(arr[i]==s)
                return val[i];
        }
        return 0;
    }

    public int SubtractionInstance(char a,char b)
    {

        String arr[]={"IV","IX","XL","XC","CD","CM"};
        int val[]={4,9,40,90,400,900};
        int i;
        char cc[]={a,b};
        String str=String.valueOf(cc);
        for(i=arr.length-1;i>=0;i--)
        {
            if(arr[i].equalsIgnoreCase(str))
                return val[i];
        }

        return -1;
    }

    public int romanToInt9(String str)
    {
        char arr[]=str.toCharArray();
        int i;
        int ctr=0;
        for(i=0;i<arr.length-1;i++)
        {
            int val=SubtractionInstance(arr[i], arr[i+1]);
            if(val!=-1)
            {
                ctr+=val;
                arr[i]=arr[i+1]='O';
            }
        }
        for(i=0;i<arr.length;i++)
        {
            int val=value(arr[i]);
            ctr+=val;
        }
        return ctr;
    }
    public int romanToInt10(String s) {
        int sum = 0;
        char a ;
        char b;
        for(int i = 0 ;i<s.length();i++){
            a =s.charAt(i);
            if(i<s.length()-1){
                b = s.charAt(i+1);
            }else {
                b='0';
            }

            if(a=='I'&&b=='V'){
                sum+=4;
                i++;
                continue;
            } else if(a=='I'&&b=='X'){
                sum+=9;
                i++;
                continue;
            }else if(a=='X'&&b=='L'){
                sum+=40;
                i++;
                continue;
            }else if(a=='X'&&b=='C'){
                sum+=90;
                i++;
                continue;
            }else if (a=='C'&&b=='D'){
                sum+=400;
                i++;
                continue;
            }else if (a=='C'&&b=='M'){
                sum+=900;
                i++;
                continue;
            }
            switch (a) {
                case 'I': sum+=1;
                    break;
                case 'V':sum+=5;
                    break;
                case 'X': sum+=10;
                    break;
                case 'L':sum+=50;
                    break;
                case 'C': sum+=100;
                    break;
                case 'D':sum+=500;
                    break;
                case 'M': sum+=1000;
                    break;

            };

        }
        int c ;
        System.out.println(sum);
        return sum;
    }
    private final int[] valor={
            1, 5, 10, 50, 100,500,1000};
    private final String[] simbolo={
            "I", "V", "X", "L", "C","D","M"};

    public int romanToInt11(String s) {

        String[] a =s.split("");
        int indice =0;
        int resultado = 0;
        for (int i=a.length; i>0 ; i--)
        {
            int actualVal=castString(a[i-1].trim());
            if(i==a.length){
                resultado=resultado + actualVal ;
            } else{
                int lastVal=castString(a[i]);
                if (a[i].compareTo(a[i-1])==0 || actualVal>lastVal ){
                    resultado=resultado + actualVal;
                }else{
                    resultado=resultado - actualVal;
                }
            }
        }

        return resultado;

    }
    public int castString(String a){
        int val=0;

        for ( int j=0; j<simbolo.length;j++){

            if(simbolo[j].compareTo(a)==0)
            {
                val = valor[j];}
        };
        return val;
    }
    public int romanToInt12(String s) {

        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int sum=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int a=map.get(ch);

            if(i+1<s.length()){
                int b=map.get(s.charAt(i+1));

                if(a>=b){
                    sum=sum+a;
                }
                else{
                    sum=sum-a;
                }
            }
            else{
                sum=sum+a;
            }
        }
        return sum;
    }
    static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt13(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if ((i+1) < s.length()) {
                char next = s.charAt(i+1);
                if (map.get(curr) < map.get(next)) {
                    ans += map.get(next) - map.get(curr);
                    i++;
                } else {
                    ans += map.get(curr);
                }
                continue;
            }
            ans += map.get(curr);
        }
        return ans;
    }
    public int romanToInt14(String s) {
        int number = 0;
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 'I':
                    if (i != s.length()-1) {
                        if (arr[i + 1] == 'V') {
                            number = number + 4;
                            i++;
                        }
                        else if (arr[i + 1] == 'X') {
                            number = number + 9;
                            i++;
                        }
                        else {
                            number++;
                        }
                    }
                    else {
                        number++;
                    }
                    break;
                case 'V':
                    number = number + 5;
                    break;
                case 'X':
                    if (i != s.length()-1) {
                        if (arr[i + 1] == 'L') {
                            number = number + 40;
                            i++;
                        }
                        else if (arr[i + 1] == 'C') {
                            number = number + 90;
                            i++;
                        }
                        else {
                            number = number + 10;
                        }
                    }
                    else {
                        number = number + 10;
                    }
                    break;
                case 'L':
                    number = number + 50;
                    break;
                case 'C':
                    if (i != s.length()-1) {
                        if (arr[i + 1] == 'D') {
                            number = number + 400;
                            i++;
                        }
                        else if (arr[i + 1] == 'M') {
                            number = number + 900;
                            i++;
                        }
                        else {
                            number = number + 100;
                        }
                    }
                    else {
                        number = number + 100;
                    }
                    break;
                case 'D':
                    number = number + 500;
                    break;
                case 'M':
                    number = number + 1000;
                    break;
            }
        }
        return number;
    }
    public int romanToInt15(String s) {


        int nums[]=new int[s.length()];
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case 'M':
                    nums[i]=1000;
                    break;
                case 'D':
                    nums[i]=500;
                    break;
                case 'C':
                    nums[i]=100;
                    break;
                case 'L':
                    nums[i]=50;
                    break;
                case 'X' :
                    nums[i]=10;
                    break;
                case 'V':
                    nums[i]=5;
                    break;
                case 'I':
                    nums[i]=1;
                    break;
            }
        }
        int sum=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1])
                sum-=nums[i];
            else
                sum+=nums[i];
        }
        return sum+nums[nums.length-1];
    }
    public static int romanToInt16(String s) {


        int sum=0;
        int j=0;
        int k=0;
        char [] arr=new char[s.length()];
        while(j<s.length()) {
            char c=s.charAt(j);
            switch(c) {
                case 'I':arr[k]=1;
                    break;
                case 'V':arr[k]=5;
                    break;
                case 'X':arr[k]=10;
                    break;
                case 'L':arr[k]=50;
                    break;
                case 'C':arr[k]=100;
                    break;
                case 'D':arr[k]=500;
                    break;
                case 'M':arr[k]=1000;
            }
            k++;
            j++;
        }
        int i=0;
        while(i<arr.length) {
            if((i+1<arr.length) && arr[i]<arr[i+1]){
                sum=sum+arr[i+1]-arr[i];
                i=i+1;

            }
            else{
                sum=sum+arr[i];
            }
            i++;
        }
        return sum;
    }
    public int romanToInt17(String s) {
        int out = 0;
        String temp = s + " ";
        for(int i = 0; i < s.length(); i ++) {
            out += convertToInt(temp.charAt(i), temp.charAt(i + 1));
        }
        return out;
    }

    public int convertToInt(char s) {
        if(s == 'I') {
            return 1;
        } if(s == 'V') {
            return 5;
        } if(s == 'X') {
            return 10;
        } if(s == 'L') {
            return 50;
        } if(s == 'C') {
            return 100;
        } if(s == 'D') {
            return 500;
        } if(s == 'M') {
            return 1000;
        }
        return -1; // error
    }

    public int convertToInt(char curr, char next) {
        if(curr == 'I' && (next == 'V' || next == 'X')) {
            return -convertToInt(curr);
        }
        if(curr == 'X' && (next == 'L' || next == 'C')) {
            return -convertToInt(curr);
        }
        if(curr == 'C' && (next == 'D' || next == 'M')) {
            return -convertToInt(curr);
        }
        return convertToInt(curr);
    }
    public int romanToInt18(String s) {
        int x=s.length(); int sum=0; char y=' ';
        for(int i=0;i<x;i++)
        {
            char w=s.charAt(i); if(i!=x-1) y=s.charAt(i+1);
            if(w=='I' && y!='V' && y!='X') sum+=1;
            if(w=='V') sum+=5;
            if(w=='L') sum+=50;
            if(w=='D') sum+=500;if(w=='M') sum+=1000;
            if(w=='I'&& y=='V' && y!='X' ){sum+=4;i++;}
            if(w=='I' && y!='V' && y=='X'){sum+=9; i++;}
            if(w=='X' && y!='L' && y!='C') sum+=10;
            if(w=='X' && y=='L' && y!='C'){sum+=40; i++;}
            if(w=='X' && y!='L' && y=='C'){sum+=90; i++;}
            if(w=='C' && y!='D' && y!='M'){sum+=100;}
            if(w=='C' && y=='D' && y!='M'){sum+=400;i++;}
            if(w=='C' && y!='D' && y=='M') {sum+=900; i++;}
        }
        return sum;
    }
}
