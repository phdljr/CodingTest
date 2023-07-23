package programmers.level2.pm43165;

public class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        go(numbers, target, 0, 0);
        return answer;
    }

    public void go(int[] numbers, int target, int sum, int index){
        if(sum == target && index == numbers.length){
            answer++;
            return;
        }

        if(index == numbers.length){
            return;
        }

        go(numbers, target, sum+numbers[index], index+1);
        go(numbers, target, sum-numbers[index], index+1);
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        System.out.println(new Solution().solution(arr, 3));
    }
}