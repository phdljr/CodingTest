import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();

        for (char digit : number.toCharArray()) {
            // k가 남아있고, 스택이 비어있지 않으며, 스택 top이 현재 숫자보다 작으면 제거
            while (k > 0 && !stack.isEmpty() && stack.peek() < digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // 아직 제거할 수가 남았다면 뒤에서 제거
        while (k-- > 0) {
            stack.pop();
        }

        // 스택에 있는 숫자들을 문자열로 이어붙임
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}