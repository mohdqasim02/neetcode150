package stack.reversepolishnotation;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
    Set<String> operators = new HashSet<>();

    public int evalRPN(String[] tokens) {
        Stack<String> expression = new Stack<String>();

        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            if (operators.contains(token)) {
                int result = evaluate(expression, token);

                System.out.println("result " + result);

                expression.push(result + "");
            } else {
                expression.push(token);
            }
        }


        return Integer.parseInt(expression.pop());
    }

    private int evaluate(Stack<String> operands, String operator) {
        switch (operator) {
            case "+" -> {
                return add(operands);
            }
            case "-" -> {
                return subtract(operands);
            }
            case "*" -> {
                return multiply(operands);
            }
            case "/" -> {
                return divide(operands);
            }
        }

        return 0;
    }

    private int divide(Stack<String> operands) {
        if (operands.isEmpty()) return -1;

        int num1 = Integer.parseInt(operands.pop());
        int num2 = Integer.parseInt(operands.pop());

        return num2 / num1;
    }

    private int multiply(Stack<String> operands) {
        if (operands.isEmpty()) return -1;

        int num1 = Integer.parseInt(operands.pop());
        int num2 = Integer.parseInt(operands.pop());

        return num2 * num1;
    }

    private int subtract(Stack<String> operands) {
        if (operands.isEmpty()) return -1;

        int num1 = Integer.parseInt(operands.pop());
        int num2 = Integer.parseInt(operands.pop());

        return num2 - num1;
    }

    private int add(Stack<String> operands) {
        if (operands.isEmpty()) return -1;

        int num1 = Integer.parseInt(operands.pop());
        int num2 = Integer.parseInt(operands.pop());

        return num2 + num1;
    }
}
