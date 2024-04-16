import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for(int i=0;i<queries.length;i++){
            int min = 10000001;
            for(int j=queries[i][0]; j<=queries[i][1]; j++){
                int k = queries[i][2];
                if(min > arr[j] & arr[j] > k){
                    min = arr[j];
                }
            }
            if(min == 10000001){
                answer[i] = -1;
            } else{
                answer[i] = min;    
            }
        }
        return answer;
    }
}