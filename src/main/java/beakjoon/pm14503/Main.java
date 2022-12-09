package beakjoon.pm14503;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        int x = sc.nextInt();
        int y = sc.nextInt();

        // 시계방향
        // 0 1 2 3 : 북 동 남 서
        int dir = sc.nextInt();

        // 빈칸은 0, 벽은 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int count = 0;
        while (true) {
            // 1. 현재 위치를 청소한다.
            if (arr[x][y] == 0) {
                arr[x][y] = -1;
                count++;
            }
            // 청소를 하지 않는다 (2-3, 2-4)
            if (arr[x - 1][y] != 0 && arr[x + 1][y] != 0 && arr[x][y - 1] != 0 && arr[x][y + 1] != 0) {
                if (arr[x - dx[dir]][y - dy[dir]] == 1) {
                    break;
                } else {
                    x -= dx[dir];
                    y -= dy[dir];
                }
            } else {
                // 청소를 한다(2-1, 2-2)
                dir = (dir + 3) % 4;
                if(arr[x+dx[dir]][y+dy[dir]] == 0){
                    arr[x+dx[dir]][y+dy[dir]] = -1;
                    x += dx[dir];
                    y += dy[dir];
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
