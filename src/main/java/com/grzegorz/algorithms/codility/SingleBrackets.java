package com.grzegorz.algorithms.codility;

import java.util.Stack;

public class SingleBrackets {

    public int solution(String s) {
        if (s.isEmpty()) {
            return 1;
        }

        int len = s.length();
        if (len % 2 != 0) {
            return 0;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return 0;
                }
                stack.pop();
            }
        }

        if (!stack.empty()) {
            return 0;
        }
        return 1;
    }
}
