package org.example.leetCodeTask;

import java.util.LinkedList;

public class ReverseInteger7 {
    public static void main(String[] args) {

    }
    public int reverse1(int x) {
        long rev= 0;
        while( x != 0){
            rev= rev*10 + x % 10;
            x= x/10;
            if( rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
                return 0;
        }
        return (int) rev;
    }
    public int reverse2(int x) {
        int prevRev = 0 , rev= 0;
        while( x != 0){
            rev= rev*10 + x % 10;
            if((rev - x % 10) / 10 != prevRev){
                return 0;
            }
            prevRev = rev;
            x= x/10;
        }
        return rev;
    }
    public int reverse3(int x) {
        long res = 0;
        for (; x != 0; x /= 10)
            res = res * 10 + x % 10;
        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0: (int) res;
    }
    public int rever4(int x){
        long r = 0;
        while(x != 0){
            r = r*10 + x%10;
            x /= 10;
        }
        if(r >= Integer.MIN_VALUE && r <= Integer.MAX_VALUE)
            return (int)r;
        else
            return 0;
    }
    public int reverse5(int x) {
        boolean isPos = x>0;
        if(!isPos)
            x = x* -1;
        int ans = 0, tmp = 0;
        while(x>0){
            if( (ans) > (Integer.MAX_VALUE/10)) return 0;// overflows
            ans = ans* 10 + x % 10;
            x /=10;
        }
        return isPos? ans: -1*ans;
    }
    public int reverse6(int x) {
        int res = 0;
        while (x!= 0) {
            if ((res*10+x%10-x%10)/10 != res)
                return 0;
            res = res*10 + x%10;
            x /= 10;
        }
        return res;
    }
    public int reverse7(int x) {
        int curr = 0;
        int last = 0;
        while(x!=0){
            curr = curr*10 + x%10;
            if((curr-x%10)/10 !=last ){
                return 0;
            }
            last = curr;
            x = x/10;

        }
        return curr;

    }
    public int reverse8(int x) {

        String num = String.valueOf(x);
        char[] str = new char[num.length()];
        int n;
        if (num.charAt(0) == '-') {
            n = 1;
            str[0] = num.charAt(0);
        } else n = 0;
        for (int i=n, j = num.length()-1; j >= n; j--,i++) {

            str[i] = num.charAt(j);
        }
        long rs = Long.parseLong(new String(str));
        if (rs >= Math.pow(2,31) || rs < -Math.pow(2,31)) return 0;
        else return (int) rs;
    }
    public int reverse9(int x) {
        String num = Integer.toString(x);
        String reverseNum = "";
        for (int i = num.length() - 1; i >=  0 ; i-- ) {
            reverseNum = reverseNum + num.substring(i, i + 1);
        }
        try {
            if (reverseNum.substring(reverseNum.length() - 1).equals("-"))
                return Integer.parseInt(reverseNum.substring(reverseNum.length() - 1)
                        + reverseNum.substring(0, reverseNum.length() - 1));
            else return Integer.parseInt(reverseNum);
        } catch(Exception e){
            return 0;
        }
    }
    public int reverse10(int x) {
        try {
            String s = Integer.toString(x);
            String[] arr = s.split("(?!^)");
            String result = "";

            if (s.contains("-")) {
                result = "-";
                for (int i = s.length() - 1; i > 0; i--) {
                    result = result + arr[i];
                }
            } else {
                for (int i = s.length() - 1; i > -1; i--) { //is positive
                    result = result + arr[i];
                }
            }

            return Integer.parseInt(result);
        }
        catch (NumberFormatException e){
            return 0;
        }
    }
    public int reverse11(int x) {
        char ch = Integer.toString(x).charAt(0);
        StringBuilder temp = new StringBuilder(Integer.toString(x));
        temp.reverse();
        String ans = temp.toString();
        if(ch == '-') {
            ans = '-' + ans.substring(0, ans.length() - 1);
            try {
                return Integer.parseInt(ans);
            } catch(NumberFormatException e){
                return 0;
            }
        }
        else{
            try {
                return Integer.parseInt(ans);
            } catch(NumberFormatException e){
                return 0;
            }
        }
    }
    public int reverse12(int x) {
        LinkedList<Integer> numList = new LinkedList<>();
        while(x != 0){
            numList.add(x % 10);
            x /= 10;
        }
        double mulUnit = Math.pow(10, numList.size() - 1);
        double ans = 0;
        for(int i : numList){
            ans += mulUnit * i;
            if(ans >= 2147483647.0 || ans <= -2147483648.0) return 0;
            mulUnit /= 10;
        }
        return (int) ans;
    }
    public int reverse13(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
    public int reverse14(int x) {

        int rev=0;
        while(x!=0){
            int mod=x%10;
            if(rev>Integer.MAX_VALUE/10 || rev==Integer.MAX_VALUE/10  && mod>7)             {
                return 0;
            }
            if(rev<Integer.MIN_VALUE/10 || rev==Integer.MIN_VALUE/10 && mod <-8)
            {
                return 0;
            }
            rev=rev*10+mod;
            x=x/10;
        }
        return rev;
    }
    public int reverse15(int x) {
        int rev = 0;
        while(x != 0)
        {
            int rem = x%10;
            if(rev > Integer.MAX_VALUE/10 || (rev==Integer.MAX_VALUE && rem>7))
            {return 0;}
            if(rev < Integer.MIN_VALUE/10 || (rev==Integer.MIN_VALUE && rem<-8))
            {return 0;}
            rev = rev*10+rem;
            x/=10;
        }
        return rev;
    }
    public int reverse16(int x) {
        int res = 0;
        while (x != 0) {
            if (Math.abs(res) > Integer.MAX_VALUE / 10) return 0;
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return res;
    }
    public int reverse17(int x) {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }
    public int reverse18(int x) {
        StringBuffer str = new StringBuffer();
        str.append(x);
        int i=0;
        int j=str.length()-1;
        while(j > 0 && str.charAt(j) == '0'){
            str.setCharAt(j,'\0');
            j--;
        }
        while(i < j){
            if(str.charAt(i) == '-'){
                i++;
                continue;
            }
            char temp = str.charAt(i);
            str.setCharAt(i,str.charAt(j));
            str.setCharAt(j, temp);
            i++;
            j--;
        }
        String output = str.toString().trim();
        if(output.charAt(0) == '-' && output.substring(1).length() > 10){
            return 0;
        }else if(output.charAt(0) != '-' && output.length() > 10){
            return 0;
        }
        if(output.charAt(0) == '-' && output.substring(1).length() == 10){
            String s1 = output.substring(1);
            if(checkForBoundary(s1)){
                return 0;
            }
        }else if(output.length() == 10){
            if(checkForBoundary(output)){
                return 0;
            }
        }

        return Integer.parseInt(output);
    }
    private static boolean checkForBoundary(String s1) {
//        String maxValue="2147483647";
        if(s1.charAt(0) - '0' > 2){
            return true;
        }
        if(s1.charAt(0) - '0' == 2){
            return Integer.parseInt(s1.substring(1)) > 147483647;
        }
        return false;
    }
    public int reverse19(int x) {
        int temp;
        long reverse = 0;

        while(x!=0){
            temp = x % 10;
            reverse = reverse * 10 + temp;
            x = x/10;
        }
        if(reverse >= Integer.MIN_VALUE && reverse <= Integer.MAX_VALUE)
            return (int)reverse;
        else
            return 0;
    }
}
