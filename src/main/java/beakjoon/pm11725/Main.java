package beakjoon.pm11725;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] graph;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        parent = new int[n + 1];
        visited = new boolean[n + 1];

        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= n; i++){
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(){
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        visited[1] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : graph[cur]){
                if(!visited[next]){
                    visited[next] = true;
                    parent[next] = cur;
                    q.add(next);
                }
            }
        }
    }
}
