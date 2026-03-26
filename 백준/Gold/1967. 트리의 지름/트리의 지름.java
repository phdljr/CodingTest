import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int v = Integer.parseInt(br.readLine());
		List<List<Integer[]>> g = new ArrayList<>();
		for(int i=0;i<=v;i++) {
			g.add(new ArrayList<>());
		}
		
		for(int i=0;i<v-1;i++) {
			String[] str = br.readLine().split(" ");
			int from = Integer.parseInt(str[0]);
			int to = Integer.parseInt(str[1]);
			int weight = Integer.parseInt(str[2]);
			
			g.get(from).add(new Integer[] {to, weight});
			g.get(to).add(new Integer[] {from, weight});
		}
		
		Integer[] t = bfs(v, g, 1);
		t = bfs(v, g, t[0]);
		
		bw.write(t[1] + "");
		bw.flush();
		bw.close();
		br.close();
	}

	private static Integer[] bfs(int v, List<List<Integer[]>> g, int start) {
		Integer[] result = new Integer[2];
		result[0] = 0;
		result[1] = Integer.MIN_VALUE;
		
		Queue<Integer[]> q = new LinkedList<>();
		q.add(new Integer[] {start, 0});
		
		boolean[] visited = new boolean[v+1];
		while(!q.isEmpty()) {
			Integer[] currentNode = q.poll();
			int cn = currentNode[0];
			int cw = currentNode[1];

			if(result[1] < cw) {
				result[0] = cn;
				result[1] = cw;
			}
			
			for(Integer[] nn: g.get(cn)) {
				if(visited[nn[0]])
					continue;

				visited[cn] = true;
				q.add(new Integer[] {nn[0], cw + nn[1]});
			}
		}
		
		return result;
	}
}
