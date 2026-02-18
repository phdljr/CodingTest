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
		long b = Long.parseLong(str[1]);
		long[][] a = new long[n][n];
		for(int i=0;i<n;i++) {	
			a[i] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		}
		
		long[][] result = pow(a, b, 1000);
		
		String temp = "";
		for(int i=0;i<result.length;i++) {
			for(int j=0;j<result[i].length;j++) {
				temp += result[i][j] + " ";
			}
			temp = temp.trim() + "\n";
		}
		
		bw.write(temp);
		bw.flush();
		br.close();
		bw.close();
	}

	private static long[][] pow(long[][] a, long b, int c) {
		
		if(b == 1) {
			for(int i=0;i<a.length;i++) {
				for(int j=0;j<a[0].length;j++) {
					a[i][j] = a[i][j] % c;
				}
			}
			return a;	
		}
		
		long[][] temp = pow(a, b/2, c);
		
		if(b % 2 == 0)
			return mul(temp, temp, c);
		
		return mul(mul(temp, temp, c), a, c);
	}
	
	private static long[][] mul(long[][] a, long[][] b, int mod){
		int n = a[0].length;
		int m = a.length;
		long[][] result = new long[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				for(int k=0;k<n;k++) {
					result[i][j] += a[i][k] * b[k][j];
					result[i][j] = result[i][j] % mod;
				}
			}
		}
		
		return result;
	}
}
