import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


class Matrix{
	int r;
	int c;
	
	Matrix(int r, int c){
		this.r = r;
		this.c = c;
	}
}

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = br.readLine().split(" ");
		int r = Integer.parseInt(str[0]);
		int c = Integer.parseInt(str[1]);
		
		int[][] map = new int[r][c];
		for(int i=0;i<r;i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		int[][] d = new int[r][c];
		for(int i=0;i<r;i++) {
			Arrays.fill(d[i], -1);
		}
		
		int result = dfs(0, 0, d, r, c, map);
		
		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
	}

	private static int dfs(int x, int y, int[][] d, int r, int c, int[][] map) {
		if(x == r-1 && y == c-1) {
			return 1;
		}
		
		if(d[x][y] != -1) {
			return d[x][y];
		}
		
		d[x][y] = 0;
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0 <= nx && nx < r
				&& 0 <= ny && ny < c){
				if(map[x][y] > map[nx][ny]) {
					d[x][y] += dfs(nx, ny, d, r, c, map);
				}
			}
		}
		
		return d[x][y];
	}
}
