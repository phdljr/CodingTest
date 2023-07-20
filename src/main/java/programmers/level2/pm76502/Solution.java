package programmers.level2.pm76502;

import java.util.Stack;

public class Solution {
    public int solution(String s) {
        int answer = 0;

        int len = s.length();
        for(int i=0;i<len;i++){
            s = s.substring(1, s.length()) + s.charAt(0);
            Stack<Character> stack = new Stack<>();
            for(int j=0;j<len;j++){
                char ch = s.charAt(j);
                if(!stack.empty()){
                    char top = stack.peek();
                    stack.push(ch);
                    if(top == '(' && ch == ')'){
                        stack.pop();
                        stack.pop();
                    } else if(top == '{' && ch == '}'){
                        stack.pop();
                        stack.pop();
                    }else if(top == '[' && ch == ']'){
                        stack.pop();
                        stack.pop();
                    }
                } else{
                    stack.push(ch);
                }
            }
            if(stack.empty())
                answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("[)(]"));
    }
}