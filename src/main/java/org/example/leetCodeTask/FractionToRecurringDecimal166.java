package org.example.leetCodeTask;

import java.util.HashMap;

public class FractionToRecurringDecimal166 {
    public String fractionToDecimal(int numerator,int denominator){
        if (numerator==0) return "0";
        StringBuilder result= new StringBuilder();
        if (numerator<0^denominator<0){
            result.append("-");
        }
        long num= Math.abs(numerator);
        long den=Math.abs(denominator);
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
}
