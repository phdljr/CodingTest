package beakjoon.pm11048;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        int[] dx = {-1, 0, -1};
        int[] dy = {0, -1, -1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int max = 0;
                for (int k = 0; k < 3; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                        if (max < map[nx][ny]) {
                            max = map[nx][ny];
                        }
                    }
                }

                map[i][j] += max;
            }
        }

        bw.write(map[n - 1][m - 1] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}


