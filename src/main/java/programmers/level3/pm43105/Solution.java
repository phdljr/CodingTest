package programmers.level3.pm43105;

public class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;

        for(int i=1;i<triangle.length;i++){
            for(int j=0;j<triangle[i].length;j++){
                if(j == 0){
                    triangle[i][0] += triangle[i-1][0];
                } else if(j == i){
                    triangle[i][i] += triangle[i-1][i-1];
                } else{
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                }
            }
        }

        for(int i=0;i<triangle.length;i++){
            if(answer < triangle[triangle.length - 1][i]){
                answer = triangle[triangle.length - 1][i];
            }
        }

        return answer;
    }
}
