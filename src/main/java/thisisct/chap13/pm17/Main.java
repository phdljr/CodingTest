package thisisct.chap13.pm17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node implements Comparable<Node> {
    int x, y, priority, second;

    public Node(int x, int y, int priority, int second) {
        this.x = x;
        this.y = y;
        this.priority = priority;
        this.second = second;
    }

    @Override
    public int compareTo(Node o) {
        if (priority < o.priority) {
            return -1;
        }
        return 1;
    }
}

public class Main {

    static int n, k;
    static int[][] d;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int s, x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] str = in.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        k = Integer.parseInt(str[1]);

        d = new int[n][n];
        for (int i = 0; i < n; i++) {
            str = in.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                d[i][j] = Integer.parseInt(str[j]);
            }
        }

        str = in.readLine().split(" ");
        s = Integer.parseInt(str[0]);
        x = Integer.parseInt(str[1]);
        y = Integer.parseInt(str[2]);

        bfs();

        System.out.println(d[x - 1][y - 1]);
    }

    public static void bfs() {
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (d[i][j] != 0) {
                    list.add(new Node(i, j, d[i][j], 0));
                }
            }
        }
        list.sort(Node::compareTo);

        Queue<Node> queue = new LinkedList<>(list);
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.second == s) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (d[nx][ny] == 0) {
                        d[nx][ny] = node.priority;
                        queue.add(new Node(nx, ny, node.priority, node.second + 1));
                    }
                }
            }
        }
    }
}
