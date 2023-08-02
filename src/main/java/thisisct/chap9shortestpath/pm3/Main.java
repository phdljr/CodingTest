package thisisct.chap9shortestpath.pm3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int index;
    int weight;

    public Node(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        if (this.weight < o.weight) {
            return -1;
        }
        return 1;
    }
}

public class Main {

    static int INF = (int) 1e9;
    static int[] d;
    static int n, m;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        graph = new ArrayList<>();
        String[] str = in.readLine().split(" ");

        n = Integer.parseInt(str[0]);
        d = new int[n + 1];
        Arrays.fill(d, INF);
        m = Integer.parseInt(str[1]);
        int c = Integer.parseInt(str[2]);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            str = in.readLine().split(" ");
            int from = Integer.parseInt(str[0]);
            int to = Integer.parseInt(str[1]);
            int weight = Integer.parseInt(str[2]);
            graph.get(from).add(new Node(to, weight));
        }

        dijkstra(c);

        int count = 0;
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (i == c) continue;
            if (d[i] == INF) continue;
            max = Math.max(max, d[i]);
            count++;
        }

        System.out.println(count + " " + max);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> heap = new PriorityQueue<>();
        heap.add(new Node(start, 0));
        d[start] = 0;

        while (!heap.isEmpty()) {
            Node node = heap.poll();
            int now = node.index;
            int weight = node.weight;

            if (d[now] < weight) continue;
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).weight;
                if (cost < d[graph.get(now).get(i).index]) {
                    d[graph.get(now).get(i).index] = cost;
                    heap.add(new Node(graph.get(start).get(i).index, cost));
                }
            }
        }
    }
}
