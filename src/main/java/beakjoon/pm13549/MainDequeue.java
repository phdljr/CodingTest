package beakjoon.pm13549;

import java.util.*;

public class MainDequeue {

    static final int MAX = 200000;
    static int[] d = new int[MAX + 1];
    static Deque<Integer> dq = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Arrays.fill(d, -1);
        d[n] = 0;
        dq.addFirst(n);

        bfs();
        System.out.println(d[k]);
    }

    private static void bfs(){
        while(!dq.isEmpty()){
            int t = dq.removeFirst();
            if(2*t <= MAX && d[2*t] == -1){
                d[2*t] = d[t];
                dq.addFirst(2*t);
            }
            if(t+1 <= MAX && d[t+1] == -1){
                d[t+1] = d[t] + 1;
                dq.addLast(t+1);
            }
            if(t-1 >= 0 && d[t-1] == -1){
                d[t-1] = d[t] + 1;
                dq.addLast(t-1);
            }
        }
    }
}