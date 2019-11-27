package leetcode_1249;

import java.util.Stack;

public class Solution_momo262_v0 {

    public String minRemoveToMakeValid(String s) {
        StringBuilder strBuilder = new StringBuilder(s);

        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    strBuilder.setCharAt(i,'1');
                } else {
                    stack.pop();
                }
            }
        }
        for (int index:stack) {
            strBuilder.setCharAt(index,'1');
        }
        s = strBuilder.toString();
        s = s .replaceAll("1","");
        return s;
    }

}
