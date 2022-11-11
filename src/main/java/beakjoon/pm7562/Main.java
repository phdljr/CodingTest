package beakjoon.pm7562;

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

    static final int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    static int[][] dist;
    static int l;
    static Queue<Pair> q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            q = new LinkedList();
            l = Integer.parseInt(sc.nextLine());
            dist = new int[l][l];
            for(int i=0;i<l;i++){
                for(int j=0;j<l;j++){
                    dist[i][j] = -1;
                }
            }

            String[] s = sc.nextLine().split(" ");
            int sx = Integer.parseInt(s[0]);
            int sy = Integer.parseInt(s[1]);
            q.add(new Pair(sx, sy));
            dist[sx][sy] = 0;

            s = sc.nextLine().split(" ");
            int ex = Integer.parseInt(s[0]);
            int ey = Integer.parseInt(s[1]);

            if(sx == ex && sy == ey){
                System.out.println(0);
                continue;
            }
            bfs(ex, ey);
            System.out.println(dist[ex][ey]);
        }
    }

    private static void bfs(int ex, int ey) {
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for(int i=0;i<8;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(0 <= nx && nx < l && 0 <= ny && ny < l){
                    if(dist[nx][ny] == -1){
                        q.add(new Pair(nx, ny));
                        dist[nx][ny] = dist[x][y] + 1;
                        if(nx == ex && ny == ey){
                            return;
                        }
                    }
                }
            }
        }
    }
}


