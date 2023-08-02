package thisisct.chap9shortestpath.pm1.dijkstra.pm2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node>{
    int index;
    int weight;

    public Node(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }

    public int getIndex() {
        return index;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Node o) {
        if(weight < o.weight){
            return -1;
        }
        return 1;
    }
}

public class Main {

    public static int INF = (int)1e9;
    // n: 노드 개수, m: 간선 개수, start: 시작 노드
    public static int n, m, start;
    public static int[] d = new int[100001];
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        for(int i=0;i<=n;i++)
            graph.add(new ArrayList<Node>());

        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node(b, c));
        }

        Arrays.fill(d, INF);

        dijkstra(start);

        System.out.println("끝");
    }

    public static void dijkstra(int start){
        PriorityQueue<Node> heap = new PriorityQueue<>();
        heap.add(new Node(start, 0));
        d[start] = 0;

        while(!heap.isEmpty()){
            Node node = heap.poll();
            int dist = node.getWeight();
            int now = node.getIndex();

            if(d[now] < dist) continue;
            for(int i=0;i<graph.get(now).size();i++){
                int cost = d[now] + graph.get(now).get(i).getWeight();
                if(cost < d[graph.get(now).get(i).getIndex()]){
                    d[graph.get(now).get(i).getIndex()] = cost;
                    heap.add(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }
}

