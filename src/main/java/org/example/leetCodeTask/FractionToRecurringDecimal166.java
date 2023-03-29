package org.example.leetCodeTask;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal166 {
    public String fractionToDecimal1(int numerator,int denominator){
        if (numerator==0) return "0";
        StringBuilder result= new StringBuilder();
        if (numerator<0^denominator<0){
            result.append("-");
        }
        long num= Math.abs((long)numerator);
        long den=Math.abs((long)denominator);
        result.append(num/den);
        long remainder=num%den;
        if (remainder==0) return result.toString();
        result.append(".");
        HashMap<Long,Integer> hm= new HashMap<Long,Integer>();
        while (remainder!=0){
            if (hm.containsKey(remainder)){
                result.insert(hm.get(remainder),"(");
                result.append(")");
                break;
            }
            hm.put(remainder,result.length());
            remainder*=10;
            result.append(remainder/den);
            remainder%=den;
        }
        return result.toString();
    }

        public String fractionToDecimal2(int numerator, int denominator) {
            if (numerator == 0) {
                return "0";
            }
            StringBuilder sb = new StringBuilder();
            if ((numerator < 0) ^ (denominator < 0)) {
                sb.append("-");
            }
            long num = Math.abs((long) numerator);
            long den = Math.abs((long) denominator);
            sb.append(num / den);
            long rem = num % den;
            if (rem == 0) {
                return sb.toString();
            }
            sb.append(".");
            Map<Long, Integer> map = new HashMap<>();
            while (rem != 0) {
                if (map.containsKey(rem)) {
                    sb.insert(map.get(rem), "(");
                    sb.append(")");
                    break;
                }
                map.put(rem, sb.length());
                rem *= 10;
                sb.append(rem / den);
                rem %= den;
            }
            return sb.toString();
        }
    public String fractionToDecimal3(int numerator, int denominator) {
        long lnum = numerator, lden = denominator;
        if (lnum == 0) {
            return "0";
        }
        if (lnum % lden == 0) {
            return Long.toString(lnum / lden);
        }
        StringBuilder number = new StringBuilder();
        if ((lden < 0) ^ (lnum < 0)) {
            number.append('-');
        }
        lnum = Math.abs(lnum);
        lden = Math.abs(lden);
        number.append(Long.toString(lnum / lden)).append('.');
        long GCD = gcd(lnum, lden);
        lnum /= GCD;
        lden /= GCD;
        lnum %= lden;
        lnum *= 10;
        int twos = 0, fives = 0;
        long temp = lden;
        for (;temp % 2 == 0; twos++) {
            temp /= 2;
        }
        for (;temp % 5 == 0; fives++) {
            temp /= 5;
        }
        if (temp == 1) {
            while (lnum != 0) {
                number.append(lnum / lden);
                lnum = (lnum % lden) * 10;
            }
        } else {
            int nonRepLen = Math.max(twos, fives);
            for (int i = 0; i < nonRepLen; i++) {
                number.append(lnum / lden);
                lnum = (lnum % lden) * 10;
            }
            long initRem = lnum;
            StringBuilder nonRep = new StringBuilder();
            do {
                nonRep.append(lnum / lden);
                lnum = (lnum % lden) * 10;
            } while (lnum != initRem);
            number.append('(').append(nonRep.toString()).append(')');
        }
        return number.toString();
    }
    private long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
    public String fractionToDecimal4(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        result.append(sign);
        result.append(num / den);
        long remainder = num % den;
        if (remainder == 0)
            return result.toString();
        result.append(".");
        HashMap<Long, Integer> hashMap = new HashMap<Long, Integer>();
        while (!hashMap.containsKey(remainder)) {
            hashMap.put(remainder, result.length());
            result.append(10 * remainder / den);
            remainder = 10 * remainder % den;
        }
        int index = hashMap.get(remainder);
        result.insert(index, "(");
        result.append(")");
        return result.toString().replace("(0)", "");
    }
    public String fractionToDecimal5(int numerator, int denominator) {
        long a = numerator;
        long b = denominator;
        if(a % b == 0) {
            return a / b + "";
        }
        StringBuffer sb = new StringBuffer();
        if(a * b < 0) {
            sb.append("-");
            a = Math.abs(a);
            b = Math.abs(b);
        }
        sb.append(a / b);
        sb.append(".");
        a %= b;
        Map<Long, Integer> map = new HashMap<>();
        while(a != 0) {
            map.put(a, sb.length());
            a *= 10;
            sb.append(a / b);
            a %= b;
            if(map.containsKey(a)) {
                return String.format("%s(%s)", sb.substring(0, map.get(a)), sb.substring(map.get(a)));
            }
        }
        return sb.toString();
    }
    public String fractionToDecimal7(int numerator, int denominator) {

        long a = numerator, b = denominator;
        if (a % b == 0) return String.valueOf(a / b);
        StringBuilder sb = new StringBuilder();

        if (a * b < 0) sb.append('-');
        a = Math.abs(a); b = Math.abs(b);

        sb.append(String.valueOf(a / b) + ".");
        a %= b;
        Map<Long, Integer> map = new HashMap<>();
        while (a != 0) {
            map.put(a, sb.length());
            a *= 10;
            sb.append(a / b);
            a %= b;
            if (map.containsKey(a)) {
                int u = map.get(a);
                return String.format("%s(%s)", sb.substring(0, u), sb.substring(u));
            }
        }
        return sb.toString();
    }
    public String fractionToDecimal8(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder res = new StringBuilder();
        res.append((numerator > 0) ^ (denominator > 0) ? "-":"");
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // integral part
        res.append(num/den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }

        // fractional part
        res.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (num != 0) {
            num *= 10;
            res.append(num/den);
            num %= den;
            if (map.containsKey(num)) {
                res.insert(map.get(num), "(");
                res.append(")");
                break;
            } else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }

    }
