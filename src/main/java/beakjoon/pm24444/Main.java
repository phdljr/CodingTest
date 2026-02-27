package beakjoon.pm24444;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int r =  Integer.parseInt(str[2]);
        boolean[] visited = new boolean[n+1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            str =  br.readLine().split(" ");
            int u = Integer.parseInt(str[0]);
            int v = Integer.parseInt(str[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i=1;i<n+1;i++){
            Collections.sort(graph.get(i));
        }

        int[] order = bfs(graph, visited, r);
        StringBuilder result = new StringBuilder();
        for(int i=1;i<order.length;i++){
            result.append(order[i]).append(" ");
        }

        bw.write(result.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int[] bfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int r) {
        int[] result = new int[graph.size()];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(r);
        int order = 1;
        result[r] = order;
        order++;
        visited[r] = true;

        while(!q.isEmpty()){
            int v = q.poll();
            for(int u:graph.get(v)){
                if(!visited[u]){
                    visited[u] = true;
                    result[u] = order;
                    order++;
                    q.add(u);
                }
            }
        }

        return result;
    }
}