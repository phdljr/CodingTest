package beakjoon.pm14499;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 동 서 북 남 0 1 2 3
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int[] dice = {0, 0, 0, 0, 0, 0, 0};
        Scanner sc = new Scanner(System.in);
        int n, m, x, y, k;
        n = sc.nextInt();
        m = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        k = sc.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < k; i++) {
            int c = sc.nextInt();
            c--;

            if(0 <= x + dx[c] && x + dx[c] < n && 0 <= y + dy[c] && y + dy[c] < m) {

                if (c == 0) {// 동
                    int temp = dice[1];
                    dice[1] = dice[4];
                    dice[4] = dice[3];
                    dice[3] = dice[2];
                    dice[2] = temp;
                } else if (c == 1) { // 서
                    int temp = dice[1];
                    dice[1] = dice[2];
                    dice[2] = dice[3];
                    dice[3] = dice[4];
                    dice[4] = temp;
                } else if (c == 2) { // 북
                    int temp = dice[1];
                    dice[1] = dice[5];
                    dice[5] = dice[3];
                    dice[3] = dice[6];
                    dice[6] = temp;
                } else { // 남
                    int temp = dice[1];
                    dice[1] = dice[6];
                    dice[6] = dice[3];
                    dice[3] = dice[5];
                    dice[5] = temp;
                }

                x = x + dx[c];
                y = y + dy[c];

                if (arr[x][y] == 0) {
                    arr[x][y] = dice[3];
                } else {
                    dice[3] = arr[x][y];
                    arr[x][y] = 0;
                }

                System.out.println(dice[1]);
            }
        }
    }
}
