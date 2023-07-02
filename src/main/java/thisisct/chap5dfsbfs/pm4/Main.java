package thisisct.chap5dfsbfs.pm4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        String[] s = in.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            s = in.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        bfs(arr, 0, 0, n, m);

        System.out.println(arr[n-1][m-1]);
    }

    public static void bfs(int[][] arr, int x, int y, int n, int m) {
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(x, y);
        queue.add(node);

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int nx, ny;

        while (!queue.isEmpty()) {
            node = queue.poll();
            x = node.x;
            y = node.y;
            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if(arr[nx][ny] != 0){
                        arr[nx][ny] = arr[x][y] + 1;
                        queue.add(new Node(nx, ny));
                    }
                }
            }
            if(arr[n-1][m-1] != 1)
                return;
        }
    }
}
