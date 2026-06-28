package beakjoon.pm16928;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int[] board = new int[101];
        boolean[] visited = new boolean[101];

        for(int i=0;i<n+m;i++){
            str = br.readLine().split(" ");
            int start =  Integer.parseInt(str[0]);
            int end = Integer.parseInt(str[1]);
            board[start] = end;
        }

        int result = bfs(board, visited);

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int[] board, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0}); // 시작위치, 이동횟수
        visited[1] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int pos = cur[0];
            int count = cur[1];

            if(pos == 100){
                return count;
            }

            for(int i=1;i<7;i++){
                int next = pos + i;

                if(next > 100){
                    continue;
                }

                if(board[next] != 0){
                    next = board[next];
                }

                if(!visited[next]){
                    visited[next] = true;
                    queue.add(new int[]{next, count+1});
                }
            }
        }

        return -1;
    }
}

