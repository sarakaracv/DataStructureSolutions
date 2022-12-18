package org.example.Tasks;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
//    Roman numerals are
//represented by seven
//different symbols: I, V, X,
//L, C, D and M.
//⮚ Symbol Value
//I 1
//V 5
//X 10
//L 50
//C 100
//D 500
//M 1000
//Please test your solution here : https://leetcode.com/problems/intersection-of-two-linked-lists/
//⮚ For example, 2 is written as II in Roman numeral, just two ones
//added together. 12 is written as XII, which is simply X + II. The
//number 27 is written as XXVII, which is XX + V + II.
//⮚ Roman numerals are usually written largest to smallest from
//left to right. However, the numeral for four is not IIII. Instead,
//the number four is written as IV. Because the one is before the
//five we subtract it making four. The same principle applies to
//the number nine, which is written as IX. There are six instances
//where subtraction is used:
//I can be placed before V (5) and X (10) to make 4 and 9.
//X can be placed before L (50) and C (100) to make 40 and 90.
//C can be placed before D (500) and M (1000) to make 400 and
//900.
//⮚ Given a roman numeral, convert it to an integer.
public static void main(String[] args) {

    int result= romanToInt("IV");
    System.out.println(result);

    int result2= convertRomanToInt("MCMXV");
    int result3= convertRomanToInt("V");
    System.out.println(result2);
    System.out.println(result3);
}


    public static int romanToInt(String str) {

        try {
            if (str.length() > 15 || str.length() < 1)
                throw new RuntimeException("String should not be less than 1 and greater than 15 characters");

        } catch (RuntimeException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        if (str.equals(str.toLowerCase())){
             str=str.toUpperCase();
        }

        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);


        for (int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);

            if (i > 0 && map.get(character) > map.get(str.charAt(i - 1))) {
                char prevChar = str.charAt(i - 1);
                res += map.get(character) - 2 * map.get(prevChar);
            } else
                res += map.get(character);

        }
        return res;
    }
    public static int convertRomanToInt(String s) {
        Map<Character, Integer> map=new HashMap<>();

        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        s = s.replace("IV","IIII");
        s = s.replace("IX","VIIII");
        s = s.replace("XL","XXXX");
        s = s.replace("XC","LXXXX");
        s = s.replace("CD","CCCC");
        s = s.replace("CM","DCCCC");
        int number = 0;

        for (int i = 0; i < s.length(); i++){

            number = number + (map.get(s.charAt(i)));
        }
        return number;
    }

    }

