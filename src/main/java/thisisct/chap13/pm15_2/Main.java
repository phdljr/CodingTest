package thisisct.chap13.pm15_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int v, e, k, x;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        v = Integer.parseInt(s[0]);
        e = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);
        x = Integer.parseInt(s[3]);

        d = new int[v+1];
        Arrays.fill(d, -1);

        for(int i=0;i<=v;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<e;i++){
            s = in.readLine().split(" ");
            int from = Integer.parseInt(s[0]);
            int to = Integer.parseInt(s[1]);
            graph.get(from).add(to);
        }

        bfs();

        boolean check = false;
        for(int i=1;i<=v;i++){
            if(d[i] == k){
                System.out.println(i);
                check = true;
            }
        }

        if(check == false){
            System.out.println(-1);
        }
    }

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        d[x] = 0;

        while (!queue.isEmpty()){
            int now = queue.poll();
            for(int i=0;i<graph.get(now).size();i++){
                int next = graph.get(now).get(i);
                if(d[next] == -1){
                    d[next] = d[now] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
