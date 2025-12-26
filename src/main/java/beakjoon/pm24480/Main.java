package beakjoon.pm24480;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Set<Integer>> graph = new ArrayList<>();
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int start = Integer.parseInt(str[2]);

        visited = new int[n + 1];

        // one base
        for (int i = 0; i < n + 1; i++) {
            graph.add(new TreeSet<>(Collections.reverseOrder()));
        }

        for (int i = 0; i < m; i++) {
            str = br.readLine().split(" ");
            int u = Integer.parseInt(str[0]);
            int v = Integer.parseInt(str[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(graph, start);

        StringBuilder result = new StringBuilder();
        for (int i = 1; i < visited.length; i++) {
            result.append(visited[i]).append("\n");
        }

        bw.write(result.toString().trim());
        bw.flush();
        br.close();
        bw.close();
    }

    static int order = 1;

    private static void dfs(List<Set<Integer>> graph, int node) {
        visited[node] = order++;
        for (int next : graph.get(node)) {
            if (visited[next] == 0) {
                dfs(graph, next);
            }
        }
    }
}

