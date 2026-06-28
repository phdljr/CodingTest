
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
    boolean cracked;
    int count;

    Node(int x, int y,  boolean cracked, int count){
        this.x = x;
        this.y = y;
        this.cracked = cracked;
        this.count = count;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int[][] board = new int[n][m];
        boolean[][][] visited = new boolean[n][m][2];

        for(int i=0;i<n;i++){
            board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int result = bfs(board, visited);

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int[][] board, boolean[][][] visited) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, false, 1));
        visited[0][0][0] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int count = node.count;

            if(x == board.length-1 && y == board[0].length-1){
                return node.count;
            }

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int state = node.cracked ? 1 : 0;

                if(0 <= nx && nx < board.length && 0 <= ny && ny < board[0].length){
                    if(visited[nx][ny][state]){
                        continue;
                    }

                    if(board[nx][ny] == 1 && !node.cracked){
                        if(!visited[nx][ny][1]){
                            queue.add(new Node(nx, ny, true, count + 1));
                            visited[nx][ny][1] = true;
                        }
                    }

                    if(board[nx][ny] == 0){
                        queue.add(new Node(nx, ny, node.cracked, count + 1));
                        visited[nx][ny][state] = true;
                    }
                }
            }
        }

        return -1;
    }
}

