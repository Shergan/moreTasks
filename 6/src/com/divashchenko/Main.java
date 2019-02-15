package com.divashchenko;

/*
6. Баланс скобок. Дана конечная последовательность, состоящая из левых и правых скобок различных заданных типов.
Определить, можно ли добавить в нее цифры и знаки арифметических действий так, чтобы получилось правильное арифметическое выражение.
 */


import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {

        String str1 = "(";
        String str2 = "))";
        String str3 = "[}";
        String str4 = "{}";
        String str5 = "(){}[]";
        String str6 = "({[]}{})";
        String str7 = "[({}())[]";

        System.out.println(str1 + "  " + checkBrackets(str1));
        System.out.println(str2 + "  " + checkBrackets(str2));
        System.out.println(str3 + "  " + checkBrackets(str3));
        System.out.println(str4 + "  " + checkBrackets(str4));
        System.out.println(str5 + "  " + checkBrackets(str5));
        System.out.println(str6 + "  " + checkBrackets(str6));
        System.out.println(str7 + "  " + checkBrackets(str7));

    }

    private static boolean checkBrackets(String str) {
        Deque<Character> stack = new ArrayDeque<>();

        try {
            for (int i = 0; i < str.length(); i++) {
                char tmp = str.charAt(i);
                if (tmp == '(' || tmp == '[' || tmp == '{') {
                    stack.push(tmp);
                } else if (tmp == ')' && stack.peek() == '(') {
                    stack.poll();
                } else if (tmp == ']' && stack.peek() == '[') {
                    stack.poll();
                } else if (tmp == '}' && stack.peek() == '{') {
                    stack.poll();
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }

        return stack.size() == 0;
    }
}
