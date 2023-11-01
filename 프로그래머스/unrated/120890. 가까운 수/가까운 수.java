import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        Arrays.sort(array);
        
        int gap = Math.abs(array[0] - n);
        answer = array[0];
        for(int num: array){
            if(gap > Math.abs(num - n)){
                gap = Math.abs(num - n);
                answer = num;
            }
        }
        return answer;
    }
}