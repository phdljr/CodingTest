package beakjoon.pm1766;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int v = Integer.parseInt(str[0]);
        int[] indegree = new int[v+1];
        int count = Integer.parseInt(str[1]);

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<v+1;i++)
            graph.add(new ArrayList<>());

        for(int i=0;i<count;i++){
            str =  br.readLine().split(" ");
            int from = Integer.parseInt(str[0]);
            int to = Integer.parseInt(str[1]);

            graph.get(from).add(to);
            indegree[to]++;
        }

        String result = run(graph, indegree).trim();

        bw.write(result);
        bw.flush();
        bw.close();
        br.close();
    }

    private static String run(List<List<Integer>> graph, int[] indegree) {
        StringBuilder result = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1;i<indegree.length;i++){
            if(indegree[i]==0){
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            int current = pq.poll();
            result.append(current).append(" ");
            for(int child: graph.get(current)){
                indegree[child]--;
                if(indegree[child]==0){
                    pq.add(child);
                }
            }
        }

        return result.toString();
    }
}

