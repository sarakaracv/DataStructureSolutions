package org.example.leetCodeTask;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal166 {
    public String fractionToDecimal(int numerator,int denominator){
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
    }
