package thisisct.chap13.pm16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int n, m;
    static int[][] d;
    static int[][] temp;
    static int max = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        d = new int[n][m];
        temp = new int[n][m];
        for(int i=0;i<n;i++){
            s = in.readLine().split(" ");
            for(int j=0;j<m;j++){
                d[i][j] = Integer.parseInt(s[j]);
            }
        }

        // 벽을 하나씩 세움
        go(0);

        System.out.println(max);
    }

    public static void go(int count){
        if(count == 3){
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    temp[i][j] = d[i][j];
                }
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(temp[i][j] == 2){
                        bfs(i, j);
                    }
                }
            }

            int safeZone = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(temp[i][j] == 0){
                        safeZone++;
                    }
                }
            }
            if(max < safeZone){
                max = safeZone;
            }

        } else{
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(d[i][j] == 0){
                        d[i][j] = 1;
                        count++;
                        go(count);
                        d[i][j] = 0;
                        count--;
                    }
                }
            }
        }
    }

    public static void bfs(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));

        while (!queue.isEmpty()){
            Node node = queue.poll();
            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if(0 <= nx && nx < n && 0 <= ny && ny < m){
                    if(temp[nx][ny] == 0){
                        temp[nx][ny] = 2;
                        queue.add(new Node(nx, ny));
                    }
                }
            }
        }
    }
}
