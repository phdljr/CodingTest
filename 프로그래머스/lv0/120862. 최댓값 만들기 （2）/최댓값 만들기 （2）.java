import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int n1 = numbers[numbers.length-1] * numbers[numbers.length-2];
        int n2 = numbers[0] * numbers[1];
        return n1 > n2 ? n1 : n2;
    }
}