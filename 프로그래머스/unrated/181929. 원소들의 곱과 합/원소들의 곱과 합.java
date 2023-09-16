import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int sumPow = (int)Math.pow(Arrays.stream(num_list).sum(), 2);
        int mul = Arrays.stream(num_list).reduce(1, (a, b) -> a*b);
        return mul < sumPow ? 1 : 0;
    }
}