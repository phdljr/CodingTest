import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Main {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		int s = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);
		
		int result = bfs(s, b);
		
		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
	}

	private static int bfs(int s, int b) {
		PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparing((a) -> a[1]));
		pq.add(new Integer[] {s, 0});
		Set<Integer> visited = new HashSet<>();
		while(!pq.isEmpty()) {
			Integer[] current = pq.poll();
			if(current[0] == b) {
				return current[1];
			}
			
			if(visited.contains(current[0])) {
				continue;	
			}
			
			visited.add(current[0]);
			
			int[][] next = {{current[0] * 2, current[1]}, {current[0] + 1, current[1] + 1}, {current[0] - 1, current[1] + 1}};
			for(int[] n: next) {
				if(n[0] >= 0 && n[0] <= 100000) {
					pq.add(new Integer[] {n[0], n[1]});
				}
			}
		}
		
		return -1;
	}
}