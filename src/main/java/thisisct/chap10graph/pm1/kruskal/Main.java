package thisisct.chap10graph.pm1.kruskal;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    int weight;
    int nodeA;
    int nodeB;

    public Edge(int nodeA, int nodeB, int weight) {
        this.weight = weight;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
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

    static int v, e;
    static int[] parent = new int[10001];
    static ArrayList<Edge> edges = new ArrayList<>();
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        for(int i=1;i<=v;i++){
            parent[i] = i;
        }

        for(int i=0;i<e;i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            edges.add(new Edge(from, to, weight));
        }

        edges.sort(Edge::compareTo);
        for(Edge edge: edges){
            if(findParent(parent, edge.nodeA) == findParent(parent, edge.nodeB)){
                continue;
            }
            unionParent(parent, edge.nodeA, edge.nodeB);
            result += edge.weight;
        }

        System.out.println(result);
    }

    public static int findParent(int[] parent, int n){
        if(parent[n] != n){
            parent[n] = findParent(parent, parent[n]);
        }
        return parent[n];
    }

    public static void unionParent(int[] arr, int a, int b){
        a = findParent(arr, a);
        b = findParent(arr, b);
        if(a<b){
            arr[b] = a;
        } else{
            arr[a] = b;
        }
    }
}
