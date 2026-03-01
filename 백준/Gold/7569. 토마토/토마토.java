
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int x;
    int y;
    int z;

    Node(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]); // 가로
        int m = Integer.parseInt(str[1]); // 세로
        int h = Integer.parseInt(str[2]); // 높이

        int[][][] map = new int[h][m][n];
        boolean[][][] visited = new boolean[h][m][n];

        for(int i=0;i<h;i++){
            for(int j=0;j<m;j++){
                map[i][j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        }

        int result = bfs(map, visited, n, m, h);
        if(!isAllOK(map, n, m, h)){
            result = -1;
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isAllOK(int[][][] map, int n, int m, int h) {
        for(int i=0;i<h;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<n;k++){
                    if (map[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private static int bfs(int[][][] map, boolean[][][] visited, int n, int m, int h) {
        int day = 0;

        // 방향: 12시 시작 x y 시계방향 -> z 위 아래
        int[] dx = {0, 1, 0, -1, 0, 0}; // 가로
        int[] dy = {-1, 0, 1, 0, 0, 0}; // 세로
        int[] dz = {0, 0, 0, 0, -1, 1}; // 높이

        Queue<Node> dayQueue = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        for(int i=0;i<h;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<n;k++){
                    if(map[i][j][k] == 1){
                        dayQueue.add(new Node(k, j, i));
                    }
                }
            }
        }

        while(!dayQueue.isEmpty()) {
            queue.addAll(dayQueue);
            dayQueue.clear();
            day++;
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                int x = node.x;
                int y = node.y;
                int z = node.z;
                if (!visited[z][y][x]) {
                    visited[z][y][x] = true;
                    for (int i = 0; i < 6; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        int nz = z + dz[i];

                        if (0 <= nx && nx < n
                            && 0 <= ny && ny < m
                            && 0 <= nz && nz < h
                            && map[nz][ny][nx] == 0) {
                            map[nz][ny][nx] = 1;
                            dayQueue.add(new Node(nx, ny, nz));
                        }
                    }
                }
            }
        }

        return day - 1;
    }
}

