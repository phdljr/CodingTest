
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

class Edge {
    int from;
    int to;
    int weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int v = Integer.parseInt(str[0]);
        int e = Integer.parseInt(str[1]);

        int result = 0;
        int[] parents = new int[v+1];
        for (int i = 0; i < v+1; i++) {
            parents[i] = i;
        }
        Edge[] edges = new Edge[e];

        for(int i=0;i<e;i++){
            str = br.readLine().split(" ");
            int from = Integer.parseInt(str[0]);
            int to = Integer.parseInt(str[1]);
            int weight = Integer.parseInt(str[2]);

            edges[i] = new Edge(from, to, weight);
        }

        Arrays.sort(edges, Comparator.comparing(i -> i.weight));

        for(Edge edge: edges){
            if(find(parents, edge.from) == find(parents, edge.to)){
                continue;
            }

            union(parents, edge.from, edge.to);
            result += edge.weight;
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int find(int[] parent, int from) {
        if(parent[from] == from){
            return from;
        }
        return parent[from] = find(parent, parent[from]);
    }

    private static void union(int[] parent, int from, int to) {
        int p1 = find(parent, from);
        int p2 = find(parent, to);

        parent[p2] = p1;
    }
}
