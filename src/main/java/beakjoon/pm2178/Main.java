package beakjoon.pm2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static int[][] a;
    static int[][] dist;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt(); sc.nextLine();
        a = new int[n][m];
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split("");
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(s[j]);
                dist[i][j] = -1;
            }
        }

        bfs(0, 0);
        System.out.println(dist[n-1][m-1]);
    }

    private static void bfs(int x, int y) {
        Queue<Pair> q = new LinkedList();
        q.add(new Pair(x, y));
        dist[x][y] = 1;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            x = p.x;
            y = p.y;
            for(int i=0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(0 <= nx && nx < n && 0 <= ny && ny < m){
                    if(a[nx][ny] == 1 && dist[nx][ny] == -1){
                        q.add(new Pair(nx, ny));
                        dist[nx][ny] = dist[x][y] + 1;
                    }
                }
            }
        }
    }
}


