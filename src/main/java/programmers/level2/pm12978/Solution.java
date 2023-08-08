package programmers.level2.pm12978;

import java.util.*;

public class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            Arrays.fill(map[i], (int)1e9);
            map[i][i] = 0;
        }

        for(int i=0;i<road.length;i++){
            int from = road[i][0];
            int to = road[i][1];
            int cost = road[i][2];
            map[from][to] = Math.min(map[from][to], cost);
            map[to][from] = Math.min(map[to][from], cost);
        }

        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        for(int i=1;i<=N;i++){
            if(map[1][i] <= K){
                answer++;
            }
        }

        return answer;
    }
}