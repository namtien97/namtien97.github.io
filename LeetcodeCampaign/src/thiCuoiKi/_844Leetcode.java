package thiCuoiKi;

import java.util.Stack;

public class _844Leetcode {
    static public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack1 = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#' && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(S.charAt(i));
            }
        }
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#' && !stack.isEmpty()) {
                stack1.pop();
            } else {
                stack1.push(T.charAt(i));
            }
        }
        if (stack.equals(stack1)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String S = "ab#c";
        String T = "#a#c";
        System.out.println(backspaceCompare(S, T));
    }
}
