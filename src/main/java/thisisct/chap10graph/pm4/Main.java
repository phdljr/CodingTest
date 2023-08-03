package thisisct.chap10graph.pm4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    static int v;
    static int[] indegree;
    // 각 노드에 연결된 간선 정보를 저장
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] times;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(in.readLine());
        indegree = new int[v+1];
        times = new int[v+1];

        for(int i=0;i<=v;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=1;i<=v;i++){
            String[] str = in.readLine().split(" ");
            times[i] = Integer.parseInt(str[0]);
            for(int j=1;j< str.length;j++){
                int x = Integer.parseInt(str[j]);
                if(x == -1){
                    break;
                }
                indegree[i]++;
                // x 강의를 들을려면 i 강의를 수강해야만 함
                graph.get(x).add(i);
            }
        }

        topologySort();
    }

    public static void topologySort(){
        int[] result = new int[v+1]; // 알고리즘 수행 결과를 담을 배열
        for (int i = 1; i <= v; i++) {
            result[i] = times[i];
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=v;i++){
            if(indegree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()){
            int now = queue.poll();
            for(int i=0;i<graph.get(now).size();i++){
                indegree[graph.get(now).get(i)]--;
                result[graph.get(now).get(i)] = Math.max(result[graph.get(now).get(i)], result[now] + times[graph.get(now).get(i)]);
                if(indegree[graph.get(now).get(i)] == 0){
                    queue.add(graph.get(now).get(i));
                }
            }
        }

        for(int i=1;i<=v;i++){
            System.out.println(result[i]);
        }
    }
}
