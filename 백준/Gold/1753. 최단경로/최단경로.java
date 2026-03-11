
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

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

    private static void run(int start, List<List<int[]>> list, int[] result) {
        boolean[] visited = new boolean[result.length];
        result[start] = 0;
        for(int i=1;i<result.length;i++) {
            int min = Integer.MAX_VALUE;
            int current = 0;
            for(int j=1; j<visited.length; j++) {
                if(min > result[j] && !visited[j]) {
                    min = result[j];
                    current = j;
                }
            }

            visited[current] = true;
            for (int[] node : list.get(current)) {
                if (result[node[0]] > result[current] + node[1]) {
                    result[node[0]] = result[current] + node[1];
                }
            }
        }
    }

    private static boolean checkAllVisited(boolean[] visited) {
        for(int i=1;i<visited.length;i++){
            if(!visited[i])
                return false;
        }

        return true;
    }
}



