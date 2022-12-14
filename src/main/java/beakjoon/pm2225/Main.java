package beakjoon.pm2225;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static long[][] d = new long[201][201];
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        d[0][0] = 1L;
        for(int i=1;i<=k;i++){
            for(int j=0;j<=n;j++){
                for(int l=0;l<=j;l++){
                    d[i][j] += d[i-1][j-l];
                    d[i][j] %= 1000000000;
                }
            }
        }
        System.out.println(d[k][n]);
    }
}
