package org.example.DataStructure;

import java.util.*;

public class MaximumNumericValue {
    // Driver method
    public static void main(String[] args) {
        String str = "100klh564abc365bg";
        String str2 = "gt12cty65mt1";
        System.out.println(extractMaximum(str));


    }
    // Method to extract the maximum value
    /*
    It declares 2 variables, 1 for collecting the number from the string and 1 more for the result.  It’s looping through the string and checking if the character is digit or not.  
If it’s a digit it does the following ( num = num * 10 + (str.charAt(i)-‘0’); ) - Assuming we have this string "gt12cty65mt1" - the first number is 12 so the first digit is 1. Our  " num is 0 ",  so the  " num * 10 "  will return 0, the second half - " (str.charAt(i)-‘0’)  " - it's doing a mathematical operation. In the ascii table ‘0’ stands at 48 and 1 stands at 49 so it’s calculating 49-48 and getting the result as 1 and assigning to num. The next digit is 2, so this time it does 1 * 10 + (50 - 48)  so the num turns 12.
After this - the next character is a string so it’s trying to find the maximum of the number and result and it’s assigning the num to 0 again to repeat the process.
I hope this helpsFor this part " (str.charAt(i)-‘0’)  " - whenever we do a mathematical operation with chars it does it by taking the indexes of those characters from the Ascii table.
     */
    public static int extractMaximum(String str) {

        int num = 0, res = 0;
        // Start traversing the given string

        for (int i = 0; i<str.length(); i++) {

            // If a numeric value comes, start converting

            // it into an integer till there are consecutive

            // numeric digits

            if (Character.isDigit(str.charAt(i)))

                num = num * 10 + (str.charAt(i)-'0');
            // Update maximum value

            else {
                res = Math.max(res, num);
              // Reset the number
                num = 0;
            }
        }
        // Return maximum value
        return Math.max(res, num);

    }
    public static int maxNumber(String str) {

        str = str.replaceAll("[^\\d]", " ");

        int max = 0;
        for (String each : (str.split(" "))) {
            if (!each.isEmpty() && Integer.parseInt(each) > max) {
                max = Integer.parseInt(each);
            }
        }
        return max;
    }

    //letter candle
//    String letter = "bacacc";
//    int m = 2;
//    long output = 0;
//    String[] arr = letter.split("");
//    ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
//    Set<Integer> numList = new TreeSet<>();
//        for (String each : list) {
//        int countChar = Collections.frequency(list, each);
//        numList.add(countChar);
//    }
//    int maxValue = Collections.max(numList);
//        for (Integer each : numList) {
//        if (each == maxValue){
//            each-=m;
//        }
//        output=output+each*each;
//    }
//        System.out.println(output);

}
