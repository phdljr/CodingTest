import java.util.Stack;

class Solution {
     boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(stack.empty()) {
                stack.push(c);
                continue;
            }
            if(isOpenAndClose(stack.peek(), c))
                stack.pop();
            else
                stack.push(c);
        }

        if(stack.size() != 0) {
            answer = false;
        }

        return answer;
    }

    private boolean isOpenAndClose(Character peek, char c) {
        if(peek == '(' && c == ')')
            return true;
        return false;
    }
}