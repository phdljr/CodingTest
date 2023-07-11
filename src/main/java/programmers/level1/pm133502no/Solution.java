package programmers.level1.pm133502no;

import java.util.Stack;

public class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        boolean[] checkArr = new boolean[4];

        for(int i=0;i<ingredient.length;i++){
            stack.push(ingredient[i]);
            answer += check(stack, checkArr);
        }

        return answer;
    }

    public static int check(Stack<Integer> stack, boolean[] checkArr){

        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,1,2,3,1,2,3,1};
        System.out.println(new Solution().solution(arr));
    }
}
