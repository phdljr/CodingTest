package beakjoon.pm1261;

import java.beans.Encoder;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class Pair{
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int n;
    static int m;
    static int[][] a;
    static int[][] d;
    static int[] dx = {-1, 1, 0 ,0};
    static int[] dy = {0, 0, -1 ,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt(); sc.nextLine();
        d = new int[n+1][m+1];
        a = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            String[] s = sc.nextLine().split("");
            for(int j=1;j<=m;j++){
                a[i][j] = Integer.parseInt(s[j-1]);
                d[i][j] = -1;
            }
        }

        bfs();
        System.out.println(d[n][m]);
    }

    static void bfs(){
        Deque<Pair> dq = new LinkedList<>();
        d[1][1] = 0;
        dq.addFirst(new Pair(1, 1));
        while (!dq.isEmpty()){
            Pair p = dq.removeFirst();
            for(int i=0;i<4;i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if(1 <= x && x <= n && 1 <= y && y <= m){
                    if(d[x][y] == -1 && a[x][y] == 0){
                        dq.addFirst(new Pair(x, y));
                        d[x][y] = d[p.x][p.y];
                    }
                    if(d[x][y] == -1 && a[x][y] == 1){
                        dq.addLast(new Pair(x, y));
                        d[x][y] = d[p.x][p.y] + 1;
                    }
                }
            }
        }
    }
}