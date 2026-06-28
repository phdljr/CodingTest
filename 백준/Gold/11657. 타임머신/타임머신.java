import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Edge {
	int from;
	int to;
	int weight;
	
	public Edge(int from, int to, int weight) {
		this.from = from; 
		this.to = to;
		this.weight = weight;
	}
}

public class Main {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		int v = Integer.parseInt(str[0]);
		int e = Integer.parseInt(str[1]);
		
		Edge[] edges = new Edge[e];
		for(int i=0;i<e;i++) {
			str = br.readLine().split(" ");
			int from = Integer.parseInt(str[0]);
			int to = Integer.parseInt(str[1]);
			int w = Integer.parseInt(str[2]);
			
			edges[i] = new Edge(from, to, w);
		}	

		String result = "";
		long[] dist = new long[v+1];
		if(!run(v, e, edges, 1, dist)) {
			result = "-1";
		} else {
			for(int i=2;i<v+1;i++) {
				if(dist[i] == Long.MAX_VALUE)
					result += "-1" + "\n";
				else
					result += dist[i] + "\n";
			}
		}
		
		bw.write(result.trim());
		bw.flush();
		bw.close();
		br.close();
	}

	private static boolean run(int v, int e, Edge[] edges, int start, long[] dist) {
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[start] = 0;
		for(int i=1;i<v+1;i++) {
			for(int j=0;j<e;j++) {
				Edge current = edges[j];
				
				if(dist[current.from] == Long.MAX_VALUE)
					continue;
				
				if(dist[current.to] > dist[current.from] + current.weight) {
					dist[current.to] = dist[current.from] + current.weight;
					
					if(i == v) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
}