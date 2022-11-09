package beakjoon.pm10844;

import java.util.Scanner;

public class Main {
    static int[][] d = new int[101][10];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mod = 1000000000;
        for(int i=1;i<=9;i++){
            d[1][i] = 1;
        }
        for(int i=2;i<=n;i++){
            for(int j=0;j<=9;j++){
                d[i][j] = 0;
                if(j-1 >= 0){
                    d[i][j] += d[i-1][j-1];
                }
                if(j+1 <= 9){
                    d[i][j] += d[i-1][j+1];
                }
                d[i][j] %= mod;
            }
        }
        long answer = 0;
        for(int i=0;i<=9;i++){
            answer += d[n][i];
        }
        System.out.println(answer%mod);
    }
}
