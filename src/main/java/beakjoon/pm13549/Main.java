package beakjoon.pm13549;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static final int MAX = 200000;
    static int[] d = new int[MAX + 1];
    static Queue<Integer> cur = new LinkedList<>();
    static Queue<Integer> next = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Arrays.fill(d, -1);
        d[n] = 0;
        cur.add(n);

        bfs();
        System.out.println(d[k]);
    }

    private static void bfs(){
        while(!cur.isEmpty()){
            int t = cur.remove();
            if(2*t <= MAX && d[2*t] == -1){
                d[2*t] = d[t];
                cur.add(2*t);
            }
            if(t+1 <= MAX && d[t+1] == -1){
                d[t+1] = d[t] + 1;
                next.add(t+1);
            }
            if(t-1 >= 0 && d[t-1] == -1){
                d[t-1] = d[t] + 1;
                next.add(t-1);
            }

            if(cur.isEmpty()){
                cur = next;
                next = new LinkedList<>();
            }
        }
    }
}