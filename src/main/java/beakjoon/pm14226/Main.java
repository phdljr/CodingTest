package beakjoon.pm14226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] d;
    static int n;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        d = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                d[i][j] = -1;
            }
        }
        d[1][0] = 0;
        bfs();

        int ans = -1;
        for(int i=0;i<=n;i++){
            if(ans == -1 || ans > d[n][i]){
                ans = d[n][i];
            }
        }

        System.out.println(ans);
    }

    private static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(0);
        while (!q.isEmpty()){
            int s = q.remove();
            int c = q.remove();
            // 클립보드 저장
            if(d[s][s] == -1){
                d[s][s] = d[s][c] + 1;
                q.add(s); q.add(s);
            }
            // 복붙
            if(s+c <= n && d[s+c][c] == -1){
                d[s+c][c] = d[s][c] + 1;
                q.add(s+c); q.add(c);
            }
            // 삭제
            if(s-1 >= 0 && d[s-1][c] == -1){
                d[s-1][c] = d[s][c] + 1;
                q.add(s-1); q.add(c);
            }
        }
    }
}
