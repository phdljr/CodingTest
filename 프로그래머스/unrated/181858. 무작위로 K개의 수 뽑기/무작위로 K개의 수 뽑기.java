import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        Arrays.fill(answer, -1);
        int i = 0;
        for(int n: Arrays.stream(arr).distinct().toArray()){
            answer[i++] = n;
            if(i == answer.length){
                break;
            }
        }
        return answer;
    }
}