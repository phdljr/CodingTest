package thisisct.chap4simul.pm3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n, m, x, y, d;
        String[] s = in.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        int[][] map = new int[n][m];
        s = in.readLine().split(" ");
        x = Integer.parseInt(s[0]);
        y = Integer.parseInt(s[1]);
        d = Integer.parseInt(s[2]);

        for(int i=0;i<n;i++){
            s = in.readLine().split(" ");
            for (int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        map[x][y] = 1;
        int res = 1;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int nx = x;
        int ny = y;
        int count = 0;
        while (count != 4){
            d--;
            count++;
            if(d < 0){
                d = 3;
            }
            nx = x + dx[d];
            ny = y + dy[d];
            if(0 <= nx && nx < n && 0 <= ny && ny <= m){
                if(map[nx][ny] == 0){
                    map[nx][ny] = 1;
                    res++;
                    x = nx;
                    y = ny;
                    count = 0;
                }
            }
        }
        System.out.println(res);
    }
}
