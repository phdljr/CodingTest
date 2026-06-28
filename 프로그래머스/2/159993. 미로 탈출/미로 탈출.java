import java.util.*;

class Node{
    int x, y, t;
    public Node(int x, int y, int t){
        this.x = x;
        this.y = y;
        this.t = t;
    }
}

class Solution {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int x, y, lx, ly, ex, ey;

    public int solution(String[] maps) {
        char[][] map = new char[maps.length][maps[0].length()];

        for(int i=0;i<maps.length;i++){
            map[i] = maps[i].toCharArray();
            for(int j=0;j<maps[i].length();j++){
                if(maps[i].charAt(j) == 'S'){
                    x = i;
                    y = j;
                } else if(maps[i].charAt(j) == 'L'){
                    lx = i;
                    ly = j;
                } else if(maps[i].charAt(j) == 'E'){
                    ex = i;
                    ey = j;
                }
            }
        }
        boolean[][] visit = new boolean[maps.length][maps[0].length()];
        int llen = bfs(map, visit, x, y, lx, ly);
        if(llen == -1){
            return -1;
        }

        visit = new boolean[maps.length][maps[0].length()];
        int elen = bfs(map, visit, lx, ly, ex, ey);
        if(elen == -1){
            return -1;
        }
        return llen + elen;
    }

    public static int bfs(char[][] map, boolean[][] visit, int startX, int startY, int endX, int endY){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY, 0));
        visit[startX][startY] = true;

        while(!queue.isEmpty()){
            Node now = queue.poll();
            int x = now.x;
            int y = now.y;
            int t = now.t;
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(0 <= nx && nx < map.length && 0 <= ny && ny < map[0].length){
                    if(visit[nx][ny] == false && map[nx][ny] != 'X'){ // 방문하지 않았다면
                        visit[nx][ny] = true;
                        queue.add(new Node(nx, ny, t+1));
                        if(nx == endX && ny == endY){
                            return t+1;
                        }
                    }
                }
            }
        }
        return -1;
    }
}