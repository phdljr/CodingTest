package programmers.level3.pm49189.an2;

import java.util.*;

public class Solution {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] check;
    static int[] d;

    public int solution(int n, int[][] edge) {
        int answer = 0;
        d = new int[n+1];
        check = new boolean[n+1];

        Arrays.fill(d, 1000000000);

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<edge.length;i++){
            int from = edge[i][0];
            int to = edge[i][1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        bfs();

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

    public void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        d[1] = 0;
        check[1] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i=0;i<graph.get(now).size();i++){
                int cost = d[now] + 1;
                if(check[graph.get(now).get(i)] == false){
                    check[graph.get(now).get(i)] = true;
                    d[graph.get(now).get(i)] = cost;
                    queue.add(graph.get(now).get(i));
                }
            }
        }
    }
}