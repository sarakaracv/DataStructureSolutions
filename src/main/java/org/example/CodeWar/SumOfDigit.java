package org.example.CodeWar;

import java.util.stream.Stream;

public class SumOfDigit {
    public static void main(String[] args) {
        int a = 51;
        //  System.out.println(SumOfDigits(a));
        //  System.out.println(SumOfDigitWithoutRecursion(a));
        // System.out.println(sum(a));
        //  System.out.println(getSum(a));
        //  System.out.println(digital_root(a));
       // System.out.println(addDigits(a));
        System.out.println(digital_root1(a));
    }

    public int addDigits11(int num) {
        int sum = 0;

        if (num < 1) return num;

        sum += num % 10 + addDigits11(num / 10);

        if (sum > 9) {
            return addDigits11(sum);
        }

        return sum;

    }
    public static int digital_root1(int n) {
        return (n != 0 && n%9 == 0) ? 9 : n % 9;
    }
    public static int SumOfDigits(int a) {
        if (a == 0) return 0;
        else if (a < 10) return a;
        else return a % 10 + SumOfDigits(a / 10);
    }

    public static int SumOfDigitWithoutRecursion(int a) {
        int sum = 0;
        if (a == 0) return 0;
        while (a != 0) {
            sum += a % 10;
            a /= 10;
        }
        return sum;
    }

    public static int sum1(int n) {
        int sum = 0;
        if (n > 0) {
            sum += n % 10;
            return sum + sum1(n / 10);
        } else return 0;
    }

    public static int getSum(int input) {  //example: input=246
        if (input % 10 == input) { //246%10=6;
            return input % 10; //2%10=2
        }

        return input % 10 + getSum((input - input % 10) / 10); //(246-6)/10=24; 24%10=4
    }

    public static int digital_root2(int n) {
        if(n%10==n) return n%10;
        else if(n<10) return n;
        else if(n==0) return 0;
        else if(n<0) return -1;
        else {return n%10+digital_root2(n/10);}

    }

    private static int sumOfDigitsOfPositive(int n) {
        if (n < 10) {
            return n;
        } else {
            long lastDigit = n % 10;
            return (int)lastDigit + sumOfDigitsOfPositive(n / 10);
        }
    }
    public static int addDigits(int num) {
        if (num < 0)
            return -1;
        if (num == 0)
            return 0;
        if (num % 9 == 0)
            return 9;
        else
            return num%9;

    }
    public static int digital_root3(int n) {//pass all test
        String numString = String.valueOf(n);
        if(numString.length()==1)
            return n;
        n = 0;
        for(int i = 0; i< numString.length();i++){
            n+= Integer.parseInt(Character.toString(numString.charAt(i)));
        }
        return digital_root3(n);
    }

    public static int digital_root(int n) {// pass everywhere
        while(n > 9){
            n = n/10 + n % 10;
        }
        return(n);
    }

    public static int digital_root8(int n) {

        if (String.valueOf(n).length() > 1) {
            int digitSum = 0;
            String numAsString = String.valueOf(n);

            for (int i = 0; i < numAsString.length(); i++) {
                int digit = Character.getNumericValue(numAsString.charAt(i));
                digitSum += digit;
            }
            return digital_root8(digitSum);
        }

        else  {
            return n;
        }
    }
    public int addDigits3(int num) {
        if(num < 10)
            return num;
        int sum1 = 0;
        for(char C : Integer.toString(num).toCharArray()){
            sum1 += Character.getNumericValue(C);
        }
        return addDigits3(sum1);
    }
    public static int digital_root10(int n) {
        return --n % 9 + 1;
    }
    public static int digital_root11(int n) {
        final int result1 = String.valueOf(n).chars().reduce(0, (acc, curr) -> acc + (curr - '0'));
        return result1 < 10 ? result1 : digital_root(result1);
    }
    public static int digital_root12(int n) {
        if (n < 10)
            return n;

        int dr = 0;
        while (n >= 1) {
            dr += n % 10;
            n = n / 10;
        }

        return digital_root12(dr);
    }
    public static int digital_root13(int n) {
        if (n < 10) {
            return Stream.of(String.valueOf(n).split(""))
                    .mapToInt(Integer::parseInt)
                    .sum();
        } else {
            return digital_root13(Stream.of(String.valueOf(n).split(""))
                    .mapToInt(Integer::parseInt)
                    .sum());
        }
    }

    public static int digital_root14(int n) {

        if (n < 10) {
            return n;
        }

        int sum = 0;

        while (n > 0) {

            sum += n % 10;
            n   /= 10;

        }

        return digital_root14(sum);

    }
}
