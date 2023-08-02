package thisisct.chap10graph.pm1.topology_sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int v, e;
    // 진입 차수를 가지는 배열
    static int[] indegree = new int[10001];
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        for(int i=0;i<=v;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<e;i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph.get(from).add(to);
            indegree[to]++;
        }

        topologySort();
    }

    public static void topologySort(){
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1;i<=v;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            // 큐에서 원소 꺼내기
            int now = queue.poll();
            result.add(now);
            // 해당 원소와 연결된 노드들의 진입차수에서 1 빼기
            for (int i = 0; i < graph.get(now).size(); i++) {
                indegree[graph.get(now).get(i)] -= 1;
                // 새롭게 진입차수가 0이 되는 노드를 큐에 삽입
                if (indegree[graph.get(now).get(i)] == 0) {
                    queue.offer(graph.get(now).get(i));
                }
            }
        }

        System.out.println("결과: ");
        for (int res: result){
            System.out.print(res + " ");
        }
    }
}
