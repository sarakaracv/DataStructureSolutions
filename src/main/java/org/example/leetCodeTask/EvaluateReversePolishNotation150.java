package org.example.leetCodeTask;

import java.util.Stack;

public class EvaluateReversePolishNotation150 {

        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();

            for (String token : tokens) {
                if (token.equals("+")) {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a + b);
                } else if (token.equals("-")) {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                } else if (token.equals("*")) {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a * b);
                } else if (token.equals("/")) {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b);
                } else {
                    stack.push(Integer.parseInt(token));
                }
            }

            return stack.pop();
        }
    private int idx;

    public int evalRPN2(String[] tokens) {
        idx = tokens.length - 1;
        return eval(tokens);
    }

    public int eval(String[] tokens) {
        var i = idx;
        var op = tokens[idx--];
        int operand1, operand2;
        switch (op) {
            case "+":
                return eval(tokens) + eval(tokens);
            case "-":
                operand2 = eval(tokens);
                operand1 = eval(tokens);
                return operand1 - operand2;
            case "*":
                return eval(tokens) * eval(tokens);
            case "/":
                operand2 = eval(tokens);
                operand1 = eval(tokens);
                return operand1 / operand2;
            default:
                return Integer.parseInt(tokens[i]);
        }
    }
    public int evalRPN3(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        String ops = "+-/*";
        for(String s : tokens){
            if(ops.indexOf(s) == -1){
                stack.push(Integer.valueOf(s));
            }else{
                if(stack.size() < 2){
                    throw new RuntimeException("Invalid expression");
                }
                int second = stack.pop();
                int first = stack.pop();
                int res = 0;
                char op = s.charAt(0);
                switch(op){
                    case '+':
                        res = first + second;
                        break;
                    case '-':
                        res = first - second;
                        break;
                    case '*':
                        res = first * second;
                        break;
                    case '/':
                        //exceptions.
                        res = first/second;
                        break;
                    default:
                        throw new RuntimeException("Invalid operation");
                }
                stack.push(res);
            }

        }
        return stack.pop();
    }
}
