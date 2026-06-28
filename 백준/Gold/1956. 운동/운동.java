import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		int v = Integer.parseInt(str[0]);
		int e = Integer.parseInt(str[1]);
		int INF = 200_000_000;
		
		int[][] g = new int[v+1][v+1];
		for(int i=1;i<v+1;i++) {
			Arrays.fill(g[i], INF);
			g[i][i] = 0;
		}
		
		for(int i=0;i<e;i++) {
			str = br.readLine().split(" ");
			int from = Integer.parseInt(str[0]);
			int to = Integer.parseInt(str[1]);
			int weight = Integer.parseInt(str[2]);
			
			g[from][to] = weight;
		}
		
		for(int k=1;k<v+1;k++) {
			for(int i=1;i<v+1;i++) {
				for(int j=1;j<v+1;j++) {
					if(g[i][k] == INF || g[k][j] == INF)
						continue;
					
					if(g[i][j] > g[i][k] + g[k][j]) {
						g[i][j] = g[i][k] + g[k][j];
					}
				}
			}
		}
		
		int min = INF;
		
		for(int i=1;i<v+1;i++) {
			for(int j=1;j<v+1;j++) {
				if(i == j)
					continue;
				
				if(min > g[i][j] + g[j][i])
					min = g[i][j] + g[j][i];
			}
		}
		
		if(min == INF)
			min = -1;
		
		bw.write(min + "");
		bw.flush();
		bw.close();
		br.close();
	}
}