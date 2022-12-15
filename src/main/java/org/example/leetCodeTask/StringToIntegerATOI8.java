package org.example.leetCodeTask;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToIntegerATOI8 {
    public static void main(String[] args) {

        String number= "42";
        System.out.println();
    }

    public int myAtoi1(String s) {
        if(s.length() ==0) return 0;
        char[] arr = s.toCharArray();
        int i = 0;
        while(i < arr.length && arr[i] == ' ') i++; // skipping spaces
        if(i==arr.length) return 0; // only whitespace characters
        boolean negative = false;
        if(arr[i] == '-'){
            negative = true;
            i++;
        } else if (arr[i] == '+'){
            i++;
        }
        while(i < arr.length &&  charToInt(arr[i]) == 0) i++; // skip zeros in front
        int beginning = i;
        // finding the end of number
        while(i < arr.length &&  charToInt(arr[i]) != -1) i++;
        if(i == beginning) return 0; // no number at all
        i--; // move to the position of last digit

        // constructing the number
        long multiplier = 1;
        long number = 0;
        for(int j=i; j>=beginning;j--){
            number += charToInt(arr[j]) * multiplier;
            long oldMultiplier = multiplier;
            multiplier *= 10L;
            if (multiplier < oldMultiplier || number > Integer.MAX_VALUE){ // overflow
                if(negative) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
        }

        if (negative) return (int) -number;
        else return (int) number;
    }

    private int charToInt(char c) {
        int result = c - '0';
        if (result >= 0 && result <=9) return result;
        else return -1;
    }
    public int myAtoi2(String s) {
        int index = 0;
        int sign = 1;
        int result = 0;
        int len = s.length();

        if(len == 0) return result;

        while(index < len && s.charAt(index) == ' '){ //skip before sign
            index++;
        }

        if(index < len && (s.charAt(index) == '-' || s.charAt(index) == '+')){ //set sign
            sign = s.charAt(index) == '+' ? sign : -sign;
            index++;
        }

        while(index < len){
            int digit = s.charAt(index) - '0';

            if(digit < 0 || digit > 9)
                break;

            if(result > Integer.MAX_VALUE / 10
                    || (result == Integer.MAX_VALUE /10 && digit > Integer.MAX_VALUE % 10)){
                if(sign == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }

            result = result*10 + digit;

            //System.out.println(result);
            index++;
        }





        return sign * result;
    }

    public boolean isDigit(char c){
        if(c >= '0' && c <= '9')
            return true;
        return false;
    }
    public int myAtoi3(String s) {
        int i=0,sign =1,ispositive=0;
        if(s.length()<=0)
            return 0;
        while(i<s.length()&&s.charAt(i)==' ')
            i++;
        if(i>=s.length())
            return 0;
        if(s.charAt(i)=='-'||s.charAt(i)=='+'){
            sign  = (s.charAt(i)=='-')?-1:+1;
            i++;
        }
        if(i>=s.length())
            return 0;
        int ans  = 0;
        for(int start  = i;start<s.length()&&s.charAt(start)>='0'&&s.charAt(start)<='9';start++){
            int temp = s.charAt(start)-'0';
            if(sign<0){
                if((ans*sign)<Integer.MIN_VALUE/10)
                    return Integer.MIN_VALUE;
                else if((ans*sign)==Integer.MIN_VALUE/10)
                {
                    if(temp>=(Integer.MIN_VALUE%10)*sign)
                        return Integer.MIN_VALUE;
                }
            }else if(sign>0){
                if(ans>Integer.MAX_VALUE/10)
                    return Integer.MAX_VALUE;
                else if(ans==Integer.MAX_VALUE/10)
                {
                    if(temp>=Integer.MAX_VALUE%10)
                        return Integer.MAX_VALUE;
                }
            }
            ans  = ans*10+(temp);
        }
        return ans*sign;
    }
    public int myAtoi4(String s) {
        s = s.trim();
        boolean negative = s.startsWith("-");
        if (negative || s.startsWith("+")) {
            s = s.substring(1);
        }
        int n = 0;
        int index = 0;
        while(index < s.length() && Character.isDigit(s.charAt(index)) ) {
            // int prev = n;
            if (n > Integer.MAX_VALUE/10 || (n == Integer.MAX_VALUE/10 && ((s.charAt(index) - '0') > Integer.MAX_VALUE% 10))) {
                if (negative) {
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }
            n = n * 10 + (s.charAt(index) - '0');
            // System.out.println(n);

            index++;
        }

        if (negative) {
            n = -n;
        }
        return n;
    }
    public int myAtoi5(String s) {
        int n = s.length(),flag =0,sign=0;
        double ans =0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)==' ' && flag==0)
                continue;
            else if(flag ==0 && s.charAt(i)=='-'){
                flag=1;
                sign = 1;
            }
            else if(flag ==0 && s.charAt(i)=='+')
                flag=1;
            else if(s.charAt(i)>= '0' && s.charAt(i) <= '9'){
                flag =1;
                ans = ans*10 + (s.charAt(i)-'0');
                if(sign==1 && ans>=Math.pow(2,31))
                    return (int)-Math.pow(2,31);
                if(sign==0 && ans>=Math.pow(2,31)-1)
                    return (int)(Math.pow(2,31)-1);
            }
            else{
                break;
            }
        }
        if(sign==1)
            ans = -1*ans;
        return (int)ans;
    }
    public int myAtoi6(String s) {
        int signflag = 0;
        int sign = 0;
        int res = 0;


        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                if(signflag==0){
                    signflag = 1;
                }
                if((res*10)%10!=0 || res*10<res || (res*10)+Integer.parseInt(s.charAt(i)+"")<res){
                    if(sign==1){
                        //System.out.println(Integer.MIN_VALUE);
                        return Integer.MIN_VALUE;
                    }
                    else{
                        //System.out.println(Integer.MAX_VALUE);
                        return Integer.MAX_VALUE;
                    }
                }
                res = res*10 + Integer.parseInt(s.charAt(i)+"");
                //System.out.println(res);
            }
            else{
                if(signflag==1){
                    break;
                }
                else if(s.charAt(i) == '-'){
                    sign = 1;
                    signflag = 1;
                }
                else if(s.charAt(i) == '+'){
                    sign = 2;
                    signflag = 1;
                }
                else if(s.charAt(i)!=' '){
                    break;
                }
            }
        }
        if(sign==1){
            res = res*-1;
        }
        return res;
    }
    public static int myAtoi7(String s) {
        // Read in and ignore any leading whitespace
        int i = 0;
        while (i < s.length() && Character.isWhitespace(s.charAt(i))) {
            i++;
        }

        // Check if the next character (if not already at the end of the string) is '-' or '+'
        boolean isNegative = false;
        if (i < s.length() && s.charAt(i) == '-') {
            isNegative = true;
            i++;
        } else if (i < s.length() && s.charAt(i) == '+') {
            i++;
        }

        // Read in next the characters until the next non-digit character or the end of the input is reached
        StringBuilder numberString = new StringBuilder();
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            numberString.append(s.charAt(i));
            i++;
        }

        // Convert these digits into an integer and change the sign as necessary
        int result = 0;
        if (numberString.length() > 0) {
            try {
                result = Integer.parseInt(numberString.toString());
                if (isNegative) {
                    result *= -1;
                }
            } catch (NumberFormatException e) {
                // This should only happen if the integer is out of range
                result = isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }

        // Return the integer as the final result
        return result;
    }
    public int myAtoi8(String s) {
        if(s.length()>0 && (!(s.charAt(0)>='0' && s.charAt(0)<='9') && s.charAt(0) != ' ' && s.charAt(0) != '+'&& s.charAt(0) != '-')){
            return 0;
        }

        double num = 0;
        char ch = '+';
        for(int i = 0; i<s.length(); i++){
            if(num>0 && (s.charAt(i) < '0' || s.charAt(i) > '9')){
                break;
            }
            if(s.charAt(i)==' ' && i<s.length()-1 && (!(s.charAt(i+1)>='0' && s.charAt(i+1)<='9') && s.charAt(i+1) != ' ' && s.charAt(i+1) != '+'&& s.charAt(i+1) != '-')){
                return 0;
            }
            if((s.charAt(i) == '+' || s.charAt(i)=='-')){
                if(i<s.length()-1 && (s.charAt(i+1) < '0' || s.charAt(i+1) > '9')){
                    return 0;
                }
                ch = s.charAt(i) == '-' ? '-' : '+';
            }

            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                num = num*10 + Integer.parseInt(String.valueOf(s.charAt(i)));
                if(i<s.length()-1 && (s.charAt(i+1) < '0' || s.charAt(i+1) > '9')){
                    break;
                }
            }
        }
        num = ch == '-' ?-1*num : num;
        if(num<-2147483648){
            return -2147483648;
        }else if(num>2147483647){
            return 2147483647;
        }
        return (int)(num);
    }
    public int myAtoi9(String s) {
        int idx = 0;
        HashSet<String> digit = new HashSet<>();
        ArrayList<Integer> store = new ArrayList<>();
        for (int i = 0; i < 10 ; i++){
            digit.add(Integer.toString(i));
        }
        boolean negative = false;
        boolean sign = false;
        boolean notDigit = false;
        boolean digitTime = false;
        int ans = 0;
        while(idx < s.length()){
            if (notDigit) {
                break;
            }
            if(s.charAt(idx) == '-' && (!notDigit && !sign && !digitTime)){
                negative = true;
                sign = true;
                idx ++;
            }
            else if (s.charAt(idx) == '+' && (!notDigit && !sign &&!digitTime)){
                sign = true;
                idx ++;
            }
            else if(s.charAt(idx) == ' ' && (!notDigit &&!digitTime && !sign)){
                idx ++;
            }
            else if(!digit.contains(Character.toString(s.charAt(idx))) && (!notDigit)){
                notDigit = true;
                idx ++;
            }
            else if(digit.contains(Character.toString(s.charAt(idx)))){
                String number = String.valueOf(s.charAt(idx));
                digitTime = true;
                store.add(Integer.parseInt(number));
                idx ++;
            }
            else{
                break;
            }
        }
        int power = store.size()-1;
        if (power >= 9 && store.get(0) > 2){
            if (negative){
                return Integer.MIN_VALUE;
            }
            else{
                return Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i< store.size(); i ++){
            if (negative){
                ans += -1* Math.pow(10, power) * store.get(i);
                power--;
            }
            else{
                ans += Math.pow(10, power) * store.get(i);
                power --;
            }
        }
        if (ans >= Integer.MAX_VALUE ){
            return Integer.MAX_VALUE;
        }
        else if (ans <= Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        else{
            return ans;
        }
    }
    public int myAtoi10(String s) {

        if (s.length() == 0) {
            return 0;
        }

        String filteredNum = "";
        boolean isMeetNumber = false;
        for (int i = 0; i < s.length(); i++) {
            if (!((s.charAt(i) == ' ') || (s.charAt(i) == '-') || (s.charAt(i) == '+')
                    || (((int) s.charAt(i) >= 48) && ((int) s.charAt(i) <= 57))) && !isMeetNumber) {
                return 0;
            }

            if (isMeetNumber && (((int) s.charAt(i) < 48) || ((int) s.charAt(i) > 57))) {
                break;
            }

            if ((s.charAt(i) == '-') || (s.charAt(i) == '+')
                    || (((int) s.charAt(i) >= 48) && ((int) s.charAt(i) <= 57))) {
                filteredNum += s.charAt(i);
                isMeetNumber = true;
            }
        }

        boolean isMathSymbol = false;
        char mathSymbol = '0';
        int startIdx = 0;
        if (filteredNum.length() == 0) {
            return 0;
        }
        if (filteredNum.charAt(0) == '+' || filteredNum.charAt(0) == '-') {
            mathSymbol = filteredNum.charAt(0);
            isMathSymbol = true;
            startIdx = 1;
        }

        boolean isNotZero = true;
        String resultNum = "";
        for (int i = startIdx; i < filteredNum.length(); i++) {
            if (isNotZero && (filteredNum.charAt(i) > 48 && filteredNum.charAt(i) <= 57)) {
                resultNum += filteredNum.charAt(i);
                isNotZero = false;
                continue;
            }

            if (isNotZero) {
                continue;
            }

            resultNum += filteredNum.charAt(i);
        }

        if (resultNum.length() == 0) {
            return 0;
        }
        if (resultNum.length() >= 19) {
            if (isMathSymbol) {
                if (mathSymbol == '-') {

                    return (Integer.MAX_VALUE + 1) * -1;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            return Integer.MAX_VALUE;
        }

        System.out.println(mathSymbol);
        if (Long.parseLong(resultNum) > (long) Integer.MAX_VALUE) {
            System.out.println("IN");
            if (isMathSymbol) {
                if (mathSymbol == '-') {

                    return (Integer.MAX_VALUE + 1) * -1;
                } else {
                    return Integer.MAX_VALUE;
                }
            }

            System.out.println("OUT " + (Integer.MAX_VALUE));
            return Integer.MAX_VALUE;

        }

        if (isMathSymbol) {
            if (mathSymbol == '-') {
                return (Integer.parseInt(resultNum)) * (-1);
            }
        } else {
            if (resultNum.length() == 0) {
                return 0;
            }
        }

        return Integer.parseInt(resultNum);
    }
    public int myAtoi11(String s) {

        double answer = 0;
        boolean flag = false;
        boolean digit = false, ch = false, reject = false;
        boolean sign = false;

        for(int i = 0; i < s.length(); i++){


            // if not whitespace
            if(!(Character.isWhitespace(s.charAt(i)))){

                // if + or -
                if(s.charAt(i) == '-' || s.charAt(i) == '+'){

                    if(flag || digit){
                        if(sign){
                            answer *= -1;
                        }
                        return (int)answer;
                    }
                    else
                        flag = true;

                    if(s.charAt(i) == '-'){
                        sign = true;
                    }

                }


                // else if digit
                else if(Character.isDigit(s.charAt(i))) {
                    digit = true;
                    answer = answer*10 + Integer.parseInt(String.valueOf(s.charAt(i)));
                }

                // else return answer
                else{
                    if(sign){
                        answer *= -1;
                    }
                    return (int)answer;
                }

                if(ch && !digit)
                    return 0;


                if(s.charAt(i) == '.'){

                    if(sign){
                        answer *= -1;
                    }
                    return (int)answer;

                }



            }
            else{
                if(digit || flag){
                    if(sign){
                        answer *= -1;
                    }
                    return (int)answer;
                }
            }


        }

        if(sign){
            answer *= -1;
        }


        if(answer > (Math.pow(2, 31) - 1))
            return (int)(Math.pow(2,31) - 1);
        else if(answer < (-1 * Math.pow(2,31)))
            return (int)(Math.pow(2,31) * -1);
        else
            return (int)answer;


    }
    public int myAtoi12(String s) {
        char[] sArray = s.toCharArray();
        int intValue = 0;
        boolean isNegative = false;
        StringBuilder numberStr = new StringBuilder();


        if(s==null || s.length()==0){
            return 0;
        }

        int i=0;

        while(i<sArray.length && sArray[i]==' '){
            i++;
        }

        if(i<sArray.length && (sArray[i]=='-' || sArray[i]=='+')){
            if(sArray[i]=='-')
                isNegative = true;
            i++;
        }

        if(i<sArray.length && !Character.isDigit(sArray[i])){
            return 0;
        }

        int returnValue = 0;
        int maxValue = Integer.MAX_VALUE / 10;
        while(i<sArray.length && Character.isDigit(sArray[i])){
            if (returnValue > maxValue || (returnValue == maxValue && s.charAt(i) - '0' > 7)) {
                if (isNegative) {
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }
            returnValue = returnValue * 10 + (s.charAt(i++) - '0');
        }

        if(isNegative){
            returnValue = 0 - returnValue;
        }

        return (int)returnValue;

    }
    public int myAtoi13(String s) {

        char [] c = s.toCharArray();
        if(c.length == 0) return 0;

        int sign = 1; long num=0; int i=0;
        char curr = c[i];
        //1
        while(curr ==' ') {i++;
            if(i == c.length) return 0;
            curr = c[i];
        }
        //2
        if (curr =='-') { sign =-1; i++; }
        else if (curr =='+') { sign =1; i++; }

        //3
        while(i<c.length){
            curr = c[i];
            if(curr < '0' || curr > '9') break;
            else {
                num = num*10;
                num += curr-'0';
                i++;

                if(sign*num <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
                else if (sign*num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            }
        }
        num *= sign;
        return (int)num;
    }
    public int myAtoi14(String str) {
        if(str == null)
            return 0;
        str = str.trim();
        if(str.length() < 1)
            return 0;

        boolean isNeg = false;
        int i = 0;
        if(str.charAt(0) == '-') {
            isNeg = true;
            i++;
        }
        else if(str.charAt(0) == '+')
            i++;
        double result = 0;
        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result*10 + (str.charAt(i) - '0');
            i++;
        }
        if(isNeg)
            result = -result;
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)result;
    }
    public int myAtoi15(String s) {
        if(s == null || s.length() == 0) return 0;

        int mult = 1;
        int sum = 0;
        int index = 0;
        int sing = 1;
        int n = s.length();
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        //Read in and ignore any leading whitespace
        while(index < n && s.charAt(index) == ' '){
            index ++;
        }

        //Check if the next character is sing
        if(index < n && s.charAt(index) == '-'){
            sing *= -1;
            index ++;
        }else if(index < n && s.charAt(index) == '+'){
            index ++;
        }

        while(index < n && s.charAt(index) - '0' >= 0 && s.charAt(index) - '9' <= 9){
            int digit = s.charAt(index) - '0';

            if(sum > max / 10 || (sum == max / 10 && digit > max % 10)){
                return sing == 1 ? max : min;
            }

            sum = sum * 10 + digit;
            //mult *= 10;
            index ++;
        }

        return sing * sum ;
    }
    public static int myAtoi16(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
        if (charNotAllowed(s.charAt(0))) return 0;

        int sign = 1;
        if (s.charAt(0) == '-') sign = -1;

        int result = 0;
        int next = 0;
        boolean failFastOn = false;
        for (char ch : s.toCharArray()) {
            if (isDigit1(ch)) {
                next = getInteger(ch);

                if ((result * sign > Integer.MAX_VALUE/10 ||
                        (result * sign == Integer.MAX_VALUE/10 && next > Integer.MAX_VALUE % 10)))
                    return Integer.MAX_VALUE;
                if (result * sign < Integer.MIN_VALUE/10 ||
                        (result * sign == Integer.MIN_VALUE/10 && next > -1*(Integer.MIN_VALUE % 10)))
                    return Integer.MIN_VALUE;

                result = result * 10 + getInteger(ch);
            } else if (failFastOn) {
                break;
            }
            failFastOn = true;
        }

        return result * sign;
    }

    private static boolean isDigit1(char ch) {
        return ch >= '0' && ch <= '9';
    }
    private static int getInteger(char ch) {
        return ch - '0';
    }
    private static boolean charNotAllowed(char ch) {
        return ! (isDigit1(ch) || ch == '-' || ch == '+');
    }
    public int myAtoi17(String s) {
        long num=0;
        boolean neg=false;
        int i=0, max=Integer.MAX_VALUE, min=Integer.MIN_VALUE;
        for(; i<s.length() && s.charAt(i)==' '; i++);
        if(i<s.length() && (s.charAt(i)=='-' || s.charAt(i)=='+')){
            neg = s.charAt(i)=='-'?true:false;
            i++;
        }
        for(; i<s.length(); i++){
            char ch=s.charAt(i);
            if(ch-'0'>=0 && ch-'0'<=9){
                num=num*10+(ch-'0');
                if(num>max){
                    return neg?min:max;
                }
            }
            else{
                break;
            }

        }
        return neg?-(int)num:(int)num;
    }
    public int myAtoi18(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int index = 0;

        while (index < s.length() && (Character.isWhitespace(s.charAt(index)))) {
            index++;
        }

        boolean isPositive = true;

        if (index < s.length() && !Character.isDigit((s.charAt(index)))) {
            if (s.charAt(index) != '-' && s.charAt(index) != '+') {
                return 0;
            }

            if (s.charAt(index) == '-') {
                isPositive = false;
            }
            index++;
        }

        int result = 0;


        while (index < s.length() && Character.isDigit(s.charAt(index))) {

            int cur = s.charAt(index) - '0';
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && cur > Integer.MAX_VALUE % 10)) {
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + cur;
            index++;
        }

        return isPositive ? result : result * -1;
    }
    public int myAtoi19(String str) {
        if (str== null || str.trim().isEmpty()) {
            return 0;
        }
        str = str.trim();
        int sign = (str.charAt(0) == '-')? -1 : 1;
        int start = (str.charAt(0) == '+' || sign==-1) ? 1: 0;

        long result = 0;
        int i=start;
        for (; i<str.length(); i++) {
            char curr = str.charAt(i);
            if (curr <'0' || curr>'9') {
                break;
            }

            result = (result*10) + curr-'0';
            if ((result*sign) < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            if ((result*sign) > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        if (i==start) {
            return 0;
        }
        return (int) (result*sign);


    }
    public int myAtoi20(String s) {
        int result = 0;
        int sign = 1;
        int index = 0;
        int len = s.length();

        while (index < len && s.charAt(index) == ' ') {
            index++;
        }

        if (index < len && s.charAt(index) == '+') {
            sign = 1;
            index++;
        } else if (index < len && s.charAt(index) == '-') {
            sign = -1;
            index++;
        }

        while (index < len && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            // check for overflow
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            index++;
        }
        return sign * result;
    }
    public int myAtoi21(String str) {
        if (str== null || str.trim().isEmpty()) {
            return 0;
        }
        str = str.trim();
        int sign = (str.charAt(0) == '-')? -1 : 1;
        int start = (str.charAt(0) == '+' || sign==-1) ? 1: 0;

        long result = 0;
        int i=start;
        for (; i<str.length(); i++) {
            char curr = str.charAt(i);
            if (curr <'0' || curr>'9') {
                break;
            }

            result = (result*10) + curr-'0';
            if ((result*sign) < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            if ((result*sign) > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        if (i==start) {
            return 0;
        }
        return (int) (result*sign);
    }
    public int myAtoi22(String str) {
        int index = 0, sign = 1, total = 0;
        if(str.trim().length() == 0) return 0;

        while(str.charAt(index) == ' ' && index < str.length())
            index ++;


        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }

        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;

            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
    }
    public int myAtoi23(String s) {
        s = s.trim();
        if(s.length() == 0) {
            return 0;
        }
        int start = 0;
        int sign = 1;
        if(s.charAt(0) == '+' || s.charAt(0) == '-') {
            sign = s.charAt(0) == '-' ? -1 : 1;
            start++;
        }
        double value = calcInteger(s, start) * sign;
        return (int) Math.min(Integer.MAX_VALUE, Math.max(Integer.MIN_VALUE, value));
        // return wrapAndSign(value, sign);
    }

    private int wrapAndSign(double value, int sign) {
        value *= sign;
        if(value > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if(value < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) value;
    }

    private double calcInteger(String s, int start) {
        double result = 0.0;
        for(int i = start; i < s.length(); i++) {
            if(!Character.isDigit(s.charAt(i))) {
                break;
            }
            if(i == start) {
                result = s.charAt(i) - '0';
            }
            else {
                result = result * 10 + s.charAt(i) - '0';
            }
        }
        return result;
    }
    public int myAtoi24(String s) {
        if (s == null) return 0;
        int n = s.length();
        if (n == 0) return 0;
        int i = 0;
        while (s.charAt(i) == ' ') {
            // only contains blank space
            if (++i == n) return 0;
        }
        int sign = 1;
        if (s.charAt(i) == '-') sign = -1;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') ++i;
        int res = 0, flag = Integer.MAX_VALUE / 10;
        for (; i < n; ++i) {
            // not a number, exit the loop
            if (s.charAt(i) < '0' || s.charAt(i) > '9') break;
            // if overflows
            if (res > flag || (res == flag && s.charAt(i) > '7'))
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (s.charAt(i) - '0');
        }
        return sign * res;
    }
    public int myAtoi25(String s) {
        s = s.trim();
        if (s.length() < 1)
            return 0;

        int sign = 1;
        int i =0;
        if(s.charAt(0) == '-') {
            sign = -1;
            i = 1;
        } else if(s.charAt(0) == '+') {
            i = 1;
        }
        int ans = 0;
        for (; i < s.length(); i++) {
            int num = s.charAt(i) - 48;

            if ((num >= 0 && num <= 9)) {
                if (sign > 0) {
                    if (ans <= Integer.MAX_VALUE / 10
                            && ((ans * 10) < Integer.MAX_VALUE - num)) {
                        ans = ans * 10 + num;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }

                if (sign < 0) {
                    if (ans * sign >= Integer.MIN_VALUE / 10
                            && ((ans * 10) * sign > Integer.MIN_VALUE + num)) {
                        ans = ans * 10 + num;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }

            } else {
                break;
            }
        }
        return ans * sign;



    }
}
