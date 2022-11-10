package beakjoon.pm2156;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int[][] d = new int[10001][3];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int k = 0; k < 3; k++) {
                if (d[i-1][k] > max) {
                    max = d[i-1][k];
                }
            }
            d[i][0] += max;
            d[i][1] += d[i - 1][0] + a[i];
            d[i][2] += d[i - 1][1] + a[i];
        }
        int answer = 0;
        for (int i = 0; i < 3; i++) {
            if (answer < d[n][i]) {
                answer = d[n][i];
            }
        }
        System.out.println(answer);
    }
}
