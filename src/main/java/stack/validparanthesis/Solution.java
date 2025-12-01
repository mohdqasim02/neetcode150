package stack.validparanthesis;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> parentheses = new Stack<>();

        for (Character c : s.toCharArray()) {
            try {
                switch (c) {
                    case ')' -> {
                        char openBracket = parentheses.pop();
                        if (openBracket != '(') return false;
                    }
                    case ']' -> {
                        char openBracket = parentheses.pop();
                        if (openBracket != '[') return false;
                    }
                    case '}' -> {
                        char openBracket = parentheses.pop();
                        if (openBracket != '{') return false;
                    }
                    default -> parentheses.push(c);
                }
            } catch (Exception e) {
                return false;
            }
        }

        return parentheses.isEmpty();
    }
}