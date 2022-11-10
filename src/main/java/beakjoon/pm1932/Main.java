package beakjoon.pm1932;

import java.util.Scanner;

public class Main {
    static long[][] d = new long[501][501];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] a = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            String[] s = sc.nextLine().split(" ");
            for(int j=1;j<=i;j++){
                a[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        d[1][1] = a[1][1];
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                if(d[i][j] < d[i-1][j] + a[i][j]){
                    d[i][j] = d[i-1][j] + a[i][j];
                }
                if(d[i][j] < d[i-1][j-1] + a[i][j]){
                    d[i][j] = d[i-1][j-1] + a[i][j];
                }
            }
        }

        long max = 0;
        for(int i=1;i<=n;i++){
            if(max < d[n][i]){
                max = d[n][i];
            }
        }
        System.out.println(max);
    }
}
