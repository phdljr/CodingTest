package beakjoon.pm2667;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Re {

    static int[] dx = {-1, 1, 0 ,0};
    static int[] dy = {0, 0, -1 ,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); sc.nextLine();
        int[][] a = new int[n][n];
        int[][] d = new int[n][n];
        for(int i=0;i<n;i++){
            String[] split = sc.nextLine().split("");
            for(int j=0;j<n;j++){
                a[i][j] = Integer.parseInt(split[j]);
            }
        }

        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(a[i][j] == 1 && d[i][j] == 0){
                    bfs(a, d, ++cnt, i, j, n);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(d[i][j]);
            }
            System.out.println();
        }

    }

    private static void bfs(int[][] a, int[][] d, int cnt, int x, int y, int n) {
        Queue<Pair> q = new LinkedList();
        q.add(new Pair(x, y));
        d[x][y] = cnt;
        while (!q.isEmpty()){
            Pair p = q.remove();
            x = p.x;
            y = p.y;
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(0 <= nx && nx < n && 0 <= ny && ny < n){
                    if(a[nx][ny] == 1 && d[nx][ny] == 0) {
                        q.add(new Pair(nx, ny));
                        d[nx][ny] = cnt;
                    }
                }
            }
        }
    }
}
