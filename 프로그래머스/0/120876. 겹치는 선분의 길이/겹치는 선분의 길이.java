import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        for(int i=0;i<lines.length;i++){
            lines[i][0] += 100;
            lines[i][1] += 100;
        }
        
        int[] d = new int[201];
        
        for(int i=0;i<lines.length;i++){
            int start = lines[i][0];
            int end = lines[i][1];
            for(int j=start;j<end;j++){
                d[j]++;
            }
        }
        
        for(int i=0;i<d.length;i++){
            if(d[i] >= 2){
                answer++;
            }
        }
        
        
        return answer;
    }
}