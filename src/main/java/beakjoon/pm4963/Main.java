package beakjoon.pm4963;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static boolean[][] check;
    static int[][] arr;
    static int result = 0;
    static int w, h;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            result = 0;
            w = sc.nextInt();
            h = sc.nextInt();
            arr = new int[h][w];
            check = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(arr[i][j] == 1 && !check[i][j]) {
                        result++;
                        check[i][j] = true;
                        bfs(new Pair(i, j));
                    }
                }
            }
            if(!(w == 0 && h == 0))
                System.out.println(result);
        } while (!(w == 0 && h == 0));
    }

    public static void bfs(Pair pair) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(pair);
        while (!queue.isEmpty()) {
            Pair p = queue.remove();
            int cx = p.x;
            int cy = p.y;
            for (int i = 0; i < 8; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(0 <= nx && nx < h && 0 <= ny && ny < w){
                    if(check[nx][ny]) {
                        continue;
                    }
                    if(arr[nx][ny] == 0) {
                        continue;
                    }
                    check[nx][ny] = true;
                    queue.add(new Pair(nx, ny));
                }
            }
        }
    }
}
