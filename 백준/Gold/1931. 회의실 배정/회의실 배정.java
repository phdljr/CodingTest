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
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		for(int i=0;i<n;i++) {
			String[] str = br.readLine().split(" ");
			arr[i] = new int[] {Integer.parseInt(str[0]), Integer.parseInt(str[1])};
		}
		
		Arrays.sort(arr, (a, b) -> {
			if (a[1] == b[1]) 
				return a[0] - b[0];
		    return a[1] - b[1];
		});
		
		int result = 1;
		int end = arr[0][1];
		for(int i=1;i<n;i++) {
			if(end <= arr[i][0]) {
				end = arr[i][1];
				result++;
			}
		}
		
		bw.write(result + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
