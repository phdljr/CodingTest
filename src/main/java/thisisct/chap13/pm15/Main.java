package thisisct.chap13.pm15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
    int index;
    int weight;

    public Node(int index, int weight) {
        this.index = index;
        this.weight = weight;
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

    static int v, e, k, x;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        v = Integer.parseInt(s[0]);
        e = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);
        x = Integer.parseInt(s[3]);

        map = new int[v+1];
        Arrays.fill(map, (int)1e9);
        for(int i=0;i<v+1;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<e;i++){
            s = in.readLine().split(" ");
            int from = Integer.parseInt(s[0]);
            int to = Integer.parseInt(s[1]);
            graph.get(from).add(new Node(to, 1));
        }

        dijkstra();

        String answer = "";
        for(int i=1;i<=v;i++){
            if(map[i] == k){
                answer += i + "\n";
            }
        }

        if(answer.length() == 0){
            System.out.println(-1);
        } else{
            System.out.println(answer);
        }
    }

    public static void dijkstra(){
        PriorityQueue<Node> heap = new PriorityQueue<>();
        heap.add(new Node(x, 0));
        map[x] = 0;

        while (!heap.isEmpty()){
            Node node = heap.poll();
            int now = node.index;
            int weight = node.weight;
            if(map[now] < weight) continue;

            for(int i=0;i<graph.get(now).size();i++){
                int cost = map[now] + graph.get(now).get(i).weight;
                if(cost < map[graph.get(now).get(i).index]){
                    map[graph.get(now).get(i).index] = cost;
                    heap.add(new Node(graph.get(now).get(i).index, cost));
                }
            }
        }
    }
}

