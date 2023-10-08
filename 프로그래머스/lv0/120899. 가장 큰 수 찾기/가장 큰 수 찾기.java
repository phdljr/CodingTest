import java.util.*;

class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        int max = 0;
        for(int i=0;i<array.length;i++){
            if(max < array[i]){
                max = array[i];
                answer[1] = i;
            }
        }
        answer[0] = array[answer[1]];
        return answer;
    }
}
