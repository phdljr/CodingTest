package beakjoon.pm1149;

import java.util.Scanner;

public class Main {

    static long[][] d = new long[1001][10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for(int i=0;i<10;i++){
            d[1][i] = 1;
        }
        for(int i=1;i<=n;i++){
            for(int j=0;j<10;j++){
                for(int k=0;k<=j;k++){
                    d[i][j] += d[i-1][k];
                    d[i][j] %= 10007;
                }
            }
        }

        long answer = 0;
        for(int i=0;i<10;i++){
            answer += d[n][i];
            answer %= 10007;
        }
        System.out.println(answer);
    }
}


