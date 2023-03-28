package org.example.leetCodeTask;

import java.util.Stack;

public class BasicCalculatorII227 {

        public int calculate1(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            Stack<Integer> stack = new Stack<>();
            int num = 0;
            char sign = '+';
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                }
                if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                    if (sign == '+') {
                        stack.push(num);
                    } else if (sign == '-') {
                        stack.push(-num);
                    } else if (sign == '*') {
                        stack.push(stack.pop() * num);
                    } else if (sign == '/') {
                        stack.push(stack.pop() / num);
                    }
                    sign = c;
                    num = 0;
                }
            }
            int result = 0;
            for (int n : stack) {
                result += n;
            }
            return result;
        }
    public int calculate2(String s) {
        char sign = '+';
        int preSum = 0;
        int num = 0;
        int lastNum = 0;

        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c == ' ') {
                // do nothing
            } else {
                switch (sign) {
                    case '+' -> {
                        preSum+= lastNum;
                        lastNum = num;
                    }
                    case '-' -> {
                        preSum += lastNum;
                        lastNum = -num;
                    }
                    case '*' -> lastNum *= num;
                    case '/' -> lastNum /= num;
                }
                num = 0;
                sign = c;
            }
        }

        switch (sign) {
            case '+' -> {
                preSum+= lastNum;
                lastNum = num;
            }
            case '-' -> {
                preSum += lastNum;
                lastNum = -num;
            }
            case '*' -> lastNum *= num;
            case '/' -> lastNum /= num;
        }

        return preSum + lastNum;
    }
    }
