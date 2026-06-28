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

        int start = Integer.parseInt(br.readLine());

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
        }

        int[] map = new int[v+1];
        Arrays.fill(map, Integer.MAX_VALUE);

        run(start, list, map);
        String result = "";
        for(int i=1;i<map.length;i++){
            if(map[i] == Integer.MAX_VALUE){
                result += "INF" + "\n";
            } else{
                result += map[i]+"\n";
            }
        }

        bw.write(result);
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