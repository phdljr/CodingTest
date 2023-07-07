package programmers.level1.pm86491;

import java.util.Arrays;

public class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int wMax = 0, hMax = 0, wi, hi;

        for(int i=0;i<sizes.length;i++)
            Arrays.sort(sizes[i]);

        for(int i=0;i<sizes.length;i++){
            if(wMax < sizes[i][0]){
                wMax = sizes[i][0];
            }
            if(hMax < sizes[i][1]){
                hMax = sizes[i][1];
            }
        }

        return wMax * hMax;
    }
}
