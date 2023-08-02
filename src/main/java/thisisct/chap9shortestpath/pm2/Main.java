package thisisct.chap9shortestpath.pm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] str = in.readLine().split(" ");
        int n = Integer.parseInt(str[0]); // 노드 개수
        int m = Integer.parseInt(str[1]); // 경로 개수
        int INF = (int)1e9;

        int[][] graph = new int[n+1][n+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(graph[i], INF);
        }

        for(int i=1;i<=n;i++){
            graph[i][i] = 0;
        }

        for(int i=0;i<m;i++){
            str = in.readLine().split(" ");
            int from = Integer.parseInt(str[0]);
            int to = Integer.parseInt(str[1]);
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        str = in.readLine().split(" ");
        int X = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                for(int k=1;k<=n;k++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int answer = graph[1][K] + graph[K][X] >= INF ? -1 : graph[1][K] + graph[K][X];
        System.out.println(answer);
    }
}
