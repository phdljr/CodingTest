package beakjoon.pm11049;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


class Matrix{
    int r;
    int c;

    Matrix(int r, int c){
        this.r = r;
        this.c = c;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Matrix[] m = new Matrix[n+1];
        for(int i=1;i<=n;i++) {
            String[] str = br.readLine().split(" ");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            m[i] = new Matrix(r, c);
        }

        // dp[i][j]: i부터 j까지의 최소 연산 횟수
        int[][] dp = new int[n+1][n+1];

        for(int d=1;d<=n;d++) { // 행렬 간의 간격
            for(int i=1;i+d<=n;i++) { // 시작 행렬
                int j = i + d; // 끝 행렬
                dp[i][j] = Integer.MAX_VALUE;

                for(int k=i;k<j;k++) { // 분할 지점
                    int cost = dp[i][k] + dp[k+1][j] + m[i].r * m[k].c * m[j].c;
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        bw.write(dp[1][n] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}