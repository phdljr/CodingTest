package beakjoon.pm16931no;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int res = 0;
        // 위, 아래
        res += n * m * 2;

        // 동 - 서 * 2
        for (int i = 0; i < n; i++) {
            // 각 행마다 최댓값 찾기
            int max = 0;
            for (int j = 0; j < m; j++) {
                if (max < a[i][j]) {
                    max = a[i][j];
                }
            }
            res += max * 2;
        }

        // 남 - 북 * 2
        for (int i = 0; i < n; i++) {
            // 각 행마다 최댓값 찾기
            int max = 0;
            for (int j = 0; j < m; j++) {
                if (max < a[j][i]) {
                    max = a[j][i];
                }
            }
            res += max * 2;
        }

        System.out.println(res);
    }
}
