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
		
		int T = Integer.parseInt(br.readLine());
		String result = "";
		for(int z=0;z<T;z++) {
			String[] str = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]); // v
			int m = Integer.parseInt(str[1]); // e
			int t = Integer.parseInt(str[2]); // 후보 개수
			
			str = br.readLine().split(" ");
			int s = Integer.parseInt(str[0]); // 출발지
			int g = Integer.parseInt(str[1]); // 예상 경로 시작점
			int h = Integer.parseInt(str[2]); // 예상 경로 도착점
			
			List<List<Integer[]>> graph = new ArrayList<>();
			for(int i=0;i<n+1;i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int i=0;i<m;i++) {
				str = br.readLine().split(" ");
				int from = Integer.parseInt(str[0]);
				int to = Integer.parseInt(str[1]);
				int w = Integer.parseInt(str[2]);
				
				graph.get(from).add(new Integer[] {to, w});
				graph.get(to).add(new Integer[] {from, w});
			}
			
			int[] expectGoal = new int[t];
			for(int i=0;i<t;i++) {
				expectGoal[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(expectGoal);
			
			int[] dijS = dijkstra(graph, s, n);
			int[] dijG = dijkstra(graph, g, n);
			int[] dijH = dijkstra(graph, h, n);
			
			for(int i=0;i<expectGoal.length;i++) {
				int goal = expectGoal[i];
				if(dijS[goal] == dijS[g] + dijG[h] + dijH[goal]
					|| dijS[goal] == dijS[h] + dijH[g] + dijG[goal]) {
					result += goal + " ";
				}
			}
			
			result += "\n";
		}
		
		bw.write(result.trim());
		bw.flush();
		bw.close();
		br.close();
	}

	private static int[] dijkstra(List<List<Integer[]>> graph, int start, int v) {
		PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparing((a) -> a[1]));
		pq.add(new Integer[] {start, 0});
		
		int[] map = new int[v+1];
		Arrays.fill(map, Integer.MAX_VALUE);
		map[start] = 0;
		
		int[] route = new int[v+1];
		for(int i=1;i<v+1;i++) {
			route[i] = i;
		}
		
		while(!pq.isEmpty()) {
			Integer[] node = pq.poll();
			int currentNode = node[0];
			int currentWeight = node[1];
			
			if(map[currentNode] < currentWeight)
				continue;
			
			for(Integer[] child: graph.get(currentNode)) {
				int nextNode = child[0];
				int nextWeight = child[1];
				
				if(map[nextNode] > map[currentNode] + nextWeight) {
					map[nextNode] = map[currentNode] + nextWeight;
					pq.add(new Integer[] {nextNode, map[nextNode]});
					route[nextNode] = currentNode;
				}
			}
		}
		
		return map;
	}
}