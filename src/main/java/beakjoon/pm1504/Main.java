package beakjoon.pm1504;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str =  br.readLine().split(" ");
        int v = Integer.parseInt(str[0]);
        int e = Integer.parseInt(str[1]);

        List<List<int[]>> list = new ArrayList<>();
        for(int i=0;i<v+1;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            str = br.readLine().split(" ");
            int from = Integer.parseInt(str[0]);
            int to = Integer.parseInt(str[1]);
            int weight = Integer.parseInt(str[2]);

            list.get(from).add(new int[]{to,weight});
            list.get(to).add(new int[]{from,weight});
        }

        str = br.readLine().split(" ");
        int v1 = Integer.parseInt(str[0]);
        int v2 = Integer.parseInt(str[1]);

        int[] map = new int[v+1];

        int INF = 1_000_000_000;

        Arrays.fill(map, INF);
        run(1, list, map);
        long result1 = map[v1];
        long result2 = map[v2];

        Arrays.fill(map, INF);
        run(v1, list, map);
        result1 += map[v2];
        result2 += map[v];

        Arrays.fill(map, INF);
        run(v2, list, map);
        result1 += map[v];
        result2 += map[v1];

        long result = Math.min(result1, result2);
        if(result >= INF){
            result = -1;
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void run(int start, List<List<int[]>> list, int[] map) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});
        map[start] = 0;
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int current = node[0];
            int weight = node[1];

            if(map[current] < weight)
                continue;

            for (int[] child : list.get(current)) {
                if (map[child[0]] > map[current] + child[1]) {
                    map[child[0]] = map[current] + child[1];
                    pq.offer(new int[]{child[0], map[current] + child[1]});
                }
            }
        }
    }
}