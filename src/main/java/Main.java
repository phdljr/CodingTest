import java.io.*;
import java.util.*;

class Node{
    int x, y, time;

    public Node(int x, int y, int time){
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class Main {

    static int[][] map;
    static boolean[][] check;
    static int x, y;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        x = Integer.parseInt(str[1]);
        y = Integer.parseInt(str[0]);

        map = new int[x][y];
        check = new boolean[x][y];
        List<Node> list = new ArrayList<>();
        for(int i=0;i<x;i++){
            str = br.readLine().split(" ");
            for(int j=0;j<y;j++){
                map[i][j] = Integer.parseInt(str[j]);
                if(map[i][j] == 1){
                    list.add(new Node(i, j, 0));
                    check[i][j] = true;
                }
            }
        }

        int result = bfs(list);
        System.out.println(result);
    }

    public static int bfs(List<Node> list){
        Queue<Node> queue = new LinkedList<>(list);
        int result = 0;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                int time = node.time + 1;

                if(!(0 <= nx && nx < x && 0 <= ny && ny < y)){
                    continue;
                }

                if(check[nx][ny]){
                    continue;
                }

                if(map[nx][ny] == 0){
                    queue.add(new Node(nx, ny, time));
                    check[nx][ny] = true;
                    if(result < time){
                        result = time;
                    }
                }
            }
        }

        return result;
    }
}