package com.grzegorz.algorithms.codility;

import java.util.Stack;

public class MultipleBrackets {

    public int solution(String s) {
        if (s.isEmpty()) {
            return 1;
        }

        int len = s.length();
        if (len % 2 != 0) {
            return 0;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char current = s.charAt(i);
            if (isOpening(current)) {
                stack.push(current);
            } else {
                if (stack.empty()) {
                    return 0;
                }
                char opening = stack.pop();
                char[] pair = new char[]{opening, current};
                if (!matches(new String(pair))) {
                    return 0;
                }
            }
        }
        if (!stack.empty()) {
            return 0;
        }

        return 1;
    }

    private boolean isOpening(char c) {
        return c == '{' || c == '[' || c == '(';
    }

    private boolean matches(String pair) {
        return pair.equals("{}")
                || pair.equals("()")
                || pair.equals("[]");
    }
}