
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str =  br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int[] indegree = new int[n+1];
        List<List<Integer>> g = new ArrayList<>();
        for(int i=0;i<n+1;i++){ //1 base
            g.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            str =  br.readLine().split(" ");
            int from =  Integer.parseInt(str[0]);
            int to =  Integer.parseInt(str[1]);

            g.get(from).add(to);
            indegree[to]++;
        }

        String result = bfs(g, indegree, n);

        bw.write(result.trim());
        bw.flush();
        bw.close();
        br.close();
    }

    private static String bfs(List<List<Integer>> g, int[] indegree, int n) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=n; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        StringBuilder result = new StringBuilder();
        while(!queue.isEmpty()){
            int node = queue.poll();
            result.append(node).append(" ");

            for(int child: g.get(node)){
                indegree[child]--;
                if(indegree[child] == 0){
                    queue.add(child);
                }
            }
        }

        return result.toString();
    }
}