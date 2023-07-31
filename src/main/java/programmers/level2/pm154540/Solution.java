package programmers.level2.pm154540;

import java.util.*;

class Node{
    int x,y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();

        int[][] map = new int[maps.length][maps[0].length()];
        boolean[][] check = new boolean[maps.length][maps[0].length()];

        for(int i=0;i<maps.length;i++){
            String[] str = maps[i].split("");
            for(int j=0;j<str.length;j++){
                if(str[j].equals("X"))
                    map[i][j] = -1;
                else
                    map[i][j] = Integer.parseInt(str[j]);
            }
        }

        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(check[i][j] == false && map[i][j] != -1)
                    list.add(bfs(map, check, i, j));
            }
        }

        int[] answer = list.stream().mapToInt(i->i).toArray();
        Arrays.sort(answer);

        return answer.length == 0 ? new int[]{-1} : answer;
    }

    public int bfs(int[][] map, boolean[][] check, int sx, int sy){
        int sum = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(sx, sy));
        check[sx][sy] = true;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            sum += map[node.x][node.y];
            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(0<=nx && nx < map.length && 0 <= ny && ny < map[0].length){

                    if(check[nx][ny] == true)
                        continue;

                    if(map[nx][ny] == -1)
                        continue;

                    check[nx][ny] = true;
                    queue.add(new Node(nx, ny));
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        new Solution().solution(new String[]{"X591X","X1X5X","X231X", "1XXX1"});
    }
}