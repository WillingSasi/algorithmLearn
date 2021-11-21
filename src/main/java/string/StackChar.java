package string;

import java.util.Stack;

/**
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 * 1.左括号入栈
 * 2.右括号入栈
 * 3.java string字符串替换
 */
public class StackChar {
    public static void main(String[] args) {
        String s = "[])";

        System.out.println(StackChar1(s));
    }

    /**
     *1.左括号入栈
     * @param s
     * @return
     */
    public static boolean StackChar1(String s) {
        if (s == null || s.length() <2) {
            return false;
        }

        Stack<Character> newStack = new Stack<Character>();
        for (int i = 0;i < s.length();i++) {
            if (s.charAt(i) == ')' && !newStack.isEmpty()){
                if (newStack.peek() == '('){
                    newStack.pop();
                }
            } else if (s.charAt(i) == ']' && !newStack.isEmpty()){
                if (newStack.peek() == '['){
                    newStack.pop();
                }
            }else if (s.charAt(i) == '}' && !newStack.isEmpty()){
                if (newStack.peek() == '{'){
                    newStack.pop();
                }
            } else {
                newStack.push(s.charAt(i));
            }
        }

        return newStack.isEmpty()? true:false;
    }

    /**
     *2.右括号入栈
     * @param s
     * @return
     */
    public static boolean StackChar2(String s) {
        if (s == null || s.length() <2) {
            return false;
        }

        int len = s.length();
        Stack<Character> newStack  = new Stack<Character>();
        for (int i = 0;i < len;i++) {
            if (s.charAt(i) == '(') {
                newStack.push(')');
            }else if (s.charAt(i) == '[') {
                newStack.push(']');
            }else if (s.charAt(i) == '{') {
                newStack.push('}');
            } else {
                if (newStack.isEmpty() || newStack.peek() != s.charAt(i)) {
                    return false;
                } else {
                    newStack.pop();
                }
            }
        }

        return newStack.isEmpty()? true:false;
    }

    /**
     *3.java string字符串替换
     * @param s
     * @return
     */
    public static boolean StackChar3(String s) {
        if (s == null || s.length() <2) {
            return false;
        }

        while (!s.equals("")) {
            if (s.contains("()")) {
                s = s.replace("()", "");
            } else if (s.contains("[]")) {
                s = s.replace("[]", "");
            }else if (s.contains("{}")) {
                s = s.replace("{}", "");
            } else {
                return false;
            }
        }

        return s.equals("") ? true:false;
    }
}
