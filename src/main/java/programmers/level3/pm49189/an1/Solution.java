package programmers.level3.pm49189.an1;

import java.util.*;

class Node implements Comparable<Node>{
    int index;
    int weight;

    public Node(int index, int weight){
        this.index = index;
        this.weight = weight;
    }

    public int compareTo(Node o){
        if(weight < o.weight){
            return -1;
        }return 1;
    }
}

public class Solution {

    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] d;

    public int solution(int n, int[][] edge) {
        int answer = 0;
        d = new int[n+1];

        Arrays.fill(d, 1000000000);

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<edge.length;i++){
            int from = edge[i][0];
            int to = edge[i][1];
            graph.get(from).add(new Node(to, 1));
            graph.get(to).add(new Node(from, 1));
        }

        dijkstra();

        int max = 0;
        for(int i=2;i<=n;i++){
            if(max < d[i]){
                max = d[i];
                answer = 1;
            } else if(max == d[i]){
                answer++;
            }
        }

        return answer;
    }

    public void dijkstra(){
        PriorityQueue<Node> heap = new PriorityQueue<>();
        heap.add(new Node(1, 0));
        d[1] = 0;

        while(!heap.isEmpty()){
            Node node = heap.poll();
            int now = node.index;
            int dist = node.weight;
            if(d[now] < dist){
                continue;
            }

            for(int i=0;i<graph.get(now).size();i++){
                int cost = d[now] + graph.get(now).get(i).weight;
                if(cost < d[graph.get(now).get(i).index]){
                    d[graph.get(now).get(i).index] = cost;
                    heap.add(new Node(graph.get(now).get(i).index, cost));
                }
            }
        }
    }
}