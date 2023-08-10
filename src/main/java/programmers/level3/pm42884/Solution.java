package programmers.level3.pm42884;

import java.util.Arrays;

public class Solution {
    public int solution(int[][] r) {
        int answer = 0;

        Arrays.sort(r, (a, b) -> a[1] - b[1]);

        int before = -50000;

        for(int i=0;i<r.length;i++){
            if(before < r[i][0]){
                before = r[i][1];
                answer++;
            }
        }

        return answer;
    }
}
