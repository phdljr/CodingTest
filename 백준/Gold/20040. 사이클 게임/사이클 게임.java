
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int result = 0;
        int[] parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        for(int i=0;i<m;i++){
            str = br.readLine().split(" ");
            int from = Integer.parseInt(str[0]);
            int to = Integer.parseInt(str[1]);

            if(find(parent, from) == find(parent, to)){
                result = i + 1;
                break;
            }

            union(parent, from, to);
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