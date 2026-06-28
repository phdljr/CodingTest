import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;
import java.util.Arrays;

public class Main {	
	public static void main(String[] args) throws URISyntaxException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int k = Integer.parseInt(str[2]);
		
		int result = Integer.MAX_VALUE;
		
		// B: 0, W: 1
		int[][] map = new int[n][m];
		int[][] arrB = new int[n][m]; // B부터 시작
		int[][] sumB = new int[n+1][m+1]; // B부터 시작
		int[][] arrW = new int[n][m]; // W부터 시작
		int[][] sumW = new int[n+1][m+1]; // W부터 시작
		for(int i=0;i<n;i++) {
			map[i] = Arrays.stream(br.readLine().split("")).mapToInt(s -> s.equals("B") ? 0 : 1).toArray();
		}
		
		// 1. B부터 시작
		int c = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] != c) {
					arrB[i][j] = 1;
				}
				c = c == 0 ? 1 : 0;
			}
			if(m%2==0)
				c = c == 0 ? 1 : 0;
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<m+1;j++) {
				sumB[i][j] = sumB[i-1][j]+sumB[i][j-1]-sumB[i-1][j-1]+arrB[i-1][j-1];
			}
		}
		
		// 2. W부터 시작
		c = 1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] != c) {
					arrW[i][j] = 1;
				}
				c = c == 0 ? 1 : 0;
			}
			if(m%2==0)
				c = c == 0 ? 1 : 0;
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<m+1;j++) {
				sumW[i][j] = sumW[i-1][j]+sumW[i][j-1]-sumW[i-1][j-1]+arrW[i-1][j-1];
			}
		}
		
		// 3. 최솟값 탐색
		for(int i=k;i<n+1;i++) {
			for(int j=k;j<m+1;j++) {
				int temp = sumW[i][j]-sumW[i-k][j]-sumW[i][j-k]+sumW[i-k][j-k];
				if(result > temp)
					result = temp;
				
				temp = sumB[i][j]-sumB[i-k][j]-sumB[i][j-k]+sumB[i-k][j-k];
				if(result > temp)
					result = temp;
			}
		}
		
		
		bw.write(result + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
