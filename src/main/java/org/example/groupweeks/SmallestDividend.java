package org.example.groupweeks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SmallestDividend {
    public static void main(String[] args) {
        int[] arr1={2,3,5,12,32,24};
        Arrays.sort(arr1);
        int[] arr2=Arrays.copyOf(arr1,arr1.length-1);
        System.out.println(lcm(arr2));
    }
    private static int gcd(int a, int b)
    {
        while (b > 0)
        {
            int temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }
    private static int lcm(int a, int b)
    {
        return a * (b / gcd(a, b));
    }
    private static int lcm(int[] input)
    {
        int result = input[0];
        for(int i = 1; i < input.length; i++) result = lcm(result, input[i]);
        return result;
    }

/*https://www.baeldung.com/java-least-common-multiple
*https://stackoverflow.com/questions/4201860/how-to-find-gcd-lcm-on-a-set-of-numbers
 */


    public static int findMinK(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(arr);
        int number = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                return -1;
            }

            for (int j = 2; j <= arr[i]; j++) {
                int freq = 0;
                while (number % j == 0) {
                    number = number / j;
                    freq++;
                }

                if (freq != 0) {
                    if (!map.containsKey(j)) {
                        map.put(j, freq);
                    } else {
                        if (freq > map.get(j)) {
                            map.replace(j, freq);
                        }
                    }
                }
            }
            number = arr[i + 1];
        }
        int k = 1;
        for (Map.Entry<Integer, Integer> eachEntry : map.entrySet()) {
            k *= Math.pow(eachEntry.getKey(), eachEntry.getValue());
        }
        return k;
    }
}
