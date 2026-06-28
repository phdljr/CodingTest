import java.util.*;

class Node{
    int x,y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static int n = 0;
    static int m = 0;

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        bfs(maps);
        return maps[n-1][m-1] == 1 ? -1 : maps[n-1][m-1];
    }

    public void bfs(int[][] maps){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0));
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if(0 <= nx && nx < n && 0 <= ny && ny < m){
                    if(maps[nx][ny] == 0)
                        continue;
                    if(maps[nx][ny] == 1){
                        maps[nx][ny] = maps[node.x][node.y] + 1;
                        queue.add(new Node(nx, ny));
                    }
                }
            }
        }
    }
}