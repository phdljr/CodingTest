
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int v = Integer.parseInt(br.readLine());
        int e =  Integer.parseInt(br.readLine());

        int INF = 100000000;

        int[][] g = new int[v+1][v+1];
        for(int i=1;i<v+1;i++){
            Arrays.fill(g[i], INF);
            g[i][i] = 0;
        }

        for(int i = 0; i < e; i++){
            String[] str = br.readLine().split(" ");
            int from =  Integer.parseInt(str[0]);
            int to =  Integer.parseInt(str[1]);
            int weight = Integer.parseInt(str[2]);

            g[from][to] = Math.min(g[from][to], weight);
        }

        for(int k=1;k<=v;k++){
            for(int i=1;i<=v;i++){
                for(int j=1;j<=v;j++){
                    if(g[i][k] == INF | g[k][j] == INF)
                        continue;

                    if(g[i][j] > g[i][k] + g[k][j]){
                        g[i][j] = g[i][k] + g[k][j];
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for(int i=1;i<v+1;i++){
            for(int j=1;j<v+1;j++){
                if(g[i][j] == INF)
                    result.append("0 ");
                else
                    result.append(g[i][j]).append(" ");
            }
            result.append("\n");
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}