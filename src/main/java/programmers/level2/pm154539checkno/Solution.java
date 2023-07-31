package programmers.level2.pm154539checkno;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[numbers.length];

        Arrays.fill(answer, -1); // 초기값을 -1로 세팅

        for (int i = 0; i < numbers.length; i++) {
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        new Solution().solution(new int[]{9,1,5,3,6,2});
    }
}