package beakjoon.pm7576;

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
    static Queue<Pair> q = new LinkedList();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt(); sc.nextLine();
        a = new int[n][m];
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(s[j]);
                dist[i][j] = -1;
                if(a[i][j] == 1){
                    dist[i][j] = 0;
                    q.add(new Pair(i, j));
                }
            }
        }
        bfs();

        int answer = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(answer < dist[i][j]){
                    answer = dist[i][j];
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j] == 0 && dist[i][j] == -1){
                    answer = -1;
                    System.out.println(answer);
                    return;
                }
            }
        }

        System.out.println(answer);
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for(int i=0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(0 <= nx && nx < n && 0 <= ny && ny < m){
                    if(a[nx][ny] == 0 && dist[nx][ny] == -1){
                        q.add(new Pair(nx, ny));
                        dist[nx][ny] = dist[x][y] + 1;
                    }
                }
            }
        }
    }
}


