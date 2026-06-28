package beakjoon.pm3665;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        for(int t=0;t<T;t++) {
            int v = Integer.parseInt(br.readLine());
            int[] indegree = new int[v+1];

            List<List<Integer>> graph = new ArrayList<>();
            for(int i=0;i<v+1;i++)
                graph.add(new ArrayList<>());

            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int i=0;i<arr.length;i++){
                for(int j=i+1;j<arr.length;j++){
                    graph.get(arr[i]).add(arr[j]);
                    indegree[arr[j]]++;
                }
            }

            int changeNum = Integer.parseInt(br.readLine());
            for(int i=0;i<changeNum;i++){
                String[] str = br.readLine().split(" ");
                int from  = Integer.parseInt(str[0]);
                int to = Integer.parseInt(str[1]);

                if(graph.get(from).contains(to)){

                    graph.get(from).remove(Integer.valueOf(to));
                    graph.get(to).add(from);

                    indegree[to]--;
                    indegree[from]++;

                }else{

                    graph.get(to).remove(Integer.valueOf(from));
                    graph.get(from).add(to);

                    indegree[from]--;
                    indegree[to]++;

                }
            }

            result.append(run(graph, indegree)).append("\n");
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static String run(List<List<Integer>> graph, int[] indegree) {
        StringBuilder result = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<indegree.length;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        boolean[] visited = new boolean[indegree.length];
        while (!queue.isEmpty()) {
            if(queue.size() >= 2){
                return "?";
            }

            int current = queue.poll();
            visited[current] = true;
            result.append(current).append(" ");
            for(int child: graph.get(current)){
                indegree[child]--;
                if(indegree[child]==0){
                    queue.add(child);
                }
            }
        }

        for(int i=1;i<visited.length;i++){
            if(!visited[i]){
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }
}
