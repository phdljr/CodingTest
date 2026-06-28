import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String result = "";
		int caseNum = 1;
		while(true) {
			String[] str = br.readLine().split(" ");
			int v = Integer.parseInt(str[0]);
			int e = Integer.parseInt(str[1]);
			
			if(v == 0 && e == 0)
				break;
			
			List<List<Integer>> g = new ArrayList<>();
			for(int i=0;i<v+1;i++) {
				g.add(new ArrayList<>());
			}
			
			for(int i=0;i<e;i++) {
				str = br.readLine().split(" ");
				int from = Integer.parseInt(str[0]);
				int to = Integer.parseInt(str[1]);
				
				g.get(from).add(to);
				g.get(to).add(from);
			}
			
			boolean[] visited = new boolean[v+1];
		    int treeCount = 0;

		    for(int i=1;i<=v;i++) {
		        if(!visited[i]) {
		            if(isTree(g, visited, i)) {
		                treeCount++;
		            }
		        }
		    }

		    if(treeCount == 0) {
		        result += "Case " + caseNum + ": No trees.\n";
		    } else if(treeCount == 1) {
		        result += "Case " + caseNum + ": There is one tree.\n";
		    } else {
		        result += "Case " + caseNum + ": A forest of " + treeCount + " trees.\n";
		    }

		    caseNum++;
		}
		
		bw.write(result.trim());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static boolean isTree(List<List<Integer>> g, boolean[] visited, int start) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {start, 0});
		visited[start] = true;

	    boolean isTree = true;
	    while(!q.isEmpty()) {
	    	int[] current = q.poll();
	    	int node = current[0];
	    	int parent = current[1];
	    	
	    	for(int child: g.get(node)) {
	    		if(!visited[child]) {
	    			visited[child] = true;
	    			q.add(new int[] {child, node});
	    		} else if(child != parent){ // 사이클 감지. 부모가 아닌데 이미 방문
	    			isTree = false;
	    		}
	    	}
	    }
		
		return isTree;
	}
}
