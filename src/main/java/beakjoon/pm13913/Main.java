package beakjoon.pm13913;

import java.util.*;

public class Main {

    static final int MAX = 200000;
    static int[] dist = new int[MAX + 1];
    static int[] from = new int[MAX + 1];

    public static void main(String[] args) {
        int n, k;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        Arrays.fill(dist, -1);
        dist[n] = 0;

        bfs(n, k);
        System.out.println(dist[k]);

        Stack<Integer> stack = new Stack<>();
        for(int i=k;i!=n;i=from[i]){
            stack.add(i);
        }
        System.out.print(n + " ");
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

    private static void bfs(int start, int k){
        Queue<Integer> q = new LinkedList();
        q.add(start);
        while (!q.isEmpty()){
            int t = q.remove();
            if(t == k){
                return;
            }
            if(t-1 >= 0 && dist[t-1] == -1){
                q.add(t-1);
                dist[t-1] = dist[t] + 1;
                from[t-1] = t;
            }
            if(t+1 <= MAX && dist[t+1] == -1){
                q.add(t+1);
                dist[t+1] = dist[t] + 1;
                from[t+1] = t;
            }
            if(t*2 <= MAX && dist[t*2] == -1){
                q.add(t*2);
                dist[t*2] = dist[t] + 1;
                from[t*2] = t;
            }
        }
    }
}
