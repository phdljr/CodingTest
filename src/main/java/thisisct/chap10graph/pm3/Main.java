package thisisct.chap10graph.pm3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Edge implements Comparable<Edge>{
    int nodeA;
    int nodeB;
    int weight;

    public Edge(int nodeA, int nodeB, int weight) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        if(weight < o.weight){
            return -1;
        }
        return 1;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] str = in.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[] parent = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
        }

        ArrayList<Edge> edges = new ArrayList<>();
        for(int i=0;i<m;i++){
            str = in.readLine().split(" ");
            int from = Integer.parseInt(str[0]);
            int to = Integer.parseInt(str[1]);
            int weight = Integer.parseInt(str[2]);
            edges.add(new Edge(from, to, weight));
        }

        ArrayList<Integer> list = new ArrayList<>();
        edges.sort(Edge::compareTo);
        for(Edge edge: edges){
            int from = edge.nodeA;
            int to = edge.nodeB;
            if(findParent(parent, from) == findParent(parent, to)){
                continue;
            }
            unionParent(parent, from, to);
            list.add(edge.weight);
        }

        int result = 0;
        for(int i=0;i<list.size()-1;i++){
            result+=list.get(i);
        }

        System.out.println(result);
    }

    public static int findParent(int[] parent, int a){
        if(parent[a] != a){
            parent[a] = findParent(parent, parent[a]);
        }
        return parent[a];
    }

    public static void unionParent(int[] parent, int a, int b){
        a = findParent(parent, a);
        b = findParent(parent, b);
        if(a<b){
            parent[b] = a;
        } else{
            parent[a] = b;
        }
    }
}
