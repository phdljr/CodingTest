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
		
		int[][] arr = new int[n][m];
		for(int i=0;i<n;i++) {
			arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		
		int size = Math.min(n, m);
		boolean flag = false;
		while(size >= 1 && flag == false) {
			for(int i=0;i<=n-size;i++) {
				for(int j=0;j<=m-size;j++) {
					if(arr[i][j] == arr[i][j+size - 1]
						&& arr[i][j] == arr[i+size - 1][j]
						&& arr[i][j] == arr[i+size - 1][j+size - 1]) {
						flag = true;
						break;
					}
				}
			}
			
			size--;
		}
		
		size++;
		
		bw.write(size * size + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
